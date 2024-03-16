package repository;

import infra.BancoDadosVeiculo;
import infra.exceptions.BancoDadosException;
import model.veiculo.Veiculo;
import repository.exceptions.RepositorioException;
import repository.interfaces.RepositorioBuscaPorNome;

import java.util.List;

public class VeiculoRepository implements RepositorioBuscaPorNome<String,Veiculo> {
    private final BancoDadosVeiculo bancoDadosVeiculo;

    public VeiculoRepository(BancoDadosVeiculo bancoDadosVeiculo) {
        this.bancoDadosVeiculo = bancoDadosVeiculo;
    }


    @Override
    public Veiculo salvar(Veiculo veiculo) throws RepositorioException {
        try {
            return bancoDadosVeiculo.salvar(veiculo);
        } catch (BancoDadosException e) {
            throw new RepositorioException(e.getMessage(), e);
        }
    }

    @Override
    public Veiculo atualizar(String s, Veiculo veiculo) {
        return null;
    }

    @Override
    public List<Veiculo> listarTodos() {
        return null;
    }

    @Override
    public Veiculo buscarPorId(String s) {
        return null;
    }

    @Override
    public List<Veiculo> buscarPorNome(String nome) {
        return null;
    }
}
