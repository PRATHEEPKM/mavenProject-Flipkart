package maven;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Flipkart {
private static Object FileOutputStream;

public static void main(String[] args) throws InterruptedException, IOException {
	System.setProperty("webdriver.edge.driver","C:\\Users\\pratheep.km\\eclipse-workspace\\Selineam\\Drivers\\msedgedriver.exe");
	WebDriver driver= new EdgeDriver();
	driver.get("https://www.flipkart.com/");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("(//button[text()])[1]")).click();
	driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Redmi mobile",Keys.ENTER);
	driver.findElement(By.xpath("//*[@type='submit']"));
	WebElement move=driver.findElement(By.xpath("//*[contains(text(),'Explore')]"));
	Thread.sleep(3000);
	Actions ac=new Actions(driver);
	ac.moveToElement(move).perform();
	String parent=driver.getWindowHandle();
	System.out.println(parent);
	driver.switchTo().window(parent);
WebElement mobil1=driver.findElement(By.xpath("(//*[contains(text(),'REDMI 9i')])[1]"));
mobil1.click();
String tex1=mobil1.getText();
System.out.println(tex1);
	driver.switchTo().window(parent);
	Thread.sleep(3000);
WebElement mobil2=	driver.findElement(By.xpath("(//*[contains(text(),'REDMI 9i')])[2]"));
mobil2.click();
	String tex2=mobil2.getText();
	System.out.println(tex2);
	driver.switchTo().window(parent);
	Thread.sleep(3000);
WebElement mobil3=	driver.findElement(By.xpath("(//*[contains(text(),'REDMI 9i')])[3]"));
mobil3.click();
	String tex3=mobil3.getText();
	System.out.println(tex3);
	driver.switchTo().window(parent);
	Thread.sleep(3000);
	Set<String> multi=driver.getWindowHandles();
	List<String>child=new ArrayList<String>(multi);
	for (int i = 0; i < child.size(); i++) {
		String text=child.get(i);
		System.out.println(text);
	driver.switchTo().window(parent);
	}
	String tex=mobil1.getText();
	System.out.println(tex);
	Thread.sleep(3000);
	TakesScreenshot st= (TakesScreenshot)driver;
	File type= st.getScreenshotAs(OutputType.FILE);
	File Loc=new File("C:\\Users\\pratheep.km\\eclipse-workspace\\maven\\target\\Drivers\\Screen Shot\\Flipkart");
	FileUtils.copyFile(type,Loc);
	driver.quit();
	
	File list= new File("C:\\Users\\pratheep.km\\eclipse-workspace\\maven\\target\\Mobiles.xlsx");
    FileOutputStream fl=new FileOutputStream(list);
    XSSFWorkbook work=new XSSFWorkbook();
   XSSFSheet sheet=work.createSheet("Mobiles");
   XSSFRow row= sheet.createRow(0);
   XSSFCell cell=row.createCell(0);
    cell.setCellValue("mobile List");
    
    XSSFRow row1= sheet.createRow(1);
    XSSFCell cell1=row1.createCell(0);
     cell1.setCellValue(tex1);
     
     XSSFRow row2= sheet.createRow(2);
     XSSFCell cell2=row2.createCell(0);
      cell2.setCellValue(tex2);
      
      XSSFRow row3= sheet.createRow(3);
      XSSFCell cell3=row3.createCell(0);
       cell3.setCellValue(tex3);
 work.write(fl);
 work.close();
	}
}

	



