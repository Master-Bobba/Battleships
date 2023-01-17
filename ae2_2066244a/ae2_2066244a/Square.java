package ae2_2066244a;

public class Square {
	
	public int rowPosition;
	public int colPosition;
	public boolean hasShip;
	public Battleship battleship;
	public boolean wasShotAt;
	
	// constructor, setting the default state of the squares
	public Square(int rowPosition, int colPosition) {
		this.rowPosition = rowPosition;
		this.colPosition = colPosition;
		this.hasShip = false;
		this.wasShotAt = false;
		//System.out.println("Square object created: " + rowPosition + "x"+ colPosition);
	}
	// returns boolean if a ship is places on the square
	public boolean hasShip() {
		return this.hasShip;
	}
	// gets a battleship references and saves it within the instance of the object
	public void setShip(Battleship battleship) {
		this.hasShip = true;
		this.battleship = battleship;
		// used for debuggin purposes
		//System.out.println("Battleship added to Square " + this.rowPosition + "x" + this.colPosition + " Battleship: " + this.battleship);
	}
	
	// to be called when the player has selected the square 
	public void shotAt() {
		this.wasShotAt = true;
				
	}
	// returns different symbol based on the state of the square
	public String toString() {
		if (!this.wasShotAt) {
			return String.format("%2s ", "-");
		} else if(this.wasShotAt && this.hasShip) {
			return String.format("%2s ", "x");
		} else {
			return String.format("%2s ", "o");
		} 
	}
}
