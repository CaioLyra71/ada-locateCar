package view;

import view.components.menu.ItemMenu;
import view.components.menu.MenuAbstrato;
import view.veiculo.MenuVeiculo;

import java.util.Scanner;

public class Menu extends MenuAbstrato {

    public Menu(Scanner scanner) {
        super(new ItemMenu[] {
                new ItemMenu(1, "Locação"),
                new ItemMenu(2, "Cliente"),
                new ItemMenu(3, "Veículo"),
                new ItemMenu(0, "Sair"),
        }, scanner);
    }

    @Override
    protected void executarOpcao(Integer opcao) {
        switch (opcao){
            case 1 -> System.out.println("menu locação");
            case 2 -> System.out.println("menu cliente");
            case 3 -> new MenuVeiculo(this.scanner).executar();
            case 0 -> System.exit(1);
            default -> System.out.println("Opção inválida");
        }
        executar();
    }
}
