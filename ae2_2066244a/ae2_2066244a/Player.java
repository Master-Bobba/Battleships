package ae2_2066244a;

import java.util.Scanner;

public class Player {
	
	//person class attributes 
	private Board myBoard = null; // must be private
	private String name;
	private int score;
	
	// player constructor 
	public Player(String name, Board myBoard) {
		this.score = 0;
		this.name = name;
		this.myBoard = myBoard;
		//System.out.println("Created Player: " + this.name);
	}
	
	//to be called from the main Game class 
	public boolean takeTurn(Player opponent) {
		// prompt user to input guess from the console
		// input: 'x y'
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print(this.name + ", please enter coordinates to attack: ");
		
		// get coordinates from the player
		int rowPosition = keyboard.nextInt();
		int colPosition = keyboard.nextInt();
		String rest = keyboard.nextLine();
		
		// check if they hit/sank or missed enemy ship
		if (!opponent.myBoard.board[rowPosition][colPosition].wasShotAt) {
			// update the square to say that it was shot at
			opponent.myBoard.board[rowPosition][colPosition].shotAt();
			// check if the player hit an enemy ship
			if (opponent.myBoard.board[rowPosition][colPosition].hasShip()) {
				opponent.myBoard.board[rowPosition][colPosition].battleship.health -= 1;
				
				// check if the player sank an enemy ship i.e. health is at zero and update score 
				if (opponent.myBoard.board[rowPosition][colPosition].battleship.health == 0) {
					this.score += 1;
					System.out.println("You sank an enemy ship! ");
				} else {
					System.out.println("You hit an enemy ship!");
				}
			} else {
				System.out.println("Unlucky! You missed!");
			}
		// invalid shot if already shot at the coordinates
		} else {
			System.out.println("Invalid Shot!");
		}
		// print out the player's score and the board 
		System.out.println(this.name + "'s Score: " + this.score);
		System.out.println(opponent.myBoard);

		// will return true if the user has hit and sunk the final battleship and has ended the game
		if (this.score == 6) {
			return true;
		} else {
			return false;
		}
	}
	// returns the score of the player
	public int getScore() {
		return this.score;
	}

	public String toString() {
		return this.name;
	}
}