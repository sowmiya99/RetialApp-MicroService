package Test;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Page.homePage;
import Page.loginPage;
import Page.orderReportPage;

public class RegressionTestIT {
  @Test
  public void searchTest() {
	  
	  System.setProperty("webdriver.chrome.driver", "/bin/chromedriver");
	  WebDriver	driver = new ChromeDriver();
	  driver.get("http://54.226.235.226:8085/");
	  Assert.assertEquals("Retail Application Demo", driver.getTitle());
	  
	  loginPage loginpage = new loginPage(driver);
	  loginpage.validLogin().validSearch().validCheckout().proceedToCheckout().fillAddress().confirmOrder().makePayments();
	  orderReportPage reportPage = new orderReportPage(driver);
	  reportPage.orderConfirmation();
	  loginpage =  reportPage.logout();
	  driver.close();
  }
}
