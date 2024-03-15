package infra;

import infra.exceptions.BancoDadosException;
import infra.interfaces.BancoDadosBuscaNome;
import model.veiculo.Veiculo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BandoDadosVeiculo implements BancoDadosBuscaNome<String, Veiculo> {
    private final Map<String, Veiculo> veiculos = new HashMap<>();

    @Override
    public Boolean salvar(Veiculo veiculo) {
        veiculos.put(veiculo.getPlacaVeiculo(), veiculo);
        return true;
    }

    @Override
    public Boolean atualizar(String s, Veiculo veiculo) {
        return null;
    }

    @Override
    public List<Veiculo> buscarPorNome(String nomeVeiculo) throws BancoDadosException {
        //lógica para buscar por nome
        throw new BancoDadosException("Veículo não foi encontrado");
    }
}
