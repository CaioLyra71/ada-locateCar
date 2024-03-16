package service;

import model.cliente.Cliente;
import repository.interfaces.Repositorio;

public class ClienteService {
    private final Repositorio<String,Cliente> clienteRepository;

    public ClienteService(Repositorio<String,Cliente> clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public String salvarCliente(Cliente cliente) {
        return null;
    }

    public String atualizarCliente(Cliente cliente) {
        return null;
    }

    public Cliente buscarClientePorId(String idCliente){
        return null;
    }
}
