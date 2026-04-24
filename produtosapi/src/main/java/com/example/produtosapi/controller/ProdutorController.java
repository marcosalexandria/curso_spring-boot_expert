package com.example.produtosapi.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.produtosapi.model.Produto;
import com.example.produtosapi.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutorController {
	
	private ProdutoRepository produtoRepository;
	
	public ProdutorController(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	@PostMapping
	public Produto salvar(@RequestBody Produto produto) {
		System.out.println("Produto recebido: " + produto);
		//forma de gerar um id único para o produto, utilizando a classe UUID do Java
		//gera algo como 4e3de94a-acd2-4b79-b0fc-cd06ee4b9645
		UUID uuid = UUID.randomUUID();
		produto.setId(uuid.toString());
		Produto produtoSalvo = produtoRepository.save(produto);
		System.out.println("Produto salvo: " + produtoSalvo);
		return produtoSalvo;
	}
	
	@GetMapping("/{id}")
	public Produto obterPorId(@PathVariable String id) {
		return produtoRepository.findById(id).orElse(null);
	}
	
	@DeleteMapping("/{id}")
	public void deletarPorId(@PathVariable String id) {
		produtoRepository.deleteById(id);
	}
}
