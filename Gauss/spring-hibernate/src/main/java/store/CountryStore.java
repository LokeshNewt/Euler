package store;

import shared.exception.DBException;
import store.namedQuery.CountryNQ;
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
            Query query = session.getNamedQuery(CountryNQ.GET_COUNTRY);
            query.setString(CountryNQ.Params.COUNTRY_ID, Id);
            countries = (List<Country>) query.list();
            if (countries.size() > 0) {
                return countries.get(0);
            }
        } catch (HibernateException e) {
            throw new DBException(" error while executing sql query", e);
        } 
        return null;
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
