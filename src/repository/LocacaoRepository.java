package repository;

import model.locacao.Locacao;

public class LocacaoRepository implements Repository<Locacao> {
    @Override
    public Boolean salvar(Locacao locacao) {
        return null;
    }

    @Override
    public Locacao buscarPorId(String id) {
        return null;
    }

    @Override
    public Locacao atualizar(String id, Locacao locacao) {
        return null;
    }

    @Override
    public Boolean deletar(String id) {
        return null;
    }
}
