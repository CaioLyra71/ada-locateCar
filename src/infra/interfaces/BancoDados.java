package infra.interfaces;

public interface BancoDados<K, V> {
    Boolean salvar(V v);
    Boolean atualizar(K k, V v);
}
