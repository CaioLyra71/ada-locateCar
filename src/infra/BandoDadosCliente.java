package infra;

import infra.interfaces.BancoDados;
import model.cliente.Cliente;

import java.util.List;
import java.util.Map;

public class BandoDadosCliente implements BancoDados<String, Cliente> {
    private Map<String, Cliente> clientes;


    @Override
    public Boolean salvar(Cliente cliente) {
        return null;
    }

    @Override
    public Boolean atualizar(String s, Cliente cliente) {
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
