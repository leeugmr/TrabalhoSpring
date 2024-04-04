package com.example.demo.controller;

import com.example.demo.model.ProdutoPadaria;
import com.example.demo.service.ProdutoPadariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoPadariaController {

    @Autowired
    private ProdutoPadariaService produtoPadariaService;

    @GetMapping
    public List<ProdutoPadaria> listarProdutos() {
        return produtoPadariaService.listarProdutos();
    }

    @PostMapping
    public ResponseEntity<ProdutoPadaria> criarProduto(@RequestBody ProdutoPadaria produto) {
        ProdutoPadaria novoProduto = produtoPadariaService.criarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoPadaria> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoPadaria novoProduto) {
        ProdutoPadaria produtoAtualizado = produtoPadariaService.atualizarProduto(id, novoProduto);
        if (produtoAtualizado != null) {
            return ResponseEntity.ok(produtoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        if (produtoPadariaService.deletarProduto(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

