package com.example.demo.service;

import com.example.demo.model.Pedido;
import com.example.demo.model.PedidoBolo;
import com.example.demo.repository.PedidoRepository;
import com.example.demo.repository.PedidoBoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final PedidoBoloRepository pedidoBoloRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository, PedidoBoloRepository pedidoBoloRepository) {
        this.pedidoRepository = pedidoRepository;
        this.pedidoBoloRepository = pedidoBoloRepository;
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido criarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido atualizarPedido(Long id, Pedido novoPedido) {
        if (pedidoRepository.existsById(id)) {
            novoPedido.setId(id);
            return pedidoRepository.save(novoPedido);
        } else {
            return null;
        }
    }

    public boolean deletarPedido(Long id) {
        if (pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public List<PedidoBolo> listarPedidosBolo() {
        return pedidoBoloRepository.findAll();
    }

    public PedidoBolo criarPedidoBolo(PedidoBolo pedidoBolo) {
        return pedidoBoloRepository.save(pedidoBolo);
    }

    public PedidoBolo atualizarPedidoBolo(Long id, PedidoBolo novoPedidoBolo) {
        if (pedidoBoloRepository.existsById(id)) {
            novoPedidoBolo.setId(id);
            return pedidoBoloRepository.save(novoPedidoBolo);
        } else {
            return null;
        }
    }

    public boolean deletarPedidoBolo(Long id) {
        if (pedidoBoloRepository.existsById(id)) {
            pedidoBoloRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
