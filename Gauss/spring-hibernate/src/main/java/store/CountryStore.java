package store;

import exception.DBException;
import hibernate.namedQuery.EmployeeNQ;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import store.entity.Country;

import java.util.List;

/**
 * Created by neerbans on 21/4/17.
 */
public class CountryStore {

    public Country getCountryById(Session session, String Id) throws DBException {
        List<Country> employees = null;
        try{
            Query query = session.getNamedQuery(EmployeeNQ.DELETE_EMPLOYEES2);
            query.setString(EmployeeNQ.Params.COUNTRY_ID, Id);
            employees = (List<Country>) query.list();
        } catch (HibernateException e) {
            throw new DBException(" error while executing sql query", e);
        } finally {
            //session.close();
        }
        return employees.get(0);
    }
}
