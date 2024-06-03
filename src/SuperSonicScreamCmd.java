
public class SuperSonicScreamCmd implements Command{

Villain v;
	
SuperSonicScreamCmd(Villain v){
		this.v=v;
	}
	
	@Override
	public void usePower() {
		v.ui.print("Please scream into your phone louder");
		TCPClient.resetFlags();
		if (TCPClient.getScream() == true)
		{
			v.ui.print("You used scream to attack " + v.name);
			v.villainHealth.hitDamage(40);	
			v.ui.print("This caused 40 damage to " + v.name);
			v.ui.print("Health left for " + v.name + " is " + v.villainHealth.toString());
		}
		else
		{
			v.ui.print("You did not scream hard enough!");
		}	
	}
	
}
