
public class Junkyard extends City{
	private static Junkyard instance;
	UI ui;
	String JunkyardDirection;
	
//	PickleState pickleState = new GoodPickle(ui);
//	
//	public void setState(PickleState state) {
//		this.pickleState = state;
//	}
	 
	// make constructor private so no else can call it from outside
	public String des = "The Junkyard is a dilapidated and run-down scrapyard where the Gangreen Gang often hangs out.\n" 
	+ "The area is littered with heaps of rusted metal, old tires, and discarded machinery.\n" 
	+ "The air is thick with the stench of oil and grease, and the ground is slippery with puddles of murky water and oil spills. \n" 
	+ "The junkyard is vast and sprawling, with piles of debris stretching out in every direction.\n"
	+ "The rusted fences surrounding the area are broken and twisted, giving the impression of a lawless wasteland.\n"
	+ "The overall atmosphere is gloomy and desolate, with a sense of danger lurking around every corner. \n";
	
	
	public String looking = "You are currently in Junkyard";
	
	private Junkyard(UI ui) {
		super(ui);
		this.ui= ui;
		characters.add(Gangreengang.getInstance(ui));
		ui.print(des);
	}
	// one static method which can be called without creating an instance
	// of the class.
	public static synchronized Junkyard getInstance(UI ui){
		if(instance == null){
			instance = new Junkyard(ui);
		}
		return instance;
	}
	@Override
	public Location walkNorth() {
		//fight scene
		GanggreenGangFightSceneLocation GGFSL = GanggreenGangFightSceneLocation.getInstance(ui);
		if(GGFSL.fightScene == true)
		{
			ui.print("As you walk up north of junkyard, you see the Gangreen Gang lurking among the heaps of scrap metal and broken "
					+ "machinery. They sneer at you, their grubby faces twisted in malicious amusement. You know that a fierce "
					+ "battle awaits, and you steel yourself for the fight ahead, drawing your weapon and preparing to face the "
					+ "villains head-on.");
			return GGFSL;
		}
		else
		{	ui.print("You have encountered Gangreengang!");
			return null;
		}
		
		 //return fightscene class
	}
	@Override
	public void walkNorthDesc() {

	}
	@Override
	public Location walkSouth() {
		//JunkyardDirection = "south";
		return null;
	}
	@Override
	public void walkSouthDesc() {
		ui.print("You see items scattered around...\n" +
		"There are some old hair clips, shoes, and purses lying around.\n");
		items.add(new Items(ui,"hair clip", "There are the hair clips that the girls wear..."));
		items.add(new Items(ui,"shoes", "They smell a lot..."));
		items.add(new Items(ui,"purse", "It is an empty purse with a picture of the girls."));//ascii art
		
//		boolean pickleFound = false;
//		for (int i = 0; i < items.size(); i++)
//		{
//			if (this.items.get(i).name.contains("pickle"))
//			{
//				pickleFound = true;
//				break;
//			}
//		}
//		if (pickleFound = false)
//		{
//			ui.print("Oh and you also see a pickle");
//			pickleState.next(this);
//			items.add(pickleState.returnPickle());
//		}
//		
	}
	
	
	
	@Override
	public Location walkWest() {
		
		return City.getInstance(ui);
	}
	@Override
	public void walkWestDesc() {

	}
	@Override
	public Location walkEast() {
		//JunkyardDirection = "east";
		return null;
	}
	@Override
	public void walkEastDesc() {
		ui.print("There is nothing to see but all shiny objects. \n"
				+ "You are blinded by something, it looks like something is reflecting a diamond or potion.");
		items.add(new Mirror(ui,"mirror", "A shiny and reflective object."));
		items.add(new Items(ui,"diamond", "When you examine it, you find that it is a low class crystal :("));
		Potions p= new Potions(ui);
		p.randomPotionGenerator();
		items.add(p);
//		boolean pickleFound = false; 
//		for (int i = 0; i < items.size(); i++)
//		{
//			if (this.items.get(i).name.contains("pickle"))
//			{
//				pickleFound = true;
//				break;
//			}
//		}
//		if (pickleFound = false)
//		{
//			ui.print("Oh and you also see a pickle");
//			pickleState.next(this);
//			items.add(pickleState.returnPickle());
//			}
	}
	@Override
	public void lookAround() {
		ui.print(looking);
	}
}
