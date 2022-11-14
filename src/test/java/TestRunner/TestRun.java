package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import utils.ConfigFile;

import java.io.FileNotFoundException;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "html:target/report/cucumber.html",
                "json:target/report/cucumber.json"
        },
        features = "src/main/resources/Features",
        glue = "Stepdefinition",
        tags = "@Verify"
)
public class TestRun extends AbstractTestNGCucumberTests {

    @BeforeClass
    public static void setup() throws FileNotFoundException {
        ConfigFile.initialiseFile();
    }
    @AfterClass
    public static void teardown(){

    }
}
