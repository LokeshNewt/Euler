import api.dto.CountryDTO;
import api.params.CountryParams;
import api.params.QueryParams;
import com.google.gson.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
import entity.BaseEntity;
import entity.Country;
import shared.exception.DBException;
import shared.exception.InvalidArgException;
import store.CountryStore;
import store.IManageCountry;

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

    public void getCountryById() throws DBException {
        Session session = sessionFactory.openSession();
        CountryStore countryStore = new CountryStore();
        Country country = countryStore.getCountryById(session, "AUS01");
        result(country);
        session.close();
//        sessionFactory.close();
    }

//    @Test
    public void createCountry() throws DBException {
        Session session = sessionFactory.openSession();
        CountryStore countryStore = new CountryStore();
        Country country = new Country();
//        country.setCountryId(2L);
        country.setName("New Zealand");
        country.setCapital("Wellington");
        countryStore.createCountry(session, country);
        session.close();
        sessionFactory.close();
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
