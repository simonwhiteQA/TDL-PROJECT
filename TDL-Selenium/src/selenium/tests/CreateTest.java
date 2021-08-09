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
import org.openqa.selenium.support.ui.Select;

import selenium.pages.CreatePage;


	public class CreateTest {
		
	private WebDriver driver;
		
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
	}

	@Test
	public void createTitle() throws InterruptedException {
		driver.get("http://127.0.0.1:5500/html/Create.html");
		assertEquals("Create", driver.getTitle());
	}

	@Test
	public void createHeader() throws InterruptedException {
		driver.get("http://127.0.0.1:5500/html/Create.html");
		CreatePage createPage = PageFactory.initElements(driver, CreatePage.class);
		createPage.returnHeader();
		assertTrue(createPage.returnHeader().contains("create"));
	}
	
	@Test
	public void createButton() throws InterruptedException {
		driver.get("http://127.0.0.1:5500/html/Create.html");
		String testCat = "test";
		String testDescription = "test";
		
		WebElement categoryInput = this.driver.findElement(By.id("category")); 
		categoryInput.sendKeys(testCat);
		
		Select priority = new Select(driver.findElement(By.id("priority")));
		priority.selectByIndex(2);
		
		WebElement descInput = this.driver.findElement(By.id("description")); 
		descInput.sendKeys(testDescription);
		
		WebElement createBtn = this.driver.findElement(By.id("submit")); 
		createBtn.click();
		
	}

	@After
	public void tearDown() {
		this.driver.quit();
	}

	}
