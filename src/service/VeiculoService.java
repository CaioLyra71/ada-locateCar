package service;

import model.veiculo.Veiculo;
import repository.interfaces.RepositorioBuscaPorNome;
import repository.exceptions.RepositorioException;
import service.exceptions.ModeloException;
import service.exceptions.ServicoException;

import java.util.List;

public class VeiculoService {

    private final RepositorioBuscaPorNome<String, Veiculo> veiculoRepository;

    public VeiculoService(RepositorioBuscaPorNome<String,Veiculo> veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public String salvarVeiculo(Veiculo veiculo) throws ServicoException {
        if (veiculo.getNomeVeiculo() == null || veiculo.getNomeVeiculo().trim().isEmpty()) {
            throw new ModeloException("Nome inválido");
        }
        if(veiculo.getPlacaVeiculo() == null || veiculo.getPlacaVeiculo().trim().isEmpty()){
            throw new ModeloException("Placa inválida");
        }

        try {
            veiculoRepository.salvar(veiculo);
            return "Veículo salvo com sucesso";
        } catch (RepositorioException e) {
            throw new ServicoException(e.getMessage(), e);
        }
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

    public Veiculo buscarVeiculoPorId(String idCliente) {
        return null;
    }

    public String atualizarVeiculo(Veiculo veiculo, String idVeiculo){
        return null;
    }
}
