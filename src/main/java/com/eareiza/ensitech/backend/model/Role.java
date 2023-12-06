package com.eareiza.ensitech.backend.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="roles")
public class Role implements Serializable{

	private static final long serialVersionUID = -2728258378812673040L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true,length = 20)
	private String nombre;

}
