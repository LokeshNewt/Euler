package sql;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by neerbans on 2/16/2016.
 */
public class EmployeeApp {

    private static CrudRepository repository;

    public static void main(String args[]) {

        ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
        repository = context.getBean(EmployeeRepositary.class);

        createEmployee(8, "prasad", "saripalli", "AVPcrossproduct");

    }

    private static void createEmployee(int id, String firstName, String lastName, String dept) {

        Employee customer = new Employee(id, firstName, lastName, dept);
        repository.save(customer);

        Iterable<Employee> customers = repository.findAll();
        for (Employee customer1: customers) {
            System.out.println(customer1.getFirstName());
        }
    }
}
