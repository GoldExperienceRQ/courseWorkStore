package org.example.courseworkstore.dao;

import java.util.List;

public interface GenericDao<T> {

    List<T> getAll();

    void create(T entity);

    T read(String name);

    void update(T entity);

    void delete(String name);
}
