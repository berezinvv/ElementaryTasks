package com.ssitacademy.berezinvv.storage.dao.ram;

import com.ssitacademy.berezinvv.storage.dao.DAO;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class RamCRUD<T> implements DAO<T> {

    private List<T> objList = new ArrayList<>();

    public RamCRUD(Class<T> type) {
        this.objList = new ArrayList<>();
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
    }

    @Override
    public void delete(T o) {
        objList.remove(o);
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
    }
}
