package swagLab_pagePKG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLab_homepage{
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"add-to-cart-sauce-labs-backpack\"]") WebElement product;
	@FindBy(xpath="//*[@id=\"shopping_cart_container\"]/a") WebElement carticon;
	
	public SwagLab_homepage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	
	public void productMtd()
	{
		product.click();
	}
	
	public void cartMtd()
	{
		carticon.click();
	}

}
