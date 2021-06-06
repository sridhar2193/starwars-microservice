package com.publicis.starwarsclient.repository;

import com.publicis.starwarsclient.entity.StarWarsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository which will connect to h2 in-memory database and get the data
 *
 * @author Sridhar
 */
@Repository
public interface StarWarsClientRepository extends CrudRepository<StarWarsEntity, Long> {

    /**
     * finds starwar record by type
     *
     * @param type starwar type
     * @return List<StarWarsEntity> data
     */
    List<StarWarsEntity> findByType(String type);

    /**
     * finds starwar record by type and name
     *
     * @param type starwar type
     * @param name starwar name
     * @return List<StarWarsEntity> data
     */
    StarWarsEntity findByTypeAndName(String type, String name);

    /**
     * counts starwar record by type
     *
     * @param type starwar type
     * @return List<StarWarsEntity> data
     */
    int countByType(String type);

    /**
     * counts starwar record by type and name
     *
     * @param type starwar type
     * @param name starwar name
     * @return List<StarWarsEntity> data
     */
    int countByTypeAndName(String type, String name);

}
