package com.dice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceJobSearch {
public static void main(String[] args) {
	//set up chrome driver path
	WebDriverManager.chromedriver().setup();
	
	//invoke selenium webdriver
	WebDriver driver = new ChromeDriver();
	
	//full screen
	driver.manage().window().fullscreen();
	
	//set wait time is case webpage is slow
	driver.manage().timeouts().implicitlyWait(2,  TimeUnit.SECONDS);
	
	//*Step 1 launch browser and navigate to dice.com
	String url = "https://dice.com";
	driver.get(url);
	
	String actualTitle = driver.getTitle();
	String expectedTitle = "Job Search for Technology Professionals | Dice.com";
	if(actualTitle.equals(expectedTitle)) {
	System.out.println("Step PASS.Dice homepage successfully loaded");
 }else {
	System.out.println("Step FAIL");
	//throw new RunTimeException("Step FAIL");
	
}
	String keyword = "java developer";
	//driver.findElement(By.id("search-field-keyword")).clear();
	driver.findElement(By.id("search-field-keyword")).sendKeys(keyword);
	
	String location = "60610";
	driver.findElement(By.id("search-field-location")).sendKeys(location);
	
	driver.findElement(By.id("findTechJobs")).click();
	String count = driver.findElement(By.id("posiCountId")).getText();
	System.out.println(count);
	
	int countResult = Integer.parseInt(count.replace(",",""));
	if(countResult > 0) {
		System.out.println("Keyword : " + keyword + "search returned : " + countResult + " result in " + location);
	}else {
		 System.out.println("Step FAIL" + keyword + countResult + location);
	}
	 driver.close();
}
}
