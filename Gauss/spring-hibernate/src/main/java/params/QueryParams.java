package params;

import util.CommonUtil;

import java.util.Date;

/**
 * Created by neerbans on 10/8/2016.
 */
public class QueryParams {

    private Date date ;

    public Date getDate() {
        return date;
    }

    public QueryParams setDate(String date) {
        this.date = CommonUtil.parseDate(date);
        return this;
    }

    public static QueryParams build() {
        return new QueryParams();
    }
}
