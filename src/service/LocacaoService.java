package service;

import model.locacao.Locacao;
import repository.Repository;

public class LocacaoService {
    private final Repository<Locacao> locacaoRepository;

    public LocacaoService(Repository<Locacao> locacaoRepository) {
        this.locacaoRepository = locacaoRepository;
    }

    public Boolean salvarLocacao(Locacao locacao) {
        return null;
    }

    public Locacao buscarLocacaoPorId(String idLocacao) {
        return null;
    }

    public Locacao atualizarLocacao(Locacao locacao, String idLocacao) {
        return null;
    }

    public Boolean deletarLocacao(String idLocacao) {
        return null;
    }
}
