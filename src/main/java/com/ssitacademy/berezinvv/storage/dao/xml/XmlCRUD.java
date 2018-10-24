package com.ssitacademy.berezinvv.storage.dao.xml;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.ssitacademy.berezinvv.storage.dao.DAO;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class XmlCRUD<T> implements DAO<T> {

    private String fileName;
    private List<T> objList = new ArrayList<>();
    public static final XmlMapper mapper = new XmlMapper();


    public XmlCRUD(Class<T> type) {
        this.fileName = "xml/" + type.getSimpleName().toLowerCase() + ".xml";
        readXmlFile(type);
    }

    private void writeXmlFile(List<T> carList) {
        File file = new File(fileName);
        try {
            mapper.writeValue(file, carList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readXmlFile(Class<T> type) {
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
        writeXmlFile(objList);
    }

    @Override
    public void delete(T o) {
        objList.remove(o);
        writeXmlFile(objList);
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
        writeXmlFile(objList);
    }
}
