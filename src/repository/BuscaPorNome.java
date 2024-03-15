package repository;

public interface BuscaPorNome<T> extends Repository<T> {
    T buscarPorNome(String nome);
}
