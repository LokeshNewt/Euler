import com.google.gson.*;
import dto.EmployeeDTO;
import exception.DBException;
import exception.InvalidArgException;
import hibernate.entity.BaseEntity;
import hibernate.entity.CustomDate;
import hibernate.entity.Employee;
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
import params.EmployeeParams;
import params.QueryParams;
import store.CountryStore;
import store.IManageEmployee;
import store.ManageEmployee;
import store.entity.Country;
import util.CommonUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;


/**
 * Created by neerbans on 10/6/2016.
 */

@ContextConfiguration(locations = {"classpath:hb-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestEmployee {

    @Autowired
    @Qualifier("manageEmployee")
    private IManageEmployee manageEmployee;

    @Autowired
    @Qualifier("hibernateSessionFactory")
    private SessionFactory sessionFactory;

    @Test
    public void test() throws InvalidArgException, DBException {
//        listEmployee();
//        addEmployee();
        testCountry();
    }

    public void testCountry() throws DBException {
        Session session = sessionFactory.openSession();
        CountryStore countryStore = new CountryStore();
        Country country = countryStore.getCountryById(session, "AUS01");
        result(country);
        session.close();

        TestUnitCoverage.coverage();
    }

//    @Test
    public void testAnnotation() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee e = new Employee();
        e.setFirstName("katy");
        e.setCreatedDTTM(CommonUtil.getCurrentServerDateTime());
        session.save(e);
        transaction.commit();
        session.close();
    }


    @SuppressWarnings("unchecked")
//    @Test
    public void listEmployee() throws InvalidArgException, DBException {
        String date = "1960-01-01T11:35:25";

        QueryParams queryParams = QueryParams.build().setDate(date);
        Session session = sessionFactory.openSession();
        List<Employee> employees = manageEmployee.listEmployees(session, queryParams, 0, 5);
        System.out.println("size :" + employees.size());
        EmployeeDTO dto = new EmployeeDTO();
        //dto.setUpdatedDTTM(CustomDate.fromDate(employees.get(0).getUpdatedDTTM()));
//        dto.setUpdatedDTTM(new CustomDate(employees.get(0).getCreatedDTTM()));
        //dto.setUpdatedDTTM(new CustomDate(new Date()));
        //test(dto);
//        dto.setName(employees.get(0).getProduct());
//        printList(employees.get(0));
//        result(dto);
        result(employees);
        session.close();
    }

    private <T extends BaseEntity> void printList( T entity ) {

//        System.out.println(entity.getProduct());
    }

    private void testDateFormat(EmployeeDTO dto) {
//        String pattern = "yyyy-MM-dd HH:mm:ss.SSS"; //yyyy-MM-dd'T'HH:mm:ss.SSS, MMM d, YYYY hh:mm:ss a
//        //Date d = dto.getUpdatedDTTM();
//        System.out.println(d);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//        String s = simpleDateFormat.format(d);
//        System.out.println(s);
    }

    //@Test
    public void xmlToObject() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeDTO.class);
        Unmarshaller jm = jaxbContext.createUnmarshaller();
        // date must be in this format : 2016-10-14T07:20:22.757 in file ( xml recognizes only this, otherwise
        // write separate adapter for this
        File f = new File("C:\\Neeraj\\deepak.xml");  // make it source file, change date format in it - todo
        //File f = new File(getClass().getClassLoader().getResource("/xml/deepak.xml").getFile());
        EmployeeDTO dto = (EmployeeDTO) jm.unmarshal(f);
        result(dto);
    }

    //@Test
    public void objectToXML() throws JAXBException, FileNotFoundException {

        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(1l);
        dto.setName("neeraj");
        dto.setDate(new Date());
        dto.setUpdatedDTTM(new CustomDate(new Date()));

        JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeDTO.class);

        Marshaller j = jaxbContext.createMarshaller();
        j.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

//        j.marshal(dto, System.out);
        j.marshal(dto, new FileOutputStream("C:\\Neeraj\\deepak2.xml")); // no need to create file, it will create automatically
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

        EmployeeParams employeeParams = EmployeeParams.build().setDept(dept).setFirstName(firstName).setLastName(lastName).setFlag(flag).
                setCreatedDTTM(date).setUpdatedDTTM(date).setMessageSid(messageSid).setId(1002L);

        for (int i=0 ; i < 1; i++)
            manageEmployee.addEmployee(sessionFactory.openSession(), employeeParams);
    }

    //@Test
    public void addMessage() {
        for (int i=0 ; i < 1; i++)
            manageEmployee.addMessage(sessionFactory.openSession(), 1l);
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
            EmployeeDTO employeeDTO = new EmployeeDTO();
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
            EmployeeDTO employee = (EmployeeDTO) in.readObject();
            System.out.println(employee.getId() + "-" + employee.getName());
            in.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //@Test
    public void addPerson() {

      //  for (int i=0 ; i < 1; i++)
           // manageEmployee.addPerson(sessionFactory.openSession(), 4);
    }

    //@Test
    public void equalHashCode() {
        EmployeeDTO employeeDTO1 = new EmployeeDTO();
        employeeDTO1.setId(1l);
        employeeDTO1.setName("neeraj");
        EmployeeDTO employeeDTO2 = new EmployeeDTO();
        employeeDTO2.setId(1l);
        employeeDTO2.setName("manya");
        List<EmployeeDTO> list = new ArrayList<>();
        Set<EmployeeDTO> set = new HashSet<EmployeeDTO>();
    }

    //@Test
    public void testNKA() {
        EmployeeDTO employeeDTO1 = new EmployeeDTO();
        employeeDTO1.setId(1l);
        employeeDTO1.setName("neeraj");
        EmployeeDTO employeeDTO2 = new EmployeeDTO();
        employeeDTO2.setId(2l);
        employeeDTO2.setName("manya");
        List<EmployeeDTO> employees = new ArrayList<>();
        employees.add(employeeDTO1);
        employees.add(employeeDTO2);
        final Long id = 200l;
        List<EmployeeDTO> filterEmployees = employees.stream().filter(e -> e.getId() == id).collect(Collectors.toList());
        //result(filterEmployees);

        Employee employee1 = new Employee();
        employee1.setEmployeeId(200l);
        employee1.setLastName("neerajdd");
        Employee employee2 = new Employee();
        employee2.setEmployeeId(2l);
        employee2.setLastName("neeraj");
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        //final Long id = 1l;
        List<Employee> filterEmployees2 = employeeList.stream().filter(e -> e.getEmployeeId().equals(id)).collect(Collectors.toList());
        result(filterEmployees2);
    }

}
