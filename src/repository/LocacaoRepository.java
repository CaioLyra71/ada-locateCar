package repository;

import infra.exceptions.BancoDadosException;
import infra.interfaces.BancoDadosDeleta;
import model.cliente.Cliente;
import model.locacao.Locacao;
import repository.exceptions.RepositorioException;
import repository.interfaces.RepositorioDeleta;

import java.util.List;

public class LocacaoRepository implements RepositorioDeleta<Cliente, Locacao> {
    private final BancoDadosDeleta<Cliente, Locacao> locacaoBancoDados;

    public LocacaoRepository(BancoDadosDeleta<Cliente, Locacao> locacaoBancoDados) {
        this.locacaoBancoDados = locacaoBancoDados;
    }

    @Override
    public Locacao salvar(Locacao locacao) throws RepositorioException {
        try {
            return locacaoBancoDados.salvar(locacao);
        } catch (BancoDadosException e) {
            throw new RepositorioException(e.getMessage(), e);
        }
    }

    @Override
    public Locacao atualizar(Cliente idLocacao, Locacao locacao) {
        return locacaoBancoDados.atualizar(idLocacao, locacao);
    }

    @Override
    public List<Locacao> listarTodos() {
        return locacaoBancoDados.listarTodos();
    }

    @Override
    public Locacao buscarPorId(Cliente idLocacao) {
        return locacaoBancoDados.buscarPorId(idLocacao);
    }

    @Override
    public Locacao deletar(Cliente idLocacao) {
        return locacaoBancoDados.deletar(idLocacao);
    }
}
