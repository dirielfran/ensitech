package com.eareiza.ensitech.backend.service;

import java.util.Optional;

import com.eareiza.ensitech.backend.interfeces.ICommonService;
import com.eareiza.ensitech.backend.utileria.Utileria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

public class CommonServiceImpl<E, R extends PagingAndSortingRepository<E,Long>> implements ICommonService<E> {

	@Autowired
	protected R entityRepo;

	@Override
	@Transactional(readOnly = true)
	public Iterable<E> findAll() {
		return entityRepo.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<E> findById(Long idEntity) {
		return entityRepo.findById(idEntity);
	}

	@Override
	@Transactional
	public E save(E entity) {
		return entityRepo.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Long idEntity) {
		entityRepo.deleteById(idEntity);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<E> findAll(Pageable pageable) {
		return entityRepo.findAll(pageable);
	}
}