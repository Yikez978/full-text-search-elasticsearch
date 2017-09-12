package br.com.sabino.lab.elk.services;

import br.com.sabino.lab.elk.domain.Cliente;
import br.com.sabino.lab.elk.repository.ClienteRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ClienteService {

    private ClienteRepository repository;

    @Inject
    public void setRepository(ClienteRepository repository) {
        this.repository = repository;
    }

    public void novo(Cliente cliente) {
        repository.save(cliente);
    }

    public Cliente atualiza(Cliente cliente) {
        return repository.update(cliente);
    }

    public void remove(Long id) {
        repository.remove(id);
    }

    public Cliente buscarPeloId(Long id) {
        return repository.findById(id);
    }

    public List<Cliente> todos() {
        return repository.findAll();
    }
}
