package service;

import models.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    Optional<Cliente> getClienteById(Integer id);
    List<Cliente> getAllCliente();
    void deleteAllCliente();
    void deleteClienteById(Integer id);
    void updateCliente(Cliente cliente);
    void insertCliente(Cliente cliente);
}
