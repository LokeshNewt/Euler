package sql;

import entity.Country;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import util.ResultUtils;

import java.awt.print.Pageable;
import java.util.List;

import static util.ResultUtils.result;

/**
 * Created by neerbans on 2/16/2016.
 */
public class EmployeeApp {

    private static Logger logger = Logger.getLogger(EmployeeApp.class);

    private static EmployeeRepositary repository;

    public static void main(String args[]) {

        ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
        repository = context.getBean(EmployeeRepositary.class);

        createEmployee(8, "prasad", "saripalli", "AVPcrossproduct");

    }

    private static void createEmployee(int id, String firstName, String lastName, String dept) {

        Employee customer = new Employee(id, firstName, lastName, dept);
        //repository.save(customer);

//        Iterable<Country> customers = repository.findAll();

//        ResultUtils.result(customers);

//        PageRequest pageRequest = new PageRequest(2, 5);
        Sort sort = new Sort(Sort.Direction.ASC, "countryId");
        org.springframework.data.domain.Pageable pageRequest = new CustomPageRequest(2, 5, sort);
        List<Country> countries = repository.getCountryById(6L, pageRequest);

        result(countries);
    }



}
