package EndToEnd;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DataProvider {
	DataFormatter formatter=new DataFormatter();
	@Test
    public Object[][] getlogintestdetails() throws IOException
    {
    	FileInputStream fis=new FileInputStream("C:\\Users\\Nagesh\\Desktop\\TestData.xlsx");
        XSSFWorkbook wb=new XSSFWorkbook(fis);
        XSSFSheet sheet=wb.getSheetAt(0);
        int rowcount=sheet.getPhysicalNumberOfRows();
        XSSFRow row=sheet.getRow(0);
        int colcount=row.getLastCellNum();      
        Object data[][]=new Object[rowcount-1][colcount];
        
        for(int i=0;i<rowcount-1;i++)
        {
        	row=sheet.getRow(i+1);
        	for(int j=0;j<colcount;j++)
        	{
        		XSSFCell cell=row.getCell(j);
        		//System.out.println(row.getCell(j));
        		data[i][j]=formatter.formatCellValue(cell);
        	//data[i][j]=Formatter.formatCellValue(cell);
        	}
        }
        return data;
    }
  	

}
