package view.veiculo;

import infra.BancoDadosVeiculo;
import repository.VeiculoRepository;
import service.VeiculoService;
import view.components.menu.ItemMenu;
import view.components.menu.MenuAbstrato;
import view.veiculo.cadastro.MenuCadastrarVeiculo;

import java.util.Scanner;

public class MenuVeiculo extends MenuAbstrato {
    public MenuVeiculo(Scanner scanner) {
        super(new ItemMenu[] {
                new ItemMenu(1, "Cadastrar"),
                new ItemMenu(2, "Atualizar"),
                new ItemMenu(3, "Buscar veículo por nome")
        }, scanner);
    }

    @Override
    protected void executarOpcao(Integer opcao) {
        switch (opcao) {
            case 1 -> new MenuCadastrarVeiculo(this.scanner).executar();
            case 2 -> System.out.println("atualizar");
            case 3 -> new MenuBuscarVeiculoPorNome(this.scanner,
                    new VeiculoService(new VeiculoRepository(new BancoDadosVeiculo())))
                    .executar();
            default -> System.out.println("Opção inválida");
        }
    }
}
