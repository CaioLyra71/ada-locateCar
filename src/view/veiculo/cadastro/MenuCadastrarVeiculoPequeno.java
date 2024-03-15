package view.veiculo.cadastro;

import model.veiculo.Veiculo;
import model.veiculo.VeiculoPequeno;
import service.VeiculoService;

import java.util.Scanner;

public class MenuCadastrarVeiculoPequeno {
    private final VeiculoService veiculoService;
    private final Scanner scanner;

    public MenuCadastrarVeiculoPequeno(VeiculoService veiculoService, Scanner scanner) {
        this.veiculoService = veiculoService;
        this.scanner = scanner;
    }

    public void executar() {
        this.scanner.nextLine();
        System.out.print("Informe o nome do veículo: ");
        String nomeVeiculo = this.scanner.nextLine();
        System.out.println("Informe a placa do veículo: ");
        String placaVeiculo = this.scanner.nextLine();

        Veiculo veiculoPequeno = new VeiculoPequeno(nomeVeiculo, placaVeiculo);

        Boolean salvou = veiculoService.salvarVeiculo(veiculoPequeno);
        if (salvou) {
            System.out.println("Veículo salvo com sucesso!");
        }
    }
}
