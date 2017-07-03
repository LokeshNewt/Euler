package com.about.java.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.repository.CrudRepository;

/**
* Created by neerbans on 3/6/2017.
*/

public class EmpApp {

    @Autowired
    EmployeeRepositary employeeRepositary;

    public void createEmployee(Employee employee) {

        //ApplicationContext context = new ClassPathXmlApplicationContext();

        employeeRepositary.save(employee);

        //Employee customer = new Employee(firstName);
//        repository.save(employee);

//        Iterable<Employee> customers = repository.findAll();
//        for (Employee customer1: customers) {
//            System.out.println(customer1.getFirstName());
//        }
    }
}
