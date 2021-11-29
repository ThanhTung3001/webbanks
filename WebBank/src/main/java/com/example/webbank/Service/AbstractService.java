package com.example.webbank.Service;

import java.util.List;

public interface AbstractService<T> {
    public  void save(T t);
    public List<T>findAll();
    public T findById(Long t);
    public List<T>findByName(String name);
    public void deleteById(Long id);
}
