package com.portela.crudcompleto.pedrocrudapi.dto;

import java.io.Serializable;

import com.portela.crudcompleto.pedrocrudapi.models.Drink;

public class DrinkDTO  implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nome;
	private String tipo;
	private Integer qtd;
	private String tamanho;
	private String preco;

	public DrinkDTO() {

	}

	public DrinkDTO(String nome, String tipo, Integer qtd, String tamanho, String preco) {
		this.nome = nome;
		this.tipo = tipo;
		this.qtd = qtd;
		this.tamanho = tamanho;
		this.preco = preco;
	}
	public DrinkDTO(Drink drink) {
		nome = drink.getNome();
		tipo = drink.getTipo();
		qtd = drink.getQtd();
		tamanho = drink.getTamanho();
		preco = drink.getPreco();
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}
	

}
