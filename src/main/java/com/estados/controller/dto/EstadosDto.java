package com.estados.controller.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.estados.modelo.Estados;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

public class EstadosDto {


	private Long id;
	private String nome;
	private String regiao;
	private int populacao;
	private String capital;
	private Float area;
	private LocalDate dataCriacao;
	private int tempoDesdeFundacao;
	
	public EstadosDto(Estados estados) {
		this.id = estados.getId();
		this.nome = estados.getNome();
		this.regiao = estados.getRegiao();
		this.populacao = estados.getPopulacao();
		this.capital = estados.getCapital();
		this.area = estados.getArea();
		this.dataCriacao = estados.getDataCriacao();
		this.tempoDesdeFundacao = estados.getTempoDesdeFundacao();
	}

	public static List<EstadosDto> converter(List<Estados> estados) {
		return estados.stream().map(EstadosDto::new).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public String getNome(){return nome;}

	public String getRegiao(){return regiao;}

	public int getPopulacao(){return populacao;}

	public String getCapital(){return capital;}

	public Float getArea(){return area;}

	public LocalDate getLocalDateTime(){return dataCriacao;}

	public int getTempoDesdeFundacao(){return tempoDesdeFundacao;}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}



}
