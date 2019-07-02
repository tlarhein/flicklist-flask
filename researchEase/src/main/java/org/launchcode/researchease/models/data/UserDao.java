package org.launchcode.researchease.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Tracey Cannon Liftoff 0519
 */

@Repository
@Transactional
public interface UserDao<User> extends CrudRepository<User, Integer> {

   //void save(org.apache.tomcat.jni.User User);
}