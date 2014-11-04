package seleniumpackage;

import java.io.File;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;



public class assignmnent1 {
	private WebDriver driver = new FirefoxDriver();

//	WebDriver driver;
@BeforeTest
public void setUp(){
	
System.out.print("flow has started");
driver.manage().window().maximize();
}


@Test
public void KohlsTest() throws Exception
{
	driver.get("http://www.kohls.com/");
	driver.findElement(By.xpath("//a[@href = 'http://www.kohls.com/myaccount/kohls_login.jsp']")).click();
	driver.findElement(By.name("txtemail_sign")).sendKeys("ankitachopra");
	driver.findElement(By.name("txtpassword_sign")).sendKeys("ankitachopra");
	File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(srcFile, new File("D:/file/account_disabled.png"));
}


@Test
public void KohlsTestMen() throws Exception
{
	driver.get("http://www.kohls.com/");
	Actions action1 = new Actions(driver);
	WebElement men = driver.findElement(By.xpath("//a[text() = 'Men']"));
    action1.moveToElement(men).build().perform();
    driver.findElement(By.xpath("//a[contains(@href,'/catalog/mens-levis-jeans-bottoms')]/span[1]")).click();
    List <WebElement> mylist = driver.findElements(By.xpath("//a[@class = 'showQuickViewPan image-holder-s']"));
    int countjeans = mylist.size();
    String expected_count = driver.findElement(By.xpath("//a[contains(@href,'/catalog/mens-levis-jeans-bottoms')]/descendant::span[@class = 'number-products']")).getText();
    Assert.assertEquals(countjeans,expected_count);
}


@Test
public void KohlsTestRandom() throws Exception
{
	driver.get("http://www.kohls.com/");
	Random rand = new Random();
	int Count = driver.findElements(By.xpath("//ul[@id='navigation']/li")).size();
	int num = rand.nextInt(Count);
	if (num>0){
		WebElement tabbtn = driver.findElement(By.xpath("//ul[@id='navigation']/li["+num+"]"));
		tabbtn.click();
	}
	int Count1 = driver.findElements(By.xpath("//ul[@id='navigation']/li")).size();
	int num1 = rand.nextInt(Count);
	if (num1>0){
		WebElement tabproduct = driver.findElement(By.xpath("//ul[@id='navigation']/li["+num1+"]"));
		tabproduct.click();
	}
//	Actions build = new Actions(driver);
}
	
@AfterTest
public void Quit(){
System.out.print("flow has stopped");
driver.quit();
}

}
