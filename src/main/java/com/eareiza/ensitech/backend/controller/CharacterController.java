package com.eareiza.ensitech.backend.controller;

import com.eareiza.ensitech.backend.dto.ComicDto;
import com.eareiza.ensitech.backend.interfeces.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/character")
public class CharacterController {
    @Autowired
    private ICharacterService iCharacterService;

    @GetMapping("/charactersList/{limit}/{offSet}")
    @ResponseStatus(HttpStatus.OK)
    @Secured({"ROLE_ADMIN","ROLE_USER"})
    public List<ComicDto> getCharacters(@PathVariable int limit, @PathVariable int offSet){
        return iCharacterService.getCharactersService(limit, offSet);
    }
}
