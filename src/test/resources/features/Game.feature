Feature: Game

Scenario: Verify Users are able to generate tic tac toe game using a valid integer
Given I navigate to codepen link provided by HR

When I enter 3 in the number field
And  I click the play button
Then I verify that tic tac toe game appears
And I verify there are three columns
And I verify there are three rows

Scenario: Verify both players are able to see their markings when playing
Given I navigate to codepen link provided by HR

When Player starts a new game of Tic Tac Toe
And  I click the space in column 1 row 1
Then I verify the "X" appears in the "center" box
And  I click the space in column 0 row 0
Then I verify the "O" appears in the "top left" box


Scenario: Verify winning player receives celebratory message
Given I navigate to codepen link provided by HR

When Player starts a new game of Tic Tac Toe
And  player "X" wins the game
Then I verify Player "X" receives a celebratory message

