package service;


import models.Cliente;
import models.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ClienteRepository;
import repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@Service("clienteService")
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Optional<Cliente> getClienteById(Integer id) {
        return clienteRepository.findById(id);
    }

    @Override
    public List<Cliente> getAllCliente() {
        return clienteRepository.findAll();
    }

    @Override
    public void deleteAllCliente() {
        clienteRepository.deleteAll();
    }

    @Override
    public void deleteClienteById(Integer id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public void updateCliente(Cliente cliente) {
        if (cliente.getId() != null) {
            clienteRepository.save(cliente);
        }
    }

    @Override
    public void insertCliente(Cliente cliente) {
        if (cliente.getId() == null) {
            clienteRepository.save(cliente);
        }
    }
}
