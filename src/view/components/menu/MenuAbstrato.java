package view.components.menu;

import java.util.Scanner;

public abstract class MenuAbstrato {

    private final ItemMenu[] itensMenu;
    private final Scanner scanner;

    public MenuAbstrato(ItemMenu[] itensMenu, Scanner scanner) {
        this.itensMenu = itensMenu;
        this.scanner = scanner;
    }

    public void executar() {
        for(ItemMenu itemMenu : itensMenu) {
            System.out.println(itemMenu.getCodigo() + " - " + itemMenu.getTexto());
        }
        System.out.println("Informe o número da opção: ");
        Integer opcao = scanner.nextInt();
        executarOpcao(opcao, scanner);
    }

    protected abstract void executarOpcao(Integer opcao, Scanner scanner);
}

