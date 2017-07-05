package shared;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by neerbans on 10/13/2016.
 */
@XmlJavaTypeAdapter(DateXmlAdapter.class)
public class CustomDate extends Date implements Serializable {

    public CustomDate(long date) {
        super(date);
    }

    public CustomDate(Date date) {
        this(date.getTime());
    }

    public static CustomDate fromDate(Date date) {
        if (date != null)
            return new CustomDate(date.getTime());
        return null;
    }
}
