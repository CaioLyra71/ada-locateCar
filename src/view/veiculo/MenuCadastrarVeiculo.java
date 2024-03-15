package view.veiculo;

import model.veiculo.Veiculo;
import service.VeiculoService;
import view.components.menu.ItemMenu;
import view.components.menu.MenuAbstrato;

import java.util.Scanner;

public class MenuCadastrarVeiculo extends MenuAbstrato {

    public MenuCadastrarVeiculo(ItemMenu[] itensMenu, Scanner scanner) {
        super(itensMenu, scanner);
    }

    @Override
    protected void executarOpcao(Integer opcao, Scanner scanner) {
        switch (opcao) {
            case 1 -> System.out.println("pequeno");
            case 2 -> System.out.println("medio");
            case 3 -> System.out.println("suv");
            default -> System.out.println("Opcão inválida");
        }
        executar();
    }
}
