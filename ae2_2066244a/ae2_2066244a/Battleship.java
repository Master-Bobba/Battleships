package ae2_2066244a;

public class Battleship {
	
	// class attributes
	public boolean isSunk;
	public int health;
	public int size;
	
	// constructor to be called by the other Battleship class constructors 
	public Battleship(int shipSize) {
		this.isSunk = false;
		this.size = shipSize;
		this.health = this.size;
		//System.out.println("Battleship Created!");
	}
	
	// returns the size of the ship
	public int getSize() {
		return this.size;
	}
	// returns the remaining health of the ship
	public int getHealth() {
		return this.health;
	}
	
	public String toString() {
		
		return "Size = " + this.size + " and health = " + this.health;
	}
	
}
