package service;

import model.veiculo.Veiculo;
import repository.interfaces.RepositorioBuscaPorNome;
import repository.exceptions.RepositorioException;
import service.exceptions.ModeloException;
import service.exceptions.ServicoException;

import java.util.ArrayList;
import java.util.List;

public class VeiculoService {

    private final RepositorioBuscaPorNome<String, Veiculo> veiculoRepository;

    public VeiculoService(RepositorioBuscaPorNome<String,Veiculo> veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    private void validarNomeVeiculo(String nomeVeiculo) {
        if (nomeVeiculo == null || nomeVeiculo.trim().isEmpty()) {
            throw new ModeloException("Nome inválido");
        }
    }

    private void validarPlaca(String placaVeiculo) {
        if (placaVeiculo == null || placaVeiculo.trim().isEmpty()) {
            throw new ModeloException("Placa inválida.");
        }
        if (!placaVeiculo.matches("[A-Z]{3}-[0-9]{4}")){
            throw new ModeloException("Placa inválida. Ex.: AAA-1111");
        }
    }

    public String salvarVeiculo(Veiculo veiculo) throws ServicoException {
        try {
            validarNomeVeiculo(veiculo.getNomeVeiculo());
            validarPlaca(veiculo.getPlacaVeiculo());
            veiculoRepository.salvar(veiculo);
            return "Veículo salvo com sucesso";
        } catch (ModeloException e) {
            throw new ModeloException(e.getMessage());
        } catch (RepositorioException e) {
            throw new ServicoException(e.getMessage(), e);
        }
    }

    public List<Veiculo> buscarVeiculoPorNome(String nomeVeiculo) throws ServicoException {
        List<Veiculo> veiculosEncontrados;
        try {
            validarNomeVeiculo(nomeVeiculo);
            veiculosEncontrados = veiculoRepository.buscarPorNome(nomeVeiculo);
            return veiculosEncontrados;
        } catch (ModeloException e) {
            throw new ModeloException(e.getMessage());
        }  catch (RepositorioException e) {
            throw new ServicoException("O veículo não foi encontrado.", e);
        }
    }

    public Veiculo buscarVeiculoPorId(String idCliente) throws ServicoException {
        try {
            validarPlaca(idCliente);
            return veiculoRepository.buscarPorId(idCliente);
        } catch (RepositorioException e) {
            throw new ServicoException(e.getMessage(), e);
        }
    }

    public String atualizarVeiculo(Veiculo veiculo, String idVeiculo){
        return null;
    }

    public List<Veiculo> listarTodos() {
        return veiculoRepository.listarTodos();
    }

    public List<Veiculo> listarVeiculosDisponiveis() {
        var todosVeiculos = listarTodos();
        List<Veiculo> veiculosDisponiveis = new ArrayList<>();
        for (Veiculo veiculo : todosVeiculos){
            if (veiculo.getEstaDisponivel()) {
                veiculosDisponiveis.add(veiculo);
            }
        }
        return veiculosDisponiveis;
    }
}
