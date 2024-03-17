package view.veiculo.cadastro;

import model.veiculo.Veiculo;
import model.veiculo.VeiculoSUV;
import service.VeiculoService;
import service.exceptions.ServicoException;

import java.util.Scanner;

public class MenuCadastrarVeiculoSUV {
    private final Scanner scanner;
    private final VeiculoService veiculoService;

    public MenuCadastrarVeiculoSUV(VeiculoService veiculoService, Scanner scanner) {
        this.veiculoService = veiculoService;
        this.scanner = scanner;
    }

    public void executar() {
        scanner.nextLine();
        System.out.print("Informe o nome do veículo: ");
        String nomeVeiculo = this.scanner.nextLine();
        System.out.print("Informe a placa do veículo: ");
        String placaVeiculo = this.scanner.nextLine();

        Veiculo veiculoSUV = new VeiculoSUV(nomeVeiculo, placaVeiculo);

        try {
            System.out.println(veiculoService.salvarVeiculo(veiculoSUV));
        } catch (ServicoException e) {
            System.err.println(e.getMessage());
        }
    }
}
