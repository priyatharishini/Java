package javaAssignment4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseDrag {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
driver.get("https://leafground.com/drag.xhtml");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
WebElement drag = driver.findElement(By.xpath("//span[text()='Drag and Drop']"));
	Actions ac=new Actions(driver);
	ac.dragAndDropBy(drag, 300, 400).perform();
	WebElement drag1 = driver.findElement(By.xpath("//p[text()='Drag to target']"));
	WebElement drop = driver.findElement(By.xpath("//span[text()='Droppable Target']"));
	ac.dragAndDrop(drag1, drop).perform();
	WebElement drop1 = driver.findElement(By.xpath("(//table[@role='grid']//tr//span)[1]"));
	WebElement drag2 = driver.findElement(By.xpath("(//table[@role='grid']//tr//span)[2]"));
	ac.dragAndDrop(drag2,drop1).perform();
	WebElement drag3 = driver.findElement(By.xpath("((//table[@role='grid'])[2]//tr[1]//td)"));
	ac.dragAndDropBy(drag3, 80, 100).perform();
	WebElement drag4 = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default'][1]"));
	ac.dragAndDropBy(drag4,10,0).perform();
	WebElement drag5 = driver.findElement(By.xpath("(//div[contains(@class,'ui-slider ui-corner-all')]//span)[2]"));
	ac.dragAndDropBy(drag5, -25,0).perform();
	}
	
}
