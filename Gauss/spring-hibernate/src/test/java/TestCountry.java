import api.dto.CountryDTO;
import api.params.CountryParams;
import api.params.QueryParams;
import com.google.gson.*;
import entity.*;
import org.apache.commons.lang.StringUtils;
import org.hibernate.*;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.json.JSONObject;
import org.json.XML;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import shared.CustomDate;
import shared.exception.DBException;
import shared.exception.InvalidArgException;
import store.CountryStore;
import store.IManageCountry;
import store.namedQuery.CountryNQ;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * Created by neerbans on 10/6/2016.
 */

@ContextConfiguration(locations = {"classpath:hb-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestCountry {

    @Autowired
    private IManageCountry manageCountry;

    @Autowired
    private CountryStore countryStore;

    @Autowired
    @Qualifier("hibernateSessionFactory")
    private SessionFactory sessionFactory;

    @Test
    public void sample() {

    }

//    @Test
    public void test() throws InvalidArgException, DBException {
//        testCountry();
    }

    private void loadSession() {
        Session session = sessionFactory.openSession();
        Country country = session.load(Country.class, "AUS01");
        System.out.println("name = " + country.getName());
    }

//    @Test
    public void getCountryById() throws DBException {
        Session session = sessionFactory.openSession();
        CountryStore countryStore = new CountryStore();
        List<Country> countries = countryStore.getCountryById(session, 1L, 0, Integer.MAX_VALUE-1);
        countries.forEach(c -> System.out.println(c.getCountryId()));
        System.out.println(countries.size() + "----------");
//        result(country);
        session.close();
    }

//   @Test
    public void createCountry() throws DBException {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        for (int i=0; i<4; i++) {
           Country country = new Country();
           country.setName("New Zealand");
           country.setCapital("Wellington");
           country.setCreatedDate(new Date());
           session.save(country);
//
//        Nation info = new Nation();
//        info.setPresident("president");
//        info.setPrime_minister("pm");
//
//        country.setInfo(info);
        }
        session.getTransaction().commit();
        session.close();
//        sessionFactory.close();
    }

       //@Test
    public void crudCountry() throws DBException {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
           // create
//        for (int i=0; i<10; i++) {
           Country country = new Country();
           country.setName("New Zealand ");
           country.setCapital("Wellington ");
           country.setCreatedDate(new Date());
           session.save(country);
//        }

        session.getTransaction().commit();

           session.close();
//           System.out.println(" Country name pulled up is : " + country.getName());

//        sessionFactory.close();
    }

//    @Test
    public void queryCountry() throws DBException {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Long countryId = 5l;

        // parameter binding using positions
//        Query query = session.createQuery("from Country where countryId > ? and capital = ?" );
//        query.setLong(0, countryId); // 0 is the position indicator
//        query.setString(1, "paris");
        // parameter binding using :
        Query query = session.createQuery("from Country where countryId > :id and capital = :capital" );
        query.setLong("id", countryId); // 0 is the position indicator
        query.setString("capital", "paris");
        query.setFirstResult(3);
        query.setMaxResults(10);

        List<Country> countries = query.list();

        session.getTransaction().commit();
        session.close();
        System.out.println(" Country name pulled up is : " + countries.size());

//        sessionFactory.close();
    }

//    @Test
    public void criteriaCountry() throws DBException {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Long countryId = 11L;

        Country exampleCountry = new Country();
//        exampleCountry.setCountryId(5L);
        exampleCountry.setName("France");

        Example example = Example.create(exampleCountry).excludeProperty("capital");

        Criteria criteria = session.createCriteria(Country.class)
                .add(example);
//                .setProjection(Projections.property("countryId"))
//                .addOrder(Order.desc("name"));
//        criteria.add(Restrictions.or(Restrictions.between("", 5, 10), Restrictions.ge("", 34)));
//        criteria.add(Restrictions.eq("capital", "paris"))
//                .add(Restrictions.gt("countryId", 5L));

        List<Country> countries = criteria.list();

        session.getTransaction().commit();
        session.close();
        System.out.println(" Country name pulled up is : " + countries.size());

//        sessionFactory.close();
    }

//    @Test
    public void namedQueryCountry() throws DBException {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Long countryId = 11L;


        Query query = session.getNamedQuery(CountryNQ.GET_NATIVE_COUNTRY);
        query.setLong(0, countryId);
//        Query query = session.getNamedQuery(CountryNQ.GET_COUNTRY);
//        query.setLong(CountryNQ.Params.COUNTRY_ID, countryId);
//        query.setFirstResult(3);
//        query.setMaxResults(10);

        List<Country> countries = query.list();

        session.getTransaction().commit();
        session.close();
        System.out.println(" Country name pulled up is : " + countries.size());

//        sessionFactory.close();
    }

   // @Test
    public void createCountry_OneToMany() throws DBException {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Country country = new Country();
        country.setName("New Zealand");
        country.setCapital("Wellington");
        country.setCreatedDate(new Date());
//
//        Nation info = new Nation();
//        info.setPresident("president");
//        info.setPrime_minister("pm");
//
//        country.setInfo(info);
        Event event1 = new Event();
        event1.setDesc("Babri Mosque");
        Event event2 = new Event();
        event2.setDesc("Operation Blue Star");
        country.getEvents().add(event1);
        country.getEvents().add(event2);
//        event1.setCountry(country);
//        event2.setCountry(country);
        session.persist(country);
//        session.save(event1);
//        session.save(event2);
        session.getTransaction().commit();
        session.close();
//        sessionFactory.close();
    }


    //    @Test
    public void createCountry_ManyToMany() throws DBException {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Country country = new Country();
        country.setName("New Zealand");
        country.setCapital("Wellington");
        country.setCreatedDate(new Date());
        Religion religion1 = new Religion();
        religion1.setName("Budhism");
        Religion religion2 = new Religion();
        religion2.setName("Budhism");
        country.getReligions().add(religion1);
        country.getReligions().add(religion2);
        religion1.getCountries().add(country);
        religion2.getCountries().add(country);
        countryStore.createCountry(session, country);
        session.save(religion1);
        session.save(religion2);
        session.getTransaction().commit();
        session.close();
//        sessionFactory.close();
    }

//    @Test
    public void getCountryBySession() throws DBException {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Country country = session.get(Country.class, 1L);
        System.out.println(country.getName());
        session.close();
        System.out.println(country.getEvents().size());
//        result(country);
//        session.close();
    }

//    @Test
    public void testAnnotation() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
//        Employee e = new Employee();
//        e.setFirstName("katy");
//        e.setCreatedDTTM(CommonUtil.getCurrentServerDateTime());
//        session.save(e);
        transaction.commit();
        session.close();
    }


    @SuppressWarnings("unchecked")
//    @Test
    public void listEmployee() throws InvalidArgException, DBException {
        String date = "1960-01-01T11:35:25";

        QueryParams queryParams = QueryParams.build().setDate(date);
        Session session = sessionFactory.openSession();
        List<Country> employees = manageCountry.listEmployees(session, queryParams, 0, 5);
        System.out.println("size :" + employees.size());
        CountryDTO dto = new CountryDTO();
        //api.dto.setUpdatedDTTM(CustomDate.fromDate(employees.get(0).getUpdatedDTTM()));
//        api.dto.setUpdatedDTTM(new CustomDate(employees.get(0).getCreatedDTTM()));
        //api.dto.setUpdatedDTTM(new CustomDate(new Date()));
        //test(api.dto);
//        api.dto.setName(employees.get(0).getProduct());
//        printList(employees.get(0));
//        result(api.dto);
        result(employees);
        session.close();
    }

    private <T extends BaseEntity> void printList( T entity ) {

//        System.out.println(entity.getProduct());
    }

    private void testDateFormat(CountryDTO dto) {
//        String pattern = "yyyy-MM-dd HH:mm:ss.SSS"; //yyyy-MM-dd'T'HH:mm:ss.SSS, MMM d, YYYY hh:mm:ss a
//        //Date d = api.dto.getUpdatedDTTM();
//        System.out.println(d);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//        String s = simpleDateFormat.format(d);
//        System.out.println(s);
    }

    //@Test
    public void xmlToObject() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(CountryDTO.class);
        Unmarshaller jm = jaxbContext.createUnmarshaller();
        // date must be in this format : 2016-10-14T07:20:22.757 in file ( xml recognizes only this, otherwise
        // write separate adapter for this
        File f = new File("C:\\Neeraj\\deepak.xml");  // make it source file, change date format in it - todo
        //File f = new File(getClass().getClassLoader().getResource("/xml/deepak.xml").getFile());
        CountryDTO dto = (CountryDTO) jm.unmarshal(f);
        result(dto);
    }

//    @Test
    public void objectToXML() throws JAXBException, FileNotFoundException {

        CountryDTO dto = new CountryDTO();
        dto.setId(1l);
        dto.setName("neeraj");
        dto.setCreatedDTTM(new Date());
        result(dto);
//        dto.setUpdatedDTTM(new CustomDate(new Date()));

        JSONObject jsonObject = new JSONObject("{\n" +
                "  \"id\": 1,\n" +
                "  \"name\": \"neeraj\",\n" +
                "  \"createdDTTM\": \"2017-07-29\"\n" +
                "}");

        JAXBContext jaxbContext = JAXBContext.newInstance(JSONObject.class);
//        String xml = XML.toString(jsonObject);
//        System.out.println(xml);

        Marshaller j = jaxbContext.createMarshaller();
        j.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

//        j.marshal(api.dto, System.out);
        j.marshal(jsonObject, new FileOutputStream("C:\\Neeraj\\deepak2.xml")); // no need to create file, it will create automatically
    }

    //@Test
    public void xmlToJson() {
        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<jdjdjdjdj id=\"1\">\n" +
                "    <date>2016-10-20T15:41:09.932+05:30</date>\n" +
                "    <name>jdjdj</name>\n" +
                "    <updatedDTTM>2222-10-20T15:41:09.932</updatedDTTM>\n" +
                "</jdjdjdjdj>";
        JSONObject jsonObject = XML.toJSONObject(str);
        System.out.println(jsonObject.toString());
    }

    //@Test
    public void addEmployee() throws InvalidArgException {

        String firstName = "geeta";
        String lastName = "krishnan";
        String dept = "clinical/pd";
        boolean flag = true;
        Long messageSid = 3l;
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();

        CountryParams countryParams = CountryParams.build().setDept(dept).setFirstName(firstName).setLastName(lastName).setFlag(flag).
                setCreatedDTTM(date).setUpdatedDTTM(date).setMessageSid(messageSid).setId(1002L);

        for (int i=0 ; i < 1; i++)
            manageCountry.addCountry(sessionFactory.openSession(), countryParams);
    }

    //@Test
    public void addMessage() {
        for (int i=0 ; i < 1; i++)
            manageCountry.addReligion(sessionFactory.openSession(), 1l);
    }

    private void result(Object response) {
        Gson gson = new GsonBuilder().registerTypeAdapter(CustomDate.class, new CustomDateSerializer()).setPrettyPrinting().create();
        //Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String res = gson.toJson(response);
        System.out.println(res);
    }

    @Ignore
    public static class CustomDateSerializer implements JsonSerializer<CustomDate> {
        @Override
        public JsonElement serialize(CustomDate customDate, Type type, JsonSerializationContext jsonSerializationContext) {
            JsonPrimitive jsonPrimitive = new JsonPrimitive(customDate.toString());
            return jsonPrimitive;
        }
    }

    private void serialize() {
        try {
            CountryDTO employeeDTO = new CountryDTO();
            employeeDTO.setName("jdjdjdj");
            employeeDTO.setId(78l);

            FileOutputStream fout = new FileOutputStream("C:\\Neeraj\\f.txt");
            ObjectOutputStream out = new ObjectOutputStream(fout);

            out.writeObject(employeeDTO);
            out.flush();
            System.out.println("success");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void deSerialize() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\Neeraj\\f.txt"));
            CountryDTO employee = (CountryDTO) in.readObject();
            System.out.println(employee.getId() + "-" + employee.getName());
            in.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //@Test
    public void addPerson() {

      //  for (int i=0 ; i < 1; i++)
           // manageCountry.addPerson(sessionFactory.openSession(), 4);
    }

}
