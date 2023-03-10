package javaAssignment4;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.UnableToCreateProfileException;


public class Snapdeal {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement mouse = driver.findElement(By.xpath("//span[@class='catText']"));
		Actions act=new Actions(driver);
		act.moveToElement(mouse).perform();
		driver.findElement(By.xpath("//span[@class='linkTest']")).click();
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		driver.findElement(By.xpath("(//li[@data-index='1'])[2]")).click();
		Thread.sleep(2000);
		List<WebElement> sort = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		for(WebElement i:sort) {
		System.out.println(i.getText());
		}
		WebElement priceChange = driver.findElement(By.xpath("//a[@class='price-slider-scroll left-handle ui-slider-handle ui-state-default ui-corner-all hashAdded']"));
		WebElement priceBar = driver.findElement(By.xpath("//div[@class='ui-slider-range ui-widget-header ui-corner-all']"));
		int x = priceBar.getLocation().getX();
		act.clickAndHold(priceChange).dragAndDropBy(priceBar, x, 0).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
		Thread.sleep(2000);
		String filter = driver.findElement(By.xpath("//div[@class='filters']")).getText();
		System.out.println(filter);
		driver.findElement(By.xpath("//div[contains(@class,'center quick-view-bar')]")).click();
		String mRP = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		String oFF = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println(mRP);
		System.out.println(oFF);
File ss=	driver.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		File dest = new File("./snap/shot.png");
		FileUtils.copyFile(ss, dest);
		driver.close();
	}

}


