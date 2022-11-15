package com.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ex02 {
	public static void main(String[] args) {
		String rakusLoginUrl = "https://rakuplus.jp/wp-login.php?redirect_to=https%3A%2F%2Frakuplus.jp%2F&reauth=1";
		String memberUrl = "https://rakuplus.jp/archives/11203";
		String userName = "";
		String pass = "";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		login(driver, rakusLoginUrl, memberUrl, userName, pass);
		list(driver, memberUrl);
		driver.close();
		
	}
	
	public static void login(WebDriver driver, String rakusLoginUrl, String memberUrl, String userName, String pass) {
		
		driver.get(rakusLoginUrl);
		
		WebElement userNameElement = driver.findElement(By.id("user_login"));
		userNameElement.click();
		userNameElement.sendKeys(userName);

		WebElement passElement = driver.findElement(By.id("user_pass"));
		passElement.click();
		passElement.sendKeys(pass);
		
		WebElement loginElement = driver.findElement(By.id("wp-submit"));
		loginElement.click();
	}
	
	public static void list(WebDriver driver, String memberUrl) {
		driver.get(memberUrl);
		
		WebElement memberSection = driver.findElement(By.className("entry-content"));
		List<WebElement> memberList  = memberSection.findElements(By.cssSelector("div[class='is-layout-flow wp-block-column is-vertically-aligned-top visual']"));
		
		for(int i=0; i<memberList.size(); i++) {
			WebElement member =  memberList.get(i);
	
			WebElement memberName = member.findElement(By.className("big"));
			WebElement memberRuby = member.findElement(By.cssSelector("p[class='has-text-align-center has-text-color']"));
			WebElement memberImage = member.findElement(By.tagName("img"));
			
			String name = memberName.getText();
			String ruby = memberRuby.getText();
			String image = memberImage.getAttribute("src");
			
			System.out.println(name+"("+ ruby +")"+ " ImageLink："+ image );
		}
	}
}
