package com.calendly.cucumber.testrunner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources/features",
        glue = "com.calendly.cucumber.stepdefs",
//        tags = {"@SmokeTest"
//
//        },
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt",
                "json:target/cucumber-reports/CucumberTestReport.json"
        },
        dryRun = false,
        monochrome = true
        // plugin = {"pretty","html:test-output"} this is jUnit

)
public class TestRunner {

    }

