import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.sql.*;
import java.util.*;
import java.io.*;

/**
 * Created by neerbans on 3/14/2017.
 */

public class MakeExcel {

    List<String> list;
    List<String> list2;

    public MakeExcel() {
        String [] arr = {"CreatedDTTM", "CreatedByUserSID", "RowStatusCD", "PrimarySID", "EffectiveDTTM", "ExpiryDTTM", "MessageSID", "TenantSID",
                "UpdatedDTTM", "UpdatedByUserSID"};

        String arr1[] = {"BeneficiaryScore","CareGap","Claim","Claim","ClaimEvent","ClaimProvider","ClaimService","ClaimServiceProcedure",
                "ClaimServiceProvider","ClinicalDiagnosis","ClinicalDiagnosisCCSearch","ClinicalOrder","ClinicalOrderDocument","ClinicalOrderProvider",
                "ClinicalOrderReason","ClinicalProcedure","ConsentDirective","ConsentDirectivePolicy","ConsentPolicyPurpose","Dispense","DispenseProvider",
                "Document","DocumentAuthor","IndividualProviderPatient","Member","MemberCOB","MemberHealthCoverage","MemberPCP","Message","Notification",
                "NotificationAction","NotificationReason","Observation","ObservationDocument","ObservationLocation","ObservationProvider","ObservationReferenceRange",
                "ObservationValue","Person","PersonAddress","PersonContact","PersonIdentifier","PersonIdentifierMap","PersonRace","Problem","ProblemDocument",
                "ProblemObservation","ProblemProvider","ProcedureDocument","ProcedureLocation","ProcedureProvider","Program","ProgramRoster","ProgramRosterOrganization",
                "RelatedObservation","ServiceModifier","SubstanceAdmin","SubstanceAdminDocument","SubstanceAdminObservation","SubstanceAdminPreCondition",
                "SubstanceAdminProvider","SubstanceAdminRefusal","SubstanceOrder","Visit","VisitLocation","VisitProvider","XDictionaryConcept","XDictionaryConceptGroup",
                "XDictionaryConceptMap","XFacility","XIndividualProvider","XIndividualProviderAddress","XIndividualProviderContact","XInsuranceGroup","XLocation",
                "XManufacturer","XOrgCollection","XOrgCollectionAddress","XOrgCollectionAssociate","XOrgCollectionContact","XOrgCollectionHierarchy","XOrganization",
                "XPayerProductTier","XProvider","XProviderSpecialty","XSubstance","XUser"};
        list = new ArrayList<>();
        list2 = new ArrayList<>();
//        System.out.println(arr1.length);
//        System.out.println(0/0);
        Collections.addAll(list, arr);
        Collections.addAll(list2, arr1);
    }

    private static final String FILE_NAME = "C:\\Neeraj\\Book1.xlsx";

    public static void main (String args[]) {
        MakeExcel me = new MakeExcel();
        me.writeToExcel();
    }

    private void writeToExcel() {
        int rowNum = 0;
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Pacific Source remaining3");
        String [][] columns = getResult();
        for (String [] col : columns) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (String s : col) {
                Cell cell = row.createCell(colNum++);
                cell.setCellValue(s);
            }
        }
        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Excel Successfully Created");
    }

    public String [] [] getResult () {
//        String [] [] column = new String [5000] [2];
        String [] [] column2 = new String [5000] [2];
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String line;
        Map<String, List<String>> map = new HashMap<>();
//        int j=0;
        ResultSet rs = connectSql();
        try {
            while (rs.next()) {
                String tableName = rs.getString("TableName");
                String columnName = rs.getString("ColumnName");
                tableName = tableName.substring(0,1).toUpperCase() + tableName.substring(1);
                boolean tableFlag, columnFlag;
                columnFlag = !list.contains(columnName);
                tableFlag = list2.contains(tableName);

//                if (tableFlag && columnFlag && tableName.equals("ConsentDirectivePolicy")) {
//                    column[j][0] = tableName;
//                    column[j++][1] = columnName;
//                }
                if (tableFlag && columnFlag && tableName.equals("XProviderSpecialty")) {
                    if (map.containsKey(tableName)) {
                        map.get(tableName).add(columnName);
                    } else {
                        List<String> list = new ArrayList<>();
                        list.add(columnName);
                        map.put(tableName, list);
                    }
                }
            }
            int k=0;
            List<String> tName = new ArrayList<>(map.keySet());
            Collections.sort(tName);
            for (String s1 : tName) {
                List<String> l2 = map.get(s1);
                Collections.sort(l2);
                for (String s3 : l2) {
                    column2[k] [0] = s1;
                    column2[k++] [1] = s3;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return column2;
    }

    public ResultSet connectSql() {
        ResultSet rs = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:jtds:sqlserver://localhost/ravikuma_xcdr;user=sa;password=Edifecs2014;");
            Statement sta = conn.createStatement();
            String Sql = getSql();
            rs = sta.executeQuery(Sql);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return rs;
    }

    private String getSql() {
        String s = "SELECT   SchemaName = c.table_schema,\n" +
                "         TableName = c.table_name,\n" +
                "         ColumnName = c.column_name,\n" +
                "         DataType = data_type\n" +
                "FROM     information_schema.columns c\n" +
                "         INNER JOIN information_schema.tables t\n" +
                "           ON c.table_name = t.table_name\n" +
                "              AND c.table_schema = t.table_schema\n" +
                "              AND t.table_type = 'BASE TABLE'\n" +
                "ORDER BY SchemaName,\n" +
                "         TableName,\n" +
                "         ordinal_position";
        return s;
    }


    private void getClassandMethodName() {

        //add below dependency
//    <dependency>
//    <groupId>org.reflections</groupId>
//    <artifactId>reflections</artifactId>
//    <version>0.9.11</version>
//    </dependency>

//        Reflections reflections = new Reflections("com.edifecs.pd.entity");
//        Set<Class<? extends BaseEntity>> classes = reflections.getSubTypesOf(BaseEntity.class);
//        List<Class<? extends BaseEntity>> classes1 = new ArrayList<>(classes);
//        Collections.sort(classes1, (o1, o2) -> {
//            Class c1 = (Class) o1;
//            Class c2 = (Class) o2;
//            return c1.getSimpleName().compareTo(c2.getSimpleName());
//        });
//        for (Class c2 : classes1) {
//            System.out.println(c2.getSimpleName());
//            Field [] fields = c2.getDeclaredFields();
//            List<Field> fields1 = new ArrayList<>();
//            Collections.addAll(fields1, fields);
//            Collections.sort(fields1, (o1, o2) -> {
//                Field f1 = (Field) o1;
//                Field f2 = (Field) o2;
//                return f1.getName().compareTo(f2.getName());
//            });
//            for (Field f : fields1) {
//                System.out.println(" - " + f.getName());
//            }
//        }
    }




}
