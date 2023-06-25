package com.kerala.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"com.kerala.features"},
        glue = {"com.kerala.steps"},
        plugin={"pretty"},
        monochrome = true
)
public class KeralaRunner extends AbstractTestNGCucumberTests{

}
