package org.launchcode.researchease.models.data;

import org.launchcode.researchease.models.Response;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Tracey Cannon Liftoff 0519
 */

@Repository
@Transactional
public interface ResponseDao extends CrudRepository<Response, Integer> {
}