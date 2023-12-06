package com.eareiza.ensitech.backend.model;

import com.eareiza.ensitech.backend.utileria.Utileria;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "util" })
public class EntityCommon {


    @Transient
    private final Utileria util = new Utileria();
    private String user;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_update")
    private String userUpdate;
    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;

    @PrePersist
    private void prePersist(){
        this.user = util.getUsuarioAuth() != null ? util.getUsuarioAuth() : "";
        this.createAt = LocalDateTime.now();
    }

    @PreUpdate
    private void preUpdate(){
        this.userUpdate = util.getUsuarioAuth();
        this.updateAt =  LocalDateTime.now();
    }
}
