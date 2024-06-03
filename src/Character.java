import java.util.ArrayList;
import java.util.Scanner;

public abstract class Character extends ConcreteObserver{
	String name;
	String dialogue;
	ArrayList<String> questions = new ArrayList<String>();
	ArrayList<String> answers = new ArrayList<String>();
	UI ui;
	String exit;
	ArrayList<ConcreteSubject> subject = new ArrayList<ConcreteSubject> ();
	
	public Character(ArrayList<ConcreteSubject> subject,UI ui, String name, String dialogue)
	{
		super(subject);
		this.dialogue = dialogue;
		this.ui = ui;
		this.name = name;
		
	}

	public abstract void help();
	
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
		ui.print("Take care, bye!");
			 
	}
	
	public void update(Message m) {
		
		
	}
	
}

