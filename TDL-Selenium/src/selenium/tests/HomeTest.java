package selenium.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import selenium.pages.HomePage;


public class HomeTest {
	
private WebDriver driver;
	
@Before
public void setup() {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	this.driver = new ChromeDriver();
	this.driver.manage().window().maximize();
}

@Test
public void homeTitle() throws InterruptedException {
	driver.get("http://127.0.0.1:5500/html/index.html");
	assertEquals("Homepage", driver.getTitle());
}

@Test
public void homeHeader() throws InterruptedException {
	driver.get("http://127.0.0.1:5500/html/index.html");
	HomePage homePage = PageFactory.initElements(driver, HomePage.class);
	homePage.returnHeader();
	assertTrue(homePage.returnHeader().contains("homepage"));
}

@After
public void tearDown() {
	this.driver.quit();
}

}
