package ae2_2066244a;

public class LargeBattleship extends Battleship{
	
	// define the attributes for each largeship
	static int largeShipCount = 1;
	static int largeShipSize = 3;
	
	// construct by passing it to the constructor of the Battleship class
	public LargeBattleship() {
		
		super(largeShipSize);
	}
	
}
