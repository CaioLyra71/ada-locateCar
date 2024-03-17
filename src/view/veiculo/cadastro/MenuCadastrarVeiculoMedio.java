package view.veiculo.cadastro;

import model.veiculo.Veiculo;
import model.veiculo.VeiculoMedio;
import service.VeiculoService;
import service.exceptions.ServicoException;

import java.util.Scanner;

public class MenuCadastrarVeiculoMedio {
    private final VeiculoService veiculoService;
    private final Scanner scanner;

    public MenuCadastrarVeiculoMedio(VeiculoService veiculoService, Scanner scanner) {
        this.veiculoService = veiculoService;
        this.scanner = scanner;
    }


    public void executar() {
        scanner.nextLine();
        System.out.print("Informe o nome do veículo: ");
        String nomeVeiculo = this.scanner.nextLine();
        System.out.print("Informe a placa do veículo: ");
        String placaVeiculo = this.scanner.nextLine();

        Veiculo veiculoMedio = new VeiculoMedio(nomeVeiculo, placaVeiculo);

        try {
            System.out.println(veiculoService.salvarVeiculo(veiculoMedio));
        } catch (ServicoException e) {
            System.err.println(e.getMessage());
        }
    }
}
