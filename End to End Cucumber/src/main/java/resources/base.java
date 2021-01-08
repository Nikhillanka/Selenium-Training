package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Formatter;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class base {
	public WebDriver driver;
	public static Properties prop;
	DataFormatter formatter=new DataFormatter();
	public WebDriver initalizeDriver() throws IOException 
	{
		prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\Nagesh\\Desktop\\NIKHIL\\EndToEnd\\src\\main\\java\\resources\\data.properties");
	    prop.load(fis);
	 String browsername=prop.getProperty("browser");
	 System.out.println(browsername);
	 if(browsername.equals("chrome"))
	 {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nagesh\\Desktop\\NIKHIL\\chromedriver.exe");
		driver = new ChromeDriver(); 
	 }
	 else if(browsername.equals("firefox")) 
	 {
		 System.setProperty("webdriver.gecko.driver", "C:\\Users\\Nagesh\\Desktop\\NIKHIL\\geckodriver.exe");
			driver = new FirefoxDriver();
	 }
	 else if(browsername.equals("IE"))
	 {
		 
	 }
	 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	 return driver;
    }
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");
		//String png= System.currentTimeMillis()+ ".png";
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+formater.format(calendar.getTime())+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		
		return destinationFile;
	}
  @DataProvider
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
