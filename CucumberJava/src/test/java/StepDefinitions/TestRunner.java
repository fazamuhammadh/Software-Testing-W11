package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/Resources/Features", glue={"StepDefinitions"},
monochrome = true,
plugin = {"pretty", "html:target/HtmlReports/report.html",
            "json:target/JSONReports/report.json",
            "junit:target/JUnitReports/report.xml"},
tags = "@SmokeTest"
        )
public class TestRunner {

    }
