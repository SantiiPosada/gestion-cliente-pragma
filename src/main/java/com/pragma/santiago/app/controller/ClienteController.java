package com.pragma.santiago.app.controller;

import ch.qos.logback.core.net.server.Client;
import com.pragma.santiago.app.model.dto.ClienteDTO;
import com.pragma.santiago.app.model.entity.Cliente;
import com.pragma.santiago.app.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	
	@PostMapping
	public ResponseEntity<ClienteDTO> guardar (@RequestBody ClienteDTO cliente){
		ClienteDTO clienteDTO=this.clienteService.guardar(cliente);
		if ( clienteDTO!= null){
			return ResponseEntity.status(HttpStatus.CREATED).body(clienteDTO);
		}else{
			return ResponseEntity.status(HttpStatus.CONFLICT).body(clienteDTO);
		}
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscar(@PathVariable("id") Integer clienteId){
		ClienteDTO cliente=this.clienteService.buscarId(clienteId);
		
		if(cliente==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(cliente);
	}
	

	@PutMapping("/{id}")
	public ResponseEntity<ClienteDTO> modificar (@RequestBody ClienteDTO clienteDetails,@PathVariable(value="id") Integer clienteId){
		ClienteDTO cliente = this.clienteService.modificar(clienteDetails,clienteId);

		if(cliente==null){
			return ResponseEntity.status(HttpStatus.CONFLICT).body(clienteDetails);
		}else{
			return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
		}
	}



	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable(value = "id") Integer clienteId){
		if(this.clienteService.eliminar(clienteId)) {
			return ResponseEntity.ok().build();
		}else{
			return ResponseEntity.notFound().build();
		}

	}

	@GetMapping()
	public List<ClienteDTO> readAll(){
		
		//List<Cliente> clientes = StreamSupport.stream(this.clienteService.findAll().spliterator(), false).collect(Collectors.toList());
		
		return this.clienteService.buscarTodo();

				//this.clienteService.buscarTodo();
	}

}