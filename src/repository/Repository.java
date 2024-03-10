package repository;

public interface Repository<T>{
    Boolean save(T t);
    T findById(String id);
    T update(String id, T t);
}
