package com.publicis.starwarsclient.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Pojo to be outputted to users and it will ignore null field values
 *
 * @author Sridhar
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResult {

    private String type;
    private int count;
    private String name;

}
