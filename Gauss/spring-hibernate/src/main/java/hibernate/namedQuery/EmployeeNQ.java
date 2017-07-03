package hibernate.namedQuery;

import javax.persistence.MappedSuperclass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Created by neerbans on 10/8/2016.
 */

@MappedSuperclass
@NamedQueries({
        @NamedQuery(name = EmployeeNQ.GET_EMPLOYEES, query = EmployeeNQ.GET_EMPLOYEES_QUERY),
        @NamedQuery(name = EmployeeNQ.DELETE_EMPLOYEES, query = EmployeeNQ.DELETE_EMPLOYEES_QUERY),
        @NamedQuery(name = EmployeeNQ.DELETE_EMPLOYEES2, query = EmployeeNQ.DELETE_EMPLOYEES_QUERY2)
})
public class EmployeeNQ {

    public interface Params {
        String CREATED_DATE = "createdDate";
        String LAST_NAME = "lastName";
        String COUNTRY_ID = "countryId";
    }

    public static final String GET_EMPLOYEES = "getEmployees";

    protected static final String GET_EMPLOYEES_QUERY = "select distinct e from Employee e inner join e.products p " +
            "where e.createdDTTM > :" + Params.CREATED_DATE + " and " +
            "p.productId in " +
            " (51) order by e.firstName desc";
//    protected static final String GET_EMPLOYEES_QUERY = "from Employee e where e.createdDTTM > :" + Params.CREATED_DATE;

    public static final String DELETE_EMPLOYEES = "deleteEmployees";
    public static final String DELETE_EMPLOYEES2 = "deleteEmployees2";

    protected static final String DELETE_EMPLOYEES_QUERY = "delete from Employee e where e.lastName like :" + Params.LAST_NAME;
    protected static final String DELETE_EMPLOYEES_QUERY2 = "select c from Country c where c.countryId = :" + Params.COUNTRY_ID;
    //protected static final String DELETE_EMPLOYEES_QUERY = "delete from Employee";
}
