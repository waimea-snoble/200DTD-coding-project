# Test Plan and Evidence / Results of Testing

## Game Description

The project involves the programming of a two-player game.


Old Gold is a two player turn based game. The game is on a 1d grid with 1 gold O coin and some X coins (chosen by the
player) where each player must take turns moving a coin to the left, or removing a coin at position 1. A player cant move a
coin to the right, jump over other coins, move it to an occupied space, or skip a turn. After each move it 
changes to the other players turn. if the coin being removed at position 1 is the O coin the current player wins.

### Game Features and Rules

The game has the following features and/or rules:


- a player can only move one coin per turn
- a player cannot jump over other coins
- a player cannot move a coin to the right
- a player cannot remove a coin on the same move that they have moved it
- a player cannot move a coin to a space that is occupied by another coin
- the player can move the coin as many spaces as they want, as long as there are no coin in the way
- the player who removes the gold coin is the winner
- a player cannot skip a turn

---

## Test Plan

The following game features / functionality and player actions will need to be tested:


- moving a coin to the left vs right
- jumping over coins
- ending turn and changing players
- inputting numbers that are not in the grid e.g. -1, 0, 500
- moving a coin to an occupied space on the grid
- no coin on space that is selected
- removing a coin X vs O/ winning the game
- inputting something that isn't a number e.g. h when selecting what coin to move
- selecting a coin to move that cant be moved e.g. selecting a coin in position 15 when there is a coin in  position 14,
this means that the coin cant move left.
- player selecting a grid size / selcting a grid size less than 10 or more than 35
- player selecting amount of coins in grid / selecting an amount of coins that is higher or less than the grid size
- doing a blank input

e.g. game win, no coin on space that is selected, jumping over coin.

The following tests will be run against the completed game. The tests should result in the expected outcomes shown.


### moving a coin to the left vs right

moving a coin to the left vs right


#### Test Data / Actions to Use

the coin being selected is number 18 on the grid, i am going to input 19 and 17 when asked where i want to move the coin

#### Expected Outcome

if the user is moving the coin in position 18 to position 19, i expect a message saying you can only move the coin to a
space to the left. Try again
it will remain the current players turn and will be asked to re enter a number
I expect the coin to move to position 17 as long as there is a blank space.


### jumping over coins

what happens if the user selects a coin and moves it over another coin

#### Test Data / Actions to Use

the coin being selected is in position 17 and there is another coin in position 14, i am going to move the coin to
position 13 and then position 15

#### Expected Outcome

i expect that when i selected the coin in position 17 to move to position 13 there will be a message saying
Invalid move. Make sure there are no coins between the selected coin and the position you are wanting to move it to, 
and repeat the statement scott, select the number of the coin you would like to move (type 1 to remove the coin at
position 1)
If the coin in position 17 is being moved to position 15 and there are no coins inbetween it should move the coin to
position 9


### ending turn and changing players

how a turn ends and what happens when it ends

#### Test Data / Actions to Use

there is an X coin in position 1, a coin in position 4, and a coin in position 8. I will remove the coin in position 1,
select a blank space when selecting a coin, select a number not in the grid, input a letter, try to move the coin in 
position 8 to position 3, try move it to position 4, try to move it to position 13, try to move it to position 12, try
to move it to position 11, try to move it to position 9, try to move it to its current position (8), move it to 7, and
move it to 5

#### Expected Outcome

if a player removes an X coin in position 1 i expect it to change to the next players turn. if the player inputs an
invalid selection when choosing a coin to move e.g. inputting a letter (h), trying to remove a coin when it is blank,
selecting a blank space when selecting to move a coin, or selecting a coin that cant move left,
it will say that the selection is invalid and ask them to try again until the selection is valid. 
If the coin selection is valid but the position the player is trying to move the coin to is invalid e.g. moving the coin
over another coin, moving to an occupied space, moving it to the right, it will say the move is invalid and ask the 
player to try again until the move is valid.

this means that i would not expect the players turn to change when the inputs are invalid, only when the inputs are
valid


### inputting numbers that are not in the grid e.g. -1, 0, 500

what happens when a player inputs a number that is not on the grid

#### Test Data / Actions to Use

the grid size is 20 and the user inputs -1, 0, or 21

#### Expected Outcome

If the user inputs the numbers -1, 0, or 21 on a grid size of 20 I expect a message saying 
Invalid input. Please enter a valid number, and it repeats the statement, scott, select the number of the coin you 
would like to move (type 1 to remove the coin at position 1)
If the player inputs a number within the size of the grid, as long as there is a coin in that position it will tell the 
player select the number of the space where you want to move the coin



### moving a coin to an occupied space on the grid

what happens when the user moves a coin to an occupied space on the grid

#### Test Data / Actions to Use

the coin the player selects is in position 14 and there is a coin in position 11, i am going to move the coin to 
position 11 and position 12

#### Expected Outcome

If the player moves the coin in position 14 to position 11 it will tell the user, that space is already occupied.
Try again, and re ask the player to select which position they would like to move the coin to. If the coin is being 
moved to position 12 it will end the current players turn


### no coin on space that is selected

what happens if a player wants to select a coin to move but the position has no coin on it.

#### Test Data / Actions to Use

there is no coin on position 8, i am going to select position 8 as if i would like to select a coin to move

#### Expected Outcome

If there is no coin in position 8 and a player selects it, i expect a message telling the player Invalid selection.
Please try again, you must select a position with a coin in it, that can also be moved to the left.


### removing a coin X vs O

what happens when a user removes coin X compared to removing coin O

#### Test Data / Actions to Use

The coin in position 1 is X, I am going to remove it
The coin in position 1 is O, i am going to remove it

#### Expected Outcome

If the coin being removed in position 1 is X I expect a message saying Coin removed from position 1, and for it to 
change the players turn. 
If the coin being removed in position 1 is O i expect the current player to win and a message is displayed saying Coin
removed from position 1. (the current player wins) wins! because they removed the O coin


### inputting something that isn't a number e.g. h when selecting what coin to move

what happens when the player inputs something that isn't a number e.g. h when selecting what coin to move

#### Test Data / Actions to Use

when asked what size i want the grid to be, how many coins I want on the grid, what coin i want to select / remove, 
where i want to move the coin to. i will input the letter h

#### Expected Outcome

if the user inputs a letter such as h when being asked for a number, i expect there to be a message saying 
Invalid input. Please enter a valid number.


### selecting a coin to move that cant be moved e.g. selecting a coin in position 15 when there is a coin in  position 
### 14, this means that the coin cant move left.

what happens if the player selects a coin to move that cant be moved e.g. selecting a coin in position 15 when there
is a coin in  position 14, this means that the coin cant move left.

#### Test Data / Actions to Use

there is a coin in position 14 and 15, i am going to select to move the coin in position 16, and 15

#### Expected Outcome

If the player selects the coin in position 15 I expect a message saying Invalid selection. Please try again, you must 
select a position with a coin in it, that can also be moved to the left. if the coin being selected is in position 14 
i expect it to ask where the player wants to move the coin to


### selcting a grid size less than 10 or more than 35

what happens if a player selects a grid size less than 10 or more than 35

#### Test Data / Actions to Use

since the minimum grid size is 10 and the maximum is 35, i am going to imput a grid size of 9, 10 35 and 36

#### Expected Outcome

if the user inputs a grid size of 9 or 36 i expect a message telling the player Invalid input. Please enter a number between 
10 and 35. If the user inputs a grid size of 10 or 35 i expect it to move on and ask them how many coins the player 
wants on the grid


### selecting an amount of coins that is higher or less than the grid size

what happens when the player selects an amount of coins that is higher or less than the grid size

#### Test Data / Actions to Use

the grid size selected is 20, i am going to select the amount of coins of 0, 1, 20, and 21

#### Expected Outcome

If the player inputs an amount of coins that is 0 or 21 i expect a message telling them Invalid input. Please enter a 
number between 1 and 20.
If the player inputs 1 or 20 i expect it continue and ask the names of the players


### doing a blank input

what happens if the play doesn't input anything (presses enter before typing)

#### Test Data / Actions to Use

i will test what happens when a player inputs nother when choosing gride size, amount of coins, selecting/ deleting a 
coin, moving a coin

#### Expected Outcome

if the player inputs nothing i expect a message saying invalid input, and it will ask the user to try again until the 
player inputs a valid input


---


## Evidence / Results of Testing

### the order of the tests done in the video are in the order of the following
1. moving a coin to the left vs right
2. jumping over coins
3. ending turn and changing players
4. inputting numbers that are not in the grid e.g. -1, 0, 500
5. moving a coin to an occupied space on the grid
6. no coin on space that is selected
7. removing a coin X vs O
8. inputting something that isn't a number e.g. h when selecting what coin to move
9. selecting a coin to move that cant be moved e.g. selecting a coin in position 15 when there is a coin in  position
   14, this means that the coin cant move left.
10. selcting a grid size less than 10 or more than 35
11. selecting an amount of coins that is higher or less than the grid size

ACTUAL RESULTS OF TESTING SHOWN HERE

https://mywaimeaschool-my.sharepoint.com/:v:/g/personal/snoble_waimea_school_nz/EQZECr0i5bJInfSj46DFw00BO2RBbQUs7poBD-qEvKWn5g?e=7lEUY0&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D
# NOTE FOR VIDEO
The first 30 seconds is frozen and it freezes sometimes throughout for me, so i dont know if it will be the same for you

1. All of my expected outcomes were correct
moving a coin to the right would result in an invalid move so the player would have to choose a different position to 
move the coin. If the coin was moved to the left, aslong as it didnt jump over any coins or moved to an occupied space,
the coin was successfully moved
2. if a coin jumoped over another coin it would rewuire the player to choose another position to move the coin to
without jumping over any coins.
3. If there was any invalid move done by the player it would still be their turn and they could try again. if the move
was valid it would then switch the players turn
4. If the player inputted a number smaller or larger than the grid size it would tell them that the input was invalid
and ask the user to input a number until it was within the grid size
5. If a coin was moved to an occupied space there would be a message saying that the space is already occupied, and 
would ask the user to input a correct space that isnt occupied
6. if the player selected a space with no coin on it told them that they need to select a position with a coin in it, 
it would ask the player this until they input a valid selection.
7. If a player removed coin X it switched turns, if the coin was O it sid that the current player one the game, if there
was nothing in position one it asked the player to do  valid move
8. if the player inputted something that wasnt a message said invalid input please input a valid number, intil the 
player inputted anumber
9. if the player selects a coin that cant be moved it askes them to select another coin until a valid coin is selected
10. if the user selects a grid size less than 10 or more than 35 a message tells them that the grid needs to be
between 10 and 35 until they have done this.
11. if the player selects a number of coins higher than the grid size it will tell them the minimum amount of coins is 
1 and the maximum is the grid size until they input a valid number of coins.



## Evidence / Results of Testing
# doing a blank input

https://mywaimeaschool-my.sharepoint.com/:v:/g/personal/snoble_waimea_school_nz/Ef0LW_3deoxHtn2Ypd5ltJIBEIDHHWihHBIT4VBMSkoENw?e=mzPWpd&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D

my expected outcome was correct because when i did a blank input it said that i needed to input a valid number until i
did