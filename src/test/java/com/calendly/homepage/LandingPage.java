package com.calendly.homepage;

import com.calendly.utilities.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BasePage {

    public LandingPage() {

        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//button[@title = 'Love']")
    @CacheLookup
    WebElement heartButton;


    public void clickHeartButton()
    {
        heartButton.click();
    }
}

