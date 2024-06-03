import java.util.ArrayList;

public class TownHall extends Location{

	static String des = "Town Hall is a grand and imposing building, situated at the heart of Townsville. Its impressive stone "
			+ "facade is decorated with intricate carvings and statuary, showcasing the city's proud heritage and civic spirit. "
			+ "The entrance to the building is flanked by two towering pillars, topped with golden eagles, which serve as a reminder "
			+ "of the city's strength and resilience.";
	//Ascii
	
	UI ui;

	public String looking = "Currently you're in TownHall";
	private static TownHall instance;
	//ArrayList<Character> characters = new ArrayList<Character>();
	
	protected TownHall(UI ui) {
		this.ui= ui;
		
		characters.add(MsBellum.getInstance(ui));
		characters.add(Mayor.getInstance(ui));
	}
	
	public static synchronized TownHall getInstance(UI ui){
		if(instance == null){
			ui.print(des);
		instance = new TownHall(ui);
		}
		return instance;
		}
	
	@Override
	public Location walkNorth() {
		
		return null;
	}

	@Override
	public void walkNorthDesc() {
		ui.print("There is nothing interesting to see here");
		
	}

	@Override
	public Location walkSouth() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void walkSouthDesc() {
		ui.print("There is nothing interesting to see here");
	}

	@Override
	public Location walkWest() {
		//maze and use state
		return SecOffice.getInstance(ui);
	}

	@Override
	public void walkWestDesc() {
		//ui.print("There is nothing interesting to see here");
		
	}

	@Override
	public Location walkEast() {
		Maze m = new Maze(ui);
		m.mazeGame();
		 
		return null;
		
		
	}

	@Override
	public void walkEastDesc() {
		
	}

	@Override
	public void lookAround() {
		// TODO Auto-generated method stub
		ui.print(looking);
	}



}
