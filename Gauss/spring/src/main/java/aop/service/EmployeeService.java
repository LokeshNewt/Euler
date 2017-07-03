package aop.service;

import aop.model.Employee;

/**
 * Created by neerbans on 6/19/2017.
 */
public class EmployeeService {

    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
