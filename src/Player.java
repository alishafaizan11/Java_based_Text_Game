import java.util.ArrayList;

public class Player extends ConcreteObserver implements Runnable{

	UI ui;
	String name = "NASH";
	Health playerHealth = new Health(ui, 100);
	Clock gameTime;
	ArrayList<Power> powers = new ArrayList<Power>();
	public static Location currentLocation = null;
	ArrayList<Items> inventory =new ArrayList<Items>();
	ArrayList<ConcreteSubject> subjects = new ArrayList<ConcreteSubject>();


	private State state = new LockedState();
	public void nextState() {
		state.next(this);
	}
	public void printStatus() {
		state.printStatus();
	}
	public void setState(State state) {
		this.state = state;
	}


	private static Player instance;
	// make constructor private so no else can call it from outside

	private Player(ArrayList<ConcreteSubject> subject, UI ui) {
		super(subject);
		playerHealth.setHealth(100);
		powers.add(new Power(ui, "ice breath"));
		powers.add(new Power(ui, "fireball"));
		powers.add(new Power(ui, "supersonic speed"));
		this.ui= ui;
		Thread t = new Thread(this);
		t.start();

	}

	// one static method which can be called without creating an instance
	// of the class.
	public static synchronized Player getInstance(ArrayList<ConcreteSubject> s, UI ui){
		if(instance == null){
			instance = new Player(s, ui);
		}
		return instance;
	}

	public void run() {
		ui.print("Welcome to the text-based game \"Finding the Powerpuff Girls\"!\n" + 
				"In this game, you'll take on the role of new powerpuff girl called 'NASH' on a mission to find the Powerpuff Girls, who have gone missing in Townsville.\n" +
				"You start your adventure in the laboratory of the professor, who has tasked you with finding the girls and bringing them back safely.\n"  +
				"As you navigate the game, you'll have access to several functions to help you find clues and progress through the story.\n" + 
				"You can talk to other characters to gather information and gain insight into the whereabouts of the Powerpuff Girls.\n" +
				"You can look around your surroundings to find items and clues that may lead you to the girls.\n" + 
				"You can also walk north, south, east, and west to explore new areas of the game world and uncover new leads.\n" +
				"With each successful discovery, you'll move closer to finding the Powerpuff Girls and completing your mission.\n" +
				"But be careful – there are villains lurking around every corner, and they'll stop at nothing to prevent you from finding the girls.\n" +
				"So stay sharp, use your wits and skills, and don't give up until you find the Powerpuff Girls and bring them back to safety!\n");

		ui.print("To begin the game enter the commands: start game");

	}

	public void setLocation(Location loc) {
		Player.currentLocation = loc;
	}

	public void showInventory(){
		ui.print("This is your inventory:");
		for(int i = 0; i < inventory.size(); i++){
			ui.print(inventory.get(i).name);
		}
	}

	public void showPower(){
		ui.print("This is the powers available:");
		for(int i = 0; i < powers.size(); i++){
			ui.print(powers.get(i).name);
		}
	}

	@Override   
	public void update(Message m) {

		if(m.payload.equalsIgnoreCase("start game")) {
			ui.print("You look around and see chemicals and flasks scattered out.\n"
					+"Out of the corner of your eye you see a man in a white coat."); 
			//ascii art
			setLocation(Lab.getInstance(ui));

		}

		if(m.payload.toLowerCase().contains("talk")) {
			String[] tokens = m.payload.split(" ", 3); 
			boolean temp = false;
			for(int i = 0; i < currentLocation.characters.size(); i++) {

				if(currentLocation.characters.get(i).name.contains(tokens[2])) {

					currentLocation.characters.get(i).conversation();
					temp = true;
					break;
				}
			}
			if(temp == false) {
				ui.print("Character not found here");
			}
		}else if(m.payload.toLowerCase().contains("help")) {
			String[] tokens = m.payload.split(" ", 3); 
			boolean temp = false;
			for(int i = 0; i < currentLocation.characters.size(); i++) {

				if(currentLocation.characters.get(i).name.contains(tokens[2])) {

					currentLocation.characters.get(i).help();
					temp = true;
					break;
				}
			}
			if(temp == false) {
				ui.print("Character not found here");
			}
		}



		else if (m.payload.toLowerCase().contains("look around")) {
			currentLocation.lookAround();
		}
		else if (m.payload.toLowerCase().contains("walk")) {
			String[] tokens = m.payload.split(" ");
			if(tokens[1].contains("north")) {
				if(currentLocation.walkNorth() == null)
					currentLocation.walkNorthDesc();
				else {
					currentLocation = currentLocation.walkNorth();
				}
			}
			else if(tokens[1].contains("south")){
				if(currentLocation.walkSouth() == null)
					currentLocation.walkSouthDesc();
				else {
					currentLocation = currentLocation.walkSouth();
				}
			}
			else if(tokens[1].contains("east"))
			{
				if(currentLocation.walkEast() == null)
					currentLocation.walkEastDesc();
				else {
					currentLocation = currentLocation.walkEast();
				}
			}
			else if(tokens[1].contains("west")){
				if(currentLocation.walkWest() == null)
					currentLocation.walkWestDesc();
				else {
					currentLocation = currentLocation.walkWest();
				}
			}else {
				ui.print("Invalid direction!");
			}

			if (currentLocation.isFightScene() == true)
			{

			}
		}else if(m.payload.toLowerCase().contains("teleport")){
			String[] tokens = m.payload.split(" ", 3);  

			if(tokens[2].toLowerCase().contains("city")) {
				ui.print("You are travelling to the city");
				currentLocation = City.getInstance(ui);
			}
			else if(tokens[2].toLowerCase().contains("town hall")) {
				
				state.next(this);
				if(state.returnStatus() == "unlocked")
				{
					ui.print("You are travelling to the City hall");
					currentLocation = TownHall.getInstance(ui);
				}
				else {
					ui.print("You can't travel here yet as you haven't collected all the items yet.");
					showInventory();
				}
			}
			else {
				ui.print("You can't teleport there!");
			} //change to state
		}else if(m.payload.toLowerCase().contains("use")){
			String[] tokens = m.payload.split(" ", 2);
			boolean temp = false;
			for(int i = 0; i < inventory.size(); i++) {

				if(inventory.get(i).name.contains(tokens[1])){
					inventory.get(i).use();
					temp = true;
					break;
				}
			}
			if(temp == false) {
				ui.print("You can't use this item!");
			}
		}else if(m.payload.toLowerCase().contains("pick")){
			String[] tokens = m.payload.split(" ", 2);
			for(int i = 0; i < inventory.size(); i++) {
				if(inventory.get(i).name.contains(tokens[1])){
					ui.print("You have already picked this item");
					break;
				}
			}

			if(currentLocation.getItem(tokens[1]) != null){
				inventory.add(currentLocation.getItem(tokens[1]));
				ui.print(inventory.get(inventory.size()-1).des);
				currentLocation.items.remove(currentLocation.getItem(tokens[1]));
				ui.print("You have added this item to your inventory!");
			}else{
				ui.print("The item can't be picked");
			}


		}else if(m.payload.toLowerCase().contains("drop")){
			String[] tokens = m.payload.split(" ", 2);
			boolean temp = false;
			for(int i = 0; i < inventory.size(); i++) {
				if(inventory.get(i).name.contains(tokens[1])){
					ui.print("Removed successfully!");
					currentLocation.items.add(inventory.get(i));
					inventory.remove(i);
					temp = true;
					break;
				}
			}
			if(temp == false) {
				ui.print("Item is not in inventory.");
			}
		}
		else if(m.payload.toLowerCase().contains("consume")){
			String[] tokens = m.payload.split(" ", 2);
			boolean temp = false;
			for(int i = 0; i < inventory.size(); i++) {
				if(inventory.get(i).name.contains(tokens[1])){
					int temphp=inventory.get(i).consume();
					playerHealth.increaseHealth(temphp);
					if(temphp != 0){

						ui.print("Total Health is now " + playerHealth.getHealth());
					}
					inventory.remove(i);
					temp = true;
					break;
				}
			}
			if(temp == false) {
				ui.print("You cannot consume this.");
			}
		}else if(m.payload.toLowerCase().contains("show inventory")){
			showInventory();
		}else if(m.payload.toLowerCase().contains("show powers")){
			showInventory();
		}



	}
}


