package com.example.demo.service;

import com.example.demo.model.AvaliacaoComentario;
import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }
    
    public Cliente getClientById(Long id) {
    	Cliente addClientComentary = null;
    	for (Cliente element : this.listarClientes()) {
			if(element.getId() == id ) {
				addClientComentary = element;
			}
		}
    	return addClientComentary;
    }

    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    
    public Cliente addAvaliacao(Long id, AvaliacaoComentario avaliacao) {
    	Cliente addClientComentary = this.getClientById(id);
    	
    	if(addClientComentary == null) {
    		return null;
    	} else {
    		addClientComentary.addAvaliacao(avaliacao);
    		return clienteRepository.save(addClientComentary);
    	}
	}
    
    public List<AvaliacaoComentario> getListaAvaliacoes() {
		return getListaAvaliacoes();
	}

    public Cliente atualizarCliente(Long id, Cliente novoCliente) {
        if (clienteRepository.existsById(id)) {
            novoCliente.setId(id);
            return clienteRepository.save(novoCliente);
        } else {
            return null;
        }
    }

    public boolean deletarCliente(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public ClienteRepository getClienteRepository() {
        return clienteRepository;
    }

    public void setClienteRepository(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
}
