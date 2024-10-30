/**
 * ------------------------------------------------------------------------
 * PROJECT NAME HERE
 * Level 2 programming project
 *
 * by YOUR NAME HERE
 *
 * BRIEF PROJECT DESCRIPTION HERE
 * BRIEF PROJECT DESCRIPTION HERE
 * BRIEF PROJECT DESCRIPTION HERE
 * ------------------------------------------------------------------------
 */

/**
 * Program entry point
 */

/**
 * ------------------------------------------------------------------------
 * PROJECT NAME HERE
 * Level 2 programming project
 *
 * by YOUR NAME HERE
 *
 * BRIEF PROJECT DESCRIPTION HERE
 * BRIEF PROJECT DESCRIPTION HERE
 * BRIEF PROJECT DESCRIPTION HERE
 * ------------------------------------------------------------------------
 */

/**
 * Program entry point
 */

import kotlin.random.Random

fun main() {
    println("What size would you like the game to be?")
    val gridSize = readln().toInt()
    val grid = MutableList(gridSize) { " " } // Represents the game board


    var numCoins = 0
    while (true) {
        // Get the number of coins from the user
        println("How many coins would you like to place on the grid?")
        numCoins = readln().toInt()

        if (numCoins > 0 && numCoins < gridSize) {
            break // Valid input, exit the loop
        } else {
            println("Invalid input. Please enter a number between 1 and $gridSize")
        }
    }

    val coins = mutableListOf<String>()
    repeat(numCoins - 1) { coins.add("X") } // Add 'X' coins
    coins.add("O") // Add the 'O' coin

    // Get player names
    println("Enter the name of player 1")
    val name1 = readln()

    println("Enter the name of player 2")
    val name2 = readln()

    println("Hello $name1 and $name2 welcome to Old Gold")

    // Place coins in the grid
    for (coin in coins) {
        var position: Int
        do {
            position = Random.nextInt(0, gridSize) // Get a random position from 0 to gridSize
        } while (grid[position] != " ") // Ensure the position is empty
        grid[position] = coin // Place the coin in the grid
    }

    // Display the game board after placing coins
    gameBoard(grid) // Now it will display the grid with coins

    var currentPlayer = name1
    var win = false

    while (!win) {
            var cointomove = false
            var selectedCoin = 0


            while (true) { // Loop indefinitely until the game ends
                cointomove = false


                while (!cointomove) {
                    println("$currentPlayer, select the number of the coin you would like to move, or type 0 to remove the coin at position 1 ")
                    val select = readln()


                    if (select == "0") {
                        // Remove the coin at position 1 and check if it results in a win
                        val removedCoin = removeCoin(grid)
                        if (removedCoin == "O") {
                            win = true
                            println("$currentPlayer wins!")
                            break
                        }

                        if (removedCoin == " ") {
                            println("There is no coin to remove at position 1.")
                        }

                        if (removedCoin == "X") {
                            gameBoard(grid)
                            currentPlayer = if (currentPlayer == name1) name2 else name1
                            println("now it is $currentPlayer's turn")
                        }

                    } else {
                        val select = select.toInt() - 1 // Convert input to 0-based index
                        if (grid[select] == " ") {
                            println("There is no coin in this space, try again")
                        } else {
                            cointomove = true
                            selectedCoin = select
                        }
                    }


                }

                // Check if the game has ended after removing a coin
                if (win) {
                    break // Exit the outer loop if a player won
                }

                // Ask the player where to move the coin
                var movingcoin = false
                while (!movingcoin) {
                    println("$currentPlayer, select the number of the space where you want to move the coin:")
                    val move = readln().toInt() - 1 // Subtract 1 to convert to 0-based index

                    // Validate that the destination space is empty
                    if (grid[move] != " ") {
                        println("That space is already occupied. Try again.")
                    } else if (move >= selectedCoin) { // Only allow moving to the left
                        println("You can only move the coin to a space to the left. Try again.")
                    } else {
                        movingcoin = true
                        grid[move] = grid[selectedCoin] // Move the coin to the new position
                        grid[selectedCoin] = " " // Clear the original position
                        gameBoard(grid)
                    }
                }
                // Switch players
                currentPlayer = if (currentPlayer == name1) name2 else name1
                println("now it is $currentPlayer's turn")
            }

    }
}

/**
 * Function to display the game board
 */
fun gameBoard(grid: MutableList<String>) {
    println("+-------------------------------------------------------------------------------+")
    // Print the grid with coins
    print("|")
    for (i in grid.indices) {
        print(" ${grid[i]} |") // Print each coin or empty space with borders
    }
    println() // New line after the row
    println("+-------------------------------------------------------------------------------+")

    var index = 1
    for (coin in grid) {
        print("|%-2d ".format(index))
        index++
    }
    print("|")
    println() // New line after the numbers
}

// Function to remove the coin at position 1
fun removeCoin(grid: MutableList<String>): String {
    val position = 0 // Position 1 corresponds to index 0

    // Capture the value at position 1 before clearing it
    val coin = grid[position]

    if (coin != " ") {
        grid[position] = " " // Set the position to empty space
        println("Coin removed from position 1.")
        return coin // Return the removed coin
    } else {
        return " " // Return a blank space if nothing was there
    }
}

//https://en.wikipedia.org/wiki/Box-drawing_characters
//test edge cases
//+-------------------------------------------------------------------------------+
//|   | X |   | X |   |   |   | X |   |   | X |   |   |   |   |   | X |   | O |   |
//+-------------------------------------------------------------------------------+
//|1  |2  |3  |4  |5  |6  |7  |8  |9  |10 |11 |12 |13 |14 |15 |16 |17 |18 |19 |20 |
//for example test the movement of coin 11 to 7, 9, 19, 12, 16 the edge of coins for each valid move
