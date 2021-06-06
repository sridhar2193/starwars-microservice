package com.publicis.starwarsclient.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.publicis.starwarsclient.model.ApiResult;
import com.publicis.starwarsclient.service.StarWarsClientService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(value = StarWarsClientController.class)
class StarWarsClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StarWarsClientService service;

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void givenType_whenStarWarsByType_ThenSuccess() throws Exception {
        ApiResult result = new ApiResult();
        result.setCount(1);
        result.setType("people");

        Mockito.when(service.getStarWarsByType(Mockito.anyString())).thenReturn(mapper.writeValueAsString(result));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/people").accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        JSONAssert.assertEquals(mapper.writeValueAsString(result), mvcResult.getResponse().getContentAsString(), false);
    }

    @Test
    public void givenType_whenStarWarsByTypeAndName_ThenSuccess() throws Exception {
        ApiResult result = new ApiResult();
        result.setCount(1);
        result.setType("people");
        result.setName("Oberyn");

        Mockito.when(service.getStarWarsByTypeAndName(Mockito.anyString(), Mockito.anyString())).thenReturn(mapper.writeValueAsString(result));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/people/Oberyn").accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        JSONAssert.assertEquals(mapper.writeValueAsString(result), mvcResult.getResponse().getContentAsString(), false);
    }
}