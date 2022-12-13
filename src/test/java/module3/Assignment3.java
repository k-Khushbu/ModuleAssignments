/*
 * Assignment -3(TestNG):
- url : https://demoqa.com/
- Click on  Forms
- Click on Practise Form
- Make above two actions in group as smoke test
- Then fill the entire form group name will be regression 
- Enter Submit
 */
package module3;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {
	WebDriver driver;
	@BeforeMethod
	public void initialization() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
					
	}
	
	@Test(groups = "smoke")
	public void testForm() {
		//WebElement forms = driver.findElement(By.xpath("//div/h5[contains(text(),'Forms')]"));
		WebElement forms = driver.findElement(By.xpath("(//div[@class=\"card-up\"])[2]"));
		//Actions act = new Actions(driver);
		//act.scrollToElement(forms).build().perform();
		forms.click();
		driver.findElement(By.xpath("//div/ul/li/span[contains(text(),'Practice Form')]")).click();
	}
	
	@AfterMethod
	public void closeDriver() {
		driver.quit();
	}
	
}
