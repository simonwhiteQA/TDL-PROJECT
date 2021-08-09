package selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePage {
	
	@FindBy(xpath = "/html/body/div[2]/h1")
	private WebElement header;
	
	// Method to return the header
	public String returnHeader() {
		return this.header.getText().toLowerCase();
	}

}
