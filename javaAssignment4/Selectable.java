package javaAssignment4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Selectable {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments();
		options.addArguments("--remote-allow-origins=*","--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://jqueryui.com/selectable/"); 
		  driver.switchTo().frame(0);
		  WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		  WebElement item3 = driver.findElement(By.xpath("//li[text()='Item 3']"));
		  WebElement item5 = driver.findElement(By.xpath("//li[text()='Item 5']"));
		  Actions clic=new Actions(driver);
		  clic.keyDown(Keys.CONTROL)
		  .click(item1)
		  .click(item3)
		  .click(item5)
		  .keyUp(Keys.CONTROL)
		  .perform();
		  driver.close();

	}

}
