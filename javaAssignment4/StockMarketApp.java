package javaAssignment4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class StockMarketApp {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.chittorgarh.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("navbtn_stockmarket")).click();
		driver.findElement(By.linkText("NSE Bulk Deals")).click();
		List<WebElement> row = driver.findElements(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr"));
		System.out.println(row.size());
		List<String> dupList = new ArrayList<String>();
		int listSize = dupList.size();
		System.out.println("ListSize "+listSize);
		for(int i=1;i<row.size();i++) {
		 String text = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]/tbody[1]/tr["+i+"]/td[1]")).getText();
			System.out.println(text);
			dupList.add(text);
		}
		Set<String> removeDup = new TreeSet<String>(dupList);
		int setSize = removeDup.size();
		System.out.println("SetSize "+setSize);
		if(listSize!=setSize) {
			System.out.println("removed duplicate");
		}else {
			System.out.println("duplicate present");
		}
		System.out.println("");
		System.out.println(removeDup);
	}


	

}
