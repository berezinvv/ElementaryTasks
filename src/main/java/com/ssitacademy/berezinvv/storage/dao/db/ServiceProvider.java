package com.ssitacademy.berezinvv.storage.dao.db;

import com.ssitacademy.berezinvv.storage.annotations.Service;
import org.reflections.Reflections;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Set;

public class ServiceProvider {
    public static Class<?> getService(String className) throws ClassNotFoundException {
        Reflections reflections = new Reflections("");
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Service.class);
        for (Class<?> cl : classes) {
            Type type = ((ParameterizedType) cl.getGenericSuperclass())
                    .getActualTypeArguments()[0];
            try {
                if (type.equals(Class.forName(className))) {
                    return cl;
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        throw new ClassNotFoundException();
    }
}
