package com.eareiza.ensitech.backend.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import com.eareiza.ensitech.backend.interfeces.ICommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public class CommonController<E, S extends ICommonService<E>>{

	@Autowired
	protected S entityService;
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		return ResponseEntity.ok().body(entityService.findAll());
	}
	
	@GetMapping("/paginable")
	public ResponseEntity<?> listar(Pageable pageable){
		return ResponseEntity.ok().body(entityService.findAll(pageable));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<E> opt = entityService.findById(id);
		if(opt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(opt.get());
	}
	
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody E entity, BindingResult result){
		if(result.hasErrors()) return this.validate(result);
		E entityBD = entityService.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(entityBD);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		entityService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	protected ResponseEntity<?> validate( BindingResult result){
		Map<String, Object> errores = new HashMap<>();
		result.getFieldErrors().forEach( err -> {
			errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
		});
		return ResponseEntity.badRequest().body(errores);
	}
}