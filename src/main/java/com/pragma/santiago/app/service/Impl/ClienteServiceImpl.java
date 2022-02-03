package com.pragma.santiago.app.service.Impl;

import com.pragma.santiago.app.mapper.IClienteMapper;
import com.pragma.santiago.app.model.dto.ClienteDTO;
import com.pragma.santiago.app.model.entity.Cliente;
import com.pragma.santiago.app.repository.ClienteRepository;
import com.pragma.santiago.app.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class ClienteServiceImpl implements ClienteService {

	 @Autowired
	 private ClienteRepository clienteRepository;

	 @Autowired
	 private IClienteMapper clienteMapper;



	@Override
	public ClienteDTO guardar(ClienteDTO clienteDTO) {

		Cliente cliente= this.clienteMapper.toCliente(clienteDTO);

		if(this.clienteRepository.BuscarClienteCorreo(cliente.getCorreo()) != null || this.clienteRepository.BuscarClienteIdentificacion(cliente.getIdentificacion()) != null){
			return null;
		}

		return this.clienteMapper.toClienteDTO(
				this.clienteRepository.save(cliente)
		) ;
	}

	@Override
	public ClienteDTO modificar(ClienteDTO clienteDTO, Integer clienteId) {
		Cliente oCliente= this.clienteRepository.findById(clienteId).get();

		if(oCliente==null){
			return null;
		}else{


			Cliente clienteDetalle  = this.clienteMapper.toCliente(clienteDTO);


			oCliente.setApellido(clienteDetalle.getApellido());
			oCliente.setNombre(clienteDetalle.getNombre());
			oCliente.setEdad(clienteDetalle.getEdad());
			oCliente.setCiudad(clienteDetalle.getCiudad());
			oCliente.setTipoIdentificacion(clienteDetalle.getTipoIdentificacion());
			//oCliente.get().setIdentificacion(clienteDetalle.getIdentificacion());
			//oCliente.get().setCorreo(clienteDetalle.getCorreo());

			return this.clienteMapper.toClienteDTO(
					this.clienteRepository.save(oCliente)
			);

		}


	}

	@Override
	public ArrayList<ClienteDTO> buscarTodo() {
		return this.clienteMapper.toClientesDTO((ArrayList<Cliente>) StreamSupport.stream(this.clienteRepository.findAll().spliterator(), false).collect(Collectors.toList()));
	}

	@Override
	public ClienteDTO buscarId(Integer id) {
		return this.clienteMapper.toClienteDTO(
				this.clienteRepository.findById(id).get()
		);
	}

	@Override
	public boolean eliminar(Integer id) {
		if (!this.clienteRepository.findById(id).isPresent()){
			return false;
		}else {
			this.clienteRepository.deleteById(id);
			return true;
		}
	}
}
