
public class Mojojojo extends Villain{

	private static Mojojojo instance;
	static UI ui;
	static Health mHealth = new Health(ui, 70);
	//MojoState MState;
	//boolean isNight;

	
	private Mojojojo(UI ui) {
		super(ui, "Mojojojo", mHealth, "Oh you look like the Powerpuff girls!\nHow dare you enter you enter my lair?!\n");
		this.ui= ui;
		//MState = new NormalMojo();
		//isNight=false;
		attacks.add(new Attacks(20,"Raygun", "Mojojojo shoots a ball of energy from two laser guns in each hand and grazes you."));
		attacks.add(new Attacks(10,"Headbutt", "Mojojojo starts flying forward with both arms raised and hits you."));
		attacks.add(new Attacks(5,"Jet Blast", "Mojojojo sets of his jet blasts and throws a punch."));
	}

	public static synchronized Mojojojo getInstance(UI ui){
		if(instance == null){
			instance = new Mojojojo(ui);
		}
		return instance;
	}
//	@Override
//	public void update(Message m) {
//		if (m.topic.contains("MojoWatchday")){
//			ui.print(m.payload + "\nMojojojo's mood is good");
//	
//			attacks.add(new Attacks(30,"Raygun", "Mojojojo shoots a ball of energy from two laser guns in each hand and grazes you."));
//			attacks.add(new Attacks(20,"Headbutt", "Mojojojo starts flying forward with both arms raised and hits you."));
//			attacks.add(new Attacks(15,"Jet Blast", "Mojojojo sets of his jet blasts and throws a punch."));
//		}
//		else if (m.topic.contains("MojoWatchevening")){
//			ui.print(m.payload + "\nMojojojo's mood getting bad");
//			MState.next(this);
//			
//		}
//		else if (m.topic.contains("MojoWatchnight")){
//			ui.print(m.payload + "\nMojojojo's mood is really bad...");
//			MState.next(this);
//			attacks.clear();
//			attacks.add(new Attacks(45,"Raygun", "Mojojojo shoots a ball of energy from two laser guns in each hand and grazes you."));
//			attacks.add(new Attacks(35,"Headbutt", "Mojojojo starts flying forward with both arms raised and hits you."));
//			attacks.add(new Attacks(25,"Jet Blast", "Mojojojo sets of his jet blasts and throws a punch."));
//		}
//		
//	}
//	public void setState(MojoState m) {
//		this.MState=m;
//	}
	
}
