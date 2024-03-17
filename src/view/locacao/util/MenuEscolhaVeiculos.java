package view.locacao.util;

import model.veiculo.Veiculo;
import service.VeiculoService;
import service.exceptions.ModeloException;
import service.exceptions.ServicoException;
import view.veiculo.util.MostrarTodosVeiculos;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class MenuEscolhaVeiculos {
    private final Scanner scanner;
    private final Set<Veiculo> veiculosDesejados;
    private final VeiculoService veiculoService;

    public MenuEscolhaVeiculos(Scanner scanner, Set<Veiculo> veiculosDesejados, VeiculoService veiculoService) {
        this.scanner = scanner;
        this.veiculosDesejados = veiculosDesejados;
        this.veiculoService = veiculoService;
    }

    public void executar() {
        var mostrarVeiculos = new MostrarTodosVeiculos(new String[]{
                "Nome", "Tipo","Valor da Diária"
        }, veiculoService.listarVeiculosDisponiveis());
        mostrarVeiculos.execute();

        scanner.nextLine();
        System.out.println("Informe o nome do veículo que deseja locar: ");
        String nomeVeiculoDesejado = scanner.nextLine();
        List<Veiculo> veiculosEncontrados;

        try {
            veiculosEncontrados = veiculoService.buscarVeiculoPorNome(nomeVeiculoDesejado);
            Veiculo veiculoDesejado = veiculosEncontrados.getFirst();
            veiculosDesejados.add(veiculoDesejado);
            System.out.println("Digite 'S' se desejar adicionar mais  ou 'N' para sair: ");
            String adicionaMaisVeiculos = scanner.nextLine();
            if (adicionaMaisVeiculos.equalsIgnoreCase("s")){
                executar();
            }
        } catch (ServicoException e) {
            System.err.println(e.getMessage());
            executar();
        }

    }
}
