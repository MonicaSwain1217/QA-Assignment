package com.calendly.cucumber.stepdefs;

import com.calendly.homepage.LandingPage;
import com.calendly.utilities.BasePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LandingStepDef extends BasePage {
    @When("I land on the webpage")
    public void i_land_on_the_webpage() {
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("Calendly"));
    }

    @Then("I verify \"([^\"]*)\" is listed in the title")
    public void i_verify_is_listed_in_the_title(String title) {
        String itemTitle = driver.findElement(By.id("editable-title-span")).getText();
        Assert.assertEquals(itemTitle, title);
    }

    @Then("^I verify the owner is \"([^\"]*)\"$")
    public void i_verify_the_owner_is(String company) {
        if (company.equalsIgnoreCase("Calendly")) {
            LandingPage landingPage = new LandingPage();
            landingPage.clickHeartButton();
        } else {
            System.out.println("Don't Bother");
            driver.close();

        }
    }
}
