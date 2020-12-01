
package newpackage;
import java.awt.Dimension;
import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
public class Myclass { 
	
	WebDriver driver;
	
	@BeforeClass
	public void testSetup()
	{
        // declaration and instantiation of objects/variables
    	System.setProperty("webdriver.gecko.driver","/Users/sk/Downloads/geckodriver");
    	driver=new FirefoxDriver();
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	driver.manage().window().maximize();

	}
	
	@BeforeMethod
	public void openBrowser()
	{
		 // launch Fire fox and direct it to the Base URL of Customer Experience Group
		driver.get("https://www.customerexperiencegroup.com/");
		//driver.navigate().refresh();

	}


	  @Test(priority=1,description="This method validates the Customer Experience Group home page is loaded or not")
	    public void PageLoad() {
		  
		  checkPageIsReady();
    	
        String expectedTitle = "Customer Experience Group | Customer Experience Strategy";
        String actualTitle = "";


        // get the actual value of the title
        actualTitle = driver.getTitle();
        System.out.println("Title of Customer Experience Group homepage is: "+actualTitle);

        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
        
        Assert.assertEquals(expectedTitle,actualTitle);
       
    }
	  @Test(priority=2,description="This method validates the Customer Experience Group Menu link are working or not")
	    public void VerifyMenuLinks() {
		  
		  SoftAssert softAssertion= new SoftAssert();
		  //Once page Is ready/loaded, Bellow given steps will be executed.	  
		  //Home Menu
		  WebElement Home = driver.findElement(By.xpath("//*[@id=\"block-system-main-menu\"]/ul/li[1]/a"));
		  System.out.println("Home menu is displaying: "+Home.getText());
		  Assert.assertTrue(Home.isDisplayed());  
		  Actions actions = new Actions(driver);
		  actions.moveToElement(Home).click().perform();
		  softAssertion.assertAll();
		  
		  //Discover Menu
		  WebElement Discover = driver.findElement(By.xpath("//*[@id=\"block-system-main-menu\"]/ul/li[2]/a"));
		  System.out.println("Discover menu is displaying: "+Discover.getText());
		  Actions actions1 = new Actions(driver);
		  Assert.assertTrue(Discover.isDisplayed());  
		  actions1.moveToElement(Discover).click().perform();
		  softAssertion.assertAll();
		  
		  //Make it Happen Menu
		  WebElement MakeItHappen = driver.findElement(By.xpath("//*[@id=\"block-system-main-menu\"]/ul/li[3]/a"));
		  System.out.println("MAKE IT HAPPEN menu is displaying: "+MakeItHappen.getText());
		  Actions actions2 = new Actions(driver);
		  Assert.assertTrue(MakeItHappen.isDisplayed());  
		  actions2.moveToElement(MakeItHappen).click().perform();
		  softAssertion.assertAll();
		  
		  //NEWS & EVENTS Menu
		  WebElement NewsEvent = driver.findElement(By.xpath("//*[@id=\"block-system-main-menu\"]/ul/li[4]/a"));
		  System.out.println("NEWS & EVENTS Menu is displaying: "+NewsEvent.getText());
		  Actions actions3 = new Actions(driver);
		  Assert.assertTrue(NewsEvent.isDisplayed());  
		  actions3.moveToElement(NewsEvent).click().perform();
		  softAssertion.assertAll();

		  //CAREERS Menu
		  WebElement Careers = driver.findElement(By.xpath("//*[@id=\"block-system-main-menu\"]/ul/li[5]/a"));
		  System.out.println("CAREERS Menu is displaying: "+NewsEvent.getText());
		  Actions actions4 = new Actions(driver);
		  Assert.assertTrue(Careers.isDisplayed());  
		  actions4.moveToElement(Careers).click().perform();
		  softAssertion.assertAll();
		  
		  
		//links count on web page
		  java.util.List<WebElement> linksize = driver.findElements(By.className("menu__link"));
	        int linksCount = linksize.size();
	        System.out.println("Total number of links on home page" + linksCount);
	        String[] links = new String[linksCount];
	        System.out.println("Number of links available");
	        for(int i=0;i<linksCount;i++) {
	        	
	            links[i]=linksize.get(i).getAttribute("href");
	            System.out.println(links[i]);}
	        
	        
		  
	  }
	  
	  @Test(priority=3,description="This method validates contact us")
	    public void VerifyContactUs() {
		  
		  driver.findElement(By.xpath("//*[@id=\"block-system-main-menu\"]/ul/li[6]/a")).click();
		  driver.findElement(By.id("edit-submitted-wrapper-name")).sendKeys("saurabh");
		  driver.findElement(By.id("edit-submitted-wrapper-email")).sendKeys("testmaileve@gmail.com");
		  driver.findElement(By.id("edit-submitted-wrapper-phone")).sendKeys("588299518");
		  
	
		  WebElement country = driver.findElement(By.id("edit-submitted-wrapper-countryselect"));
		  country.click();
		  Select mySelect =new Select(driver.findElement(By.id("edit-submitted-wrapper-countryselect")));
		  mySelect.selectByValue("EUROPE");
	
		  driver.findElement(By.id(" edit-submitted-wrapper-company")).sendKeys("abcd");	 
		  driver.findElement(By.id(" edit-submitted-wrapper-position ")).sendKeys("abcd"); 
		  
		  WebElement product = driver.findElement(By.id(" edit-submitted-wrapper-productcatgory "));
		  product.click();
		  Select mySelectt =new Select(driver.findElement(By.id("edit-submitted-wrapper-countryselect")));
		  mySelectt.selectByValue("Automotive");
		  
		  WebElement send = driver.findElement(By.xpath("/html/body/div[3]/div/main/div/div/div/div[1]/div/form/div/div[5]/input"));
		  send.click();
		  
		  
	  }
	  
	  
	  public void checkPageIsReady() {
		  
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  
		  
		  //Initially bellow given if condition will check ready state of page.
		  if (js.executeScript("return document.readyState").toString().equals("complete")){ 
		   System.out.println("Page Is loaded.");
		   return; 
		  } 
		  
		  //This loop will rotate for 25 times to check If page Is ready after every 1 second.
		  //You can replace your value with 25 If you wants to Increase or decrease wait time.
		  for (int i=0; i<50; i++){ 
		   try {
		    Thread.sleep(1000);
		    }catch (InterruptedException e) {} 
		   //To check page ready state.
		   if (js.executeScript("return document.readyState").toString().equals("complete")){ 
		    break; 
		   } }  
		  }
	  
	/*	@Test
		public void softAssert(){
			SoftAssert softAssertion= new SoftAssert();
			System.out.println("softAssert Method Was Started");
			softAssertion.assertTrue(false);
			System.out.println("softAssert Method Was Executed");
			softAssertion.assertAll();
		}
		@Test
		public void hardAssert(){
			System.out.println("hardAssert Method Was Started");
			Assert.assertTrue(false);
			System.out.println("hardAssert Method Was Executed");
		}*/
		
		@AfterMethod
		public void postSignUp()
		{
		System.out.println(driver.getCurrentUrl());

		}
		
		@AfterClass
		public void afterClass()
		{
		driver.quit();
		}

}