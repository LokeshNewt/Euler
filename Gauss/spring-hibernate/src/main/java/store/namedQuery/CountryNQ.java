package store.namedQuery;

import javax.persistence.MappedSuperclass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;

/**
 * Created by neerbans on 10/8/2016.
 */

@MappedSuperclass
@NamedQueries({
        @NamedQuery(name = CountryNQ.GET_COUNTRY, query = CountryNQ.GET_COUNTRY_QUERY, hints = {
                @QueryHint(name = "org.hibernate.cacheable", value = "true")
        })
})
public class CountryNQ {

    public interface Params {
        String CREATED_DATE = "createdDate";
        String LAST_NAME = "lastName";
        String COUNTRY_ID = "countryId";
    }

    public static final String GET_COUNTRY = "getCountry";

    static final String GET_COUNTRY_QUERY = "select c from Country c where c.countryId > :" + Params.COUNTRY_ID;
}
