package maven;

import java.security.Key;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class wink {

	public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\pratheep.km\\eclipse-workspace\\maven\\target\\Drivers\\chromedriver.exe");	
	WebDriver driver=new ChromeDriver();
	driver.get("https://wynk.in/music?gclid=Cj0KCQjw0oCDBhCPARIsAII3C_H1Jkj96l4KU7QQ78yZT2vIVfWk0DGYxk66JeRvwwsHWRtcT1z1PZcaAuvgEALw_wcB");
	driver.manage().window().maximize();
WebElement sh=driver.findElement(By.xpath("//a[text()='Search']"));
sh.click();

driver.findElement(By.xpath("//input[@type='search']")).sendKeys("SidSriRam",Keys.ENTER);
Thread.sleep(3000);
WebElement alb=driver.findElement(By.xpath("//button[text()='Albums']"));
	Actions ac=new  Actions(driver);
	ac.moveToElement(alb).click().build().perform();
	Thread.sleep(3000);
driver.findElement(By.xpath("//*[contains(text(),'Sid Sriram Swag')]")).click();	


	
	}
	}


