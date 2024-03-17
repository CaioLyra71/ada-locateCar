package repository.interfaces;

import model.locacao.Locacao;

public interface RepositorioDeleta <K, V> extends Repositorio<K, V> {
    Locacao deletar(K k);
}
