
public class TornadoCmd implements Command{

	Villain v;

	TornadoCmd(Villain v){
		this.v=v;
	}

	@Override
	public void usePower() {
		v.ui.print("Please spin your phone around fastly!");
		TCPClient.resetFlags();

		if (TCPClient.getTornado() == true)
		{
			v.ui.print("You spun like a tornado and attacked " + v.name);
			v.villainHealth.hitDamage(30);	
			v.ui.print("This caused 30 damage to " + v.name);
			v.ui.print("Health left for " + v.name + " is " + v.villainHealth.getHealth());
		}
		else
		{
			v.ui.print("You did not spin your phone around fast enough!");
		}
	}
}