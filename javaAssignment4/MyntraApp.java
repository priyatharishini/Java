package javaAssignment4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MyntraApp {

	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments();
		options.addArguments("--remote-allow-origins=*","--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Actions act=new Actions(driver);
		driver.get("https://www.myntra.com/");
		WebElement hover = driver.findElement(By.xpath("//a[text()='Men']"));
		act.moveToElement(hover).perform();
		driver.findElement(By.xpath("//a[text()='Jackets']")).click();
		String noOfJacket = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		noOfJacket=noOfJacket.replaceAll("\\D","");
		int noOfJack = Integer.parseInt(noOfJacket);
		System.out.println(noOfJack);
		Thread.sleep(2000);
		String sub1 = driver.findElement(By.xpath("(//span[@class='categories-num'])[1]")).getText();
		sub1=sub1.replaceAll("\\D", "");
		String sub2 = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
		sub2=sub2.replaceAll("\\D", "");
		int int1 =Integer.parseInt(sub1);
		int int2 = Integer.parseInt(sub2);
		int tot=int1 +int2;
		System.out.println(tot);
		if(noOfJack==tot) {
			System.out.println("Equal number of jackets");
		}
		driver.findElement(By.xpath("//div[@class='common-checkboxIndicator']")).click();
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']")).sendKeys("Duke");
		driver.findElement(By.xpath("//label[@class=' common-customCheckbox']")).click();
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
		List<WebElement> productBrand = driver.findElements(By.xpath("//h3[@class='product-brand']"));
		for(WebElement i:productBrand)
		{
			String brand = i.getText();
			if(brand.equalsIgnoreCase("Duke")) {
				System.out.println("same brand");
			}else {
				System.out.println("diff");
			}
		}
		driver.findElement(By.xpath("//div[@class='sort-sortBy']")).click();
		driver.findElement(By.xpath("(//label[@class='sort-label '])[4]")).click();
		String price = driver.findElement(By.xpath("//span[@class='product-discountedPrice']")).getText();
		System.out.println(price);
		driver.findElement(By.xpath("//div[@class='product-imageSliderContainer']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handle = new ArrayList<String>(windowHandles);
		driver.switchTo().window(handle.get(1));
		File ss = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snap/shot.png");
		FileUtils.copyFile(ss, dest);
		driver.findElement(By.xpath("//div[contains(@class,' pdp-add-to-wishlist pdp-button ')]")).click();
		driver.quit();
	
	
	}


}
