package infra;

import infra.exceptions.BancoDadosException;
import infra.interfaces.BancoDados;
import model.cliente.ClientePessoaFisica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BancoDadosPessoaFisica implements BancoDados<String, ClientePessoaFisica> {

    private static final Map<String, ClientePessoaFisica> clientes = new HashMap<>();

    @Override
    public ClientePessoaFisica salvar(ClientePessoaFisica cliente) throws BancoDadosException {
        ClientePessoaFisica clienteExistente = buscarPorId(cliente.getCpf());
        if (clienteExistente != null) {
            throw new BancoDadosException("Cliente já existe.");
        }
        return clientes.put(cliente.getCpf(), cliente);
    }

    @Override
    public ClientePessoaFisica atualizar(String idCliente, ClientePessoaFisica clientePessoaFisica) {
        if (!idCliente.equals(clientePessoaFisica.getCpf())) {
            clientes.remove(idCliente);
        }
        return clientes.put(clientePessoaFisica.getCpf(), clientePessoaFisica);
    }

    @Override
    public List<ClientePessoaFisica> listarTodos() {
        List<ClientePessoaFisica> clientesPessoaFisica = new ArrayList<>();
        var entries = clientes.entrySet();
        for (var entry : entries) {
            clientesPessoaFisica.add(entry.getValue());
        }
        return clientesPessoaFisica;
    }

    @Override
    public ClientePessoaFisica buscarPorId(String idCliente) {
        return clientes.get(idCliente);
    }
}
