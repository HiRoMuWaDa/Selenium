package com.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.co.jp/");
		
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("selenium");
		element.sendKeys(Keys.chord(Keys.ENTER));
		
		List<WebElement> resultList = driver.findElements(By.tagName("h3"));
		String result = resultList.get(0).getText();
		System.out.println(result);
		
		driver.close();
	}
}
