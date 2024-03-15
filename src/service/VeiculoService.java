package service;

import model.veiculo.Veiculo;
import repository.BuscaPorNome;
import repository.exceptions.RepositorioException;
import service.exceptions.ModeloException;
import service.exceptions.ServicoException;

import java.util.List;

public class VeiculoService {

    private final BuscaPorNome<Veiculo> veiculoRepository;

    public VeiculoService(BuscaPorNome<Veiculo> veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public Boolean salvarVeiculo(Veiculo veiculo){
        if (veiculo.getNomeVeiculo() == null || veiculo.getNomeVeiculo().trim().isEmpty()) {
            throw new ModeloException("Nome inválido");
        }
        if(veiculo.getPlacaVeiculo() == null || veiculo.getPlacaVeiculo().trim().isEmpty()){
            throw new ModeloException("Placa inválida");
        }

        return veiculoRepository.salvar(veiculo);
    }

    public List<Veiculo> buscarVeiculoPorNome(String nomeVeiculo) throws Exception {
        List<Veiculo> veiculosEncontrados;
        if(nomeVeiculo == null || nomeVeiculo.trim().isEmpty()) {
            throw new Exception("O nome do veículo não pode ser vazio");
        }
        // mais validações
        try {
            veiculosEncontrados = veiculoRepository.buscarPorNome(nomeVeiculo);
        } catch (RepositorioException e) {
            throw new ServicoException("O veículo não foi encontrado.", e);
        }
        return veiculosEncontrados;
    }

    public Veiculo atualizarVeiculo(Veiculo veiculo, String idVeiculo){
        return null;
    }

    public Boolean deletarVeiculo(String idVeiculo){
        return null;
    }
}
