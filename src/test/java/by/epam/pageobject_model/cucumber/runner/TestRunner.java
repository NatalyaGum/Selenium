package by.epam.pageobject_model.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/loginMailru.feature","src/test/resources/mailru.feature"},
        glue={"by.epam.pageobject_model.cucumber.steps","by.epam.pageobject_model.cucumber.hooks"},
        plugin= {"pretty"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
