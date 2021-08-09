package selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	@FindBy(xpath = "//*[@id=\"jumbo\"]/h1")
	private WebElement header;
	
	// Method to return the header
	public String returnHeader() {
		return this.header.getText().toLowerCase();
	}
	
}
