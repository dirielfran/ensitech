package com.eareiza.ensitech.backend.service;

import com.demo.marvelProject.dto.*;
import com.demo.marvelProject.rest.MarvelRest;
import com.eareiza.ensitech.backend.dto.ResponseCharacterDto;
import com.eareiza.ensitech.backend.model.CharacterRegistry;
import com.eareiza.ensitech.backend.repository.ICharacterRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {MarvelRest.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class CharacterServiceImplTest {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private ICharacterRepository iCharacterRepository;

    @InjectMocks
    private CharacterServiceImpl characterService;


    @Test
    public void testGetCharactersService() {
        when(restTemplate.exchange(anyString(), any(HttpMethod.class), any(), eq(MarvelDTO.class)))
                .thenReturn(new ResponseEntity<>(createMockMarvelDTO(), HttpStatus.OK));
        when(iCharacterRepository.save(any())).thenReturn(new CharacterRegistry());

        ResponseCharacterDto result = characterService.getCharactersService(10, 0);

        assertEquals(2, result.getComics().size());
        assertEquals(10, result.getTotalRecords());
    }

    private MarvelDTO createMockMarvelDTO() {
        MarvelDTO marvelDTO = new MarvelDTO();
        DataDTO dataDTO = new DataDTO();
        dataDTO.setTotal(10);
        marvelDTO.setData(dataDTO);
        marvelDTO.setEtag("53ee9607ebf8aa182aa2a349acb124ac9d5c8c09");
        List<ResultDTO> results= new ArrayList<>();
        ResultDTO resultDTO1 = new ResultDTO();
        resultDTO1.setDescription("Prueba descripcion");
        resultDTO1.setName("3D Man");
        resultDTO1.setModified(new Date());

        ComicsDTO comicsDTO = new ComicsDTO();
        comicsDTO.setAvailable(5);

        resultDTO1.setComics(comicsDTO);
        resultDTO1.setEvents(comicsDTO);
        resultDTO1.setSeries(comicsDTO);

        StoriesDTO storiesDTO1 = new StoriesDTO();
        storiesDTO1.setAvailable(9);
        resultDTO1.setStories(storiesDTO1);
        results.add(resultDTO1);

        ResultDTO resultDTO2 = new ResultDTO();
        resultDTO2.setDescription("Prueba descripcion2");
        resultDTO2.setName("3D Man2");
        resultDTO2.setModified(new Date());

        ComicsDTO comicsDTO2= new ComicsDTO();
        comicsDTO.setAvailable(6);

        StoriesDTO storiesDTO2 = new StoriesDTO();
        storiesDTO2.setAvailable(8);
        resultDTO2.setStories(storiesDTO2);
        resultDTO2.setComics(comicsDTO);
        resultDTO2.setEvents(comicsDTO);
        resultDTO2.setSeries(comicsDTO);

        results.add(resultDTO2);
        dataDTO.setResults(results);
        marvelDTO.setData(dataDTO);
        return marvelDTO;
    }


}