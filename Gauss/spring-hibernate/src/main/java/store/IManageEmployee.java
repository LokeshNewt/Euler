package store;

import exception.DBException;
import exception.InvalidArgException;
import org.hibernate.Session;
import params.EmployeeParams;
import params.QueryParams;
import shared.Param;

import java.util.List;

/**
 * Created by neerbans on 4/6/2017.
 */
public interface IManageEmployee {

    void addEmployee(Session session, EmployeeParams employeeParams) throws InvalidArgException;

    Long addMessage(Session session, Long messageSid);

    List listEmployees(Session session , @Param("QueryParams") QueryParams queryParams, int startIndex, int limitCount) throws InvalidArgException, DBException;
}
