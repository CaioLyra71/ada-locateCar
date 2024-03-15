package repository;

import infra.BandoDadosVeiculo;
import infra.exceptions.BancoDadosException;
import model.veiculo.Veiculo;
import repository.exceptions.RepositorioException;

import java.util.List;

public class VeiculoRepository implements BuscaPorNome<Veiculo> {
    private final BandoDadosVeiculo bandoDadosVeiculo;

    public VeiculoRepository(BandoDadosVeiculo bandoDadosVeiculo) {
        this.bandoDadosVeiculo = bandoDadosVeiculo;
    }

    @Override
    public Boolean salvar(Veiculo veiculo) {
        return bandoDadosVeiculo.salvar(veiculo);
    }

    @Override
    public List<Veiculo> buscarPorNome(String nomeVeiculo) throws RepositorioException {
        try {
            return bandoDadosVeiculo.buscarPorNome(nomeVeiculo);
        } catch (BancoDadosException e) {
            throw new RepositorioException("O veículo não foi encotrado",e);
        }
    }

    @Override
    public Veiculo buscarPorId(String id) {
        return null;
    }

    @Override
    public Veiculo atualizar(String id, Veiculo veiculo) {
        return null;
    }

    @Override
    public Boolean deletar(String id) {
        return null;
    }
}
