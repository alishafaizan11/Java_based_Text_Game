
public class Mayor extends SideCharacter{
	UI ui;
	private static Mayor instance;
	boolean talkMayor=false;
	
	// one static method which can be called without creating an instance
	// of the class.
	
	private Mayor(UI ui){
		super(ui, "Mayor", "Mayor looks up. The colour drains from his face. He starts visibly shaking.");
		this.ui = ui;
	
		questions.add("you ok"); 
		questions.add("yes do"); 
		questions.add("go closer");//command
		
		answers.add("Yes, I am fine.\n Do you have all the collectables."); 
		answers.add("Great! I will collect them now. Just come closer and place it on the table!");
		answers.add("It is not what you think! The girls are with the p-");
		
		exit = "who";
	}
	public static synchronized Mayor getInstance(UI ui){
		if(instance == null){
		instance = new Mayor(ui);
		}
		return instance;
		}
	
	@Override
	public void help(){
		ui.print(name );
	}
	@Override
	public void conversation() {
		
		ui.print(dialogue);
		String input = ui.input();
		while(!input.contains(exit)){
			boolean temp = false;
			for(int i =0;i<questions.size();i++){
				String[] tokens = questions.get(i).split(" ", 2); 
				if(input.contains(tokens[0]) && input.contains(tokens[1])){
					ui.print(answers.get(i));
					temp = true;
					break;
				}
			}
			if(temp == false){
				ui.print("I don't understand...");
			}
			input = ui.input();
		}
		talkMayor = true;
		ui.print("You see a beam of bright light and all of a sudden you can't move\n " + 
		"There is a tall man wearing a white suit taking all the collectables you had.\n " +
		"He walks south, out of the room, without sparing a glance back.\n" + 
		"You and the mayor finally move.\nMayor says 'We must have gotten shot by the containment ray which temporarily freezes its victims. "
		+"I only one person that could posses this machine... Go follow that man!'");
			 
	}
}
