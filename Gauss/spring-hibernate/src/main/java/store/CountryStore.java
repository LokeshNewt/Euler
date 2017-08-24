package store;

import shared.exception.DBException;
import store.namedQuery.CountryNQ;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import entity.Country;

import java.util.List;

/**
 * Created by neerbans on 21/4/17.
 */
public class CountryStore {

    @SuppressWarnings("unchecked")
    public List<Country> getCountryById(Session session, Long Id, int start, int limit) throws DBException {
        List<Country> countries = null;
        try{
            Query query = session.getNamedQuery(CountryNQ.GET_COUNTRY);
            query.setLong(CountryNQ.Params.COUNTRY_ID, Id);
            query.setMaxResults(limit);
            query.setFirstResult(start);
            countries = (List<Country>) query.list();
        } catch (HibernateException e) {
            throw new DBException(" error while executing sql query", e);
        } 
        return countries;
    }

    public Country createCountry(Session session, Country country) throws DBException {
        try{
            session.save(country);
        } catch (HibernateException e) {
            throw new DBException(" error while executing sql query", e);
        }
        return null;
    }
}
