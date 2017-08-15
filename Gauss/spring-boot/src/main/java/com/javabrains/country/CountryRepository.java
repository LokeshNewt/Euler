package com.javabrains.country;

import entity.Country;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by neerbans on 15/8/17.
 */
public interface CountryRepository extends CrudRepository<Country, Long> {
}
