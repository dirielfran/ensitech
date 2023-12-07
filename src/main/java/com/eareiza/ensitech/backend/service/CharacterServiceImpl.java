package com.eareiza.ensitech.backend.service;

import com.demo.marvelProject.dto.MarvelDTO;
import com.demo.marvelProject.dto.ResultDTO;
import com.demo.marvelProject.rest.MarvelRest;
import com.eareiza.ensitech.backend.dto.ComicDto;
import com.eareiza.ensitech.backend.interfeces.ICharacterService;
import com.eareiza.ensitech.backend.model.CharacterRegistry;
import com.eareiza.ensitech.backend.repository.ICharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterServiceImpl extends CommonServiceImpl<CharacterRegistry, ICharacterRepository> implements ICharacterService {

    @Autowired
    RestTemplate restTemplate;
    @Value("${marvelCharacters.url}")
    private String urlMarvel;

    @Value("${marvelCharacters.apikey}")
    private String apiKey;

    @Value("${marvelCharacters.hash}")
    private String hash;

    @Value("${marvelCharacters.ts}")
    private String ts;

    public List<ComicDto> getCharactersService(int limit, int offSet){
        MarvelRest marvelService = new MarvelRest(restTemplate, urlMarvel, apiKey, hash, ts, limit, offSet);
        MarvelDTO marvelDTO = marvelService.findAll();
        List<ComicDto> comicDtos = marvelDTO.getData().getResults().stream().map(this::getComic).collect(Collectors.toList());
        return comicDtos;
    }

    private ComicDto getComic(ResultDTO result){
        ComicDto comicDto = ComicDto.builder()
                .id(result.getID())
                .description(result.getDescription())
                .name(result.getName()).build();
        return comicDto;
    }
}
