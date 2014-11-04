package seleniumpackage;



import java.io.File;
import java.util.List;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;




public class Webelements {

	
private WebDriver driver = new FirefoxDriver();

//	WebDriver driver;
@BeforeTest
@Parameters("browser")
public void setUp(String browsers ){
	if(browsers.equalsIgnoreCase("chrome"))
	{
System.setProperty("webdriver.chrome.driver", "D://Chrome//chromedriver.exe");
driver = new ChromeDriver();

	}else
	{
if(browsers.equalsIgnoreCase("ie"))
{
	System.setProperty("webdriver.ie.driver", "D://Chrome//IEDriverServer.exe");
	driver = new InternetExplorerDriver();
}
else
{
	 driver = new FirefoxDriver();
}
	
	}	
System.out.print("flow has started");
}


@Test(enabled = false)
public void GmailTest() throws Exception
{
	driver.get("http://www.google.com/");
	List <WebElement> mylist = driver.findElements(By.xpath("//div[@id = 'als']/a"));
	WebElement input1 = mylist.get(4);
	driver.findElement(By.xpath("//input[@id ='gbqfq']")).sendKeys(input1.getText());
	Thread.sleep(10000);
	driver.findElement(By.xpath("//button[@id='gbqfb']")).click();
}

@Test(enabled = false)
public void Javascript() throws Exception
{
driver.get("http://www.google.com/");
JavascriptExecutor js = (JavascriptExecutor)driver;
js.executeScript("alert(document.getElementsByTagName('input').length)");
Thread.sleep(1000);
}


@Test
public void javascriptAlert() throws Exception
{
driver.get("http://www.google.com/");
}


@Test(enabled = false)
public void Screenshots() throws Exception
{
driver.get("http://www.google.com/");
List <WebElement> mylist = driver.findElements(By.xpath("//div[@id = 'als']/a"));
WebElement input1 = mylist.get(4);
driver.findElement(By.xpath("//input[@id ='gbqfq']")).sendKeys(input1.getText());
Thread.sleep(10000);
driver.findElement(By.xpath("//button[@id='gbqfb']")).click();
File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(srcFile, new File("D:/file/account_disabled.png"));
}


@Test(enabled = false)
public void linkPresent()
{
	driver.get("http://www.google.com/");
	Actions action = new Actions(driver);
//	JavascriptExecutor jse = (JavascriptExecutor) driver;
//	jse.executeScript("document.getElementById('gbqfq').focus();");
	action.moveToElement(driver.findElement(By.xpath("//input[@id = 'gbqfq']"))).clickAndHold().build().perform();
    action.keyDown(Keys.SHIFT).moveToElement(driver.findElement(By.xpath("//input[@id = 'gbqfq']"))).click().sendKeys("selenium").keyUp(Keys.SHIFT).build().perform();
	driver.findElement(By.xpath("//button[@id = 'gbqfb']/span")).click();
	Assert.assertTrue(isElementPresent(By.xpath("//a[text() = 'Selenium - Web Browser Automation']")));
}

boolean isElementPresent(By locator )
{
	try{
		driver.findElement(locator);
		return true;
	}
	catch(NoSuchElementException e){
		return false;
	}
}




@AfterTest
public void Quit(){
System.out.print("flow has stopped");
driver.quit();
}

}
 


