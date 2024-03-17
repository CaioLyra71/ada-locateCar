package view.veiculo;

import model.veiculo.Veiculo;
import service.PessoaFisicaService;
import service.VeiculoService;
import service.exceptions.ModeloException;
import service.exceptions.ServicoException;
import view.cliente.util.MostrarTodosPessoaFisica;
import view.veiculo.util.MostrarTodosVeiculos;

import java.math.BigDecimal;
import java.util.Scanner;

public class MenuAtualizarVeiculo {

    private final Scanner scanner;
    private final VeiculoService veiculoService;
    private final MostrarTodosVeiculos todosVeiculos;

    public MenuAtualizarVeiculo(Scanner scanner, VeiculoService veiculoService) {
        this.scanner = scanner;
        this.veiculoService = veiculoService;
        this.todosVeiculos = new MostrarTodosVeiculos(
                new String[]{"Nome", "Tipo", "Valor da Diária"},
                veiculoService.listarTodos()
        );
    }
    public void executar(){
        scanner.nextLine();
        todosVeiculos.execute();

        System.out.print("Informe a placa do veículo: ");
        String placaVeiculo = scanner.nextLine();



        try {
            Veiculo veiculoDesejado = veiculoService.buscarVeiculoPorId(placaVeiculo);
            System.out.print("Informe o novo nome do veículo: ");
            String novoNome = scanner.nextLine();
            System.out.print("Informe a nova placa: ");
            String novaPlaca = scanner.nextLine();
            System.out.print("Informe o novo valor da diária do veículo: R$");
            String novoValorDiaria = scanner.nextLine();

            if (novoNome != null && !novoNome.trim().isEmpty()) {
                veiculoDesejado.setNomeVeiculo(novoNome);
            }
            if (novaPlaca != null && !novaPlaca.trim().isEmpty()){
                veiculoDesejado.setPlacaVeiculo(novaPlaca);
            }
            if(novoValorDiaria != null && novoValorDiaria.trim().isEmpty()){
                veiculoDesejado.setValorDiaria(new BigDecimal(novoValorDiaria));
            }

            System.out.println(veiculoService.atualizarVeiculo(veiculoDesejado, placaVeiculo));

        } catch (ServicoException | ModeloException e) {
            System.err.println(e.getMessage());
        }
    }
}
