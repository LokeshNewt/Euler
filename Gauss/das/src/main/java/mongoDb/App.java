package mongoDb;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import sql.Employee;

/**
 * Created by neerbans on 2/16/2016.
 */
public class App {

    private static final Log log = LogFactory.getLog(App.class);

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
        MongoOperations mongoOperation = (MongoOperations) context.getBean("mongoTemplate");

        //User user = new User("prasad2", "saripalli", "kdkdkd");

        Employee employee = new Employee(8, "prasad", "saripalli", "AVPcrossproduct");

        mongoOperation.save(employee);


        //log.info(mongoOperation.findOne(new Query(where("firstName").i)), Employee.class);

        //mongoOperation.dropCollection();
    }
}
