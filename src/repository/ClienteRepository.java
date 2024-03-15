package repository;

import model.cliente.Cliente;

public class ClienteRepository implements Repository<Cliente> {
    @Override
    public Boolean salvar(Cliente cliente) {
        return null;
    }

    @Override
    public Cliente atualizar(java.lang.String id, Cliente cliente) {
        return null;
    }

    @Override
    public Boolean deletar(String id) {
        return null;
    }
    @Override
    public Cliente buscarPorId(String id) {
        return null;
    }
}
