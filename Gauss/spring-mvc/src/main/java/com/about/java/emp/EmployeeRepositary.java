package com.about.java.emp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Created by neerbans on 3/6/2017.
*/
@Repository
public interface EmployeeRepositary extends CrudRepository<Employee, Long>{

    List<Employee> findAll();

}
