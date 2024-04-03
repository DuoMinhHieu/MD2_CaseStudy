package controller;

import java.util.List;

public interface IController<E> {
    void add(E e);
    void edit(int index, E e);
    void delete(int index);
    List<E> findAll();
    int findByID(int id);
    List<E> findByName(String name);
}
