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

import selenium.pages.CreatePage;
import selenium.pages.UpdatePage;

public class UpdateTest {

	private WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
	}

	@Test
	public void updateTitle() throws InterruptedException {
		driver.get("http://127.0.0.1:5500/html/update.html");
		assertEquals("Update", driver.getTitle());
	}

	@Test
	public void updateHeader() throws InterruptedException {
		driver.get("http://127.0.0.1:5500/html/update.html");
		UpdatePage updatePage = PageFactory.initElements(driver, UpdatePage.class);
		updatePage.returnHeader();
		assertTrue(updatePage.returnHeader().contains("update"));
	}
	
	@Test
	public void updateNav() throws InterruptedException {
		driver.get("http://127.0.0.1:5500/html/update.html");
		
		//test create link
		WebElement createLink = this.driver.findElement(By.xpath("/html/body/div[1]/nav/div/div/ul/li[1]"));
		createLink.click();
		CreatePage createPage = PageFactory.initElements(driver, CreatePage.class);
		createPage.returnHeader();
		assertTrue(createPage.returnHeader().contains("create"));
		
		//return to update page
		WebElement updateLink = this.driver.findElement(By.xpath("/html/body/div[1]/nav/div/div/ul/li[3]"));
		updateLink.click();
		UpdatePage updatePage = PageFactory.initElements(driver, UpdatePage.class);
		updatePage.returnHeader();
		assertTrue(updatePage.returnHeader().contains("update"));
		
		
	}

	@After
	public void tearDown() {
		this.driver.quit();
	}
	
}
