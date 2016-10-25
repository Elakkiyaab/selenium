package TestData;

import com.beust.jcommander.internal.Lists;
import com.google.common.base.Splitter;
import config.Constants;
import data.User;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ExcelUtils {
    private static HSSFSheet excelWSheet;
    private static HSSFWorkbook excelWBook;

    public static List<String> getTestData(String FilePath, String sheetName, final String testcaseName)    throws Exception
    {
        List list = Lists.newArrayList();
        try{
            FileInputStream excelFile = new FileInputStream(FilePath);
            excelWBook = new HSSFWorkbook(excelFile);
            excelWSheet = excelWBook.getSheet(sheetName);
            int rowCount = excelWSheet.getLastRowNum();
            for (int i=0 ; i<=rowCount; i++){
                Row row = excelWSheet.getRow(i);
                if(row.getCell(0).getStringCellValue().equals(testcaseName)){
                     list.add(row.getCell(1).getStringCellValue());
                }
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        }
        return list;
    }

    public static Object getObject(Map<String, String> map, String className) throws ClassNotFoundException {
        Class c =  Class.forName(className);
        final ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(map, c);
    }

    public static Object[][] getTestDataArray(List<String> testData) throws Exception {
        Object [][] objArray = new Object[testData.size()][];
        int index =0;
        for(String data:testData) {
            Map<String, String> map = Splitter.on("#####").withKeyValueSeparator("=").split(data);
            String className = map.get("propertyName");
            objArray[index] = new Object[1];
            objArray[index++][0] = ExcelUtils.getObject(map, className);
        }
        return objArray;

    }

}