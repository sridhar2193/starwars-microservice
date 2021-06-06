package com.publicis.starwarsclient.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.publicis.starwarsclient.entity.StarWarsEntity;
import com.publicis.starwarsclient.model.ApiResult;
import com.publicis.starwarsclient.repository.StarWarsClientRepository;
import com.publicis.starwarsclient.util.StarWarsConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Starwars service to does connect to repository and builds API result
 *
 * @author Sridhar
 */
@Service
public class StarWarsClientService {

    @Autowired
    private StarWarsClientRepository repository;

    private final ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    /**
     * service method to get count of starwars by type and build ApiResult
     *
     * @param type type
     * @return ApiResult
     * @throws JsonProcessingException json checked Exception
     */
    public String getStarWarsByType(String type) throws JsonProcessingException {
        int count = repository.countByType(type);
        ApiResult result = new ApiResult();
        result.setType(type);
        result.setCount(count);
        return mapper.writeValueAsString(result);
    }

    /**
     * service method to get count of starwars by type and name then build ApiResult
     *
     * @param type type
     * @param name name
     * @return ApiResult
     * @throws JsonProcessingException json checked Exception
     */
    public String getStarWarsByTypeAndName(String type, String name) throws JsonProcessingException {
        int count = repository.countByTypeAndName(type.toLowerCase(), name);
        ApiResult result = new ApiResult();
        result.setType(type);
        result.setCount(count);
        result.setName(name);
        return mapper.writeValueAsString(result);
    }

    /**
     * service method to get data of starwars by type and build ApiResult
     *
     * @param type type
     * @return ApiResult
     * @throws JsonProcessingException json checked Exception
     */
    public String getStarWarsDataByType(String type) throws JsonProcessingException {
        List<StarWarsEntity> entityList = repository.findByType(type);
        if(Objects.nonNull(entityList) & !entityList.isEmpty()){
            return mapper.writeValueAsString(entityList);
        } else {
            return String.format(StarWarsConstants.NO_DATA_FOUND_TYPE, type);
        }
    }

    /**
     * service method to get data of starwars by type and name then build ApiResult
     *
     * @param type type
     * @param name name
     * @return ApiResult
     * @throws JsonProcessingException json checked Exception
     */
    public String getStarWarsByDataTypeAndName(String type, String name) throws JsonProcessingException {
        StarWarsEntity entity = repository.findByTypeAndName(type.toLowerCase(), name);
        if(Objects.nonNull(entity)){
            return mapper.writeValueAsString(entity);
        } else {
            return String.format(StarWarsConstants.NO_DATA_FOUND_TYPE_NAME, type, name);
        }
    }
}
