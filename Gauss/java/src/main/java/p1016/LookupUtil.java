package p1016;

/**
 * Created by neerbans on 10/16/2017.
 */
public class LookupUtil {

    public static String getSelectPreparedStatementStr(String tableName, String[] selectFieldNames, String[] criteriaFieldNames) {
        String condition = null;
        if (criteriaFieldNames != null && criteriaFieldNames.length > 0) {
            StringBuilder conditionStr = new StringBuilder();
            for (int i = 0; i < criteriaFieldNames.length; i++) {
                if (i > 0) {
                    conditionStr.append("and ");
                }
                conditionStr.append(criteriaFieldNames[i]);
                conditionStr.append("= ? ");
            }
            condition = conditionStr.toString();
        }
        return getSelectPreparedStatementStr(tableName, selectFieldNames, condition);
    }

    public static String getSelectPreparedStatementStr(String tableName, String[] selectFieldNames, String condition) {
        StringBuilder selectStr = new StringBuilder("select ");
        if (selectFieldNames != null) {
            for (int i = 0; i < selectFieldNames.length; i++) {
                if (i > 0) {
                    selectStr.append(", ");
                }
                selectStr.append(selectFieldNames[i]);
            }
        }
        selectStr.append(" from " + tableName);
        if (condition != null) {
            selectStr.append(" where " + condition);
        }
        return selectStr.toString();
    }
}
