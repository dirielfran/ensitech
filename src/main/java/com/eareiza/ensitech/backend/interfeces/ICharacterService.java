package com.eareiza.ensitech.backend.interfeces;
import com.eareiza.ensitech.backend.dto.ResponseCharacterDto;

public interface ICharacterService {

    public ResponseCharacterDto getCharactersService(int limit, int offSet);
}
