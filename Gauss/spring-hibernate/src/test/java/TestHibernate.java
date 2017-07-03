import exception.DBException;
import hibernate.namedQuery.EmployeeNQ;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import params.EmployeeParams;
import params.QueryParams;
import store.ManageEmployee;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by neerbans on 10/8/2016.
 */

//@ContextConfiguration(locations = {"classpath:test-hb-context.xml"})
//@RunWith(SpringJUnit4ClassRunner.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestHibernate {

    @Autowired
    @Qualifier("hibernateSessionFactory")
    private SessionFactory sessionFactory;

    @Autowired
    private ManageEmployee manageEmployee;

    @Test
    public void test() {}

//    @Test
    public void addEmployees () {
        addEmployee("victor", "ungur", false, 1001);
        addEmployee("ion", "ungur", true, 1002);
    }

    //@Test
    public void listEmployee() throws DBException {

        Session session = sessionFactory.openSession();

        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        String d = simpleDateFormat.format(date);

        QueryParams queryParams = QueryParams.build().setDate(d);

        List employees = manageEmployee.listEmployees(session, queryParams, 0, 100);

        assertEquals("size should be 2", 2, employees.size());
    }

    private void addEmployee(String firstName, String lastName, boolean exclusionFlag, int id) {

        Session session = sessionFactory.openSession();

        String dept = "clinical/pd";
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();

        EmployeeParams employeeParams = EmployeeParams.build().setDept(dept).setFirstName(firstName)
                .setLastName(lastName).setFlag(exclusionFlag).setMessageSid(-1l).setCreatedDTTM(date);

        manageEmployee.addEmployee(session, employeeParams);

    }

//    @Test
    public void countEmployee() {
        Session session = sessionFactory.openSession();
        long count = manageEmployee.countEmployees(session);
        assertEquals("count should be 4", 4l, count);
    }

//    @Test
    public void deleteTestEmployees() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.getNamedQuery(EmployeeNQ.DELETE_EMPLOYEES);
        query.setString(EmployeeNQ.Params.LAST_NAME, "ungur");
        int rows = query.executeUpdate();
        assertEquals("invalid row size deleted", 2, rows);
        transaction.commit();
        session.close();

        TestUnitCoverage.coverage();
    }

}
