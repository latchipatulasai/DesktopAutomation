package com.mytests;

import java.io.IOException;

import java.net.URL;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;

public class Notepad {
	public static WindowsDriver<WebElement> driver = null;

	@BeforeClass
	public void setup() throws InterruptedException, IOException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("app", "C:\\Windows\\System32\\notepad.exe");
		cap.setCapability("platformName", "Windows");
		cap.setCapability("deviceName", "WindowsPC");
		Thread.sleep(5000);
		Runtime.getRuntime()
				.exec("cmd /c start \"\" \"C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe\"");
		// Thread.sleep(5000);
		driver = new WindowsDriver<WebElement>(new URL("http://127.0.0.1:4723"), cap);

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void clieanUp() throws IOException, InterruptedException {
		driver.quit();

	}

	@Test(priority = 2)
	public void checkHelpAboutNowTest() throws Exception {
		driver.findElement(By.name("View")).click();
		driver.findElement(By.name("*Untitled - Notepad")).click();

		Thread.sleep(5000);
		// driver.findElement(By.name("Don't save")).click();
//		driver.findElement(By.name("About Notepad")).click();
//		driver.findElement(By.name("OK")).click();
//		// driver.fin
	}

	@Test(priority = 1)
	public void enterText() throws Exception {
		driver.findElement(By.name("RichEdit Control")).sendKeys("Hii sai you did desktop autoamation great.....");
		Thread.sleep(5000);

		driver.findElement(By.name("File")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("File")).click();

		driver.findElement(By.name("Edit")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("Edit")).click();

	}

}
