package com.example.demo.controller;

import com.example.demo.model.AvaliacaoComentario;
import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    @PostMapping("/add_avaliacao/{id}")
    public ResponseEntity<Cliente> addAvaliacao(@PathVariable Long id, @RequestBody AvaliacaoComentario avaliacao) {
        Cliente cliente = clienteService.buscarClientePorId(id);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        } else {
            cliente.addAvaliacao(avaliacao);
            clienteService.atualizarCliente(id, cliente);
            return ResponseEntity.ok(cliente);
        }
    }

    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
        Cliente novoCliente = clienteService.criarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente novoCliente) {
        Cliente clienteAtualizado = clienteService.atualizarCliente(id, novoCliente);
        if (clienteAtualizado != null) {
            return ResponseEntity.ok(clienteAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCliente(@PathVariable Long id) {
        if (clienteService.deletarCliente(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idCliente}/remove_avaliacao/{idAvaliacao}")
    public ResponseEntity<Cliente> deleteAvaliacao(@PathVariable Long idCliente, @PathVariable Long idAvaliacao) {
        Cliente cliente = clienteService.buscarClientePorId(idCliente);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        } else {
            boolean removido = cliente.removerAvaliacao(idAvaliacao);
            if (removido) {
                clienteService.atualizarCliente(idCliente, cliente);
                return ResponseEntity.ok(cliente);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    }
}
