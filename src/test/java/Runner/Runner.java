package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features="FeatureFiles",glue="stepDefinitions",plugin = {"com.cucumber.listener.ExtentCucumberFormatter:CucumberReports/report.html","html:targer/cucumber-reports"})

public class Runner {
	
} 
 