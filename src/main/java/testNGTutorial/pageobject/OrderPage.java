package testNGTutorial.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testNGTutorial.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent{
	
	WebDriver driver;
	public OrderPage(WebDriver driver) {
       
	  super(driver);	
      this.driver=driver;
      PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="tr td:nth-child(3)")
	private List<WebElement> productNames;
	
	
    @FindBy(css="[class*='subtotal'] button")
    WebElement checkoutEle;
    
	

	public Boolean VerifyOrderDisplay(String productName)
	{
		boolean match = productNames.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
        return match;
	
	}
	
	

}