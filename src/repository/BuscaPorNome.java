package repository;

import repository.exceptions.RepositorioException;

import java.util.List;

public interface BuscaPorNome<T> extends Repository<T> {
    List<T> buscarPorNome(String nome) throws RepositorioException;
}
