package infra;

import infra.interfaces.BancoDadosDeleta;
import model.locacao.Locacao;

import java.util.List;
import java.util.Map;

public class BandoDadosLocacao implements BancoDadosDeleta<String, Locacao> {
    private final Map<String, Locacao> locacoes;

    public BandoDadosLocacao(Map<String, Locacao> locacoes) {
        this.locacoes = locacoes;
    }

    @Override
    public Boolean salvar(Locacao veiculo) {
        return null;
    }

    @Override
    public Boolean atualizar(String idLocacao, Locacao locacao) {
        return null;
    }

    @Override
    public List<Locacao> listarTodos() {
        return null;
    }

    @Override
    public Locacao buscarPorId(String s) {
        return null;
    }

    @Override
    public Boolean deletar(String idLocacao) {
        return null;
    }
}
