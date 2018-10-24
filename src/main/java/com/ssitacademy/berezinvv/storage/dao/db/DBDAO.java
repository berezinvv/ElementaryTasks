package com.ssitacademy.berezinvv.storage.dao.db;

import java.util.List;

public interface DBDAO<T> {
    public List<T> getAll();

    public T getById(int id);

    public List<T> getAllByColumnName(int id, String mappingColumnName);

    public void update(T o);

    public void delete(T o);

    public void save(T o);
}
