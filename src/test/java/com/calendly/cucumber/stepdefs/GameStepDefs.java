package com.calendly.cucumber.stepdefs;

import com.calendly.game.Game;
import com.calendly.utilities.BasePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class GameStepDefs extends BasePage {

    @When("I enter {int} in the number field")
    public void i_enter_three_in_the_number_field(Integer num) throws InterruptedException {
        Game game = new Game();
        game.enterNumberToGenerateGame(num);

    }

    @When("^I click the play button$")
    public void i_click_the_play_button() {
        Game game = new Game();
        game.clickPlayButton();
    }

    @Then("^I verify that tic tac toe game appears$")
    public void i_verify_that_tic_tac_toe_game_appears() {
        Boolean table = driver.findElement(By.id("table")).isDisplayed();
        Assert.assertTrue(table);
        List<WebElement> boxes = driver.findElements(By.xpath("//table/tr/td"));
        System.out.println(boxes.size());
        Assert.assertTrue(boxes.size() == 9);

    }

    @Then("^I verify there are three columns$")
    public void i_verify_there_are_three_columns() {
        List<WebElement> columns = driver.findElements(By.xpath("//table/tr/td[@data-row= 0]"));
        System.out.println(columns.size());
        Assert.assertTrue(columns.size() == 3);

    }

    @Then("^I verify there are three rows$")
    public void i_verify_there_are_three_rows() {
        List<WebElement> rows = driver.findElements(By.xpath("//table/tr"));
        System.out.println(rows.size());
        Assert.assertTrue(rows.size() == 3);
    }

    @When("Player starts a new game of Tic Tac Toe")
    public void player_starts_a_new_game_of_Tic_Tac_Toe() throws InterruptedException {
        Game game = new Game();
        game.enterNumberToGenerateGame(3);
        game.clickPlayButton();

    }

    @When("I click the space in column {int} row {int}")
    public void i_click_the_space_in_column_row(Integer column, Integer row) {
        Game game = new Game();
        game.markingSpaceInBoxes(column, row);

    }

    @Then("I verify the \"([^\"]*)\" appears in the \"([^\"]*)\" box")
    public void i_verify_the_appears_in_the_box(String playerMarking, String space) {
        if (playerMarking.equalsIgnoreCase("X")) {
            String actual = driver.findElement(By.id("4")).getText();
            Assert.assertEquals(actual, playerMarking);
        } else if (playerMarking.equalsIgnoreCase("O")) {
            String actual = driver.findElement(By.id("0")).getText();
            Assert.assertEquals(actual, playerMarking);
        } else {
            System.out.println("Error - Player marking is not present! ");
        }
    }

    @When("player \"([^\"]*)\" wins the game")
    public void player_wins_the_game(String player) {
        Game game = new Game();
        game.playerXwins();
    }

    @Then("I verify Player \"([^\"]*)\" receives a celebratory message")
    public void i_verify_Player_receives_a_celebratory_message(String player) {
        String winner = driver.findElement(By.id("endgame")).getText();
        Assert.assertTrue(winner.contains(player));
        System.out.println(winner);

        }
    }

