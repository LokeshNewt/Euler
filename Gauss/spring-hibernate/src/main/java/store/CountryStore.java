package store;

import shared.exception.DBException;
import store.namedQuery.EmployeeNQ;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import shared.entity.Country;

import java.util.List;

/**
 * Created by neerbans on 21/4/17.
 */
public class CountryStore {

    @SuppressWarnings("unchecked")
    public Country getCountryById(Session session, String Id) throws DBException {
        List<Country> countries = null;
        try{
            Query query = session.getNamedQuery(EmployeeNQ.DELETE_EMPLOYEES2);
            query.setString(EmployeeNQ.Params.COUNTRY_ID, Id);
            countries = (List<Country>) query.list();
        } catch (HibernateException e) {
            throw new DBException(" error while executing sql query", e);
        } 
        return countries.get(0);
    }
}
