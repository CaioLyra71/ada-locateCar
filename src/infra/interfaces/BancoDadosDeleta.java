package infra.interfaces;

import model.locacao.Locacao;

public interface BancoDadosDeleta<K, V> extends BancoDados<K, V> {
    Locacao deletar(K k);
}
