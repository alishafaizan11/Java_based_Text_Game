import java.util.ArrayList;
import java.util.Random;

public class MojoJojoFightSceneLocation extends Location implements Runnable{

	public UI ui;
	public String des;
	public Player currentPlayer;
	public String winner;
	public Villain mojojojo;
	boolean fightScene = true;
	
	private static MojoJojoFightSceneLocation instance;
	
	public void startFightScene(){
		Thread t = new Thread(this);
		t.start();
	}
	
	private MojoJojoFightSceneLocation(UI ui) {
		{
			this.ui= ui;
			fightScene = true;
			currentPlayer = Player.getInstance(null, ui);
			mojojojo = Mojojojo.getInstance(ui);
			this.startFightScene();
		}
	}

	public void run(){
		ui.setDisableUI();
		//print mojojojos dialogue
		//while loop when :
		//thread sleep then output 
		ui.print(mojojojo.dialogue);
		ui.print("                                                                                                                 . &%%((((((((#(####&                 \n"
				+ "                                        .                                                            ......       %#%%((((##%&&&&&&&                 .\n"
				+ "&%%&%#%&&&&&&&&&%&%&&&&&&&&&%&&&&&&&&%&%            &&&&%&%&%&&&&&&%%######%(&, (  %&&&&&&&&&&&&&&&&&&&%&%%####%###%%%%(((((((####&(&%#%#%(,   .##%%%%\n"
				+ "(&/#%%%((//#(#///((((#//((((((/((((#((/%%#%#%%%##%%%&((/((////(((%@((   ((  .(.  .((@&(#((%/((((////((//((((///#(#/&&%%%%%%%%%%%###%%##%#&(&((%%&%%##(\n"
				+ "(&&/%%%((//#(##///(((#//((((((/((((#((/%&%##(#(####%&((/((///##    ((   ((   ((   /(     @&/((((////((*/#(((///((#/%%%%###((((///(%%%%#&%#%*/%**%%%%#(\n"
				+ "(&&&/%%((//%(##///((((//((((((/((((#((/%&%&&&&&&&&%%&(#/((//#    *(*   /(.   .(*   ,(/     @((((////((//#(((///((#/%%&#(##%%&&&&&&&&%%(&%(%%%#%&&&&&##\n"
				+ "(&%&&/%#(//#(#%///(((#//((((((/((((#((/%%&&%%#(((((%&(#/(((( ./((,    /(*     ,((    .(/(.  *#((////((//((((///((#/%&((((((((((##%&###(&%(&&&&&&&%&%#(\n"
				+ ",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,@/.        ((.  /(    ((,        ,*@,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,\n"
				+ "********,*,,,,,,,,,,,,,,,****///**,,,,,,,,,,,****/////////@       *((,   (/.(,    ((/        &&&&&&&&&&&&%%&&&&&&&&&&%#####%&&&&&&&&&&&&&&&&&&&&&&&&&&\n"
				+ "(((((((&//#***********************************************@   /((((    /(.   ((.    .(((/,   &*******************************************************/\n"
				+ "%%%%%%%&//#********************************##(************@((/      *((   /(   *((        .((&*********************/##*******************************/\n"
				+ "(%((#((&//#********************************/*(************@     .((/     /&&(     ,(//       %*********************#//(******************************/\n"
				+ "/*//***&//#***********************************************@/((/.       ./@,*@/(        .//(((&*******************************************************#\n"
				+ "#(((///&//(**///(((((((((((///////************************@       ./(((@*****,&(/(/.         %*******************************************************#\n"
				+ "&&&&%&&&//(***********************************************@*(%&&#/*,***,&((###(****(@@@@@&(**&%&%%%%%%%%*,,***,,*,,*.%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%#\n"
				+ "(#(&#%/&//(*****************************************&,,,%(@****%##(%****&###((#***&(##&******&&#,,/&********/,,*,,**,**************%******************\n"
				+ "(#(&#/%&//(*******************************#///****/,,(,&,,@@@@@@@@&%##(//******//((#%&@@@@@@@@,,/,,,&*********%,,%*************,*(/*&*****************\n"
				+ "(#(&%/%#//(******************************@@@%&%%%%&,,,,*#,@@@@,,@,,,,,*@,,,@%,,(@,,,,,@,,%@@@@,@,,,,*%%%%%%%@&&******#//(**********%******************\n"
				+ "(#(&((&&//(****************************#@@@@@@@@%&&&,,/,,,@@@@/,,&,,,,,%,/,,,(%**,,,,@,,,@@@@@,,,,,,@&&%@@@@@@@@#*****************/*******************\n"
				+ "&&&%&&%&///*************************@@@@@@@@@@@@@@%%@(,,,,@@@@@@*,,,%&#,,,&&&,,,,%%,,,,%@@@@@@,,,,(%%&@@@@@@@@@@@@@/***************%*%****************\n"
				+ "&&&&&&&&///**********************,(@@@@@@@@@@@@@@@@&&%%%%%&@@@@@@@@@@@%,,,,,,,,,*@@@@@@@@@@@@@&%%%%%@@@@@@@@@@@@@@@@@/*************(*****************&\n"
				+ "/(#/(//#///*********************@@@@@@@@@@@@@@@@@@@@&%%%%%%&@@@@@@@@@,&/,,,,,,,,(&,@@@@@@@@@@%%%%%%@@@@@@@@@@@@@@@@@@@@(***********#.****************&\n"
				+ "/(#/(//#///*******************@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%&%&@@@&,,,&   (  @,,,@@@@&%@%%%%%%%%@@@@@@@@@@@@@@@@@@@@@,*****************************&\n"
				+ "/(#/((/(////*******************@@@@@@@@@@@@@@@%%%%%%%%&%%%%%%%%%%%%%@,,,,,,,,,,,,,,&&%%%%%%%%%%%&@%%%%%#%@@@@@@@@@@@@@@@*****************************&\n"
				+ "/(#/((//////******************(@@@@@@@@@@#&%%%%%%%%%%%#@%%%%%%%%%%%%%&@,,,,,,,,,,@%%%%%%%%%%%%%%@#%%%%%%%%%%%@@@@@@@@@@@*****************************%\n"
				+ ",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,&@@@@@@@@,,,&%%%%%%%%%%%%%%@&%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%@%%%%%%%%%%%%%%@,,%&@@@@@@%#@,,,,,,,,,,,,,,,,,,,,,,,,,,,\n"
				+ ",,,,,,,,,,,,,,,,,,,,,,,,,,,,@*@@@@@@@%,,,,&%%%%%%%%%%%%%%%%%%%@@&&%%&&%%%&%%%&%%%&%%&&&@@@%%%#%%%%%%%%%%%%%%%@,,,,@@@/   &,,,,,,,,,,,,,,,,,,,,,,,,,,,,\n"
				+ "...........  .... .......    (      @##@..&%%%%%%%%%%%%%%%%%%%%%%%%%#&   %*****,   &%%%%%%%%%%%%%%%%%%%%%%%%%@ /#..     &   ...       .         ......\n"
				+ " ....... ....... .  ..  ...(#    .(...@.%.&%%%%%%%%%%%%%%%%%%%%%%%##%@@@@&&#*%&@@@@@###%%%%%%%%%%%%%%%%%%%%%%@.@ (  .(      ,/.. ......  .......  ... \n"
				+ " ...... ........  .....  @.&@ (% @...    .%%%%%%%%%%%%%%%%%%%%%%%%&&%%%%%%%%%%%%%%%%%&&%%%%%%%%%%%%%%%%%%%%%%&    .  *  (, ((@ . ...... ...... .  ... \n"
				+ " ..  ....  ... . ... .. ... & & .&&,.... *%#%%%%%%%%%%%%%%%%%%%%##%&,*/(@&&&&&&@,.  *%#%%%%%%%%%%%%%%%%%%%%%%/   .. #&.  %,      ............... ...  \n"
				+ " .......................... .... ........@%%%%%%%%%%%%%%%%%%%%%%%&     /#%%%%%%#@     @%%%%%%%%%%%%%%%%%%%%#@ .................. ................... .\n"
				+ "                          .    .       .,&#%%%%%%%%%%%%%%%%%%%%%@      &%%%%%%%%#/     @%%%%%%%%%%%%%%%%%%%@..                                        ");
		ArrayList<Command> cmds = new ArrayList<Command>();
		cmds.add(new IceBreathCmd(mojojojo));
		cmds.add(new FireballCmd(mojojojo));
		cmds.add(new SuperSpeedCmd(mojojojo));
		
				
		for (int i = 0; i < currentPlayer.powers.size(); i++)
		{
			if (currentPlayer.powers.get(i).name == "tornado")
				cmds.add(new TornadoCmd(mojojojo));
			
			if (currentPlayer.powers.get(i).name == "scream")
				cmds.add(new SuperSonicScreamCmd(mojojojo));
				
			if (currentPlayer.powers.get(i).name == "invisibility")
				cmds.add(new InvisibilityCmd(mojojojo));
		}
		
		ControlPanel actions = new ControlPanel(cmds);
		ArrayList<Attacks> mojojojoAttacks = mojojojo.returnAttacks();
		
		while(currentPlayer.playerHealth.getHealth() > 0 || mojojojo.villainHealth.getHealth() > 0)
		{
			
			ui.setDisableUI();
			
			ui.print("Current Player Health: " + currentPlayer.playerHealth.getHealth());
			
			currentPlayer.showPower();
			
			ui.print("You can activate X where X is a Power");
			
		
			String input = ui.input();
	
			String[] tokens = input.split(" ", 2); 
			
			boolean powerfound = false;
			
			for(int i = 0;i < currentPlayer.powers.size(); i++){
				if (currentPlayer.powers.get(i).name.contains(tokens[1]))
				{
					actions.buttonWasPressed(i);
					powerfound = true;
					break;
				}
			}
			
			if (powerfound == false){
				ui.print("Power not found...");
			}
			
			if (mojojojo.villainHealth.getHealth() <= 0)
			{
				winner = "player";
				break;
			}
			
			Random rand = new Random();
			int villainAttack = rand.nextInt(mojojojo.attacks.size());
			
			ui.print(mojojojoAttacks.get(villainAttack).getDes());
			mojojojo.attack(currentPlayer, mojojojoAttacks.get(villainAttack).getDamage());
			
			if (currentPlayer.playerHealth.getHealth() <= 0)
			{
				winner = "other";
				break;
			}
		}
		ui.resetDisableUI();
		
		if (winner == "player")
		{
			ui.print("You've defeated Mojo Jojo!");
			ui.print("You've collected Sugar. You're getting ever soclose to finding the Powerpuff Girls'");
			ui.print("Power Unlocked: invisibility . Use this on your quest :D");
			currentPlayer.inventory.add(new Items(ui, "sugar", "This collectable gives you the power to invisibility"));
			currentPlayer.powers.add(new Power(ui, "invisibility"));
			fightScene = false;
		}
		else
		{
			ui.print("Mojo Jojo proved to be difficult and you have been defeated :()");
		}
		ui.print("Returning to Previous Location...");
		currentPlayer.setLocation(Tower.getInstance(ui));
		
		
	}

	public static synchronized MojoJojoFightSceneLocation getInstance(UI ui){
		if(instance == null){
			instance = new MojoJojoFightSceneLocation(ui);
		}
		return instance;
	}
	
	public void setPlayer(Player player)
	{
		currentPlayer = player;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public Location walkNorth() {
		
		return null;
	}
	
	@Override
	public void walkNorthDesc() {
		
	}

	@Override
	public Location walkSouth() {
		return null;

	}

	@Override
	public Location walkWest() {
		return null;

	}

	@Override
	public Location walkEast() {
		return null;

	}

	@Override
	public void walkSouthDesc() {
		
	}

	@Override
	public void walkWestDesc() {
		

	}

	@Override
	public void walkEastDesc() {


	}

	public void lookAround() {
	}
}
