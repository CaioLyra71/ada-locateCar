package view.locacao.util;

import model.veiculo.Veiculo;
import service.VeiculoService;
import service.exceptions.ServicoException;
import view.veiculo.util.MostrarTodosVeiculos;

import java.util.List;
import java.util.Scanner;

public class MenuEscolhaVeiculos {
    private final Scanner scanner;
    private final VeiculoService veiculoService;

    public MenuEscolhaVeiculos(Scanner scanner, VeiculoService veiculoService) {
        this.scanner = scanner;
        this.veiculoService = veiculoService;
    }

    public Veiculo executar() {
        var mostrarVeiculos = new MostrarTodosVeiculos(new String[]{
                "Nome", "Tipo","Valor da Diária"
        }, veiculoService.listarVeiculosDisponiveis());
        mostrarVeiculos.execute();

        System.out.println("Informe o nome do veículo que deseja locar: ");
        String nomeVeiculoDesejado = scanner.nextLine();
        List<Veiculo> veiculosEncontrados;
        Veiculo veiculoEscolhido = null;

        try {
            veiculosEncontrados = veiculoService.buscarVeiculoPorNome(nomeVeiculoDesejado);
            veiculoEscolhido = veiculosEncontrados.getFirst();
        } catch (ServicoException e) {
            System.err.println(e.getMessage());
            executar();
        }
        return veiculoEscolhido;
    }
}
