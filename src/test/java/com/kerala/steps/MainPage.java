package com.kerala.steps;

import com.kerala.runner.Base;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import io.cucumber.java.en.Given;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

@Test(priority = 1)
public class MainPage extends Base{
    @Test(priority = 1)
    @Given("User is in the kerala government website main page")
    public void User_is_in_the_kerala_government_website_main_page() throws InterruptedException {
        driver.get("https://kerala.gov.in/");
        driver.manage().window().maximize();
    }
    @Test(priority = 2)
    @When("User clicks language options and selects English")
    public void User_clicks_language_options_and_selects_English() throws InterruptedException {
        Select lang = new Select(driver.findElement(By.className("lang")));
        lang.selectByIndex(2);
        Thread.sleep(3000);
    }
    @Test(priority = 3)
    @Then("Page should shifted to English language")
    public void Page_should_shifted_to_English_language() throws IOException, InterruptedException {
        Thread.sleep(2000);
        WebElement gov = driver.findElement(By.id("logoimg"));
        File srcFile = gov.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("img/kerala_logo.png"));

        WebElement language = driver.findElement(By.id("govthead"));
        assertEquals(language.getText(), "Government");
    }

}
