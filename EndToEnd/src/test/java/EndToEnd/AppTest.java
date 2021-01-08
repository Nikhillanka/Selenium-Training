package EndToEnd;

import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Formatter;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void getlogintestdetails() throws IOException
    {
    	FileInputStream fis=new FileInputStream("C:\\Users\\Nagesh\\Desktop\\TestData.xlsx");
        XSSFWorkbook wb=new XSSFWorkbook(fis);
        XSSFSheet sheet=wb.getSheetAt(0);
        int rowcount=sheet.getPhysicalNumberOfRows();
        XSSFRow row=sheet.getRow(0);
        int colcount=row.getLastCellNum();      
        Object data[][]=new Object[rowcount-1][colcount];
        DataFormatter formatter = new DataFormatter();
        for(int i=0;i<rowcount-1;i++)
        {
        	row=sheet.getRow(i+1);
        	for(int j=0;j<colcount;j++)
        	{
        		//XSSFCell cell=row.getCell(j);
        		System.out.println(row.getCell(j));
        		
        	//data[i][j]=Formatter.formatCellValue(cell);
        	}
        }
        
    }
  	
}
