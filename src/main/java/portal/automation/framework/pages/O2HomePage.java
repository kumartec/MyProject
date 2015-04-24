package portal.automation.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import portal.automation.framework.core.BasePage;

public class O2HomePage extends BasePage {

	WebDriver driver;
	@FindBy(id="pn1")
	WebElement shopLink;
	@FindBy(linkText="Coming soon")
	WebElement lnkComingSoon;
	
	public O2HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}
	
	public void moveToShopLink() {
		Actions action = new Actions(driver);
		action.moveToElement(shopLink).build().perform();
		lnkComingSoon.click();		
	}
	
}
