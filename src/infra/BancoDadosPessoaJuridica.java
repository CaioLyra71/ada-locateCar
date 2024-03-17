package infra;

import infra.exceptions.BancoDadosException;
import infra.interfaces.BancoDados;
import model.cliente.ClientePessoaJuridica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BancoDadosPessoaJuridica implements BancoDados<String, ClientePessoaJuridica> {
    protected static final Map<String, ClientePessoaJuridica> clientes = new HashMap<>();

    @Override
    public ClientePessoaJuridica salvar(ClientePessoaJuridica clientePessoaJuridica) throws BancoDadosException {
        var clienteExistente = buscarPorId(clientePessoaJuridica.getCnpj());
        if (clienteExistente != null) {
            throw new BancoDadosException("Cliente já existe.");
        }
        return clientes.put(clientePessoaJuridica.getCnpj(), clientePessoaJuridica);
    }

    @Override
    public ClientePessoaJuridica atualizar(String idCliente, ClientePessoaJuridica clientePessoaJuridica) {
        if (!idCliente.equals(clientePessoaJuridica.getCnpj())) {
            clientes.remove(idCliente);
        }
        return clientes.put(clientePessoaJuridica.getCnpj(), clientePessoaJuridica);
    }

    @Override
    public List<ClientePessoaJuridica> listarTodos() {
        List<ClientePessoaJuridica> clientes = new ArrayList<>();
        var entries = BancoDadosPessoaJuridica.clientes.entrySet();
        for (var entry : entries) {
            clientes.add(entry.getValue());
        }
        return clientes;
    }

    @Override
    public ClientePessoaJuridica buscarPorId(String idCliente) {
        return clientes.get(idCliente);
    }
}
