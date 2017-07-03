package sql;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * Created by neerbans on 2/16/2016.
 */

public interface EmployeeRepositary extends CrudRepository<Employee, Long>{

    List<Employee> findAll();

}
