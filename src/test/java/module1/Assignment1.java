/*
 * Assignment -1(Webdriver  architecture, All Types of Drivers)
- First Selenium Test: Verify amazon HomaPage
- verify the FaceBook HomePage 
- Verify the Page Tittle. 
- Invoke : Firefox, Safari, Opera, IE
- Using Navigator commands to move home page to other page and comeback to homepage
 */

package module1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		String expRes = "https://www.amazon.in/";
		String actRes = driver.getCurrentUrl();
		if(expRes.equalsIgnoreCase(actRes)) {
			System.out.println("Amazon Home Page Verified.");
		}
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("email");
		driver.findElement(By.cssSelector("#pass")).sendKeys("Pass");
		driver.findElement(By.name("login")).click();
		expRes = "https://www.facebook.com/homepage";
		actRes = driver.getCurrentUrl();
		if(expRes.equalsIgnoreCase(actRes)) {
			System.out.println("Facebook Home Page Verified.");
		}
		else {
			System.out.println("Facebook Home Page not Verified.");
		}
		
		driver.get("https://www.amazon.in/");
		driver.navigate().to("https://www.facebook.com/");
		driver.navigate().back();
		
		driver.close();
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver firefox = new FirefoxDriver();
		firefox.close();
		//WebDriverManager.safaridriver().setup();
		//WebDriver safari = new SafariDriver();
		
		//WebDriverManager.iedriver().setup();
		//WebDriver ie = new InternetExplorerDriver();
		
		//WebDriverManager.operadriver().setup();
		//WebDriver opera = new OperaDriver();
		
		
	}

}
