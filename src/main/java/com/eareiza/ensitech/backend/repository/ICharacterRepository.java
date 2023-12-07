package com.eareiza.ensitech.backend.repository;

import com.eareiza.ensitech.backend.model.CharacterRegistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICharacterRepository extends JpaRepository<CharacterRegistry, Long> {
}
