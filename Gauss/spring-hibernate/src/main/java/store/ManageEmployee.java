package store;

import exception.DBException;
import hibernate.entity.Employee;
import hibernate.entity.Message;
import hibernate.entity.Person;
import hibernate.namedQuery.EmployeeNQ;
import org.apache.log4j.Logger;
import params.EmployeeParams;
import params.QueryParams;
import org.hibernate.*;
import org.hibernate.criterion.Projections;

import java.util.List;

/**
 * Created by neerbans on 10/29/2015.
 */
public class ManageEmployee implements IManageEmployee{

    private static final Logger logger = Logger.getLogger(ManageEmployee.class);

    public long countEmployees(Session session) {
        Transaction tx = null;
        long eCount = 0;
        try{
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(Employee.class);
            cr.setProjection(Projections.rowCount());
            List count = cr.list();
            eCount = (Long) count.get(0);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return eCount;
    }

    public List listEmployees(Session session , QueryParams queryParams, int startIndex, int limitCount) throws DBException {
        logger.info("Fetching list of all employees whose created date > " + queryParams.getDate());
        List employees = null;
        try{
            Query query = session.getNamedQuery(EmployeeNQ.GET_EMPLOYEES);
            setQueryParams(query, queryParams);
            query.setFirstResult(startIndex);
            query.setMaxResults(limitCount);
            employees = query.list();
        } catch (HibernateException e) {
            throw new DBException(" error while executing sql query", e);
        } finally {
            //session.close();
        }
        return employees;
    }

    public void addEmployee(Session session, EmployeeParams employeeParams) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Employee employee = new Employee();
            employee.setEmployeeId(employeeParams.getId());
            employee.setFirstName(employeeParams.getFirstName());
            employee.setLastName(employeeParams.getLastName());
            employee.setExclusionFlag(employeeParams.isFlag());
            employee.setCreatedDTTM(employeeParams.getCreatedDTTM());
            employee.setUpdatedDTTM(employeeParams.getUpdatedDTTM());

            Message message = new Message();
            message.setMessageSid(employeeParams.getMessageSid());
            employee.setMessage(message);

            session.save(employee);   // It will not insert into message table
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Long addMessage(Session session, Long messageSid) {
        Transaction tx = null;
        Long employeeId = null;
        try {
            tx = session.beginTransaction();
            Message message = new Message();
            message.setMessageSid(messageSid);

            employeeId = (Long) session.save(message);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeeId;
    }

    public Integer addPerson(Session session, int id) {
        Transaction tx = null;
        Integer employeeId = null;
        try {
            tx = session.beginTransaction();
            Person p = new Person();
            p.setId(id);
            p.setName("wadhwa");

            employeeId = (Integer) session.save(p);   // It will not insert into message table
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeeId;
    }

    private void setQueryParams(Query query, QueryParams queryParams) {
        query.setTimestamp(EmployeeNQ.Params.CREATED_DATE, queryParams.getDate());
    }
}
