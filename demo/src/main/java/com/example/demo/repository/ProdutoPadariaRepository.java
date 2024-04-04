package com.example.demo.repository;

import com.example.demo.model.ProdutoPadaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoPadariaRepository extends JpaRepository<ProdutoPadaria, Long> {
}
