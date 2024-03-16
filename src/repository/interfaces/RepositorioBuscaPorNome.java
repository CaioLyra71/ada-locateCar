package repository.interfaces;

import repository.exceptions.RepositorioException;

import java.util.List;

public interface RepositorioBuscaPorNome<K,V> extends Repositorio<K,V> {
    List<V> buscarPorNome(String nome) throws RepositorioException;
}
