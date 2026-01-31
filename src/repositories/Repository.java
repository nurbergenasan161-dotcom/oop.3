package repositories;

import java.util.List;

public interface Repository<T> {
    T create(T item);
    List<T> findAll();
    T findById(int id);
}
