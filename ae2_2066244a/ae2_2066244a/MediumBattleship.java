package ae2_2066244a;

public class MediumBattleship extends Battleship{
	
	// define the attributes for each mediumship
	static int mediumShipCount = 2;
	static int mediumShipSize = 2;
	
	// construct by passing it to the constructor of the Battleship class
	public MediumBattleship() {
		
		super(mediumShipSize);
	}
	
}
