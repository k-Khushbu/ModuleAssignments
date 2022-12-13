/*
 * Assignment -2(TestNG):
- url : https://demo.guru99.com/test/login.html
- Using TestNG Annotaions to complete this assignment
- In Before test annotation must have the initialize the drivers
- In Test annotation we have to enter the username and password
- You need to take the data(username and password) from datadriven method
- In After annotation must have the close() to close the application
 */
package module3;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {
	WebDriver driver;
	static XSSFWorkbook workbook;
	static XSSFSheet sheetName;
	
	@BeforeTest
	public void initialization() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/login.html");
	}
	
	@Test
	public void login() throws IOException {
		String filePath = "./testData.xlsx";
	 	workbook = new XSSFWorkbook(filePath);
		sheetName = workbook.getSheet("Module3Assignment2_LoginData");
		String email = sheetName.getRow(1).getCell(0).getStringCellValue();
		String password = sheetName.getRow(1).getCell(1).getStringCellValue();
		
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("passwd")).sendKeys(password);
		driver.findElement(By.id("SubmitLogin")).click();
	}
	
	@AfterTest
	public void closeDriver() {
		driver.quit();
	}
}
