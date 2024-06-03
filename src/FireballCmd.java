
public class FireballCmd implements Command{

Villain v;
	
	FireballCmd(Villain v){
		this.v=v;
	}
	
	@Override
	public void usePower() {
		v.ui.print("You used fire ball to blast " + v.name);
		v.villainHealth.hitDamage(35);	
		v.ui.print("This caused 35 damage to " + v.name);
		v.ui.print("Health left for " + v.name + " is " + v.villainHealth.getHealth());
	}
}
