/**
 * ------------------------------------------------------------------------
 * PROJECT Old Gold
 * Level 2 programming project
 *
 * by Scott Noble
 *
 * The project I am making is a two-player turn-based game called Old Gold.
 *
 * The game consists of 2 coin types: one O and a number of X coins chosen by the players.
 * The aim is to be the player who removes the O coin at position 1. To do this, each player takes turns moving a coin to
 * the left without jumping over another coin until someone is forced to move the O coin to position 1, resulting in the
 * other player winning.
 * ------------------------------------------------------------------------
 */

/**
 * Program entry point
 */
import kotlin.random.Random

fun main() {
    var gridSize: Int
    while (true) {
        // get the size of the grid from the user
        println("What size would you like the game to be? The minimum grid size is 10 and the maximum grid size is 35")
        try {
            gridSize = readln().toInt()
            if (gridSize in 10..35) break // makes sure the grid size is within the correct range
            else println("Invalid input. Please enter a number between 10 and 35.")
        } catch (e: Exception) {
            println("Invalid input. Please enter a valid number.")
        }
    }

    val grid = MutableList(gridSize) { " " } // represents the game board

    var numCoins: Int
    while (true) {
        // get a number of coins from the player
        println("How many coins would you like to place on the grid?")
        try {
            numCoins = readln().toInt()
            // makes sure the number of coins is within the grid size
            if (numCoins in 1 until gridSize + 1) break
            else println("Invalid input. Please enter a number between 1 and $gridSize.")
        } catch (e: Exception) {
            println("Invalid input. Please enter a valid number.")
        }
    }

    // creates a list of coins
    val coins = mutableListOf<String>().apply {
        repeat(numCoins - 1) { add("X") } // adds X coins
        add("O") // adds O coin
    }

    // get the names of the players
    println("Enter the name of player 1")
    val name1 = readln()
    println("Enter the name of player 2")
    val name2 = readln()
    println("Hello $name1 and $name2, welcome to Old Gold!")

    // show the game rules
    println("The rules are stated below")
    println("Taking turns, starting with $name1, each player can do one of the following:")
    println("Move any coin a number of spaces to the left as long as:")
    println("- It doesn't jump over any other coins")
    println("- It is not being moved to an occupied position")
    println("On each player's turn they can remove a coin from position 1, ending their turn.")
    println("- A player cannot move a coin and then remove it on the same move; if a player moves a coin, it ends their turn.")
    println("- If the coin being removed is X, it changes to the other player's turn.")
    println("- If the coin being removed is O, the player who removed it wins, and the game ends.")
    println("The aim of the game is to force a player to move the O coin to position 1 so the other player can remove it and win.")

    // randomly place the coins on the grid
    for (coin in coins) {
        var position: Int
        do {
            position = Random.nextInt(0, gridSize) // chooses a random position on the grid for the coins to go
        } while (grid[position] != " ") // makes sure the position is empty
        grid[position] = coin // places the coin on the grid
    }

    var currentPlayer = name1 // starts with player 1

    // main game loop
    while (true) {
        gameBoard(grid) // display the game board
        if (playerMove(grid, currentPlayer)) {
            println("$currentPlayer wins because $currentPlayer removed the O coin.")
            break
        }

        // switch players
        currentPlayer = if (currentPlayer == name1) name2 else name1
    }
}

/**
 * Function to display the game board
 */
fun gameBoard(grid: MutableList<String>) {
    // display the top of the grid
    repeat(grid.size) {
        print("+---")
    }
    print("+")
    println()

    // print the grid with coins
    print("|")
    for (i in grid.indices) {
        print(" ${grid[i]} |") // display each coin or empty space with borders
    }
    println() // new line after the row
    repeat(grid.size) {
        print("+---")
    }
    print("+")
    println()

    var index = 1
    for (coin in grid) {
        print("  %-2d".format(index))
        index++
    }
    println() // new line after the numbers
}

// function to remove the coin that is in position 1
fun removeCoin(grid: MutableList<String>): String {
    val position = 0
    val coin = grid[position]
    // check to see if there is a coin in position 1
    if (coin != " ") {
        grid[position] = " " // Make position 1 blank
        println("Coin removed from position 1.")
        return coin // return the type of coin removed
    }
    return " " // no coin to remove
}

// function for selecting a coin to move
fun selectCoin(grid: MutableList<String>, currentPlayer: String): Int {
    while (true) {
        println("$currentPlayer, select the number of the coin you would like to move (type 1 to remove the coin at position 1)")
        try {
            val select = readln().toInt() - 1
            if (select == 0) {
                val removedCoin = removeCoin(grid)
                if (removedCoin == "O") return -1 // O coin removed so game win
                if (removedCoin == " ") {
                    println("There is no coin to remove at position 1.") // no coin to remove
                    gameBoard(grid)
                } else {
                    return 0
                }
            }
            // check if there is a coin and the coin can move left
            else if (grid[select] != " " && select in grid.indices && grid[select - 1] == " ") {
                return select
            } else {
                println("Invalid selection. Please try again. You must select a position with a coin in it that can also be moved to the left.")
                gameBoard(grid)
            }
        } catch (e: Exception) {
            println("Invalid input. Please enter a valid number.")
        }
    }
}

// function to move the selected coin
fun moveCoin(grid: MutableList<String>, selectedCoin: Int, currentPlayer: String): Boolean {
    while (true) {
        println("$currentPlayer, select the number of the space where you want to move the coin:")
        try {
            val move = readln().toInt() - 1

            // check to see if the move is within the range of the grid size
            if (move !in grid.indices) {
                println("Invalid input. Please enter a valid number within the grid size.")
                gameBoard(grid)
            } else if (grid[move] != " ") {
                println("That space is already occupied. Try again.")
                gameBoard(grid)

                // makes sure the coin can only move to the left
            } else if (move >= selectedCoin) {
                println("You can only move the coin to a space to the left. Try again.")
                gameBoard(grid)
            } else if ((move + 1 until selectedCoin).all { grid[it] == " " }) {
                grid[move] = grid[selectedCoin]
                grid[selectedCoin] = " " // make the original position blank
                return false // move is complete
            } else {
                println("Invalid move. Make sure there are no coins between the selected coin and the position you are wanting to move it to.")
                gameBoard(grid)
            }
        } catch (e: Exception) {
            println("Invalid input. Please enter a valid number.")
        }
    }
}

fun playerMove(grid: MutableList<String>, currentPlayer: String): Boolean {
    val selectedCoin = selectCoin(grid, currentPlayer) // select a coin to move
    if (selectedCoin == -1) return true
    if (selectedCoin > 0) moveCoin(grid, selectedCoin, currentPlayer) // move the selected coin if the move is valid
    return false
}
