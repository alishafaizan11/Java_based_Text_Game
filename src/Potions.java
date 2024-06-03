import java.util.Random;

public class Potions extends Items{
	
	UI ui;
	PotionStrategy strategy;
	static int count = 1;
	
	
	public Potions(UI ui){
		super(ui, "potion "+ Integer.toString(count) ,"This will increase your health points");
		count++;
		this.ui = ui;
		
		
	}
	@Override
	public int consume(){
		 return strategy.getStrength();
	}
	
	public void setStrategy(PotionStrategy strategy) { 
		
		this.strategy = strategy;
	}
	
	public void randomPotionGenerator() {
		Random r = new Random();
		int temp = r.nextInt(3);
		switch(temp) {
		case 0:
			   this.setStrategy(new PotionStrategy25());
			break;
		case 1:
			this.setStrategy(new PotionStrategy50());
			break;
		case 2:
			this.setStrategy(new PotionStrategy45());
			break;
		}
		
	}
}

