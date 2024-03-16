package repository;

import model.cliente.Cliente;
import repository.interfaces.Repositorio;

import java.util.List;

public class ClienteRepository implements Repositorio<String, Cliente> {

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
