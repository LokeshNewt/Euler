package shared;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Date;

/**
 * Created by neerbans on 10/20/2016.
 */
public class DateXmlAdapter extends XmlAdapter<Date, CustomDate> {


    @Override
    public CustomDate unmarshal(Date v) throws Exception {
        return new CustomDate(new Date());
    }

    @Override
    public Date marshal(CustomDate v) throws Exception {

//        GregorianCalendar gcal = new GregorianCalendar();
//        gcal.setTime(v);
//        XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
//        xmlDate.setYear(2255);
//        xmlDate.setTimezone(DatatypeConstants.FIELD_UNDEFINED);

        return v;

    }
}