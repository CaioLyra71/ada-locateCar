package infra;

import model.cliente.Cliente;
import model.veiculo.Veiculo;

import java.util.List;
import java.util.Map;

public class BandoDados {
    private Map<String, Cliente> clientes;
    private Map<String, Veiculo> veiculos;
    private Map<Cliente, Veiculo> locacoes;

    public List<Veiculo> buscarPorNome(String nomeVeiculo) {
        //lógica para buscar por nome
        throw new RuntimeException("Veículo não foi encontrado");
    }
}
