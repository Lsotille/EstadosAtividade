package com.estados.controller.form;

import com.estados.modelo.Estados;
import com.estados.repository.EstadosRepository;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class EstadosForm {

    private String nome;
    @Pattern(regexp = "Norte|Nordeste|Sul|Sudeste|Centro-Oeste")
    private String regiao;
    private int populacao;
    private String capital;
    private Float area;
    private LocalDate dataCriacao;

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



    public Estados converter() {
        return new Estados(this.nome,this.regiao,this.populacao,this.capital,this.area,this.dataCriacao);
    }


    public Estados atualizar(Long id, EstadosRepository estadosRepository) {
        Estados estados = estadosRepository.getOne(id);
        estados.setArea(this.area);
        estados.setNome(this.nome);
        estados.setRegiao(this.regiao);
        estados.setCapital(this.capital);
        estados.setPopulacao(this.populacao);
        estados.setDataCriacao(this.dataCriacao);
        return estados;
    }
}
