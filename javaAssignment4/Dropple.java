package javaAssignment4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Dropple {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments();
		options.addArguments("--remote-allow-origins=*","--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  driver.get("https://jqueryui.com/droppable/"); 
		  driver.switchTo().frame(0);
		  WebElement drags =driver.findElement(By.xpath("//div[@id='draggable']"));
		  WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
		  Actions acts=new Actions(driver);
		  acts.dragAndDrop(drags, drop).perform();
		  driver.close();

	}

}
