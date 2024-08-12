package com.albin.dbrelations.Services;

import java.util.List;

public interface ICrud<V> {
    public V insert(V obj);
    public V update(V obj);
    public void delete(V obj);
    public V findById(long id);
    public List<V> findAll();
}
