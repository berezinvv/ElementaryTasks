package com.ssitacademy.berezinvv.storage.dao;

import java.util.List;

public interface DAO<T> {
    public List<T> getAll();

    public T getById(int id);

    public void update(T o);

    public void delete(T o);

    public void save(T o);
}
