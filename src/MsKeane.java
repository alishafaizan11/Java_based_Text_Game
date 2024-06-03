
public class MsKeane extends SideCharacter{
	UI ui;
		
	public MsKeane(UI ui){
		super(ui, "Ms Keane", "Hello there! My name is Ms. Keane, and I'm the teacher at Pokey Oaks Kindergarten.\n" +
		"You must be here to help the Powerpuff Girls, right?\n I heard that you're on a mission to get something Sedusa.\n" +
		"She's a sneaky villain who's causing trouble all over Townsville.\nDo you have any specific questions I can answer");
		this.ui = ui;
	
		questions.add("where mirror"); // where are the girls
		questions.add("how defeat"); //how to defeat sedusa
		questions.add("where sedusa");// where is sedusa
		
		answers.add("The mirror is in the junkyard"); 
		answers.add("To defeat Sedusa you need a mirror"); 
		answers.add("Sedua is in the south of playground");
		
		exit = "bye";
		
	}
	
	@Override
	public void help(){
		ui.print(name + " says: To defeat Sedusa you are going to need a shiny object... ");
	}
	
}
