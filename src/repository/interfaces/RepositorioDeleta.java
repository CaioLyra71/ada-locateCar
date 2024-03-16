package repository.interfaces;

public interface RepositorioDeleta <K, V> extends Repositorio<K, V> {
    String deletar(K k);
}
