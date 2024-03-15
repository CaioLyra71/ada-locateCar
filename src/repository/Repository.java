package repository;

public interface Repository<T>{
    Boolean salvar(T t);
    T buscarPorId(String id);
    T atualizar(String id, T t);
    Boolean deletar(String id);
}
