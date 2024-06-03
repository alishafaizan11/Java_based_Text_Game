
public class FightScene extends Location{
	String des = "You're in the FightScene!";
	UI ui;

	private static FightScene instance;
	
	public FightScene(UI ui) {
		this.ui= ui;
	}
	
	public static synchronized FightScene getInstance(UI ui){
		if(instance == null){
		instance = new FightScene(ui);
		}
		return instance;
		}
	
	@Override
	public Location walkNorth() {
		return PlayGround.getInstance(ui);
	}

	@Override
	public void walkNorthDesc() {
	}

	@Override
	public Location walkSouth() {
		//tower
		return Tower.getInstance(ui);
	}

	@Override
	public void walkSouthDesc() {
	}

	@Override
	public Location walkWest() {
		return null;
	}

	@Override
	public void walkWestDesc() {
		ui.print("There is nothing interesting here...");
		
	}

	@Override
	public Location walkEast() {
		//junk yard
		return Junkyard.getInstance(ui);
	}

	@Override
	public void walkEastDesc() {

	}

	@Override
	public void lookAround() {
		// TODO Auto-generated method stub
		
	}
	
}
