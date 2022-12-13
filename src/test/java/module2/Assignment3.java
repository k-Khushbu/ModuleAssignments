/*
 * Assignment -3(Actions, JavaScript Executors):
- url : https://jqueryui.com/
- Click on Draggable
- Drag the “Drag me around” box another place
- Take the Screeshot of that dragged
- Suggested method javascript Executor
 */
package module2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/");
		driver.findElement(By.xpath(".//a[contains(text(),'Draggable')]")).click();
		WebElement iframe1 = driver.findElement(By.xpath("//iframe"));
		driver.switchTo().frame(iframe1);
		WebElement drag = driver.findElement(By.id("draggable"));
		Actions act = new Actions(driver);
		act.dragAndDropBy(drag, 131, 56).build().perform();
		driver.quit();
	}

}
