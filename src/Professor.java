import java.util.ArrayList;

public class Professor extends Villain{

	private static Professor instance;
	static UI ui;
	static Health pHealth = new Health(ui,90);
	private Professor(UI ui) {
		super( ui, "professor", pHealth,"Welcome to my laboratory!\n" +
		"You are finally awake! We have a crisis on our hands, and I need your help.\n"+
		"The girls are missing, and I fear they may be in danger. But I have a lead on their whereabouts.\n"+
		"The mayor may know something, but he's not going to talk to just anyone.\n"+
		"You'll need to prove yourself by collecting the ingredients for the Girls' creation: sugar, spice, and everything nice.\n"+
		"These ingredients can be found in the possession of some of the villains we've faced in the past: Mojojojo, Sedusa, and Gangreengang.\n"+
		"Do you have any questions?\n" +
		"Hint: Ask the professor about the powers you have, how to go to city, and how to interact with objects.\n"+
		"Hint: To exit a conversation type \"bye\".\n" +
		"Hint: To get help type \"help me\" with the name of the character.");
		
		attacks.add(new Attacks(20,"shock rays", "Electrifies you"));
		attacks.add(new Attacks(10,"Heat vision","Temporarily burns you"));
		attacks.add(new Attacks(10,"Energy Blasts","A whiff energy startles you"));
		
		questions.add("how objects"); //
		questions.add("what powers"); //what powers do u start with
		questions.add("go city");//how to go to city
		
		answers.add("You need to first pick up the object and then use it.\n" +
		"You can also pick potions that would increase your health!\n"+
		"Hint: To get health from potion you need to first pick and then type consume.\n"+
		"Not all objects you pick are useful!\n"+
		"First look around the lab and try picking some items."); 
		answers.add("Right now you only have 3 basic power: \n" + 
		"Using these are enough to defeat some villains but others require special items!"); 
		answers.add("You have the ablity to teleport to the City and Mayor's Office!" + 
		"However, to go the Mayor's Office you would need to collect all the items to meet him... \n" +
		"Hint: Type teleport and the location.");
		
		
		exit = "bye";
	}
	
	public static synchronized Professor getInstance(UI ui){
		if(instance == null){
			instance = new Professor(ui);
		}
		return instance;
	}
	
	@Override
	public void help() {
		ui.print("Keep your friends close but your enemies closer...");
	}

}
