package infra;

import infra.interfaces.BancoDados;
import model.cliente.Cliente;

import java.util.List;
import java.util.Map;

public class BancoDadosCliente implements BancoDados<String, Cliente> {
    private Map<String, Cliente> clientes;


    @Override
    public Cliente salvar(Cliente cliente) {
        return null;
    }

    @Override
    public Cliente atualizar(String s, Cliente cliente) {
        return null;
    }

    @Override
    public List<Cliente> listarTodos() {
        return null;
    }

    @Override
    public Cliente buscarPorId(String s) {
        return null;
    }
}
