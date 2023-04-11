package dao.interfaces;

import java.util.List;

public interface Dao <T>{
    T save(T object);

    void update(T object);

    T findById(T object);

    void delete(T object);

    List<T> findAll(T object);
}

