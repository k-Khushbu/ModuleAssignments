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

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class Assignment3 {
    WebDriver driver;
    @BeforeClass
    public void initialization() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");

    }

    @Test(priority=1, groups={"Smoke"})
    //@Test(priority = 1)
    public void testForm() {
        WebElement forms = driver.findElement(By.xpath("(//div[@class=\"card-up\"])[2]"));
        forms.click();
        driver.findElement(By.xpath("//div/ul/li/span[contains(text(),'Practice Form')]")).click();
    }

    @Test(priority=2, groups={"Regression"})
    //@Test(priority = 2)
    public void fillForms() {
        driver.findElement(By.id("firstName")).sendKeys("Mayuri");
        driver.findElement(By.id("lastName")).sendKeys("Thapar");
        driver.findElement(By.id("userEmail")).sendKeys("Mayuri.Thapar@xyz.com");
        driver.findElement(By.xpath(".//label[contains(text(), 'Female')]")).click();
        driver.findElement(By.id("userNumber")).sendKeys("7664546475");
        driver.findElement(By.id("dateOfBirthInput")).click();
        WebElement year = driver.findElement(By.className("react-datepicker__year-select"));
        year.click();
        Select yr = new Select(year);
        yr.selectByValue("2005");

        WebElement month = driver.findElement(By.className("react-datepicker__month-select"));
        month.click();
        Select mon = new Select(month);
        mon.selectByIndex(1);

        driver.findElement(By.xpath(".//div[contains(text(), '23')]")).click();

        driver.findElement(By.xpath(".//div[contains (@class ,'subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3')]")).sendKeys("Hello I am Mayuri Thapar");
        driver.findElement((By.xpath(".//label[contains(text(), 'Reading')]"))).click();
        driver.findElement(By.id("submit")).click();

    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
   }
}
