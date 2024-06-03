
public class MsBellum extends SideCharacter{
	UI ui;
	private static MsBellum instance;
	
	private MsBellum(UI ui){
		super(ui, "Ms Bellum","Good afternoon! What can I help you with today.");
		this.ui = ui;
	
		questions.add("meet mayor"); 
		questions.add("sugar spice");
		questions.add("professor utonium"); 
		
		answers.add("Oh yes I can schedule an appointment. You look very similar to the Powerpuff Girls.\n" + 
		"Also, what is it you are carrying."); 
		answers.add("Isn't that what was used to create the Powerpuff Girls?\n" + 
		"I had thought these ingredients where hidden since the law was passed...\n" + 
		"Who did you say sent you?");
		answers.add("Oh ok he is already here waiting for you! Bye."); 
		
		exit = "bye";
	}
	public static synchronized MsBellum getInstance(UI ui){
		if(instance == null){
		instance = new MsBellum(ui);
		}
		return instance;
		}
	@Override
	public void help(){
		ui.print(name + "I have scheduled the appointment for you. Meet the Mayor.");
	}
	
}
