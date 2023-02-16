/*
    Assignment -2(Page Object Model(POM)):
    - url : https://itechnotion.com/what-will-be-the-cost-of-an-app-like-justdial-its-indias-no-1-local-business-directory/
    - Retrieve all headers
    - Click on Products and Select vDoctor
    - Click on the FEATURES and retrieve the all features
    - Click on TECHNOLOGY and retrieve the all technologies
    - Click on Get Quote
    - Enter the data into form by taking all the data from excel sheet
    - Select any option in what is your interest
    - Click on submit
 */
package module4;

import com.module4.Assignment2;
import org.testng.annotations.Test;

public class TestAssignment2 extends BaseClass {

    @Test(priority = 1)
    public void testHeaderName(){
        Assignment2 assignment2 = new Assignment2(driver);
        assignment2.headerName();
    }

    @Test(priority = 2)
    public void testProductLink(){
        Assignment2 assignment2 = new Assignment2(driver);
        assignment2.verifyProductLink();
    }

    @Test(priority = 3)
    public void testPrintFeatures(){
        Assignment2 assignment2 = new Assignment2(driver);
        assignment2.printFeatures();
    }
    @Test(priority = 4)
    public void testPrintAllTechnologies(){
        Assignment2 assignment2 = new Assignment2(driver);
        assignment2.printAllTechnologies();
    }

    @Test(priority = 5)
    public void testFillGetQuoteForm(){
        Assignment2 assignment2 = new Assignment2(driver);
        assignment2.fillGetQuoteForm();
    }

}
