package com.carl.friedrich;

import com.carl.friedrich.service.CountryService;
import entity.Country;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by neerbans on 10/9/2017.
 */

@Path("/countries")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CountryResource {

    CountryService countryService = new CountryService();

    @GET
    public List<Country> getCountries(@QueryParam("year") int year, @QueryParam("start") int start,
                                      @QueryParam("size") int size) {
        if (year > 0) {
            return countryService.getAllCountriesForYear(year);
        }
        if (start >=0 && size > 0) {
            return countryService.getAllCountriesPaginated(start, size);
        }
        return countryService.getAllCountries();
    }

    @GET
    @Path("/{countryId}")
    public Country getCountry(@PathParam("countryId") Long id) {
//        return countryService.getCountries();
        return new Country(id);
    }

    @POST
    public Country addCountry(Country country) {
//        return countryService.getCountries();
        return country;
    }

    @PUT
    @Path("/{countryId}")
    public Country updateCountry(@PathParam("countryId") Long id, Country country) {
        country.setCountryId(id);
        return country;
    }

    @DELETE
    @Path("/{countryId}")
    public Country deleteCountry(@PathParam("countryId") Long id) {
        return new Country(id);
    }

}
