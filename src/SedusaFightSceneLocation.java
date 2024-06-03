 import java.util.ArrayList;
import java.util.Random;


public class SedusaFightSceneLocation extends Location implements Runnable{

	public UI ui;
	public String des;
	public Player currentPlayer;
	public String winner;
	public Villain sedusa;//make sedusa instae
	boolean fightScene = true;
	
	private static SedusaFightSceneLocation instance;
	
	public void startFightScene(){
		Thread t = new Thread(this);
		t.start();
	}
	
	private SedusaFightSceneLocation(UI ui) {
		{
			this.ui= ui;
			fightScene = true;
			currentPlayer = Player.getInstance(null, ui);
			sedusa = Sedusa.getInstance(ui);
			this.startFightScene();
		}
	}

	public void run(){
		ui.setDisableUI();
		//print sedusas dialogue
		//while loop when :
		//thread sleep then output 
		
		ui.print(sedusa.dialogue);
		ui.print("                                                                                                                                                      \n"
				+ "                                                                  .(/****//,          (/******/#.                    ,..                              \n"
				+ "                                                              /,,,**,(*...,#        *,...,******,.,/            #*,,.,.,/(                            \n"
				+ "                                                            #,,*      *..,*        *..,,/   **  **,,/         /,..*/&/*..,*.                          \n"
				+ "                                       . /*/.               /,.,,.** /*..**       ,,.,,*/(*/ /,,...,/          /*,*(  **,.,*                          \n"
				+ "                                ,***,,***,.*#       ,*,...,//(****. ,*..,,,,,,/   **,,,......*, /,*     /*,...,/  *,   /,.,*(                         \n"
				+ "                            ./,,.***  /,..,/       *..........,**   **........*(       #*....,*      (*...,,*,,,*,    /*,.*(                          \n"
				+ "                           /,,* /*   /,....*(    (,...............*/    /,...*/      (,/..,.,/      *,..,*#    /*,,.*,***                             \n"
				+ "                           *,.**,*/   /**,,..........,(.*............,#,,. ..,//*,,.. ....**       **,..,%       /**(                                 \n"
				+ "                             **,,*#         .#**,,**,    *.............  ...............*/           /*...,/                                          \n"
				+ "                                                       *,,..... ... .....................,/#           .*...,(                                        \n"
				+ "                                       (**,.,..............  ...  ...........,,... ....... .........,........,(                                       \n"
				+ "                                     *.................................,,(#,..............................,*/*                                        \n"
				+ "                                    *,.*. ./**.............,,*,.....*/@@@@(,..........................**/                                             \n"
				+ "                                    *,.*       (*...****(&@@@,.....,@@@@@@@#***,**#@@.............*/                                                  \n"
				+ "                                    *..,*        *..*,#@@@@@@%,...,#@@@@@@@@@@@@*.#,,&#........,/                                                     \n"
				+ "                   *                (,..,*      #,..&,@%/.(@@@@,..,%@@@@@@@@&,,//(&,/&@&.............,,,,,,,,,,,.,.,,*/                               \n"
				+ "              (*..,*,,**           #,....*(    ,,..@*@&*/.,.../@#*.#@@,@@*...,#&//&##@@@(..............................*#                             \n"
				+ "             (,.,* (*,(    **,,......,**/,     (...@/@&//*.,.,.,(%,*@@,%//.....//%@##@@@&..............................,#                             \n"
				+ "             (,.,*      #*....,*(,             *...@@@&,*(////(.@#,,&@%,@%///(/,,,,,*@@@&................***(, /,,...,,*                              \n"
				+ "             /,..,*     /....*&               .,...@&&.&@@@&..#*...*@@@@(,(@@@@@@&%&@@@@/........,*/*(.         *,...,*                               \n"
				+ "             ,*.,.,*((  /,..,/             ,/,....,#@@@@@@&*,..,*/@@#**,,***&@@@@@@@@@@&..,/*(                  (,...,/                               \n"
				+ "                 */**,,,...,/             *.........&(*,.,*(@@@@@,**#&@@@@@/,&@@@@@@@@&,                         *...*(                               \n"
				+ "                                    (******,*( .#**,..,*@@@@@@/*,,,,,,,,,,..*%@@@@@@@*/                          *,..,**                              \n"
				+ "                                  .*,,,,,*#/,.*   ,..*#,@@@@@@@@@@@@@@@&%**,*@@@@@@*.                             /*.....,,...,,**,                   \n"
				+ "                                 #*,*/*.***,,,/   *,.,,*/,/@@@@@@@@@@@@@@@@@@@@@*.                                   (***//*****..*(                  \n"
				+ "                                */,*/*,..*%        *,,,,*   /.,%@@@@@@@@@@@%,.,                                             (*% *,,/                  \n"
				+ "                                /,,***/              *((          .*,/@@@@,                            *,, ,.*  /.*      /,,,, *,,**                  \n"
				+ "                                                                   .,@@@@&,../%                     * *.,.,,,.,,*,,,*    /,,**.**                     \n"
				+ "                                                                 /,,*@@@@@@@&..,@@@@@@&%(*,..,,*,  ,,*,.,,,,,,,/                                      \n"
				+ "                                                            ,.,*&@@@@@@@@@&.,,.@@@@@@@@@@@@@&,,,,,,.*,.,,,,.,                                         \n"
				+ "                                                       /..,,,,.&@@@@@@@@@.,,,,.&@@@@@@#%&@@@/,,,,,,,,.**,,,....&                                      \n"
				+ "                                                      *,,,,,,,,.(@@,&@&.,,,,,,.,@@@@#,/      //...,,.*,,,,,,,*,*.*                                    \n"
				+ "                                                    *,%(,,,,,,,,.(((@.,,,,,,,,,.*@@,,.              *..,...,*,,...                                    \n"
				+ "                                                 /,%@@@@/,,,,,,,,...,,,,,,,,,,,,...*                ..,,,                                             \n"
				+ "                                            /,..,.@@@*..(,.,,,,,,,,,,,,,,,,,,,,,,.,                ,,,.,...*                                          \n"
				+ "                                       *.,,,,,,,,,.,.     ,.,,,,,,,,,,,,,,,,,,,..                  ,,,.,,..,..*                                       \n"
				+ "                                    *,,,,,,,,,,,*.         *.,,,,,,,,,,,,,,,,,.,                  .,,,,.,,..,,,,..*                                   \n"
				+ "                                 *,,,,,,,,*,,(               .,,,,,,,,,,,,,,,.                     ,,,,,.,,,..,,,,,,,,*                               \n"
				+ "                   .*,,*       ,,,,,,,**,,                    .,,,,,,,,,,,,.,                      (,,,,,,,,,,,,,,,,,,,,,                             \n"
				+ "                ,,,./.*,#    /.,,,,,,,*                        .,,,,,,,,,..*                        ,,,,,,,,,,,,,,,,,,,,,,,                           \n"
				+ "              ,**,.,**,,,.,/.,,**,..                            ..,,,,,,.*                           ,,,,,,,,,,,,,,,,,,,,,,                           ");
		ArrayList<Command> cmds = new ArrayList<Command>();
		cmds.add(new IceBreathCmd(sedusa));
		cmds.add(new FireballCmd(sedusa));
		cmds.add(new SuperSpeedCmd(sedusa));
		
				
		for (int i = 0; i < currentPlayer.powers.size(); i++)
		{
			if (currentPlayer.powers.get(i).name == "tornado")
				cmds.add(new TornadoCmd(sedusa));
			
			if (currentPlayer.powers.get(i).name == "scream")
				cmds.add(new SuperSonicScreamCmd(sedusa));
				
			if (currentPlayer.powers.get(i).name == "invisibility")
				cmds.add(new InvisibilityCmd(sedusa));
		}
		
		ControlPanel actions = new ControlPanel(cmds);
		ArrayList<Attacks> sedusaAttacks = sedusa.returnAttacks();
		
		while(currentPlayer.playerHealth.getHealth() > 0 || sedusa.villainHealth.getHealth() > 0)
		{
			
			ui.setDisableUI();
			
			ui.print("+ Current Player Health: " + currentPlayer.playerHealth.getHealth());
			
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
			
			
			if (sedusa.villainHealth.getHealth() <= 0)
			{
				winner = "player";
				break;
			}
			
			Random rand = new Random();
			int villainAttack = rand.nextInt(sedusa.attacks.size());
			
			ui.print(sedusaAttacks.get(villainAttack).getDes());
			sedusa.attack(currentPlayer, sedusaAttacks.get(villainAttack).getDamage());
			
			if (currentPlayer.playerHealth.getHealth() <= 0)
			{
				winner = "other";
				break;
			}
			
		}
		ui.resetDisableUI();
		if (winner == "player")
		{
			ui.print("You've defeated Sedusa!");
			ui.print("You've collected Spice. You're getting so close to finding the Powerpuff Girls'");
			ui.print("Power Unlocked: scream . Use this on your quest :D");
			currentPlayer.inventory.add(new Items(ui, "spice", "This collectable gives you the power to scream"));
			currentPlayer.powers.add(new Power(ui, "scream"));
			fightScene = false;
		}
		else
		{
			ui.print("Sedusa proved to be difficult and you have been defeated :()");
			
		}
		ui.print("Returning to Previous Location...");
		currentPlayer.setLocation(PlayGround.getInstance(ui));
		
	}

	public static synchronized SedusaFightSceneLocation getInstance(UI ui){
		if(instance == null){
			instance = new SedusaFightSceneLocation(ui);
		}
		return instance;
	}
	
//	public void setPlayer(Player player)
//	{
//		currentPlayer = player;
//	}
	
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
