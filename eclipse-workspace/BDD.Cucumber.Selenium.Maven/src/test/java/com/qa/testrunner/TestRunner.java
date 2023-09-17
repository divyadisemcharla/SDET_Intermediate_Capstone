package com.qa.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = "src/test/resources/", glue="com.qa.stepdefinition", tags="Sample",plugin = {"pretty", "html:target/cucumber-reports"}, dryRun=false
		)
public class TestRunner extends AbstractTestNGCucumberTests {

}
