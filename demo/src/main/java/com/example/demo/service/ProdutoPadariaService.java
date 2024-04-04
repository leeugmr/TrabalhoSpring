package com.example.demo.service;

import com.example.demo.model.ProdutoPadaria;
import com.example.demo.repository.ProdutoPadariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoPadariaService {

    @Autowired
    private ProdutoPadariaRepository produtoPadariaRepository;

    public List<ProdutoPadaria> listarProdutos() {
        return produtoPadariaRepository.findAll();
    }

    public ProdutoPadaria criarProduto(ProdutoPadaria produto) {
        return produtoPadariaRepository.save(produto);
    }

    public ProdutoPadaria atualizarProduto(Long id, ProdutoPadaria novoProduto) {
        Optional<ProdutoPadaria> optionalProduto = produtoPadariaRepository.findById(id);
        if (optionalProduto.isPresent()) {
            ProdutoPadaria produtoExistente = optionalProduto.get();
            produtoExistente.setNome(novoProduto.getNome());
            produtoExistente.setPreco(novoProduto.getPreco());
            return produtoPadariaRepository.save(produtoExistente);
        } else {
            return null; // ou lançar uma exceção indicando que o produto não foi encontrado
        }
    }

    public boolean deletarProduto(Long id) {
        if (produtoPadariaRepository.existsById(id)) {
            produtoPadariaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
