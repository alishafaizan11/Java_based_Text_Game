
public class LockedState implements State{

	@Override
	public void next(Player context) {
		// TODO Auto-generated method stub
		if (canTransition(context) == true)
		{
			context.setState(new UnlockedState());
		}
	}
	@Override
	public void printStatus() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean canTransition(Player context) {
		boolean isSugar = false;
		boolean isSpice = false;
		boolean isEverythingnice = false;

		for(int i =0 ;i < context.inventory.size(); i++){
			if(context.inventory.get(i).name.contains("sugar")){
				isSugar = true;
			}
			else if(context.inventory.get(i).name.contains("spice")){
				isSpice = true;
			}
			else if(context.inventory.get(i).name.contains("everythingnice")){
				isEverythingnice = true;
			}
		}

		if(isSugar && isSpice && isEverythingnice){
			return true;
		}
		else
		{
			return false;
		}

	}

	@Override
	public String returnStatus() {
		// TODO Auto-generated method stub
		return "locked";
	}
}
