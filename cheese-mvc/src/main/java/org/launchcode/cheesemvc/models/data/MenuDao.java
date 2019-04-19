package org.launchcode.cheesemvc.models.data;

import org.launchcode.cheesemvc.models.Menu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by LaunchCode, assignment revised by Tracey Cannon
 */

@Repository
@Transactional
public interface MenuDao extends CrudRepository<Menu, Integer> {
}

