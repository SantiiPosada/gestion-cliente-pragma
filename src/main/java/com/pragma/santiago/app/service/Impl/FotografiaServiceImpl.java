package com.pragma.santiago.app.service.Impl;


import com.pragma.santiago.app.model.entity.Fotografia;
import com.pragma.santiago.app.repository.FotografiaRepository;
import com.pragma.santiago.app.service.FotografiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class FotografiaServiceImpl implements FotografiaService {

	@Autowired
	private FotografiaRepository fotografiaRepository;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<Fotografia> findAll() {
		return this.fotografiaRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Fotografia findByIdCliente(Integer idCliente) {
		return this.fotografiaRepository.BuscarFotografiaIdCliente(idCliente);
	}

	@Override
	@Transactional
	public Fotografia save(Fotografia fotografia) {
		return this.save(fotografia);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		this.fotografiaRepository.deleteById(id);
	}

	
}
