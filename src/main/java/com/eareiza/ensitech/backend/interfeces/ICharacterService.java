package com.eareiza.ensitech.backend.interfeces;
import com.eareiza.ensitech.backend.dto.ResponseCharacterDto;
import com.eareiza.ensitech.backend.model.CharacterRegistry;

public interface ICharacterService extends ICommonService<CharacterRegistry>{

    public ResponseCharacterDto getCharactersService(int limit, int offSet);
}
