package store.namedQuery;

import entity.Country;

import javax.persistence.*;

/**
 * Created by neerbans on 10/8/2016.
 */

@MappedSuperclass
@NamedQueries({
        @NamedQuery(name = CountryNQ.GET_COUNTRY, query = CountryNQ.GET_COUNTRY_QUERY, hints = {
                @QueryHint(name = "org.hibernate.cacheable", value = "true")
        })
})
// we can write sql query using @NamedNativeQuery
@NamedNativeQuery(name = CountryNQ.GET_NATIVE_COUNTRY, query = "select * from Country where countryId = ?", resultClass = Country.class)
public class CountryNQ {

    public interface Params {
        String CREATED_DATE = "createdDate";
        String LAST_NAME = "lastName";
        String COUNTRY_ID = "countryId";
    }

    public static final String GET_COUNTRY = "Country.byId";
    public static final String GET_NATIVE_COUNTRY = "CountryNative.byId";

    static final String GET_COUNTRY_QUERY = "select c from Country c where c.countryId > :" + Params.COUNTRY_ID;
}
