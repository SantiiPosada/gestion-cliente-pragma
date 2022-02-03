package com.pragma.santiago.app.repository;

import com.pragma.santiago.app.model.entity.Fotografia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface FotografiaRepository extends JpaRepository<Fotografia, Integer> {
	
	@Query("select x from Fotografia x where x.idCliente= :idCliente")
	public Fotografia BuscarFotografiaIdCliente(@Param("idCliente") Integer idCliente);
	
}
