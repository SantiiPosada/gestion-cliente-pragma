package com.pragma.santiago.app.service;

import com.pragma.santiago.app.model.dto.ClienteDTO;
import com.pragma.santiago.app.model.entity.Cliente;

import java.util.ArrayList;
import java.util.Optional;


public interface ClienteService {

	
	public ClienteDTO  guardar(ClienteDTO clienteDTO);

	public ClienteDTO  modificar(ClienteDTO clienteDTO,Integer clienteId);

	public ArrayList<ClienteDTO> buscarTodo();

	public ClienteDTO buscarId(Integer id);

	public boolean eliminar(Integer id);


}
