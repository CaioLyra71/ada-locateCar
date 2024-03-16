package infra;

import infra.interfaces.BancoDadosDeleta;
import model.locacao.Locacao;

import java.util.List;
import java.util.Map;

public class BancoDadosLocacao implements BancoDadosDeleta<String, Locacao> {
    private final Map<String, Locacao> locacoes;

    public BancoDadosLocacao(Map<String, Locacao> locacoes) {
        this.locacoes = locacoes;
    }

    @Override
    public Locacao salvar(Locacao veiculo) {
        return null;
    }

    @Override
    public Locacao atualizar(String idLocacao, Locacao locacao) {
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
