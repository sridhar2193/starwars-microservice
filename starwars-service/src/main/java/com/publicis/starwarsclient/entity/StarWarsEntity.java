package com.publicis.starwarsclient.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

/**
 * Starwars entity which is entity for starwars table
 *
 * @author Sridhar
 */
@Entity
@Table(name = "starwars")
@Data
public class StarWarsEntity {

    @ApiModelProperty(notes = "The database generated ID")
    @Id
    @GeneratedValue
    private Long id;

    @ApiModelProperty(notes = "StarWars Type")
    @Column(nullable = false)
    private String type;

    @ApiModelProperty(notes = "StarWars name for the specific type")
    @Column(nullable = false)
    private String name;

}
