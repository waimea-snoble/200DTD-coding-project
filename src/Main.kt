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
    val grid = MutableList(20) { " " } // Represents the game board

    val coins = mutableListOf<String>()
    coins.add("X")
    coins.add("X")
    coins.add("X")
    coins.add("X")
    coins.add("X")
    coins.add("O")

    // Get player names
    println("Enter the name of player 1")
    val name1 = readln()

    println("Enter the name of player 2")
    val name2 = readln()

    println("Hello $name1 and $name2 welcome to Old Gold")


    // Highlighted change: Place coins in the grid before displaying it
    for (coin in coins) {
        var position: Int
        do {
            position = Random.nextInt(0, 20) // Get a random position from 0 to 20
        } while (grid[position] != " ") // Ensure the position is empty
        grid[position] = coin // Place the coin in the grid
    }


    // Highlighted change: Display the game board after placing coins
    gameBoard(grid) // Now it will display the grid with coins

    var currentPlayer = name1
    var cointomove = false
    var selectedCoin = 0

    while (true) { // Loop indefinitely until the game ends
        cointomove = false


        while (!cointomove) {

            println("$currentPlayer, select the number of the coin you would like to move, or type 0 to remove the coin at position 1 ")
            val select = readln()

            if (select == "0") {
                // Remove the coin at position 1
                removeCoin(grid)
                gameBoard(grid)
                // Switch players
                currentPlayer = if (currentPlayer == name1) name2 else name1
                println("now it is $currentPlayer's turn")
            } else {

                val select = select.toInt() - 1 // Convert input to 0-based index
                if (grid[select] == " ") {
                    println("There is no coin in this space, try again")
                } else cointomove = true
                selectedCoin = select
            }
        }


    // Ask the player where to move the coin
    var movingcoin = false
    while (!movingcoin) {
        println("$currentPlayer, select the number of the space where you want to move the coin:")
        val move = readln().toInt() - 1 // Subtract 1 to convert to 0-based index

        // Validate that the destination space is empty
        if (grid[move] != " ") {
            println("That space is already occupied. Try again.")
        }
        else if (move >= selectedCoin) { // Only allow moving to the left
            println("You can only move the coin to a space to the left. Try again.")
        }
        else { movingcoin = true
            grid[move] = grid[selectedCoin] // Move the coin to the new position
            grid[selectedCoin] = " " // Clear the original position
            movingcoin = true // Exit the loop
            gameBoard(grid)
        }
    }
    // Switch players
    currentPlayer = if (currentPlayer == name1) name2 else name1
        println("now it is $currentPlayer's turn")
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

//Function to remove the coin at position 1

fun removeCoin(grid: MutableList<String>) {
    val position = 0 // Position 1 corresponds to index 0
    if (grid[position] != " ") {
        grid[position] = " " // Set the position to empty space
        println("Coin removed from position 1.")
    } else {
        println("There is no coin to remove at position 1.")
    }
}