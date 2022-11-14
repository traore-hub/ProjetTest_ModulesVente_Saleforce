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
import utils.ConfigFile;

import java.util.concurrent.TimeUnit;

public class VerifyOpportunity {
    WebDriver driver;
    @BeforeClass
    @Given("launch salesforce plateform opportunity section list")
    public void launch_salesforce_plateform_opportunity_section_list() {
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
    @When("click opportunity")
    public void click_opportunity() {
       driver.findElement(By.xpath("//one-app-nav-bar-item-root[2]/a/span")).click();
    }
    @When("select opportunity")
    public void select_opportunity() {
        driver.findElement(By.xpath("//a[contains(@href, '/lightning/r/0068d000009iEmQAAU/view')]")).click();
    }
    @Then("change the date")
    public void change_the_date() {
        driver.findElement(By.xpath("//div[@class='highlights slds-clearfix slds-page-header slds-page-header_record-home fixed-position']//div[@class='slds-grid primaryFieldRow']//div[@class='slds-col slds-no-flex slds-grid slds-grid_vertical-align-center horizontal actionsContainer']//div//button[@name='Edit'][normalize-space()='Modifier']")).click();
         driver.findElement(By.xpath("//lightning-datepicker/div/div/input")).click();
         driver.findElement(By.xpath("//*/text()[normalize-space(.)='14']/parent::*")).click();
        driver.findElement(By.xpath("//records-record-layout-base-input/lightning-input/div/input")).click();
    }
    @Then("verify last date and current date")
    public void verify_date_and_current_date() {
       String newDate=driver.findElement(By.xpath("//div[2]/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___sfa__-opportunity_rec_-l___-opportunity___-v-i-e-w/forcegenerated-flexipage_opportunity_rec_l_opportunity__view_js/record_flexipage-record-page-decorator/div/records-record-layout-event-broker/slot/slot/flexipage-record-home-with-subheader-template-desktop2/div/div/slot/flexipage-component2/slot/records-lwc-highlights-panel/records-lwc-record-layout/forcegenerated-highlightspanel_opportunity___012000000000000aaa___compact___view___recordlayout2/records-highlights2/div/div[2]/slot/records-highlights-details-item[2]/div/p")).getText();
        Assert.assertNotEquals(newDate,"06/10/2022");
    }
    @Then("change name")
    public void change_name() {
        driver.findElement(By.xpath("//div[@class='highlights slds-clearfix slds-page-header slds-page-header_record-home fixed-position']//div[@class='slds-grid primaryFieldRow']//div[@class='slds-col slds-no-flex slds-grid slds-grid_vertical-align-center horizontal actionsContainer']//div//button[@name='Edit'][normalize-space()='Modifier']")).click();
        driver.findElement(By.xpath("//records-record-layout-base-input/lightning-input/div/input")).sendKeys("CDI TALAN SUISSE");
        driver.findElement(By.xpath("//records-record-layout-base-input/lightning-input/div/input")).click();
    }

    @AfterClass
    @Then("verify name again")
    public void verify_name_again() {
        String newName = driver.findElement(By.xpath("//div[2]/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___sfa__-opportunity_rec_-l___-opportunity___-v-i-e-w/forcegenerated-flexipage_opportunity_rec_l_opportunity__view_js/record_flexipage-record-page-decorator/div/records-record-layout-event-broker/slot/slot/flexipage-record-home-with-subheader-template-desktop2/div/div/slot/flexipage-component2/slot/records-lwc-highlights-panel/records-lwc-record-layout/forcegenerated-highlightspanel_opportunity___012000000000000aaa___compact___view___recordlayout2/records-highlights2/div/div/div/div[2]/h1/slot/lightning-formatted-text")).getText();
       Assert.assertEquals(newName,"CDI TALAN");
        driver.close();
    }

}
