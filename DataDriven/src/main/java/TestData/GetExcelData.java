package TestData;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class GetExcelData extends ReadExcelData {

    public static Object[][] LoginData;
    public static Object[][] ShipmentData;
    public static HSSFRow Row;
    public static HSSFCell cell;
    public static String FilePath = "C:\\Users\\admin\\Desktop\\DataSheet.xls";
    public static String SheetName1 = "Account Creation";
    public static String SheetName2 = "SignIN";
    public static HSSFSheet Sheet;

    @DataProvider
    public static Object[][] getLoginData() throws Exception{

        Sheet = DataSheet(FilePath, SheetName1);
        int rowCount = Sheet.getLastRowNum();
        System.out.println(rowCount);
        int colCount = Sheet.getRow(0).getLastCellNum();
        System.out.println(colCount);

        LoginData = new Object[rowCount][colCount];

        for (int rCnt=1; rCnt<=rowCount;rCnt++){
            for (int cCnt=0; cCnt<colCount;cCnt++){
                LoginData[rCnt-1][cCnt] = getCellData(SheetName1, rCnt, cCnt);
                System.out.println(LoginData[rCnt-1][cCnt]);
            }
        }

        return LoginData;
    }
    @DataProvider
    public static Object[][] getShipmentData() throws Exception{

        Sheet = DataSheet(FilePath, SheetName2);
        int rowCount = Sheet.getLastRowNum();
        System.out.println(rowCount);
        int colCount = Sheet.getRow(0).getLastCellNum();
        System.out.println(colCount);

        ShipmentData = new Object[rowCount][colCount];

        for (int rCnt=1; rCnt<=rowCount;rCnt++){
            for (int cCnt=0; cCnt<colCount;cCnt++){
                ShipmentData[rCnt-1][cCnt] = getCellData(SheetName2, rCnt, cCnt);
                System.out.println(ShipmentData[rCnt-1][cCnt]);
            }
        }

        return ShipmentData;
    }

    public static String getCellData(String Sheet, int row, int col){

        try {

            int index = WBook.getSheetIndex(Sheet);


            WSheet = WBook.getSheetAt(index);
            Row = WSheet.getRow(row);
            if (Row == null)
                return "";

            cell = Row.getCell(col);
            if (cell == null)
                return "";

            switch (cell.getCellType())
            {
                case  Cell.CELL_TYPE_STRING:
                    return cell.getStringCellValue();

                case  Cell.CELL_TYPE_BOOLEAN:
                    return String.valueOf(cell.getBooleanCellValue());

                case  Cell.CELL_TYPE_BLANK:
                    return "";

                case  Cell.CELL_TYPE_ERROR:
                    return cell.getStringCellValue();

                case  Cell.CELL_TYPE_NUMERIC:
                    return String.valueOf(cell.getNumericCellValue());

                default:
                    return "Cell not found";

            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return "row " + row + " or column " + col+ " does not exist in xls";
        }

    }
}
