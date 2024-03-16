package infra.interfaces;

import java.util.List;

public interface BancoDados<K, V> {
    Boolean salvar(V v);
    Boolean atualizar(K k, V v);
    List<V> listarTodos();
    V buscarPorId(K k);
}
