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
    public Veiculo atualizar(String idVeiculo, Veiculo veiculo) {
        return bancoDadosVeiculo.atualizar(idVeiculo, veiculo);
    }

    @Override
    public List<Veiculo> listarTodos() {
        return bancoDadosVeiculo.listarTodos();
    }

    @Override
    public Veiculo buscarPorId(String idVeiculo) throws RepositorioException {
        Veiculo veiculo = bancoDadosVeiculo.buscarPorId(idVeiculo);
        if (veiculo == null) {
            throw new RepositorioException("Veículo não existe.");
        }
        return veiculo;
    }

    @Override
    public List<Veiculo> buscarPorNome(String nome) {
        return bancoDadosVeiculo.buscarPorNome(nome);
    }
}
