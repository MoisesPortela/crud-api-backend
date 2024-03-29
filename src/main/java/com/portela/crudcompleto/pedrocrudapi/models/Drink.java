package com.portela.crudcompleto.pedrocrudapi.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

//anotação para criar tabela no jakarta, sendo o nome da tabela especificado na anotation
@Entity
@Table(name = "tb_drink")
public class Drink implements Serializable {
	private static final long serialVersionUID = 1L;
	// configurando a geração de id automatica pelo jakarta
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// omitindo a anotação column pq o jakarta já entende que cada caracteristica é
	// uma coluna
	private String nome;
	private String tipo;
	private Integer qtd;
	private String tamanho;
	private String preco;

	@ManyToMany
	@JoinTable(name = "tb_drinks_list", joinColumns = @JoinColumn(name = "drink_id"), inverseJoinColumns = @JoinColumn(name = "list_id"))
	private Set<DrinkList> drinksList = new HashSet<>();
	
	public Drink() {
	};

	public Drink(Long id, String nome, String tipo, Integer qtd, String tamanho, String preco) {
		this.id = id;
		this.nome = nome;
		this.tipo=tipo;
		this.qtd = qtd;
		this.tamanho = tamanho;
		this.preco = preco;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// gets and sets
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTipo() {
		return tipo;
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

	public Set<DrinkList> getDrinkList() {
		return drinksList;
	}

	// gerando o equal and hash code para comparar dois objetos nas tabelas
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Drink other = (Drink) obj;
		return Objects.equals(id, other.id);
	}

}
