package service;

import model.veiculo.Veiculo;
import repository.Repository;

import java.util.List;

public class VeiculoService {

    private final Repository<Veiculo> veiculoRepository;

    public VeiculoService(Repository<Veiculo> veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public Boolean salvarVeiculo(Veiculo veiculo){
        return null;
    }

    public List<Veiculo> buscarVeiculoPorNome(String nomeVeiculo){
        return null;
    }

    public Veiculo buscarVeiculoPorId(String idVeiculo){
        return null;
    }

    public Veiculo atualizarVeiculo(Veiculo veiculo, String idVeiculo){
        return null;
    }

    public Boolean deletarVeiculo(String idVeiculo){
        return null;
    }
}
