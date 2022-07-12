package maven;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartWorkout {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pratheep.km\\eclipse-workspace\\maven\\target\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		WebElement move=driver.findElement(By.xpath("//div [text()='Jobs']"));
		WebElement move1=driver.findElement(By.xpath("//div [text()='Jobs']"));
		
		Actions ac= new Actions(driver);
		ac.moveToElement(move).build().perform();
		ac.moveToElement(move1).click().build().perform();
		
		
Set<String>	child=	driver.getWindowHandles();
List<String> multi=new ArrayList<String>(child);

	driver.switchTo().window(multi.get(1));
	
	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(60));
	
	wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[text()='Later']")))).click();
	
	driver.findElement(By.xpath("(//*[@type='text'])[1]")).sendKeys("Manual Testing",Keys.ARROW_DOWN,Keys.ENTER);	
	
	driver.findElement(By.xpath("(//*[@type='text'])[2]")).sendKeys("chennai",Keys.ARROW_DOWN,Keys.ENTER);
	
driver.findElement(By.xpath("//*[text()='Search ']")).click();
	
		Robot ro=new Robot();
		ro.keyPress(KeyEvent.VK_DOWN);
		ro.keyRelease(KeyEvent.VK_DOWN);
		
		ro.keyPress(KeyEvent.VK_DOWN);
		ro.keyRelease(KeyEvent.VK_DOWN);
		
		ro.keyPress(KeyEvent.VK_DOWN);
		ro.keyRelease(KeyEvent.VK_DOWN);
		
		WebElement down =driver.findElement(By.xpath("(//*[contains(text(),'Jobs by Skill')])[2]"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Jobs by Skill')])[2]")));
		JavascriptExecutor js=  (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",down);
		WebElement up=driver.findElement(By.xpath("(//*[text()='Jobs'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(false)",up );
		
		
		TakesScreenshot tk= (TakesScreenshot)driver; 
		File type=tk.getScreenshotAs(OutputType.FILE);	
		File location=new File("C:\\Users\\pratheep.km\\eclipse-workspace\\maven\\target\\FlipKart");	
		FileUtils.copyFile(type, location);
			}
		
		
		
	
}

