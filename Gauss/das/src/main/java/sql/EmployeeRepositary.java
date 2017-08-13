package sql;

import entity.Country;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by neerbans on 2/16/2016.
 */

public interface EmployeeRepositary extends CrudRepository<Country, Long> {

    List<Country> findAll();

    @Query("select c from Country c where c.countryId < :id")
    List<Country> getCountryById(@Param("id") Long id, @Param("pageRequest")
                                 Pageable pageRequest);

}
