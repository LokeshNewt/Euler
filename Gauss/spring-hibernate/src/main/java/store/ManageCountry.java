package store;

import entity.Country;
import entity.Religion;
import shared.exception.DBException;
import entity.Person;
import store.namedQuery.CountryNQ;
import org.apache.log4j.Logger;
import api.params.CountryParams;
import api.params.QueryParams;
import org.hibernate.*;
import org.hibernate.criterion.Projections;

import java.util.List;

/**
 * Created by neerbans on 10/29/2015.
 */
public class ManageCountry implements IManageCountry {

    private static final Logger logger = Logger.getLogger(ManageCountry.class);

    public long countEmployees(Session session) {
        Transaction tx = null;
        long eCount = 0;
        try{
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(Country.class);
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
            Query query = session.getNamedQuery(CountryNQ.GET_COUNTRY);
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

    public void addCountry(Session session, CountryParams countryParams) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Country employee = new Country();
//            employee.setEmployeeId(countryParams.getId());
//            employee.setFirstName(countryParams.getFirstName());
//            employee.setLastName(countryParams.getLastName());
//            employee.setExclusionFlag(countryParams.isFlag());
//            employee.setCreatedDTTM(countryParams.getCreatedDTTM());
//            employee.setUpdatedDTTM(countryParams.getUpdatedDTTM());
//
//            Message message = new Message();
//            message.setMessageSid(countryParams.getMessageSid());
//            employee.setMessage(message);

            session.save(employee);   // It will not insert into message table
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Long addReligion(Session session, Long messageSid) {
        Transaction tx = null;
        Long employeeId = null;
        try {
            tx = session.beginTransaction();
            Religion message = new Religion();
//            message.setMessageSid(messageSid);

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
        query.setTimestamp(CountryNQ.Params.CREATED_DATE, queryParams.getDate());
    }
}
