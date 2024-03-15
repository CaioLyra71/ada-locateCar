package infra.interfaces;

public interface BancoDadosDeleta<K, V> extends BancoDados<K, V> {
    Boolean deletar(K k);
}
