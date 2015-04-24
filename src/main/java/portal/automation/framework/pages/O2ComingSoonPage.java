package portal.automation.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import portal.automation.framework.core.BasePage;

public class O2ComingSoonPage extends BasePage {
	
	WebDriver driver;
	@FindBy(css="p.product-cta")
	WebElement lnkGetUpdates;

	public O2ComingSoonPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void clickGetUpdates() {		
		lnkGetUpdates.click();		
	}

}
