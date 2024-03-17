package view.veiculo;

import model.veiculo.Veiculo;
import service.VeiculoService;
import service.exceptions.ServicoException;
import view.veiculo.util.MostrarTodosVeiculos;

import java.util.List;
import java.util.Scanner;

public class MenuBuscarVeiculoPorNome {
    private final Scanner scanner;
    private final VeiculoService veiculoService;


    public MenuBuscarVeiculoPorNome(Scanner scanner, VeiculoService veiculoService) {
        this.scanner = scanner;
        this.veiculoService = veiculoService;
    }

    public void executar(){
        scanner.nextLine();

        System.out.print("Informe o nome do veículo: ");
        String nomeVeiculo = scanner.nextLine();

        try{
            List<Veiculo> veiculos = veiculoService.buscarVeiculoPorNome(nomeVeiculo);
            var mostrarVeiculos = new MostrarTodosVeiculos(
                    new String[] {
                            "Nome", "Tipo", "Valor Diária"
                    }, veiculos
            );
            mostrarVeiculos.execute();
        } catch (ServicoException e) {
            System.err.println(e.getMessage());
        }
    }

}
