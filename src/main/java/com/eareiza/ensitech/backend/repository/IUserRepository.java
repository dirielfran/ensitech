package com.eareiza.ensitech.backend.repository;


import com.eareiza.ensitech.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
    public User findByEmail(String email);
    public User findByUsername(String username);
}
