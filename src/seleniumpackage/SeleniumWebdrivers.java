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
import org.testng.annotations.AfterTest;





public class SeleniumWebdrivers {

	
//private WebDriver driver = new FirefoxDriver();

	WebDriver driver;
@BeforeTest
@Parameters("browser")
public void setUp(String browsers ){
	if(browsers.equalsIgnoreCase("chrome"))
	{
		System.out.println(System.getProperty("user.dir"));
System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\exefiles\\chromedriver.exe" );
System.out.println( System.getProperty("user.dir")+"\\exefiles\\chromedriver.exe" );
driver = new ChromeDriver();

	}else
	{
if(browsers.equalsIgnoreCase("ie"))
{
	 System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\exefiles\\IEDriverServer.exe" );
     System.out.println( System.getProperty("user.dir")+"\\exefiles\\IEDriverServer.exe" );
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
	
	driver.get("http://www.gmail.com/");
	driver.findElement(By.name("Email")).sendKeys("ankitachopra"); 
	driver.findElement(By.name("Passwd")).sendKeys("ankitachopra"); 
	driver.findElement(By.name("signIn")).click(); 
	driver.manage().window().maximize();
	String text = driver.findElement(By.id("errormsg_0_Passwd")).getText();
	Assert.assertEquals(text,"The email or password you entered is incorrect. ?");
}


@Test(enabled = false)
public void MacysUrl() throws Exception
{
	driver.get("https://www.macys.com");
	boolean url = driver.getCurrentUrl().contains("macys.com");
	System.out.println(url);
	Assert.assertTrue(url);
}

@Test
public void verifyLogo(String browsers) throws Exception
{
	driver.get("https://www.macys.com");
	Assert.assertTrue(isElementPresent(By.xpath("//div[@id='macysHomePageLogo']")));
	}


@Test(enabled = false)
@Parameters("browser")
public void Screenshots(String browsers) throws Exception
{
	driver.get("https://www.macys.com/account/profile");
	driver.findElement(By.xpath("//button[@id = 'createProfileBtn']")).click();
	System.out.println("REACHED BROWSER@@@@@@@@@@@");
	File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
if(browsers.equalsIgnoreCase("ie"))
{

FileUtils.copyFile(srcFile, new File("D:/file/ie.png"));
}
else
{
	if(browsers.equalsIgnoreCase("chrome"))
	{
		
		FileUtils.copyFile(srcFile, new File("D:/file/chrome.png"));
	}
	else
	{
	
	FileUtils.copyFile(srcFile, new File("D:/file/firefox.png"));
	}
}
}





@Test(enabled = false)
public void GmailTesting() throws Exception
{
	driver.get("http://www.gmail.com/");
	driver.findElement(By.name("Email")).sendKeys("ankita.chopra888"); 
	driver.findElement(By.name("Passwd")).sendKeys("yshuditellu"); 
	driver.findElement(By.name("signIn")).click(); 
	driver.manage().window().maximize();
	Thread.sleep(20000);
	driver.findElement(By.xpath("//div[@class = 'Cp']//table/descendant::tbody[1]/tr[2]/td[2]/div/div")).click();
	driver.findElement(By.xpath("//div[@aria-label = 'Delete']/div[@class = 'asa']/div")).click();
	String verify_message = driver.findElement(By.xpath("//div[@class = 'vh']")).getText();
	Assert.assertEquals(verify_message,"The conversation has been moved to the Trash.  Learn more  Undo");
	driver.findElement(By.id("link_undo")).click();
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
 

