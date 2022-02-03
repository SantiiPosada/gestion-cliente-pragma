package com.pragma.santiago.app.service;


import com.pragma.santiago.app.model.entity.Fotografia;

public interface FotografiaService {

	public Iterable<Fotografia> findAll();
	
	public Fotografia findByIdCliente(Integer id);
	
	public Fotografia  save(Fotografia fotografia);
	
	public void deleteById(Integer id);
	
}
