package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions( features = "src/test/java/featureFiles/InvalidLogin.feature",
glue="stepDefinitions")
public class LoginInvalideCridintial {

}
