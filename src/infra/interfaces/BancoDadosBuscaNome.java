package infra.interfaces;

import infra.exceptions.BancoDadosException;

import java.util.List;

public interface BancoDadosBuscaNome<K, V> extends BancoDados<K, V>{
    List<V> buscarPorNome(K k);
}
