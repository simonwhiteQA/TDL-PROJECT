package selenium.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import selenium.pages.DeletePage;

public class DeleteTest {
	
	private WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
	}

	@Test
	public void deleteTitle() throws InterruptedException {
		driver.get("http://127.0.0.1:5500/html/delete.html");
		assertEquals("Delete", driver.getTitle());
	}

	@Test
	public void deleteHeader() throws InterruptedException {
		driver.get("http://127.0.0.1:5500/html/delete.html");
		DeletePage deletePage = PageFactory.initElements(driver, DeletePage.class);
		deletePage.returnHeader();
		assertTrue(deletePage.returnHeader().contains("delete"));
	}

	@After
	public void tearDown() {
		this.driver.quit();
	}

}
