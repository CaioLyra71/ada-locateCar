package infra;

import infra.exceptions.BancoDadosException;
import infra.interfaces.BancoDadosBuscaNome;
import model.veiculo.Veiculo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BancoDadosVeiculo implements BancoDadosBuscaNome<String, Veiculo> {
    private final static Map<String, Veiculo> veiculos = new HashMap<>();

    @Override
    public Veiculo salvar(Veiculo veiculo) throws BancoDadosException {
        Veiculo veiculoASalvar = buscarPorId(veiculo.getPlacaVeiculo());
        if (veiculoASalvar != null) {
            throw new BancoDadosException("Veículo já existe.");
        }
        return veiculos.put(veiculo.getPlacaVeiculo(), veiculo);
    }

    @Override
    public Veiculo atualizar(String idVeiculo, Veiculo veiculo) {
        if(!idVeiculo.equals(veiculo.getPlacaVeiculo())){
            veiculos.remove(idVeiculo);
        }
        return veiculos.put(veiculo.getPlacaVeiculo(), veiculo);
    }

    @Override
    public List<Veiculo> listarTodos() {
        List<Veiculo> registros = new ArrayList<>();
        var entries = veiculos.entrySet();
        for (var entry : entries) {
            registros.add(entry.getValue());
        }
        return registros;
    }

    @Override
    public Veiculo buscarPorId(String idVeiculo) {
        return veiculos.get(idVeiculo);
    }

    @Override
    public List<Veiculo> buscarPorNome(String nomeVeiculo) {
        List<Veiculo> todosVeiculos = listarTodos();
        List<Veiculo> veiculosEncontrados = new ArrayList<>();
        for (Veiculo veiculo : todosVeiculos) {
            if (veiculo.getNomeVeiculo().toLowerCase().contains(nomeVeiculo.toLowerCase())
            && veiculo.getEstaDisponivel()) {
                veiculosEncontrados.add(veiculo);
            }
        }
        return veiculosEncontrados;
    }
}
