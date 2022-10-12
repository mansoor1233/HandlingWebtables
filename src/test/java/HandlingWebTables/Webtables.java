package HandlingWebTables;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Webtables {

	@Test
	@SuppressWarnings("deprecation")
	public void pagenationusingforloop() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://datatables.net/examples/advanced_init/dt_events.html");

		int Pagenationsize = driver.findElements(By.cssSelector("#example_paginate>span>a")).size();
		
		//Above : To check how many pages are in pagenation list

		List<String> names = new ArrayList<String>();

		for (int i = 1; i <= Pagenationsize; i++) {
			String pagenationselector = "#example_paginate>span>a:nth-child(" + i + ")";
			
	
			driver.findElement(By.cssSelector(pagenationselector)).click();

			List<WebElement> namesElement = driver.findElements(By.cssSelector("#example>tbody>tr>td:nth-child(2)"));

			for (WebElement namesElement1 : namesElement) {
				names.add(namesElement1.getText());

			}
		}

		for (String name : names) {

			System.out.println(name);

		}

		int totalnames = names.size();
		System.out.println("Total no of names" + totalnames);

		String displaycount = driver.findElement(By.id("example_info")).getText().split(" ")[5];
		System.out.println("total no of displayednames " + displaycount);

		Assert.assertEquals(displaycount, String.valueOf(totalnames));
		
		Thread.sleep(3000);
		
		driver.quit();

	}

}
