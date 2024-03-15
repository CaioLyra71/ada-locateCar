package view.veiculo;

import view.components.menu.ItemMenu;
import view.components.menu.MenuAbstrato;

import java.util.Scanner;

public class MenuVeiculo extends MenuAbstrato {
    public MenuVeiculo(ItemMenu[] itensMenu, Scanner scanner) {
        super(itensMenu, scanner);
    }

    @Override
    protected void executarOpcao(Integer opcao, Scanner scanner) {
        switch (opcao) {
            case 1 -> System.out.println("cadastrar");
            case 2 -> System.out.println("atualizar");
            case 3 -> System.out.println("buscar por nome");
            default -> System.out.println("Opção inválida");
        }
        executar();
    }
}
