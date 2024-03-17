package view.cliente;

import view.cliente.atualizacao.MenuAtualizacaoCliente;
import view.cliente.cadastro.MenuCadastroCliente;
import view.components.menu.ItemMenu;
import view.components.menu.MenuAbstrato;

import java.util.Scanner;

public class MenuCliente extends MenuAbstrato {
    public MenuCliente(Scanner scanner) {
        super(new ItemMenu[]{
                new ItemMenu(1, "Cadastrar"),
                new ItemMenu(2, "Atualizar")
        }, scanner);
    }

    @Override
    protected void executarOpcao(Integer opcao) {
        switch (opcao){
            case 1 -> new MenuCadastroCliente(scanner).executar();
            case 2 -> new MenuAtualizacaoCliente(scanner).executar();
            default -> System.out.println("Opção inválida.");
        }
    }
}
