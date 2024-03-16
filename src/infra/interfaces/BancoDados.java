package infra.interfaces;

import infra.exceptions.BancoDadosException;

import java.util.List;

public interface BancoDados<K, V> {
    V salvar(V v) throws BancoDadosException;
    V atualizar(K k, V v);
    List<V> listarTodos();
    V buscarPorId(K k);
}
