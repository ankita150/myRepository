package seleniumpackage;

import java.io.File;
import java.io.IOException;
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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;



public class Assignmnent {
//	private WebDriver driver = new FirefoxDriver();

//	WebDriver driver;
@BeforeTest
public void setUp(){
//	
//System.out.print("flow has started");
//driver.manage().window().maximize();
}



//@Test(enabled = false)
//public void MacysTestRandom() throws Exception
//{
//	driver.get("http://www.macys.com//");
//	driver.findElement(By.id("closeButton")).click();
//	Thread.sleep(10000);
//	Random tab = new Random();
//	List <WebElement> countElements = driver.findElements(By.xpath("//div[@id = 'globalMastheadCategoryMenu']/ul/li"));
//    int countTabs = countElements.size();
//    int num = 1+tab.nextInt(countTabs-1);
//	String tabName;
//	WebElement tabBtn = driver.findElement(By.xpath("//div[@id = 'globalMastheadCategoryMenu']/ul/li["+num+"]"));
//	System.out.println(tabBtn);
//	tabName = tabBtn.getText();
//	System.out.println(tabName);
//	Actions action = new Actions(driver);
//	action.moveToElement(tabBtn).build().perform();;
//	Random category = new Random();
//	List <WebElement> countProducts = driver.findElements(By.xpath("//div[@id='globalMastheadFlyout']/div[@class='subnav flyout-on']//ul/li/a"));
//    int productsSize = countProducts.size();
//    System.out.println("+++++++++++++++++++"+productsSize);
//	int num1 = 1+category.nextInt(productsSize);
//	String catName = countProducts.get(num1).getText();
//	System.out.println(catName);
//	
//	WebElement tabproduct = driver.findElement(By.xpath("//div[@id='globalMastheadFlyout']/div[@class='subnav flyout-on']//ul/li/a[text() = '"+catName+"']"));
//	tabproduct.click();
//	try{
//	WebElement openBrandTab = driver.findElement(By.id("BRAND"));
//	openBrandTab.click();
//	driver.findElement(By.xpath("//div[@class = 'brandContainer']//ul[@id = 'featuredBrands']/li[1]/span[1]")).click();
//	}
//	catch (Exception e) {
//		WebElement openBrandTab = driver.findElement(By.id("BRAND"));
//		openBrandTab.click();
//		driver.findElement(By.xpath("//div[@class = 'brandContainer']//ul[@id = 'featuredBrands']/li[1]/span[1]")).click();
//		
//	}
//	
//    String expected_count = driver.findElement(By.xpath("//ul[@id = 'featuredBrands']//li[1]/span[contains(@id,'count_BRAND')]")).getText();
//    System.out.println("expected Count==============="+expected_count);
//    WebElement itemsNumber = driver.findElement(By.xpath("//*[@id='productCount']"));
//    String itemCount = itemsNumber.getText();
//    System.out.println("Item List ==========="+itemCount);
//    Thread.sleep(10000);
//    String itemCountCheck = "("+itemCount+")"; 
//    Assert.assertEquals(itemCountCheck,expected_count);
//}
//
//
//@Test
//public void CreateProfile() throws Exception
//{
//	driver.get("https://www.macys.com/account/profile");
//	driver.findElement(By.xpath("//button[@id = 'createProfileBtn']")).click();
//	File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//	FileUtils.copyFile(srcFile,new File(System.getProperty("user.dir")+"\\ScreenshotFile\\File\\screenshot1.png"));
//	System.out.println(System.getProperty("user.dir")+"\\selenium\\File\\screenshot1.png");
//	driver.findElement(By.id("firstName")).sendKeys("ankita");
//	driver.findElement(By.id("lastName")).sendKeys("chopra");
//	driver.findElement(By.id("addressLine1")).sendKeys("main market");
//	driver.findElement(By.id("city")).sendKeys("karnal");
//	Select dropdown = new Select(driver.findElement(By.id("state")));
//	dropdown.selectByValue("IN");
//	driver.findElement(By.id("zipcode")).sendKeys("132001");
//	Select month = new Select(driver.findElement(By.id("month")));
//	month.selectByValue("02");
//	Select date = new Select(driver.findElement(By.id("date")));
//	date.selectByValue("28");
//	Select year = new Select(driver.findElement(By.id("year")));
//	year.selectByValue("1990");
//	Select gender = new Select(driver.findElement(By.id("gender")));
//	gender.selectByValue("F");
//	driver.findElement(By.id("email")).sendKeys("ankita.chopra8@gmail.com");
//	driver.findElement(By.id("createConfirmEmail")).sendKeys("ankita.chopra8@gmail.com");
//	driver.findElement(By.id("password")).sendKeys("ankitachopra");
//	driver.findElement(By.id("confirmPassword")).sendKeys("ankitachopra");
//	Select securityQuestion = new Select(driver.findElement(By.id("SecurityQna")));
//	securityQuestion.selectByValue("1");
//	driver.findElement(By.id("securityAns")).sendKeys("pokemon");
//}
//
//@Test
//public void MacysTestPagination() throws Exception
//{
//	driver.get("http://www.macys.com//");
//	driver.findElement(By.id("closeButton")).click();
//	Thread.sleep(10000);
//	Random tab = new Random();
//	List <WebElement> countElements = driver.findElements(By.xpath("//div[@id = 'globalMastheadCategoryMenu']/ul/li"));
//    int countTabs = countElements.size();
//    System.out.println("**********" +countTabs);
//    int num = 1+tab.nextInt(countTabs-1);
//	String tabName;
//		WebElement tabBtn = driver.findElement(By.xpath("//div[@id = 'globalMastheadCategoryMenu']/ul/li["+num+"]"));
//		System.out.println(tabBtn);
//		tabName = tabBtn.getText();
//		System.out.println(tabName);
//		Actions action = new Actions(driver);
//		action.moveToElement(tabBtn).build().perform();;
//	Random category = new Random();
//	List <WebElement> countProducts = driver.findElements(By.xpath("//div[@id='globalMastheadFlyout']/div[@class='subnav flyout-on']//ul/li/a"));
//    int productsSize = countProducts.size();
//	int num1 = 1+category.nextInt(productsSize-1);
//	String catName = countProducts.get(num1).getText();
//	System.out.println(catName);
//	WebElement tabproduct = driver.findElement(By.xpath("//div[@id='globalMastheadFlyout']/div[@class='subnav flyout-on']//ul/li/a[text() = '"+catName+"']"));
//	tabproduct.click();
//	String paginateText = driver.findElement(By.xpath("//div[@id='paginateTop']/span[1]/following-sibling::a[1]")).getText();
//	Assert.assertEquals("1",paginateText);
//	WebElement paginateBtnTwo = driver.findElement(By.xpath("//div[@id='paginateTop']/span[1]/following-sibling::a[2]"));
//	paginateBtnTwo.click();
//	String paginateText2 = driver.findElement(By.xpath("//div[@id='paginateTop']/span[@class = 'currentPage']")).getText();
//	Assert.assertEquals("2",paginateText2);
//}


@Test(enabled = true)
public void excelFetch() throws IOException{
	Excel excel = new Excel();	
	excel.setExcel("D:\\excel.xls", "Sheet1");
	System.out.println(excel.getcellvalue(1,0));
	String name = excel.getcellvalue(3,1);
	Assert.assertEquals("sonam", name);
}


	
@AfterTest
public void Quit(){
System.out.print("flow has stopped");
//driver.quit();
}

}

