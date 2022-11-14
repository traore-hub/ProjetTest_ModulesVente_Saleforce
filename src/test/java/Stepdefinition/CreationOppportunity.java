package Stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ConfigFile;

import java.util.concurrent.TimeUnit;

public class CreationOppportunity {

    public WebDriver driver;


   @BeforeClass
    @Given("navigate to url salesforce")
    public void navigate_to_url_salesforce() {
       if( ConfigFile.property.getProperty("Browsertype").equalsIgnoreCase("Chrome")){
           System.setProperty("webdriver.chrome.driver","src/main/resources/Drivers/chromedriver.exe");
           driver = new ChromeDriver();
       }
       if (ConfigFile.property.getProperty("Browser").equalsIgnoreCase("firefox")) {
           System.setProperty("webdriver.gecko.driver","src/main/resources/Drivers/geckodriver.exe");
           driver =new FirefoxDriver();
       }
       driver.navigate().to(ConfigFile.property.getProperty("url"));
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(ConfigFile.property.getProperty("login"));
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(ConfigFile.property.getProperty("password"));
        driver.findElement(By.xpath("//input[@id='Login']")).click();
    }


    @Test
    @Given("User navigate to Sales Portal")
    public void user_navigate_to_sales_portal() throws InterruptedException {


        driver.findElement(By.xpath("//div[@id='brandBand_1']/div/div/div/div/div/div/div[2]/ul/li/a")).click();


    }

    @Test
    @When("User Creates An Opportunity with : Amount {string}, Opportunity Stage {string} and Close Date {string}")
    public void user_creates_an_opportunity_with_amount_opportunity_stage_and_close_date(String string, String string2, String string3) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//sfa-input-opportunity-amount/lightning-input/div/input")).sendKeys(string);

        driver.findElement(By.xpath("//records-record-layout-base-input/lightning-input/div/input")).sendKeys("CDI TALAN");
        driver.findElement(By.xpath("//lightning-datepicker/div/div/input")).sendKeys(string3);

                driver.findElement(By.xpath("//lightning-base-combobox/div/div/button")).click();
        driver.findElement(By.xpath("//lightning-base-combobox-item[3]/span[2]/span")).click();
        driver.findElement(By.xpath("//li[3]/runtime_platform_actions-action-renderer/runtime_platform_actions-executor-lwc-headless/slot/slot/lightning-button/button")).click();


        }

        @Test(priority = 0)
    @Then("Opportunity should be created with correct information")
    public void opportunity_should_be_created_with_correct_information() {
       String message = driver.findElement(By.xpath("//lightning-base-combobox/div/div/button")).getText();
        Assert.assertNotEquals(message,"Opportunité à été bien enregistréé");

    }

    @AfterClass
    @Then("close Browser")
    public void close_browser() {
        driver.close();
        driver.quit();
    }

}
