package com.calendly.game;

import com.calendly.utilities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Game extends BasePage {

    int i;

    public Game() {

        PageFactory.initElements(driver, this);
        i = 0;
    }

    @FindBy(xpath = "//input[@id = 'number']")
    @CacheLookup
    WebElement numInputField;

    @FindBy(id = "start")
    @CacheLookup
    WebElement playButton;

    WebDriverWait wait;

        public void enterNumberToGenerateGame(Integer num) throws InterruptedException {
        driver.switchTo().frame("result");
        numInputField.click();
        numInputField.sendKeys(String.valueOf(num));

    }

        public void clickPlayButton() {
            playButton.click();
        }

        public void markingSpaceInBoxes(Integer column, Integer row){
        WebElement markSpace = driver.findElement(By.xpath("//td[@data-column= '"+column+"'][contains(@data-row, '"+row+"')]"));

        markSpace.click();

        }
        public void playerXwins(){
            markingSpaceInBoxes(1,0);
            markingSpaceInBoxes(0,2);
            markingSpaceInBoxes(1,1);
            markingSpaceInBoxes(2,0);
            markingSpaceInBoxes(1,2);
        }

    }



