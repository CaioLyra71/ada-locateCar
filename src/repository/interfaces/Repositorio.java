package repository.interfaces;

import repository.exceptions.RepositorioException;

import java.util.List;

public interface Repositorio<K, V>{
    V salvar(V v) throws RepositorioException;
    V atualizar(K k, V v);
    List<V> listarTodos();
    V buscarPorId(K k);
}
