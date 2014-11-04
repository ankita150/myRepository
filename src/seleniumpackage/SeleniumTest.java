package seleniumpackage;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

import com.thoughtworks.selenium.webdriven.commands.GetTitle;





public class SeleniumTest {
	
	
private WebDriver driver = new FirefoxDriver();
private DataFormatter formatter;
private HSSFCell cell;
private HSSFWorkbook workbook;

@BeforeTest
public void setUp(){
System.out.print("flow has started");
driver.manage().window().maximize();
}

//@Parameters("username")
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

@Test(enabled = false)
public void javascriptAlert() throws Exception
{
driver.get("http://www.google.com/");
JavascriptExecutor js = (JavascriptExecutor)driver;
js.executeScript("alert('Welcome')");
Thread.sleep(10000);
Alert alert = driver.switchTo().alert();
System.out.println(alert.getText());
alert.accept();
}

@Test(enabled = false)
public void irctcFlights() throws Exception
{
driver.get("https://www.irctc.co.in");
driver.findElement(By.xpath("//a[text() = 'Flights']")).click();
driver.manage().window().maximize();
Set<String>  allwin = driver.getWindowHandles();
for(String eachwind: allwin)
{
	driver.switchTo().window(eachwind);
}
driver.manage().window().maximize();
Thread.sleep(10000);
driver.findElement(By.xpath("//input[@id='origin']")).sendKeys("delhi");
Thread.sleep(1000);
driver.findElement(By.xpath("//a[text() = 'New Delhi, DEL']")).click();
driver.findElement(By.id("destination")).sendKeys("jai");
Thread.sleep(1000);
driver.findElement(By.xpath("//a[text() = 'Jaipur, JAI']")).click();
driver.findElement(By.xpath("//*[text() = 'Departure']/following::div[@class = 'whencontainerfld']/input[@id = 'departDateInt']/following::img[3]")).click();
driver.findElement(By.linkText("Next")).click(); //click next month
driver.findElement(By.linkText("16")).click();
driver.findElement(By.xpath("//*[@id='showdometic']/div[@class = 'srchbtn']")).click();
List <WebElement> mylist = driver.findElements(By.xpath("//table[@class = 'flightcont']"));
mylist.size();
driver.findElement(By.xpath("//div[@id = 'flightListResult']/div[1]")).getText();
File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(srcFile,new File(System.getProperty("user.dir")+"\\selenium\\screenshot\\pic1.png"));
System.out.println(System.getProperty("user.dir")+"\\selenium\\screenshot\\pic1.png");
}




@Test(enabled = false)
public void irctcFlightsJaipur() throws Exception
{
driver.get("https://www.irctc.co.in");
driver.findElement(By.xpath("//a[text() = 'Flights']")).click();
driver.manage().window().maximize();
String parentWindow = driver.getWindowHandle();
Set<String>  allwin = driver.getWindowHandles();
for(String eachwind: allwin)
{
	driver.switchTo().window(eachwind);
}
driver.getTitle();
System.out.println(driver.getTitle());
driver.close();
driver.switchTo().window(parentWindow);
System.out.println("*********"+ driver.getTitle());
driver.findElement(By.xpath("//input[@id = 'loginbutton']")).click();
driver.findElement(By.xpath("//span[@class = 'close']")).click();
 WebElement frameName = driver.findElement(By.xpath("//div[@class = 'adds']/following::div[@id = 'banner3']/iframe"));
driver.switchTo().frame(frameName);
driver.findElement(By.xpath("//img[@alt = 'Maharajas Express']")).click();
Set<String>  maharajawin = driver.getWindowHandles();
for(String eachwind: maharajawin)
{
	driver.switchTo().window(eachwind);
}
Actions action = new Actions(driver);
WebElement we = driver.findElement(By.xpath("//ul[@class = 'menuH']/li[3]/a"));
action.moveToElement(we).build().perform();
WebElement gems = driver.findElement(By.xpath("//ul[@class = 'menuH']/li[3]/descendant::ul[1]/li[1]/a"));
action.moveToElement(gems).build().perform();
WebElement jaipur = driver.findElement(By.xpath("//ul[@class = 'menuH']/li[3]//a[contains(@href,'gems-of-india')]/following::li[4]/a[text() = 'Jaipur']"));
jaipur.click();
driver.findElement(By.xpath("//a[text() = 'Places Of Interest']")).click();
List <WebElement> mylist = driver.findElements(By.xpath("//*[@id='view2']/h3"));
for(WebElement eachwind: mylist)
{
System.out.println(eachwind.getText());
}
}



@Test(enabled = true)
public void GspannValidation() throws Exception
{
	Excel excel = new Excel();
	excel.setExcel("D:\\excel.xls", "Sheet1");
	driver.get("http://mail.gspann.com/");
	WebElement emailBox = driver.findElement(By.id("cred_userid_inputtext"));
	WebElement passwordBox = driver.findElement(By.name("passwd"));
	
	

		for (int i=1; i < 4; i++){
				String un = excel.getcellvalue(i,1);
				String ps = excel.getcellvalue(i,2);
				emailBox.sendKeys(un);
		        passwordBox.sendKeys(ps);
		        driver.findElement(By.id("cred_sign_in_button")).click();
		        emailBox.clear();
		        passwordBox.clear();

		}
}



@Test(enabled = true)
public void macysValidation() throws Exception{
	Excel excel = new Excel();
	excel.setExcel(System.getProperty("user.dir")+"\\selenium\\excel.xls", "Sheet2");
	driver.get("https://www.macys.com/account/profile");
	WebElement firstname = driver.findElement(By.id("firstName"));
	WebElement lastname = driver.findElement(By.id("lastName")); 
	WebElement mailingadd1 = driver.findElement(By.id("addressLine1")); 
	Select state = new Select(driver.findElement(By.id("state")));
	WebElement city = driver.findElement(By.id("city"));  
	WebElement zipcode = driver.findElement(By.id("zipcode")); 
	WebElement emailAdd = driver.findElement(By.id("email"));
	WebElement passwrd = driver.findElement(By.id("password"));
	WebElement validatePasswrd = driver.findElement(By.id("confirmPassword"));
	WebElement verifyEmail = driver.findElement(By.id("createConfirmEmail"));
	Select dateValue = new Select(driver.findElement(By.id("date")));
	Select mnthValue = new Select(driver.findElement(By.id("month")));
	Select yearValue = new Select(driver.findElement(By.id("year")));
	Select gender = new Select(driver.findElement(By.id("gender")));
	Select security = new Select(driver.findElement(By.id("SecurityQna")));
	WebElement securityans = driver.findElement(By.id("securityAns"));
	
	int noOfRows = excel.totalRows();
		for (int rows=1; rows <= noOfRows; rows++){
			
				String frst = excel.getcellvalue(rows,1);
				if(!frst.isEmpty()){
					
					firstname.sendKeys(frst);
				}
				String last = excel.getcellvalue(rows,2);
				if(!last.isEmpty()){
					lastname.sendKeys(last);
				}
					
				String mailing = excel.getcellvalue(rows,3);
				if(!mailing.isEmpty()){
					mailingadd1.sendKeys(mailing);
				}
				String cityname = excel.getcellvalue(rows,4);
				if(!cityname.isEmpty()){
					city.sendKeys(cityname);
				}
				String statename = excel.getcellvalue(rows,5);
				
				
				
				
				if(!statename.isEmpty()){
				
				System.out.println("Before Loop");
				System.out.println("********************************"+statename);
				if(statename.matches(".*[0-9].*")){
					System.out.println("In Loop");
					int length = statename.length();
					int position = 0;
					if(length == 3){
					position = Integer.parseInt(statename.substring(0,1));
					position = position+1;
					System.out.println("=========="+position);
					}
					else{
						position = Integer.parseInt(statename.substring(0,2));
						position = position+1;
					}
					System.out.println("Clicking");
					Thread.sleep(2000);
					state.selectByVisibleText((driver.findElement(By.xpath("//select[@id = 'state']/option["+position+"]")).getText()));
					System.out.println(driver.findElement(By.xpath("//select[@id = 'state']/option["+position+"]")).getText());
				}
				else{
					state.selectByVisibleText(statename);
				}
				}
				String zipcodeid = excel.getcellvalue(rows,6);
				if(!zipcodeid.isEmpty()){
				
				zipcode.sendKeys(zipcodeid);
				}
				
				String columnDate = excel.getcellvalue(rows,7);
				if(!columnDate.isEmpty()){
					System.out.println(columnDate);
					String date= columnDate.substring(0,2);
					String month = columnDate.substring(3,5);
					String year = columnDate.substring(6,10);
					String monthName = dateConverter(month);
					System.out.println(date+"      "+monthName+"      "+year);
					mnthValue.selectByVisibleText(monthName);
					yearValue.selectByVisibleText(year);
					dateValue.selectByValue(date);
					
				}
				
				String genderType = excel.getcellvalue(rows,8);
				if(!genderType.isEmpty()){
					gender.selectByVisibleText(genderType);
				}
				
				String emailAddrow = excel.getcellvalue(rows,9);
				if(!emailAddrow.isEmpty()){
					emailAdd.sendKeys(emailAddrow);
				}
				
				String verifyemailvalue = excel.getcellvalue(rows, 10);
				if(!verifyemailvalue.isEmpty()){
					verifyEmail.sendKeys(verifyemailvalue);
					}
				
				String passwrdvalue = excel.getcellvalue(rows,11);
				if(!passwrdvalue.isEmpty()){
					passwrd.sendKeys(passwrdvalue);
				}
				
				String verifyPasswrd = excel.getcellvalue(rows,12);
				if(!verifyPasswrd.isEmpty()){
					validatePasswrd.sendKeys(verifyPasswrd);
				}
				
				String securityquestion = excel.getcellvalue(rows,13);
				if(!securityquestion.isEmpty()){
					security.selectByIndex(10);	
				}
				
				String securityanswer = excel.getcellvalue(rows,14);
				if(!securityanswer.isEmpty()){
					securityans.sendKeys(securityanswer);	
				}
				Thread.sleep(2000);
				driver.findElement(By.id("createProfileBtn")).click();
				String screenshots = excel.getcellvalue(rows,15);
				if(!screenshots.isEmpty()){
					File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					  FileUtils.copyFile(srcFile,new File(System.getProperty("user.dir")+"\\selenium\\screenshot\\"+frst+".png"));
				
				}
				
				firstname.clear();
				lastname.clear();
				mailingadd1.clear();
				city.clear();
				zipcode.clear();
				emailAdd.clear();
				passwrd.clear();
				validatePasswrd.clear();
				verifyEmail.clear();
				securityans.clear();
				
		}
		}



@Test
public void irctc() throws Exception
{
	Excel excel = new Excel();
	excel.setExcel("D:\\excel.xls", "Sheet3");
//	for(int i=1;i<=3;i++){
//		WebDriver driver = new FirefoxDriver();
	driver.get("https://www.irctc.co.in");
	driver.findElement(By.xpath("//a[text() = 'Flights']")).click();
	driver.manage().window().maximize();
	Set<String>  allwin = driver.getWindowHandles();
	for(String eachwind: allwin)
	{
		driver.switchTo().window(eachwind);
	}
	Thread.sleep(10000);
	WebElement origin = driver.findElement(By.xpath("//input[@id='origin']"));
	WebElement destination = driver.findElement(By.xpath("//input[@id='destination']"));
	int noOfRows = excel.totalRows();
	for (int rows=2; rows <= noOfRows; rows++){
		System.out.println("**************"+rows);
			boolean check = excel.getcellvalue(rows,1).isEmpty();
			if(!check){
			
			String to = excel.getcellvalue(rows,1);
			destination.sendKeys(to);
			Thread.sleep(10000);
			driver.findElement(By.xpath("//li[@class = 'ui-menu-item'][1]/a")).click();
			}
			boolean secondCheck = excel.getcellvalue(rows,2).isEmpty();
			if(!secondCheck)
			{
			String from = excel.getcellvalue(rows,2);
			origin.sendKeys(from);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//li[@class = 'ui-menu-item'][1]/a")).click();
			
			}
			
			boolean thirdColumnCheck = excel.getcellvalue(rows,3).isEmpty();
			if(!thirdColumnCheck)
			{driver.findElement(By.xpath("//*[text() = 'Departure']/following::div[@class = 'whencontainerfld']/input[@id = 'departDateInt']/following::img[3]")).click();
				String date = excel.getcellvalue(rows,3);
				String onlyDate = date.substring(0,2);
				String month = date.substring(3,5);
				String year = date.substring(6, 8);
				String monthValue = dateConverter(month);
				System.out.println(monthValue);
				String calender1 = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/div/div/span[1]")).getText();
				while(!calender1.equalsIgnoreCase(monthValue))
				{	System.out.println("====================="+calender1);
					driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a/span")).click();
					calender1 = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/div/div/span[1]")).getText();
				}
				driver.findElement(By.xpath("//td[@data-year = '20"+year+"' and @data-month = '"+month+"']/a[text() = '"+onlyDate+"']")).click();
				driver.findElement(By.xpath("//*[@id='showdometic']/div[@class = 'srchbtn']")).click();
				Thread.sleep(1000);
				driver.get("http://www.air.irctc.co.in/");
//				driver.close();
					
				}
	}
				
			
			}

public String dateConverter(String month)
{
	String monthValue ="";
	int mon = Integer.parseInt(month);
	switch (mon){
	
	case 1:
    	monthValue =  "January";
       break;
    case 2:
    	monthValue =  "February";
       break;
    case 3:
       monthValue =  "March";
       break;
    case 4:
    	monthValue =  "April";
    	break;
    case 5:
    	monthValue =  "May";
    	break;
    case 6:
    	monthValue =  "June";
    	break;
    case 7:
    	monthValue =  "July";
    	break;
    case 8:
    	monthValue =  "August";
    	break;
    case 9:
    	monthValue =  "September";
    	break;
    case 10:
    	monthValue =  "October";
    	break;
    case 11:
    	monthValue =  "November";
    	break;
    case 12:
    	monthValue =  "December";
    	break;
    
	}
	
	return monthValue;

}

	

@AfterTest
public void Quit(){
System.out.print("flow has stopped");
driver.quit();
}
}


 
