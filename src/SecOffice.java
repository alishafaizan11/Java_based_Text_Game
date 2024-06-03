
public class SecOffice extends TownHall {

private static SecOffice instance;

public String des = "Ms. Bellum's office is overlooking the bustling streets of Townsville "
		+ "As you enter the room, you are immediately struck by its orderly and efficient layout. The walls are adorned with "
		+ "various awards and plaques, highlighting Ms. Bellum's contributions to the city and her many achievements.\n"
		+ "\n"
		+ "Ms. Bellum's jumps up from her chair and rushes over to greet you.";
	
public String looking = "Currently you're in the Secretary's Office.";
	private SecOffice(UI ui){
		super(ui);
		this.ui = ui;
		ui.print(des);
		//characters.add(MsBellum.getInstance(ui));
	
	}
	public static synchronized SecOffice getInstance(UI ui){
		if(instance == null){
		instance = new SecOffice(ui);
		}
		return instance;
		}
	@Override
	public Location walkNorth() {
		
		return null;
		
	}
	@Override
	public void walkNorthDesc() {
		ui.print("There is nothing to see here, go to another direction");
		
	}
	@Override
	public Location walkSouth() {
		

		return MayorsOffice.getInstance(ui);
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
		ui.print("There is nothing to see here, go to another direction");
		
		
		
	}
	@Override
	public Location walkEast() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void walkEastDesc() {
		ui.print("There is nothing to see here, go to another direction");
		
		
	}
	@Override
	public void lookAround() {
		ui.print(looking);
		
	}
}
