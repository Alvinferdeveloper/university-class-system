package com.albin.universitySystem.Services;
import java.util.List;

public interface ICrud<V, K> {
    public K insert(V obj);
    public K update(Long id,V obj);
    public void delete(long id);
    public K findById(long id);
    public List<K> findAll();
}
