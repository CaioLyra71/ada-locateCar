package view.cliente.util;

import model.cliente.ClientePessoaFisica;
import view.components.tabela.TabelaView;

import java.util.List;

public class MostrarTodosPessoaFisica {
    private final String[] cabecalhos;
    private final String[][] linhas;
    private final List<ClientePessoaFisica> clientes;

    public MostrarTodosPessoaFisica(String[] cabecalhos, List<ClientePessoaFisica> clientes) {
        this.cabecalhos = cabecalhos;
        this.clientes = clientes;
        this.linhas = new String[clientes.size()][cabecalhos.length];
    }

    public void executar() {
        for (int i = 0; i < clientes.size(); i++) {
            ClientePessoaFisica cliente = clientes.get(i);
            linhas[i][0] = cliente.getNomeCliente();
            linhas[i][1] = cliente.getCpf();
        }

        TabelaView tabelaView = new TabelaView(cabecalhos, linhas);
        tabelaView.executar();
    }
}
