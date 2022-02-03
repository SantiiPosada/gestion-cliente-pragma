package com.pragma.santiago.app.controller;

import com.pragma.santiago.app.model.entity.Fotografia;
import com.pragma.santiago.app.service.FotografiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;



@RestController
@RequestMapping("/api/fotografias")
public class FotografiaController {

	@Autowired
	private FotografiaService fotograService;
	
	
	@PostMapping
	public ResponseEntity<Fotografia> create (@RequestBody Fotografia fotografia){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.fotograService.save(fotografia));
		
	}
	
	
	@GetMapping("/{idCliente}")
	public ResponseEntity<?> read(@PathVariable("idCliente") Integer clienteId){
		Fotografia oFotografia=this.fotograService.findByIdCliente(clienteId);
		
		if(oFotografia==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oFotografia);
	}
	
	
	@PutMapping("/{idCliente}")
	public ResponseEntity<Fotografia> update (@RequestBody Fotografia detalleFotografia,@PathVariable(value="idCliente") Integer clienteId){
		Fotografia oFotografia=this.fotograService.findByIdCliente(clienteId);
		
		if(oFotografia==null) {
			return ResponseEntity.notFound().build();
		}
		
		oFotografia.setBase64(detalleFotografia.getBase64());
		//BeanUtils.copyProperties(userDetails, oUser.get());
	
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.fotograService.save(oFotografia));
	}
	
	@DeleteMapping("/{idCliente}")
	public ResponseEntity<?> delate(@PathVariable(value = "idCliente") Integer clienteId){
		
		Fotografia oFotografia=this.fotograService.findByIdCliente(clienteId);
		
		if(oFotografia==null) {
			return ResponseEntity.notFound().build();
		}
		
		this.fotograService.deleteById(oFotografia.getId());
		return ResponseEntity.ok().build();
	}
	
	
	
	@GetMapping()
	public List<Fotografia> readAll(){
		
		List<Fotografia> fotografias = StreamSupport.stream(this.fotograService.findAll().spliterator(), false).collect(Collectors.toList());
		
		return fotografias;
		
	}
	
}
