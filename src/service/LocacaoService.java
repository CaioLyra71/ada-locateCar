package service;

import model.locacao.Locacao;
import repository.interfaces.Repositorio;
import repository.interfaces.RepositorioDeleta;

public class LocacaoService {
    private final RepositorioDeleta<String,Locacao> locacaoRepository;

    public LocacaoService(RepositorioDeleta<String,Locacao> locacaoRepository) {
        this.locacaoRepository = locacaoRepository;
    }

    public String salvarLocacao(Locacao locacao) {
        return null;
    }

    public Locacao buscarLocacaoPorId(String idLocacao) {
        return null;
    }

    public String atualizarLocacao(Locacao locacao, String idLocacao) {
        return null;
    }

    public String deletarLocacao(String idLocacao) {
        return null;
    }
}
