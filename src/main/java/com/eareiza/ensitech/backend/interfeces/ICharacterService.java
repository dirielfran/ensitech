package com.eareiza.ensitech.backend.interfeces;

import com.demo.marvelProject.dto.MarvelDTO;
import com.eareiza.ensitech.backend.dto.ComicDto;

import java.util.List;

public interface ICharacterService {

    public List<ComicDto> getCharactersService(int limit, int offSet);
}
