package com.about.java.emp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by neerbans on 3/8/2017.
 */
@Repository
public interface UserRepositary extends CrudRepository<User, Long> {
}
