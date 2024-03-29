package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "src/test/resources/features", 
		glue = {"stepdefinitions","hooks"},
		publish=true,
		tags="@all",
		plugin = { "pretty",
				"html:target/CucumberReports/CucumberReport.html", 
                "json:target/CucumberReports/CucumberReport.json",
                "junit:target/CucumberReports/CucumberReport.xml"})
public class TestRunner {

}
