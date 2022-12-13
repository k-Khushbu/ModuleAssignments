/*
 * Assignment -1(Apache POI (Data Driven)):
- url : http://demo.guru99.com/V4/
- Get the data from excel sheet using Apache poi
- Enter the username 
- Enter the password
- Click on Login button
- One prompt will open click on OK 
 */
package module4;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {
	WebDriver driver;
	static XSSFWorkbook workbook;
	static XSSFSheet sheetName;
	
	@BeforeMethod
	public void initialization() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/V4/");
	}
	
	@Test
	public void login() throws IOException {
		String filePath = "./testData.xlsx";
	 	workbook = new XSSFWorkbook(filePath);
		sheetName = workbook.getSheet("Module3Assignment2_LoginData");
		String email = sheetName.getRow(1).getCell(0).getStringCellValue();
		String password = sheetName.getRow(1).getCell(1).getStringCellValue();
		
		driver.findElement(By.name("uid")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();
		
		Alert al = driver.switchTo().alert();
		al.accept();
	}
	
	@AfterMethod
	public void closeDriver() {
		driver.quit();
	}
}
