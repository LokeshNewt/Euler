import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import scala.Char;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by neerbans on 3/29/2017.
 */
public class ReadExcel {

    private static final String FILE_NAME = "C:\\Neeraj\\test\\Entity_Cols_notMapped.xlsx";


    public static void main(String args []) {
        ReadExcel re = new ReadExcel();
        re.read();
    }

    private void read() {
        try {
            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);

            Set<String> tableNames = new HashSet<>();
            for (Row currentRow : datatypeSheet) {
                Cell cell = currentRow.getCell(2);
                if (cell != null) {
                    String value = currentRow.getCell(2).getStringCellValue();
                    if (value.contains("x")) {
//                        System.out.println(currentRow.getRowNum()+1);
//                        System.out.println(currentRow.getCell(0).getStringCellValue());
//                        System.out.println(currentRow.getCell(1).getStringCellValue());

                        String tableName = currentRow.getCell(0).getStringCellValue();
//                        if (!tableNames.contains(tableName)) {
//                            System.out.println(tableName);
//                            tableNames.add(tableName);
//                            System.out.println();
//                        }

                        String dbColumnName = currentRow.getCell(1).getStringCellValue();
                        String columnName = dbColumnName;
                        String type = "";
                        String de = "@Type(type = IEntity.code)\n";
                        String v = "";
                        String bool = "@Type(type = \"yes_no\")\n";
                        int size;
                        boolean flag = false;
                        if (columnName.endsWith("SID")) {
                            type = "Long";
                            size = columnName.length();
                            columnName = columnName.substring(0, size-2) + columnName.substring(size-2).toLowerCase();
                            flag = true;
                        } else if (columnName.endsWith("ID")) {
                            type = "String";
                            size = columnName.length();
                            columnName = columnName.substring(0, size-1) + columnName.substring(size-1).toLowerCase();
                        } else if (columnName.endsWith("DE")) {
                            type = "CodeDE";
                            v += de;
                            size = columnName.length();
                            columnName = columnName.substring(0, size-2);
                        } else if (columnName.endsWith("Flag")) {
                            type = "Boolean";
                            v += bool;
                        } else if (columnName.endsWith("DTTM")) {
                            type = "Date";
                        } else if (columnName.endsWith("QTY")) {
                            type = "Double";
                            size = columnName.length();
                            columnName = columnName.substring(0, size-2) + columnName.substring(size-2).toLowerCase();
                        } else {
                            type = "String";
                            v += "-----";
                        }
//                        v += "@Column(name = \""+dbColumnName+"\")\n";
//                        v += "private "+ type + " " + Character.toLowerCase(columnName.charAt(0)) + columnName.substring(1) + ";";
//                        System.out.println(v);

                        if (flag) {
                            if (!tableNames.contains(tableName)) {
                                System.out.println();
                                System.out.println(tableName);
                                tableNames.add(tableName);
//                            System.out.println();
                            }
                            System.out.println("----" + columnName);
                        }
//                        System.out.println();
                    }

                }
            }
            System.out.println(tableNames.size());
            System.out.println(tableNames);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
