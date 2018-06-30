package net.java.main.interfaces;

import net.java.main.exceptions.NoUnitToRemoveExeption;

import java.util.Collection;

public interface Repository<T> {

    void save(T element);

    void remove(T element) throws NoUnitToRemoveExeption;

    Collection<T> findAll();

    T findByName(String name);
}
