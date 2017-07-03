package aop;

import aop.model.Employee;
import aop.service.EmployeeService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by neerbans on 6/19/2017.
 */
public class SpringMain {

    public static void main(String [] args) {

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        EmployeeService employeeService = ctx.getBean("employeeService", EmployeeService.class);

        System.out.println(employeeService.getEmployee().getName());

        employeeService.getEmployee().setName("Neeraj");

        employeeService.getEmployee().throwException();
    }
}
