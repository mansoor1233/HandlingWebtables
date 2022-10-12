package HandlingWebTables;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pract1 {
	static String nextclassname;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://mdbootstrap.com/docs/b4/jquery/tables/pagination/");

		int sizeOfPagenation = driver.findElements(By.xpath("//div[@id='dtBasicExample_paginate']//a")).size();

		System.out.println("size : " + sizeOfPagenation);

		List<String> names = new ArrayList<String>();

		List<WebElement> listofnames;

		WebElement nextbutton;

		if (sizeOfPagenation > 0) {

			do {
				listofnames = driver.findElements(By.xpath("//td[@class='sorting_1']"));
				for (WebElement name : listofnames) {

					names.add(name.getText());

				}
				nextbutton = driver.findElement(By.id("dtBasicExample_next"));

				nextclassname = nextbutton.getAttribute("class");

				if (!nextclassname.contains("disabled")) {
					nextbutton.click();
				} else {
					break;
				}
			} while (true);
		} else {
			System.out.println("No pagenation in the page");
		}

		for (String Allnames : names) {

			System.out.println(Allnames);

		}

	}

}
