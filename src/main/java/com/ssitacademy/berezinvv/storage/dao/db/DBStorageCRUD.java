package com.ssitacademy.berezinvv.storage.dao.db;

import com.ssitacademy.berezinvv.storage.annotations.*;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBStorageCRUD<T> implements DBDAO<T> {

    private Class<T> clazz;
    private List<T> objList = new ArrayList<>();
    private String nameTable;
    private Connection jdbcConnection;

    @SuppressWarnings("unchecked")
    public DBStorageCRUD() {

        //get first generic this object
        this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
        try {
            clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        ModelEntity modelEntity = clazz.getAnnotation(ModelEntity.class);
        this.nameTable = modelEntity.nameTable();
    }

    @Override
    public List<T> getAll() {

        objList.clear();
        String sql = "SELECT * FROM storage." + nameTable;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            jdbcConnection = DBUtil.connect(jdbcConnection);

            statement = jdbcConnection.createStatement();
            resultSet = statement.executeQuery(sql);

            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            while (resultSet.next()) {
                //set the result of the selection in our object
                T obj = (T) clazz.newInstance();
                for (int index = 1; index <= resultSetMetaData.getColumnCount(); index++) {
                    String columnNameResultSet = resultSetMetaData.getColumnName(index);
                    Object columnValueResultSet = resultSet.getObject(index);
                    Field fieldObjByName = obj.getClass().getDeclaredField(columnNameResultSet);
                    fieldObjByName.setAccessible(true);
                    //set field(not primetive) enum, object(by relations)
                    if (fieldObjByName.getType().isEnum()) { //enum
                        fieldObjByName.set(obj, Enum.valueOf((Class<Enum>) fieldObjByName.getType(), (String) columnValueResultSet));
                    } else if (fieldObjByName.isAnnotationPresent(OneToOne.class)) { //OneToOne
                        String typeNameField = fieldObjByName.getType().getName();

                        Class clazzDBService = ServiceProvider.getService(typeNameField);
                        DBStorageCRUD dbStorageCRUDInner = (DBStorageCRUD) clazzDBService.newInstance();
                        if (columnValueResultSet != null) {
                            fieldObjByName.set(obj, dbStorageCRUDInner.getById((int) columnValueResultSet));
                        }
                    } else if (fieldObjByName.isAnnotationPresent(ManyToOne.class) || fieldObjByName.isAnnotationPresent(ManyToMany.class)) { //ManyToMany
                        String typeNameField = fieldObjByName.getType().getName();

                        Class clazzDBService = ServiceProvider.getService(typeNameField);
                        DBStorageCRUD dbStorageCRUDInner = (DBStorageCRUD) clazzDBService.newInstance();
                        if (columnValueResultSet != null) {
                            fieldObjByName.set(obj, dbStorageCRUDInner.getById((int) columnValueResultSet));
                        }
                    }else {//set field (primetive)
                        fieldObjByName.set(obj, columnValueResultSet);
                    }
                }

                //set other fields with annotations OneToMany, ManyToMany
                Field[] fields = obj.getClass().getDeclaredFields();
                Field idFieldObj = obj.getClass().getDeclaredField("id");
                idFieldObj.setAccessible(true);
                int idFieldObjValue = idFieldObj.getInt(obj);
                for (Field field : fields) {
                    if (field.isAnnotationPresent(OneToMany.class) || field.isAnnotationPresent(ManyToMany.class)) { //OneToMany
                        ParameterizedType pType = (ParameterizedType) field.getGenericType();
                        Class<?> clazz = (Class<?>) pType.getActualTypeArguments()[0];
                        String typeNameField = clazz.getName();

                        Class clazzDBService = ServiceProvider.getService(typeNameField);
                        DBStorageCRUD dbStorageCRUDInner = (DBStorageCRUD) clazzDBService.newInstance();

                        OneToMany annotationOneToMany = field.getAnnotation(OneToMany.class);
                        if (annotationOneToMany != null) {
                            field.setAccessible(true);
                            field.set(obj, dbStorageCRUDInner.getAllByColumnName(idFieldObjValue, annotationOneToMany.mapping()));
                        }
                    }
                }

                objList.add(obj);
            }
            resultSet.close();
            statement.close();
            DBUtil.disconnect(jdbcConnection);
        } catch (SQLException | IllegalAccessException | InstantiationException | NoSuchFieldException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return objList;
    }

    @Override
    public T getById(int id) {
        T obj = null;
        DBStorageCRUD dbStorageCRUDInner = null;
        String sql = "SELECT * FROM storage." + nameTable + " WHERE id = ?";
        try {
            jdbcConnection = DBUtil.connect(jdbcConnection);

            PreparedStatement statement = jdbcConnection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            while (resultSet.next()) {
                obj = (T) clazz.newInstance();
                for (int index = 1; index <= resultSetMetaData.getColumnCount(); index++) {
                    String columnNameResultSet = resultSetMetaData.getColumnName(index);
                    Object columnValueResultSet = resultSet.getObject(index);
                    Field fieldObjByName = obj.getClass().getDeclaredField(columnNameResultSet);
                    fieldObjByName.setAccessible(true);
                    //set field(not primetive) enum, object(by relations)
                    if (fieldObjByName.getType().isEnum()) { //enum
                        fieldObjByName.set(obj, Enum.valueOf((Class<Enum>) fieldObjByName.getType(), (String) columnValueResultSet));
                    } else if (fieldObjByName.isAnnotationPresent(OneToOne.class)) { //OneToOne
                        String typeNameField = fieldObjByName.getType().getName();

                        Class clazzDBService = ServiceProvider.getService(typeNameField);
                        dbStorageCRUDInner = (DBStorageCRUD) clazzDBService.newInstance();
                        if (columnValueResultSet != null) {
                            fieldObjByName.set(obj, dbStorageCRUDInner.getById((int) columnValueResultSet));
                        }
                    } else if (fieldObjByName.isAnnotationPresent(ManyToOne.class) || fieldObjByName.isAnnotationPresent(ManyToMany.class)) { //ManyToMany
                        String typeNameField = fieldObjByName.getType().getName();

                        Class clazzDBService = ServiceProvider.getService(typeNameField);
                        dbStorageCRUDInner = (DBStorageCRUD) clazzDBService.newInstance();
                        if (columnValueResultSet != null) {
                            fieldObjByName.set(obj, dbStorageCRUDInner.getById((int) columnValueResultSet));
                        }
                    }else {//set field(primetive)
                        fieldObjByName.set(obj, columnValueResultSet);
                    }
                }

                //set other fields with annotations OneToMany, ManyToMany
                Field[] fields = obj.getClass().getDeclaredFields();
                Field idFieldObj = obj.getClass().getDeclaredField("id");
                idFieldObj.setAccessible(true);
                int idFieldObjValue = idFieldObj.getInt(obj);
                for (Field field : fields) {
                    if (field.isAnnotationPresent(OneToMany.class) || field.isAnnotationPresent(ManyToMany.class)) { //OneToMany
                        ParameterizedType pType = (ParameterizedType) field.getGenericType();
                        Class<?> clazz = (Class<?>) pType.getActualTypeArguments()[0];
                        String typeNameField = clazz.getName();

                        Class clazzDBService = ServiceProvider.getService(typeNameField);
                        dbStorageCRUDInner = (DBStorageCRUD) clazzDBService.newInstance();

                        OneToMany annotationOneToMany = field.getAnnotation(OneToMany.class);
                        if (annotationOneToMany != null) {
                            field.setAccessible(true);
                            field.set(obj, dbStorageCRUDInner.getAllByColumnName(idFieldObjValue, annotationOneToMany.mapping()));
                        }
                    }
                }

                objList.add(obj);
            }

            resultSet.close();
            statement.close();
            DBUtil.disconnect(jdbcConnection);
        } catch (SQLException | IllegalAccessException | NoSuchFieldException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return obj;
    }

    @Override
    public List<T> getAllByColumnName(int id, String mappingColumnName) { //select data by mapping column
        String sql = "SELECT * FROM storage." + nameTable + " where " + mappingColumnName + " = '" + id + "'";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        DBStorageCRUD dbStorageCRUDInner = null;
        try {
            jdbcConnection = DBUtil.connect(jdbcConnection);

            statement = jdbcConnection.prepareStatement(sql);
            resultSet = statement.executeQuery(sql);

            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            while (resultSet.next()) {
                T obj = (T) clazz.newInstance();
                for (int index = 1; index <= resultSetMetaData.getColumnCount(); index++) {
                    String columnNameResultSet = resultSetMetaData.getColumnName(index);
                    Object columnValueResultSet = resultSet.getObject(index);
                    Field fieldObjByName = obj.getClass().getDeclaredField(columnNameResultSet);
                    fieldObjByName.setAccessible(true);
                    //set field(not primetive) enum, object(by relations)
                    if (fieldObjByName.getType().isEnum()) { //enum
                        fieldObjByName.set(obj, Enum.valueOf((Class<Enum>) fieldObjByName.getType(), (String) columnValueResultSet));
                    } else if (fieldObjByName.isAnnotationPresent(OneToOne.class)) { //OneToOne
                        String typeNameField = fieldObjByName.getType().getName();

                        Class clazzDBService = ServiceProvider.getService(typeNameField);
                        dbStorageCRUDInner = (DBStorageCRUD) clazzDBService.newInstance();
                        if (columnValueResultSet != null) {
                            fieldObjByName.set(obj, dbStorageCRUDInner.getById((int) columnValueResultSet));
                        }
                    } else if (fieldObjByName.isAnnotationPresent(ManyToOne.class) || fieldObjByName.isAnnotationPresent(ManyToMany.class)) { //ManyToOne
                        //do not fill
                        //fieldObjByName.set(obj,);
                    } else if (fieldObjByName.isAnnotationPresent(OneToMany.class)) { //OneToMany
                        String typeNameField = fieldObjByName.getType().getName();

                        Class clazzDBService = ServiceProvider.getService(typeNameField);
                        dbStorageCRUDInner = (DBStorageCRUD) clazzDBService.newInstance();

                        OneToMany annotationOneToMany = fieldObjByName.getAnnotation(OneToMany.class);
                        if (annotationOneToMany != null) {
                            fieldObjByName.set(obj, dbStorageCRUDInner.getAllByColumnName(obj.getClass().getDeclaredField("id").getInt(obj), annotationOneToMany.mapping()));
                        }

                    } else {
                        fieldObjByName.set(obj, columnValueResultSet);
                    }
                }
                objList.add(obj);
            }
            resultSet.close();
            statement.close();
            DBUtil.disconnect(jdbcConnection);
        } catch (SQLException | IllegalAccessException | InstantiationException | NoSuchFieldException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return objList;
    }

    @Override
    public void delete(T o) {
        DBStorageCRUD dbStorageCRUDInner = null;

        try {

            jdbcConnection = DBUtil.connect(jdbcConnection);

            Field idFieldParamObj = o.getClass().getDeclaredField("id");
            idFieldParamObj.setAccessible(true);
            int idFieldParamObjValue = idFieldParamObj.getInt(o);
            String sql = "DELETE FROM " + nameTable + " where id = '" + idFieldParamObjValue + "'";
            PreparedStatement statement = jdbcConnection.prepareStatement(sql);

            Field[] fields = o.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(OneToMany.class) || field.isAnnotationPresent(ManyToMany.class)) {
                    Object objInnerCollection = field.get(o);
                    ParameterizedType pType = (ParameterizedType) field.getGenericType();
                    Class<?> clazz = (Class<?>) pType.getActualTypeArguments()[0];
                    String typeNameField = clazz.getName();

                    Class clazzDBService = ServiceProvider.getService(typeNameField);
                    dbStorageCRUDInner = (DBStorageCRUD) clazzDBService.newInstance();
                    if (objInnerCollection != null) {
                        for (Object objArray : (ArrayList) objInnerCollection) {
                            dbStorageCRUDInner.delete(objArray);
                        }
                    }
                }
            }

            boolean rowDeleted = statement.executeUpdate() > 0;
            statement.close();
            DBUtil.disconnect(jdbcConnection);
        } catch (SQLException | IllegalAccessException | NoSuchFieldException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(T o) {
        DBStorageCRUD dbStorageCRUDInner = null;

        StringBuilder sqlBuider = new StringBuilder("UPDATE " + nameTable + " SET ");

        try {
            jdbcConnection = DBUtil.connect(jdbcConnection);
            //generate sql query and insert field object
            Field[] fields = o.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(OneToOne.class) || field.isAnnotationPresent(ManyToOne.class)) {
                    Object objInner = field.get(o);
                    Field idFieldObj = objInner.getClass().getDeclaredField("id");
                    idFieldObj.setAccessible(true);
                    int idFieldObjValue = idFieldObj.getInt(objInner);

                    sqlBuider.append(field.getName() + "=");
                    sqlBuider.append("'" + idFieldObjValue + "',");

                    //get ServiceProvider
                    if (field.isAnnotationPresent(OneToOne.class)) {
                        String typeNameField = field.getType().getName();

                        Class clazzDBService = ServiceProvider.getService(typeNameField);
                        dbStorageCRUDInner = (DBStorageCRUD) clazzDBService.newInstance();
                        if (objInner != null) {
                            dbStorageCRUDInner.update(objInner);
                        }
                    }
                }else if (field.isAnnotationPresent(OneToMany.class) || field.isAnnotationPresent(ManyToMany.class)) {
                    Object objInnerCollection = field.get(o);
                    ParameterizedType pType = (ParameterizedType) field.getGenericType();
                    Class<?> clazz = (Class<?>) pType.getActualTypeArguments()[0];
                    String typeNameField = clazz.getName();

                    Class clazzDBService = ServiceProvider.getService(typeNameField);
                    dbStorageCRUDInner = (DBStorageCRUD) clazzDBService.newInstance();
                    if (objInnerCollection != null) {
                        for (Object objArray: (ArrayList)objInnerCollection) {
                            dbStorageCRUDInner.update(objArray);
                        }
                    }
                }else {
                    sqlBuider.append(field.getName() + "=");
                    sqlBuider.append("'" + field.get(o) + "',");
                }
            }

            Field idFieldObj = o.getClass().getDeclaredField("id");
            idFieldObj.setAccessible(true);
            int idFieldObjValue = idFieldObj.getInt(o);

            String sql = sqlBuider.substring(0, sqlBuider.length()-1).toString() + " WHERE id ='" + idFieldObjValue + "'";

            PreparedStatement statement = jdbcConnection.prepareStatement(sql);

            boolean rowInserted = statement.executeUpdate() > 0;
            statement.close();
            DBUtil.disconnect(jdbcConnection);
        } catch (SQLException | IllegalAccessException | InstantiationException | NoSuchFieldException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(T o) {

        DBStorageCRUD dbStorageCRUDInner = null;
        String sql = "INSERT INTO " + nameTable + " (";
        StringBuilder sqlColumns = new StringBuilder();
        StringBuilder sqlValue = new StringBuilder();

        try {
            jdbcConnection = DBUtil.connect(jdbcConnection);
            //generate sql query and insert field object
            Field[] fields = o.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(OneToOne.class) || field.isAnnotationPresent(ManyToOne.class)) {
                    Object objInner = field.get(o);
                    Field idFieldObj = objInner.getClass().getDeclaredField("id");
                    idFieldObj.setAccessible(true);
                    int idFieldObjValue = idFieldObj.getInt(objInner);

                    sqlColumns.append(field.getName() + ",");
                    sqlValue.append("'" + idFieldObjValue + "',");

                    //get ServiceProvider
                    if (field.isAnnotationPresent(OneToOne.class)) {
                        String typeNameField = field.getType().getName();

                        Class clazzDBService = ServiceProvider.getService(typeNameField);
                        dbStorageCRUDInner = (DBStorageCRUD) clazzDBService.newInstance();
                        if (objInner != null) {
                            dbStorageCRUDInner.save(objInner);
                        }
                    }
                }else if (field.isAnnotationPresent(OneToMany.class) || field.isAnnotationPresent(ManyToMany.class)) {
                    Object objInnerCollection = field.get(o);
                    ParameterizedType pType = (ParameterizedType) field.getGenericType();
                    Class<?> clazz = (Class<?>) pType.getActualTypeArguments()[0];
                    String typeNameField = clazz.getName();

                    Class clazzDBService = ServiceProvider.getService(typeNameField);
                    dbStorageCRUDInner = (DBStorageCRUD) clazzDBService.newInstance();
                    if (objInnerCollection != null) {
                        for (Object objArray: (ArrayList)objInnerCollection) {
                            dbStorageCRUDInner.save(objArray);
                        }
                    }
                }else {
                    sqlColumns.append(field.getName() + ",");
                    sqlValue.append("'" + field.get(o) + "',");
                }
            }
            sql += sqlColumns.substring(0, sqlColumns.length()-1) +
                    ") VALUES (" + sqlValue.substring(0, sqlValue.length()-1) + ")";

            PreparedStatement statement = jdbcConnection.prepareStatement(sql);

            boolean rowInserted = statement.executeUpdate() > 0;
            statement.close();
            DBUtil.disconnect(jdbcConnection);
        } catch (SQLException | IllegalAccessException | NoSuchFieldException | InstantiationException | ClassNotFoundException e) {
            //e.printStackTrace();
        }
    }
}
