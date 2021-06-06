package com.publicis.starwarsclient.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.publicis.starwarsclient.entity.StarWarsEntity;
import com.publicis.starwarsclient.model.ApiResult;
import com.publicis.starwarsclient.repository.StarWarsClientRepository;
import com.publicis.starwarsclient.util.StarWarsConstants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StarWarsClientServiceTest {

    @Mock
    private StarWarsClientRepository repository;

    @InjectMocks
    private StarWarsClientService service;

    private final ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    private ApiResult apiResult = null;

    @Test
    void givenType_whenStarWarsByType_testSuccess() throws JsonProcessingException {
        Mockito.when(repository.countByType(Mockito.anyString())).thenReturn(2);
        String result = service.getStarWarsByType("test");
        apiResult = mapper.readValue(result, ApiResult.class);
        assertEquals(2, apiResult.getCount());
        assertEquals("test", apiResult.getType());
    }

    @Test
    void givenTypeAndName_whenStarWarsByTypeAndName_testSuccess() throws JsonProcessingException {
        Mockito.when(repository.countByTypeAndName(Mockito.anyString(), Mockito.anyString())).thenReturn(1);
        String result = service.getStarWarsByTypeAndName("people", "Oberyn");
        apiResult = mapper.readValue(result, ApiResult.class);
        assertEquals(1, apiResult.getCount());
        assertEquals("people", apiResult.getType());
        assertEquals("Oberyn", apiResult.getName());
    }

    @Test
    void givenType_whenStarWarsDataByType_testNotFound() throws JsonProcessingException {
        Mockito.when(repository.findByType(Mockito.anyString())).thenReturn(Collections.emptyList());
        String result = service.getStarWarsDataByType("people");
        assertEquals(String.format(StarWarsConstants.NO_DATA_FOUND_TYPE, "people"), result);
    }

    @Test
    void givenType_whenStarWarsDataByType_testSuccess() throws JsonProcessingException {
        List<StarWarsEntity> entityList = new ArrayList<>();
        StarWarsEntity entity = new StarWarsEntity();
        entity.setType("people");
        entity.setName("Oberyn");
        entityList.add(entity);
        Mockito.when(repository.findByType(Mockito.anyString())).thenReturn(entityList);
        String result = service.getStarWarsDataByType("people");
        assertEquals(mapper.writeValueAsString(entityList), result);
    }

    @Test
    void givenTypeAndName_whenStarWarsDataByTypeAndName_testSuccess() throws JsonProcessingException {
        StarWarsEntity entity = new StarWarsEntity();
        entity.setType("people");
        entity.setName("Oberyn");
        Mockito.when(repository.findByTypeAndName(Mockito.anyString(),Mockito.anyString())).thenReturn(entity);
        String result = service.getStarWarsByDataTypeAndName("people", "Oberyn");
        assertEquals(mapper.writeValueAsString(entity), result);
    }
}