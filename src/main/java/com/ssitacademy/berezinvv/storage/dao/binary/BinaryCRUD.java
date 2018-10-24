package com.ssitacademy.berezinvv.storage.dao.binary;

import com.ssitacademy.berezinvv.storage.dao.DAO;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class BinaryCRUD<T> implements DAO<T> {

    private String fileName;
    private List<T> objList = new ArrayList<>();

    public BinaryCRUD(Class<T> type) {
        this.fileName = "binary/" + type.getSimpleName().toLowerCase() + ".dat";
        readBinaryFile();
    }

    private void writeBinaryFile(List<T> carList) {
        File file = new File(this.fileName);

        try (OutputStream outputStream = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(outputStream);) {
            oos.writeObject(carList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readBinaryFile() {
        File file = new File(this.fileName);

        try (InputStream inputStream = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(inputStream);) {
            objList = (List<T>) ois.readObject();
        } catch (EOFException e) {
            //e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
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
        writeBinaryFile(objList);
    }

    @Override
    public void delete(T o) {
        objList.remove(o);
        writeBinaryFile(objList);
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
        writeBinaryFile(objList);
    }
}
