package javaAssignment4;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class LeafGroundFrame {
public static void main(String[] args)
	{
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://leafground.com/frame.xhtml;jsessionid=node05us3gij8ed091h38fieurov685953.node0");
		driver.manage().window();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.switchTo().frame(0);
		WebElement click = driver.findElement(By.xpath("//button[text()='Click Me']"));
		click.click();
		System.out.println(click.getText());
		driver.switchTo().defaultContent();
		List<WebElement>countframe = driver.findElements(By.tagName("iframe"));
	 int size = countframe.size();
	 System.out.println(size);
driver.switchTo().frame(2); 
driver.switchTo().frame("frame2");
WebElement click1 = driver.findElement(By.xpath("//button[text()='Click Me']"));
click1.click();
System.out.println(click1.getText());
driver.switchTo().defaultContent();
List<WebElement> outerframe = driver.findElements(By.tagName("iframe"));
System.out.println("Total Frames without Nested are " + outerframe.size());
int outercount = outerframe.size();
int count = 0;
for (int i = 0; i <outerframe.size(); i++) 
{

	driver.switchTo().frame(outerframe.get(i));
	java.util.List<WebElement> inner = driver.findElements(By.tagName("iframe"));
	count = count + inner.size();
	driver.switchTo().defaultContent();
}

int framesize = count + outercount;
System.out.println("Frame is"+framesize);
	}
}
	