package com.example.produtosapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Produto {
	
	@Id
	private String id;
	private String nome;
	private String descricao;
	private Double preco;
}
