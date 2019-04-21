package org.launchcode.cheesemvc.models.data;

import org.launchcode.cheesemvc.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Launchcode, assignment by Tracey Cannon 0419
 */

@Repository
@Transactional
public interface CategoryDao extends CrudRepository<Category, Integer> {
}
