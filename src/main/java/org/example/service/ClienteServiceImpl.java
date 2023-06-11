package org.example.service;


import org.example.models.Cliente;
import org.example.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

//@Service = Define uma classe de Serviço
@Service("clienteService")
public class ClienteServiceImpl implements ClienteService {


    //@Autowired = Define pontos de injeção de dependencias dentro de uma classe
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
