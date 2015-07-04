package com.indiewire.automation.testcases;

import static org.junit.Assert.fail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.indiewire.automation.common.WebDriverWrapper;

public class IWMainPage {
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  private static String baseElement;

	  @Before
	  public void setUp() throws Exception {
	    WebDriverWrapper.loadDrivers();
	    driver = WebDriverWrapper.getWebDriver(WebDriverWrapper.Driver.ChromeDriver);
	    baseUrl = "http://indiewire.com/";
	    baseElement= ".//*[@id='main-nav']/div[@class='nav-parent']/a[@href='/blogs']";
	   //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    System.out.println("Property asdasdasd"+System.getProperty("webdriver.chrome.driver"));
	  }

	  @Test
	  public void testMainPagesLink() throws Exception {
	    driver.get(baseUrl); 
	   
	   // driver.get("http://blogs.indiewire.com/pressplay");
	   // driver.findElement(By.linkText("News")).click();
	    System.out.println("Title "+driver.getTitle());
	  
	    System.out.println("Title "+driver.getCurrentUrl());
	     
	    WebDriverWait wait = new WebDriverWait(driver, 60);
	   // Actions actions = new Actions(driver);
	   // WebElement triggerDropDown = wait.until(ExpectedConditions.elementToBeClickable(By
         //       .xpath(baseElement)));
	   // actions.moveToElement(triggerDropDown).build().perform();
	    //System.out.println("Localtion "+triggerDropDown.getLocation());
	   // WebElement webElement = getWebElement(driver, ".//*[@id='main-nav']/div[5]/div/a[2]");
	    //WebElement webElement = getWebElement(driver, "Thompson on Hollywood");
	    List<WebElement> webElementsList= driver.findElements(By.xpath(baseElement+"/following-sibling::div/a"));
 	    System.out.println("List size "+webElementsList.size());
 	    
 	  
	    for(int index=1;index<=webElementsList.size();index++)
	    {
	    	
	    WebElement webElement = getWebElement(driver, baseElement+"/following-sibling::div/a["+index+"]");
	    //System.out.println("Presence " +isElementPresent(By.xpath(".//*[@id='main-nav']/div[5]/div/a[1]")));
	    	 //System.out.println("Title111 "+driver.getTitle());
	    	 //actions.moveToElement(webElement).build().perform();
	    webElement.click();
	    System.out.println("Title222 "+driver.getTitle());
	    Thread.sleep(15000L);
	    driver.navigate().back();
	    Thread.sleep(5000L);
	    
	    }
	    
	    /*driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    driver.findElement(By.linkText("Criticwire")).click();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    driver.navigate().back();
	    driver.findElement(By.linkText("The Playlist")).click();
	    driver.navigate().back();
	    driver.findElement(By.linkText("Thompson on Hollywood")).click();
	    driver.navigate().back();
	    driver.findElement(By.linkText("Animation Scoop")).click(); */
	    System.out.println("DOne successfully");
	    
	   /* driver.get(baseUrl);
	    String underConsTitle = "Under Construction: Mercury Tours";
        List<WebElement> linkElements = driver.findElements(By.tagName("a"));
        String[] linkTexts = new String[linkElements.size()];
        int i = 0;
 
        //extract the link texts of each link element
        for (WebElement e : linkElements) {
            linkTexts[i] = e.getText();
            i++;
        }
 
        //test each link
        for (String t : linkTexts) {
            driver.findElement(By.linkText(t)).click();
            if (driver.getTitle().equals(underConsTitle)) {
                System.out.println("\"" + t + "\""
                        + " is under construction.");
            } else {
                System.out.println("\"" + t + "\""
                        + " is working.");
            }
            driver.navigate().back();
        }*/
        //driver.quit();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    System.out.println("Executed all links successfully");
	    
	  }
	  
	  public static WebElement getWebElement(WebDriver driver, String text) {
	        WebElement myDynamicElement = null;
	        System.out.println("Inside");
	        try {
//	        	Actions actions = new Actions(driver);
	//            actions.moveToElement(driver.findElement(By
	  //                          .linkText(text))).build().perform();//perform();
	            /*myDynamicElement = (new WebDriverWait(driver, 100))
	                    .until(ExpectedConditions.presenceOfElementLocated(By
	                            .xpath(text)));*/
	        	WebDriverWait wait = new WebDriverWait(driver, 60);
	        	//WebElement triggerDropDown = driver.findElement(By
	        	//                .xpath(".//*[@id='main-nav']/div[5]/a"));
	        	Actions actions = new Actions(driver);
	           // actions.moveToElement(triggerDropDown).build().perform();
//	        	triggerDropDown.click();
	        	WebElement triggerDropDown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(baseElement)));
	        	//System.out.println("sfsdfsdfd"	+        	triggerDropDown.getTagName());
	        	actions.moveToElement(triggerDropDown).build().perform();
	        	 System.out.println("Info triggerDropDown "+triggerDropDown);
	        	//triggerDropDown.
	        	// List<WebElement> webElementsList= driver.findElements(By.xpath(".//*[@id='main-nav']/div[@class='nav-parent']/a[@href='/blogs']/following-sibling::div/a"));
		     	 //   System.out.println("List size "+webElementsList.size());
	        	 myDynamicElement= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(text)));
	        	 actions.moveToElement(triggerDropDown).build().perform();
	        	 
	     	    
	        	 //Thread.sleep(5000L);
	            System.out.println("Info "+myDynamicElement);
	            myDynamicElement= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(text)));
	        	 actions.moveToElement(triggerDropDown).build().perform();
	        	 
	            //Select select = new Select(myDynamicElement);
	            //select.
	            //select.selectByVisibleText("SECURITY");
	            //Actions actions = new Actions(driver);
	           // actions.moveToElement(myDynamicElement).build().perform();
	            //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", myDynamicElement);
	            //assert(myDynamicElement.isEnabled());
	            return myDynamicElement;
	        } catch (Exception ex) {
	        	System.out.println("Exception "+ex.getMessage());
	            return null;
	            
	        }
	    }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }

	}
