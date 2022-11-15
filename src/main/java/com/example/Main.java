package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver diver = new ChromeDriver();
		
		diver.get("https://www.google.co.jp/");
		
	}
}
