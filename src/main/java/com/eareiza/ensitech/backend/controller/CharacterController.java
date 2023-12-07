package com.eareiza.ensitech.backend.controller;

import com.eareiza.ensitech.backend.dto.ResponseCharacterDto;
import com.eareiza.ensitech.backend.interfeces.ICharacterService;
import com.eareiza.ensitech.backend.model.CharacterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/character")
public class CharacterController extends CommonController<CharacterRegistry, ICharacterService> {


    @GetMapping("/charactersList/{limit}/{offSet}")
    @ResponseStatus(HttpStatus.OK)
    @Secured({"ROLE_ADMIN","ROLE_USER"})
    public ResponseCharacterDto getCharacters(@PathVariable int limit, @PathVariable int offSet){
        return entityService.getCharactersService(limit, offSet);
    }
}
