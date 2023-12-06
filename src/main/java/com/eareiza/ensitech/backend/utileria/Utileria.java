package com.eareiza.ensitech.backend.utileria;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class Utileria {

	public String getUsuarioAuth(){
		return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
}
