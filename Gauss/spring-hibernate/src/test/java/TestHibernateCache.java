import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import entity.Country;
import shared.exception.DBException;
import shared.exception.InvalidArgException;
import store.CountryStore;

/**
 * Created by neerbans on 7/6/2017.
 */

//@ContextConfiguration(locations = {"classpath:hb-context.xml"})
//@RunWith(SpringJUnit4ClassRunner.class)
public class TestHibernateCache {

    @Autowired
    @Qualifier("hibernateSessionFactory")
    private SessionFactory sessionFactory;

    private Statistics stats;

    @Test
    public void sample() {

    }

//    @Test
    public void test() throws InvalidArgException, DBException {
        stats = sessionFactory.getStatistics();
        stats.setStatisticsEnabled(true);
        testCountry();
    }

    public void testCountry() throws DBException {
        Session session = sessionFactory.openSession();
        CountryStore countryStore = new CountryStore();
//        Country country = session.load(Country.class, "AUS01");
        Country country = countryStore.getCountryById(session, "AUS01");
//        result(country);
        System.out.println("name = " + country.getName());
        printStats(stats, 1);

//        country = session.load(Country.class, "AUS01");
        country = countryStore.getCountryById(session, "AUS01");
        System.out.println("name = " + country.getName());
        printStats(stats, 2);

//        session.evict(country);
//        country = session.load(Country.class, "AUS01");
        country = countryStore.getCountryById(session, "AUS01");
//        result(country);
        System.out.println("name = " + country.getName());
        printStats(stats, 3);
//        session.close();
        testSession2();
    }

    private void testSession2() throws DBException {
        CountryStore countryStore = new CountryStore();
        Session session = sessionFactory.openSession();
        Country country = countryStore.getCountryById(session, "AUS01");
//        Country country = session.load(Country.class, "AUS01");
//        result(country);
        System.out.println("name = " + country.getName());
        printStats(stats, 4);
        session.close();
        sessionFactory.close();
    }

    private void printStats (Statistics stats, int i) {
        System.out.println("************** " + i + " *****************");
        System.out.println("query hit count = " + stats.getQueryCacheHitCount());
        System.out.println("query miss count = " + stats.getQueryCacheMissCount());
        System.out.println("query put count = " + stats.getQueryCachePutCount());
        System.out.println("second level hit count = " + stats.getSecondLevelCacheHitCount());
        System.out.println("second level miss count = " + stats.getSecondLevelCacheMissCount());
        System.out.println("second level put count = " + stats.getSecondLevelCachePutCount());
        System.out.println("entity fetch count = " + stats.getEntityFetchCount());
    }
}
