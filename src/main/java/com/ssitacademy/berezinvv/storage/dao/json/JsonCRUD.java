package com.ssitacademy.berezinvv.storage.dao.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssitacademy.berezinvv.storage.dao.DAO;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class JsonCRUD<T> implements DAO<T> {

    private String fileName;
    private List<T> objList = new ArrayList<>();
    public static final ObjectMapper mapper = new ObjectMapper();

    public JsonCRUD(Class<T> type) {
        this.fileName = "json/" + type.getSimpleName().toLowerCase() + ".json";
        readJsonFile(type);
    }

    private void writeJsonFile(List<T> objList) {
        File file = new File(fileName);
        try {
            mapper.writeValue(file, objList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readJsonFile(Class<T> type) {
        File file = new File(fileName);
        try {
            this.objList = mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(ArrayList.class, type));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<T> getAll() {
        return objList;
    }

    @Override
    public T getById(int id) {
        for (T obj : objList) {
            try {
                //field "id" search in collection objects
                Field idFieldListObj = obj.getClass().getDeclaredField("id");
                idFieldListObj.setAccessible(true);
                int idFieldListObjValue = idFieldListObj.getInt(obj);
                if (id == idFieldListObjValue) {
                    return obj;
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void update(T o) {
        T objUpdate = null;
        for (T obj : objList) {
            try {
                //field "id" search in param object
                Field idFieldParamObj = o.getClass().getDeclaredField("id");
                idFieldParamObj.setAccessible(true);
                int idFieldParamObjValue = idFieldParamObj.getInt(o);
                //field "id" search in collection objects
                Field idFieldListObj = obj.getClass().getDeclaredField("id");
                idFieldListObj.setAccessible(true);
                int idFieldListObjValue = idFieldParamObj.getInt(obj);
                if (idFieldParamObjValue == idFieldListObjValue) {
                    objUpdate = obj;
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if (objUpdate != null) {
            objUpdate = o;
        } else {
            objList.add(o);
        }
        writeJsonFile(objList);
    }

    @Override
    public void delete(T o) {
        objList.remove(o);
        writeJsonFile(objList);
    }

    @Override
    public void save(T o) {
        T objUpdate = null;
        for (T obj : objList) {
            try {
                //field "id" search in param object
                Field idFieldParamObj = o.getClass().getDeclaredField("id");
                idFieldParamObj.setAccessible(true);
                int idFieldParamObjValue = idFieldParamObj.getInt(o);
                //field "id" search in collection objects
                Field idFieldListObj = obj.getClass().getDeclaredField("id");
                idFieldListObj.setAccessible(true);
                int idFieldListObjValue = idFieldParamObj.getInt(obj);
                if (idFieldParamObjValue == idFieldListObjValue) {
                    objUpdate = obj;
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if (objUpdate != null) {
            objUpdate = o;
        } else {
            objList.add(o);
        }
        writeJsonFile(objList);
    }
}
