package by.epam.pageobject_model.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.Listeners;
import by.epam.pageobject_model.utils.TestListener;
@Listeners({TestListener.class})
@CucumberOptions(
        features = {"src/test/resources/loginMailru.feature","src/test/resources/mailru.feature"},
        glue={"by.epam.pageobject_model.cucumber.steps","by.epam.pageobject_model.cucumber.hooks"},
        plugin= {"pretty"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
