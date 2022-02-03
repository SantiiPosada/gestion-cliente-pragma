package com.pragma.santiago.app.repository;


import com.pragma.santiago.app.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	
	@Query("select x from Cliente x where x.correo= :correo")
	public Cliente BuscarClienteCorreo(@Param("correo") String correo);
	
	@Query("select x from Cliente x where x.identificacion= :identificacion")
	public Cliente BuscarClienteIdentificacion(@Param("identificacion") Long identificacion);
	
}
