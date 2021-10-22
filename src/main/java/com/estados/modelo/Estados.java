package com.estados.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Entity
public class Estados {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@Pattern(regexp = "Norte|Nordeste|Sul|Sudeste|Centro-Oeste")
	private String regiao;
	private int populacao;
	private String capital;
	private Float area;
	private LocalDate dataCriacao;
	private int tempoDesdeFundacao;

	public Estados() {
	}

	public Estados(String nome, String regiao, int populacao, String capital, Float area, LocalDate dataCriacao) {
		this.nome = nome;
		this.regiao = regiao;
		this.populacao = populacao;
		this.capital = capital;
		this.area = area;
		this.dataCriacao = dataCriacao;
		this.tempoDesdeFundacao = LocalDate.now().compareTo(dataCriacao);
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getRegiao() {
		return regiao;
	}

	public int getPopulacao() {
		return populacao;
	}

	public String getCapital() {
		return capital;
	}

	public Float getArea() {
		return area;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public int getTempoDesdeFundacao() {
		return tempoDesdeFundacao;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public void setPopulacao(int populacao) {
		this.populacao = populacao;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public void setArea(Float area) {
		this.area = area;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public void setTempoDesdeFundacao(int tempoDesdeFundacao) {
		this.tempoDesdeFundacao = tempoDesdeFundacao;
	}
}
