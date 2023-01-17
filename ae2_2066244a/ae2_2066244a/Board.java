package ae2_2066244a;

import java.util.Random;

public class Board {
	
	// create a reference for the square array and one for the battleship array
	Square[][] board = null;
	Battleship[] battleFleet = null;
	
	public Board(int numRows, int numCols) {
		// create the array of Square objects
		this.board = new Square[numRows][numCols];
		//System.out.println("Board Created!");
	}
	
	// Use this to create a board of Square objects
	public void populateBoard() {
		for (int i = 0; i < this.board.length; i++) {
			for (int j = 0; j < this.board[0].length; j++) {
				// for each i and j in the array create the Square object
				this.board[i][j] = new Square(i, j);
			}
		}
		//System.out.println("Board Populated!");
	}
	
	public void generateBattleship() {
		
		//need to create 6 battleships - random position and random orientation
		Random randomValue = new Random();
				
		// create 6 Battleships
		this.battleFleet = new Battleship[6];
		
		// create array for count and ship size of each type of ship that we want on the board
		int [] shipTypeCount = {LargeBattleship.largeShipCount, MediumBattleship.mediumShipCount, SmallBattleship.smallShipCount};
		int [] shipTypeSize = {LargeBattleship.largeShipSize, MediumBattleship.mediumShipSize, SmallBattleship.smallShipSize};

		int shipCount = 0;
		
		// populate the battleFleet array with battleships of different sizes
		for (int i = 0; i < shipTypeCount.length; i++) {
			for (int j = 0; j < shipTypeCount[i]; j ++) {
							
				// if we need to place a large BattleShip
				if (shipTypeSize[i] == 3) {
					this.battleFleet[shipCount] = new LargeBattleship();
				// if we need to place a medium Battleship
				} else if (shipTypeSize[i] == 2) {
					this.battleFleet[shipCount] = new MediumBattleship();
				// if we need to place a small Battleship
				} else if (shipTypeSize[i] == 1){
					this.battleFleet[shipCount] = new SmallBattleship();	
				}
				shipCount += 1;
			}
			
		}
		// now need to place each of the battleship on the board
		for (int i = 0; i < battleFleet.length; i ++) {
			
			int rowPosition;
			int colPosition;
			
			// true = vertical and false = horizontal
			boolean orientation; 
			
			// do this while no issues
			while(true) {
				// use true for vertical and false = horizontal
				orientation = randomValue.nextBoolean();
				
				// get random values for the first element of the battleship, ensuring the battleship can fit in the board- limiting the size of the board based on orientation
				if (orientation) {
					rowPosition = randomValue.nextInt(this.board.length - battleFleet[i].size - 1);
					colPosition = randomValue.nextInt(this.board[rowPosition].length);
				} else {
					rowPosition = randomValue.nextInt(this.board.length);
					colPosition = randomValue.nextInt(this.board[rowPosition].length- battleFleet[i].size - 1);
				}
				//System.out.println(rowPosition + " " + colPosition + " " + orientation);	
				
				// check if the ship will not overlap with another ship
				// first check the first element
				if (board[rowPosition][colPosition].hasShip()) {
					continue;
				// then check the rest depending on the orientation
				} else {
					if (orientation) {
						for (int j = 1; j < battleFleet[i].size; j++) {
							if (board[rowPosition + j][colPosition].hasShip()) {
								System.out.println("has ship");
								continue;
							}
						}
					} else {
						for (int j = 1; j < battleFleet[i].size; j++) {
							if (board[rowPosition][colPosition + j].hasShip()) {
								System.out.println("has ship");
								continue;
							}
						}
					}
				}
				// if no overlap then end the loop and place the ships on the board
				break;
			}
			// place the ship on the board again depending on the orientation
			board[rowPosition][colPosition].setShip(battleFleet[i]);
			if (orientation) {
				for (int j = 1; j < battleFleet[i].size; j++) {
					board[rowPosition + j][colPosition].setShip(battleFleet[i]);
				}
			} else {
				for (int j = 1; j < battleFleet[i].size; j++) {
					board[rowPosition][colPosition + j].setShip(battleFleet[i]);
				}
			}
			
		}
	
	}
	
	public String toString() {
		// to be used to print the board. get the info from each square object and creates a single string to return
		String toPrint = "";
		for (int i= 0; i < this.board.length; i++) {
			for (int j =0; j<this.board[0].length; j++) {
				toPrint = String.format("%s%s", toPrint, this.board[i][j]);
			}
			toPrint = String.format("%s\n", toPrint);
		}
		return toPrint;
	}
	
	
	
}
