
public class Tower extends City{
	private static Tower instance;
	UI ui;
	
	
	
	public String des = "As you approach Mojo Jojo's tower, you can't help but feel a sense of foreboding. "
			+ "\nThe tower looms high above the city, casting a dark shadow over the surrounding buildings. The exterior of the "
			+ "tower is made of dark gray stone, with sharp angles and jagged edges that give it an ominous appearance."
			+"As you make your way up the pathway, you can hear the faint hum of machines and the sound of cackling laughter "
			+ "coming from inside the tower. \nThe entrance to the tower is a large, ornate door made of dark metal with intricate "
			+ "designs etched into its surface.\n"
			+ "                                        _..-,--.._\n"
				+ "                                  ,`. ,',','      `.\n"
				+ "                                  `. `,/`/          \\\n"
				+ "                                    :'.`:            :\n"
				+ "         ____ _          _ __       | |`|            |\n"
				+ "       _(    `.)        ( (  )`.    : `-'            ;     _\n"
				+ "      ( (    ) ))      ( (    ))    ,\\_            _/.  (`','\n"
				+ "     ( (   )  _)        `-(__.'    '.  ```------'''  .`\n"
				+ "      '.__)--'       .-..           |``-...____...-''|\n"
				+ "                    (_)_))          |                |\n"
				+ "               ,'`.        ___...---|                |--..._\n"
				+ "   ,'`. ,'`. ,'   _`.---'''         |                | \"\n"
				+ " -'..._`.   `.   /`-._  \"      \"    |    _           |\n"
				+ "        ```-..`./:::::)             `-...||______...-'    \"\n"
				+ "               /:::_.'     \"        \"                \"\n"
				+ "            _.:.'''   \"                       \"          ";
	
	
	public String looking = "Currently you're in the Tower. This is Mojojojo's Lair.";
	
	
	
	
	private Tower(UI ui) {
		super(ui);
		this.ui= ui;
		characters.add(Mojojojo.getInstance(ui));
		
		ui.print(des);
		
	}

	public static synchronized Tower getInstance(UI ui){
		if(instance == null){
			instance = new Tower(ui);
		}
		return instance;
	}
	
	
	@Override
	public Location walkNorth() {
		
		return City.getInstance(ui);
	}
	
	@Override
	public void walkNorthDesc() {
	}
	
	@Override
	public Location walkSouth() {
		
		return null;
	}
	@Override
	public void walkSouthDesc() {
		ui.print("This is the south of the tower, there is nothing interesting to see here but a glass catches the corner of your eye...");
		Potions p = new Potions(ui);
		p.randomPotionGenerator();
		items.add(p);
	}
	@Override
	public Location walkWest() {
		return null;
	}
	@Override
	public void walkWestDesc() {
		
		ui.print("This is the west of the tower, there is nothing interesting to see here but you find Mojojojo's cape");
		items.add(new Items(ui, "Mojocape", "This is the infamous purple cape owned my Mojojojo."));
	}
	
	@Override
	public Location walkEast() {
		
		//fight scene with Mojojojo
		MojoJojoFightSceneLocation MJFSL = MojoJojoFightSceneLocation.getInstance(ui);
		if(MJFSL.fightScene == true)
		{
			ui.print("As you walk to the east of the tower, you feel the weight of the Mojojojo's gaze upon you. You know that a fierce"
					+ "battle awaits, \nand you steel yourself for the fight ahead, drawing your weapon and preparing to face the evil "
					+ "genius head-on.");
			return MJFSL;
		}
		else
		{	ui.print("You have encountered Mojojojo!");
			return null;
		}
	}
	@Override
	public void walkEastDesc() {
		
		
	}
	@Override
	public void lookAround() {
		ui.print(looking);
	}
}
