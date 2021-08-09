package selenium.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import selenium.pages.HomePage;

public class ReadTest {
	
	private WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
	}

	@Test
	public void readTitle() throws InterruptedException {
		driver.get("http://127.0.0.1:5500/html/read.html");
		assertEquals("Read", driver.getTitle());
	}

	@Test
	public void readHeader() throws InterruptedException {
		driver.get("http://127.0.0.1:5500/html/read.html");
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.returnHeader();
		assertTrue(homePage.returnHeader().contains("read"));
	}
	
	@Test 
	public void readSearch() throws InterruptedException {
		driver.get("http://127.0.0.1:5500/html/read.html");
		String input = "ICT";
		
		WebElement search = this.driver.findElement(By.id("myInput"));
		search.sendKeys(input);
		
		WebElement category = this.driver.findElement(By.id("table"));
		String text = category.getText();
		assertTrue(text.contains("ICT"));
	}

	@After
	public void tearDown() {
		this.driver.quit();
	}

}
