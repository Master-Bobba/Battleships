package ae2_2066244a;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Start a Scanner to read the Player's names 
		Scanner keyboard = new Scanner(System.in);
		
		// read players names
		System.out.print("Player 1 please enter your name: ");
		String namePlayerOne = keyboard.nextLine();
		
		System.out.print("Player 2 please enter your name: ");
		String namePlayerTwo = keyboard.nextLine();
		
		// Create players' boards and initialise the players with the corresponding board
		Board boardOne = new Board(10,10);
		Player playerOne = new Player(namePlayerOne, boardOne);
		Board boardTwo = new Board(10,10);
		Player playerTwo = new Player(namePlayerTwo, boardTwo);
		
		
		// populate the boards of the two players and add battleships to each one
		boardOne.populateBoard();
		boardTwo.populateBoard();
		boardOne.generateBattleship();
		boardTwo.generateBattleship();
		
		// Players take turns until 1 of them wins i.e. sinks all enemy ships
		while (true) {
			if (playerOne.takeTurn(playerTwo)) {
				System.out.println("Game Over! " + playerOne + " wins!!");
				break;
			}
			if (playerTwo.takeTurn(playerOne)) {
				System.out.println("Game Over! " + playerTwo + " wins!!");
				break;
			}
		}
		// check if draw at the end. Will never be reached due to nature of the game
		if (playerOne.getScore() == playerTwo.getScore()) {
			System.out.println("Game Over. It is a DRAW!");
		}
				
	}
}
