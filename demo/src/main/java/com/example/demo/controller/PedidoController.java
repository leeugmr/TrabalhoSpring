package com.example.demo.controller;

import com.example.demo.model.Pedido;
import com.example.demo.model.PedidoBolo;
import com.example.demo.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/bolos")
    public List<PedidoBolo> listarPedidosBolo() {
        return pedidoService.listarPedidosBolo();
    }

    @PostMapping("/bolos")
    public ResponseEntity<PedidoBolo> criarPedidoBolo(@RequestBody PedidoBolo pedidoBolo) {
        PedidoBolo novoPedidoBolo = pedidoService.criarPedidoBolo(pedidoBolo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPedidoBolo);
    }

    @PutMapping("/bolos/{id}")
    public ResponseEntity<PedidoBolo> atualizarPedidoBolo(@PathVariable Long id, @RequestBody PedidoBolo novoPedidoBolo) {
        PedidoBolo pedidoBoloAtualizado = pedidoService.atualizarPedidoBolo(id, novoPedidoBolo);
        if (pedidoBoloAtualizado != null) {
            return ResponseEntity.ok(pedidoBoloAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/bolos/{id}")
    public ResponseEntity<?> deletarPedidoBolo(@PathVariable Long id) {
        if (pedidoService.deletarPedidoBolo(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidoService.listarPedidos();
    }

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {
        Pedido novoPedido = pedidoService.criarPedido(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> atualizarPedido(@PathVariable Long id, @RequestBody Pedido novoPedido) {
        Pedido pedidoAtualizado = pedidoService.atualizarPedido(id, novoPedido);
        if (pedidoAtualizado != null) {
            return ResponseEntity.ok(pedidoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPedido(@PathVariable Long id) {
        if (pedidoService.deletarPedido(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
