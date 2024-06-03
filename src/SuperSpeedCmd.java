
public class SuperSpeedCmd implements Command{

	Villain v;
	
	SuperSpeedCmd(Villain v){
		this.v=v;
	}
	
	@Override
	public void usePower() {
		v.ui.print("You used super speed to fastly attack" + v.name);
		v.villainHealth.hitDamage(30);	
		v.ui.print("This caused 30 damage to " + v.name);
		v.ui.print("Health left for " + v.name + " is " + v.villainHealth.getHealth());
		
	}
}
