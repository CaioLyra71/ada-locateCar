package infra;

import infra.exceptions.BancoDadosException;
import infra.interfaces.BancoDadosBuscaNome;
import model.veiculo.Veiculo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BancoDadosVeiculo implements BancoDadosBuscaNome<String, Veiculo> {
    private final Map<String, Veiculo> veiculos = new HashMap<>();

    @Override
    public Veiculo salvar(Veiculo veiculo) throws BancoDadosException {
        Veiculo veiculoASalvar = veiculos.put(veiculo.getPlacaVeiculo(), veiculo);
        if(veiculoASalvar == null) {
            throw new BancoDadosException("Falha ao tentar salvar o veículo");
        }
        return veiculoASalvar;
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
    public List<Veiculo> buscarPorNome(String nomeVeiculo) throws BancoDadosException {
        //lógica para buscar por nome
        throw new BancoDadosException("Veículo não foi encontrado");
    }
}
