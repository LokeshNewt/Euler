package p1016;

/**
 * Created by neerbans on 10/16/2017.
 */
public class DBTableMetaProvider {

    private static final String SQL_TABLE = LookupUtil.getSelectPreparedStatementStr(XDBExtendedProperty.TABLE, new String[]{XDBExtendedProperty.ColumnName,
            XDBExtendedProperty.NullableFlag, XDBExtendedProperty.DataTypeName, XDBExtendedProperty.LengthNUM, XDBExtendedProperty.IntegrationKeyFlag,
            XDBExtendedProperty.DefaultValue, XDBExtendedProperty.DEFlag, XDBExtendedProperty.BooleanFlag, XDBExtendedProperty.ScaleNUM, XDBExtendedProperty.PrecisionNUM,
            XDBExtendedProperty.TableName, XDBExtendedProperty.PrimaryKeyFlag, XDBExtendedProperty.ForeignKeyTableName, XDBExtendedProperty.ForeignKeyColumnName}, new String[]{});

    public static void main (String args []) {
        System.out.println(SQL_TABLE);
    }
}
