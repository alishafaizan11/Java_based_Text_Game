import java.util.ArrayList;

public class ControlPanel { 
	
	ArrayList<Command> slots = new ArrayList<Command> ();
	public ControlPanel(ArrayList<Command> slots) { 
		this.slots = slots;
	}

	public void buttonWasPressed(int i){ 
		slots.get(i).usePower();
	} 
}