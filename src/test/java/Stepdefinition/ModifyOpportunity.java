package Stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ConfigFile;

import java.util.concurrent.TimeUnit;

public class ModifyOpportunity {
    WebDriver driver;
    @BeforeClass
    @Given("navigate to url salesforce modify")
    public void navigate_to_url_salesforce_modify() {
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
    @When("user check opportunity list")
    public void user_check_opportunity_list() {
        System.out.println("check list");
    }
    @Test
    @When("select opportunity and click")
    public void select_opportunity_and_click() {
        driver.findElement(By.xpath("//a[contains(@href, '/lightning/r/0068d000009iEmQAAU/view')]")).click();
    }
    @Test
    @When("click button modify")
    public void click_button_modify() {
        driver.findElement(By.xpath("//div[@class='highlights slds-clearfix slds-page-header slds-page-header_record-home fixed-position']//div[@class='slds-grid primaryFieldRow']//div[@class='slds-col slds-no-flex slds-grid slds-grid_vertical-align-center horizontal actionsContainer']//div//button[@name='Edit'][normalize-space()='Modifier']")).click();
    }
    @Test
    @When("modify information the opportunity")
    public void modify_information_the_opportunity() {
     driver.findElement(By.xpath("//records-record-layout-base-input/lightning-input/div/input")).click();
        driver.findElement(By.xpath("//records-record-layout-base-input/lightning-input/div/input")).sendKeys("CDI TALAN FRANCE");

    }
    @Test
    @Then("click save")
    public void click_save() {
        driver.findElement(By.xpath("//records-record-layout-base-input/lightning-input/div/input")).click();
        driver.quit();
    }

}
