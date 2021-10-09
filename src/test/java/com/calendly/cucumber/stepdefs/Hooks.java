package com.calendly.cucumber.stepdefs;

import com.calendly.utilities.BasePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;


public class Hooks extends BasePage {

    @Before
    public void setUp() throws InterruptedException{
        initialization(defaultEnv);
    }

    @After
    public void tearDown() throws Throwable {

//        driver.quit();
    }

    @Given("I navigate to codepen link provided by HR")
    public void i_navigate_to_codepen_link_provided_by_HR() {

      driver.get(baseURL);
    }
}