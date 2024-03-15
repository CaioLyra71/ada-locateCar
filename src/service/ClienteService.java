package service;

import model.cliente.Cliente;
import repository.Repository;

public class ClienteService {
    private final Repository<Cliente> clienteRepository;

    public ClienteService(Repository<Cliente> clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Boolean salvarCliente(Cliente cliente) {
        return null;
    }

    public Cliente atualizarCliente(Cliente cliente) {
        return null;
    }

    public Cliente buscarClientePorId(String idCliente){
        return null;
    }

    public Boolean deletarCliente(String idCliente) {return null;}
}
