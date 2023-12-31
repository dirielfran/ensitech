package com.eareiza.ensitech.backend.interfeces;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ICommonService<E> {
	
	public Iterable<E> findAll();
	
	public Page<E> findAll(Pageable pageable);
	
	public Optional<E> findById(Long idEntity);
	
	public E save(E entity);
	
	public void deleteById(Long idAlumno);
}