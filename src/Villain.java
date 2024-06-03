import java.util.ArrayList;

public class Villain extends Character{

	Health villainHealth;
	ArrayList<Attacks> attacks = new ArrayList<Attacks>();
	
	public Villain(UI ui, String name, Health villainHealth, String des)
	{
		super(new ArrayList<ConcreteSubject>(), ui, name, des);
		this.villainHealth = villainHealth;
		
	}
	
	@Override
	public void help(){
		ui.print("Ha! What makes you think I would help ??");
	}
	
	public void attack(Player a, int damage){
		a.playerHealth.hitDamage(damage);
	}	
	
	public ArrayList<Attacks> returnAttacks()
	{
		return attacks;
	}
	
}
