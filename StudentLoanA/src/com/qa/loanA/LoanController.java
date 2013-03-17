package com.qa.loanA;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoanController {
	public void test(WebDriver driver) throws InterruptedException{
		  //driver.switchTo().window(driver1.getWindowHandle());
		  	clickElement(By.xpath("//div[4]/div/ul/li[5]/a"), driver);
		  	Thread.sleep(2000);
		  	typeTextboxElement(By.xpath("//table/tbody/tr[2]/td[2]/input"),"3000", driver);
		  	typeTextboxElement(By.xpath("//table/tbody/tr[3]/td[2]/input"),"500", driver);
		  	typeTextboxElement(By.xpath("//table/tbody/tr[4]/td[2]/input"),"1000", driver);
		  	typeTextboxElement(By.xpath("//div[@id='cdl1']/table/tbody/tr[2]/td[4]/input"),"500", driver);
		  	typeTextboxElement(By.xpath("//div[@id='cdl1']/table/tbody/tr[3]/td[4]/input"),"500", driver);
		  	typeTextboxElement(By.xpath("//div[@id='cdl1']/table/tbody/tr[4]/td[4]/input"),"400", driver);	
		  	
		  	clickElement(By.xpath("//div[@id='cdl1']/table/tbody/tr[16]/td[2]/input[1]"),driver);
		  	Thread.sleep(2000);
		  	String text = driver.findElement( By.xpath("//table/tbody/tr[15]/td[2]/input")).getAttribute("value");
			System.out.println("Text is "+text);
			Assert.assertEquals("-3100.00", text);
	  }
	  public void clickElement(By by,WebDriver driver1) throws InterruptedException{
		  	
			WebElement element = driver1.findElement(by);
			Thread.sleep(1000);
			element.click();}
	  
	  public void typeTextboxElement(By by,String textToType, WebDriver driver1){
			WebElement element = driver1.findElement(by);
			element.clear();
			element.sendKeys(textToType);}

}
