package com.estados.repository;

import java.util.List;

import com.estados.modelo.Estados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.beans.factory.BeanCreationException;

public interface EstadosRepository extends JpaRepository<Estados, Long> {

	List<Estados> findByRegiao(String regiao);

    @Query("SELECT e from Estados e order by e.populacao desc")
	List<Estados> ordenarPorPopulacao();

	@Query("SELECT e from Estados e order by e.area desc")
	List<Estados> ordenarPorArea();

}
