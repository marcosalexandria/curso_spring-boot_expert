package com.example.produtosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.produtosapi.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, String> {

}
