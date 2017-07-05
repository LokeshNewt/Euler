package store;

import shared.exception.DBException;
import shared.exception.InvalidArgException;
import org.hibernate.Session;
import api.params.CountryParams;
import api.params.QueryParams;
import shared.Param;

import java.util.List;

/**
 * Created by neerbans on 4/6/2017.
 */
public interface IManageCountry {

    void addCountry(Session session, CountryParams countryParams) throws InvalidArgException;

    Long addReligion(Session session, Long messageSid);

    List listEmployees(Session session , @Param("QueryParams") QueryParams queryParams, int startIndex, int limitCount) throws InvalidArgException, DBException;
}
