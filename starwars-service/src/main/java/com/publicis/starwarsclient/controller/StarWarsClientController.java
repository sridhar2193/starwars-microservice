package com.publicis.starwarsclient.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.publicis.starwarsclient.service.StarWarsClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller which accepts the requests from user.
 * base context path is /api
 *
 * @author Sridhar
 */
@RestController
@RequestMapping("/api")
@Api(value="starwars", tags = "Operations to get starwars details")
public class StarWarsClientController {

    @Autowired
    private StarWarsClientService service;

    /**
     * Api endpoint which returns the count of starwar types based on the user input type
     *
     * @param type Starwars type
     * @return ApiResult string
     * @throws JsonProcessingException Json checked Exception
     */
    @ApiOperation(value = "View StarWars count by type", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved data"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/{type}")
    public String getStarWarsCountByType(@PathVariable String type) throws JsonProcessingException {
        return service.getStarWarsByType(type);
    }

    /**
     * Api endpoint which returns the count of starwar types and name based on the user input type and name
     *
     * @param type Starwars type
     * @param name Starwars name
     * @return ApiResult string
     * @throws JsonProcessingException Json checked Exception
     */
    @ApiOperation(value = "View StarWars count by type and name", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved data"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/{type}/{name}")
    public String getStarWarsCountByTypeAndName(@PathVariable String type, @PathVariable String name) throws JsonProcessingException {
        return service.getStarWarsByTypeAndName(type, name);
    }

    /**
     * Api endpoint which returns the dta of starwar types and name based on the user input type
     *
     * @param type Starwars type
     * @return ApiResult string
     * @throws JsonProcessingException Json checked Exception
     */
    @ApiOperation(value = "View StarWars data by type", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved data"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/data/{type}")
    public String getStarWarsDataByType(@PathVariable String type) throws JsonProcessingException {
        return service.getStarWarsDataByType(type);
    }

    /**
     * Api endpoint which returns the data of starwar types and name based on the user input type and name
     *
     * @param type Starwars type
     * @param name Starwars name
     * @return ApiResult string
     * @throws JsonProcessingException Json checked Exception
     */
    @ApiOperation(value = "View StarWars data by type and name", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved data"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/data/{type}/{name}")
    public String getStarWarsDataByTypeAndName(@PathVariable String type, @PathVariable String name) throws JsonProcessingException {
        return service.getStarWarsByDataTypeAndName(type, name);
    }

}
