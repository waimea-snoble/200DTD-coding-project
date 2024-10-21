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
    println("$currentPlayer, select the number of the coin you would like to move")
    val select = readln().toInt() - 1

    if (grid[select] == " ") {
        println("There is no coin in this space, try again")
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