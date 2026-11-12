package swagLab_pagePKG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLab_loginpage {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"user-name\"]") WebElement username;
	@FindBy(xpath="//*[@id=\"password\"]") WebElement password;
	@FindBy(xpath="//*[@id=\"login-button\"]") WebElement loginbtn;
	
	public SwagLab_loginpage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void loginMtd(String un, String ps)
	{
		username.sendKeys(un);
		password.sendKeys(ps);
		loginbtn.click();
		
	}

}
