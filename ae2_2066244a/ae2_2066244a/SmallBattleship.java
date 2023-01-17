package ae2_2066244a;

public class SmallBattleship extends Battleship{

	// define the attributes for each smallship
	static int smallShipCount = 3;
	static int smallShipSize = 1;
	
	// construct by passing it to the constructor of the Battleship class
	public SmallBattleship() {
		super(smallShipSize);
	}
	
}
