import java.util.ArrayList;

public class City extends Location{

	static String des = "Welcome to Townsville, a bustling metropolis nestled on the coast of the ocean."
			+ " The city is a vibrant hub of activity, with towering skyscrapers and bustling streets filled with cars and "
			+ "people.\r\n"
			+ "\r\n"
			+ "As you wander through the city, you can't help but notice the bright and bold colors that seem to be everywhere. "
			+ "From the colorful storefronts and billboards to the neon signs that light up the night, Townsville is a city that's "
			+ "full of life and energy.\nYou see Robin,  a friendly tour guide who knows all about the city's unique features and hidden gems. "
			+ "Hint Hint: You should talk to Robin, she can help you guide your way around"
			+"               _________\r\n"
			+ "              |MMMMMMMMM|                _\r\n"
			+ "  ________    |MMMMMMMMM|              _|l|_\r\n"
			+ " |!!!!!!!_|___|MMMMMMMMM|             |lllll|\r\n"
			+ " |!!!!!!|=========|MMMMM|             |lllll|_______\r\n"
			+ " |!!!!!!|=========|MMMMM|            _|lllll|HHHHHHH|\r\n"
			+ " |!!!!!!|=========|MMMMM|   ________|lllllllll|HHHHH|\r\n"
			+ " |!!!!!!|=========|MMMMM|  |unununun|lllllllll|HHHHH|______\r\n"
			+ " |!!!!!!|=========|MMMMM|  |nunununu|lllllllll|HH|:::::::::|\r\n"
			+ " |!!!!!!|=========|MMM__|..|un__unun|lllllllll|HH|:::::::::|\r\n"
			+ " |!!!!!!|=======_=|M_( ')' );' .)unu|lllllllll|HH|:::::::::|\r\n"
			+ " |!!!_!!|======( )|(. ` ,) (_ ', )un|lllllllll|HH|:::::::::| ~~~\r\n"
			+ " |!!(.)!|===__(`.')_(_ ')_,)(. _)unu|lllllllll|HH|:__::::::|~~  ~~\r\n"
			+ " |!(.`')|==( .)' .)MMM|M|| |un|nunun|lllllllll|``|( ,)_::::| ~~~~ ~\r\n"
			+ "  -(: _)|=(`. ')_)|---|- '  ``|`````|lll____ll|  (_; `'):::|~~~  ~~~\r\n"
			+ "     |  |==(_'_)|=|    ______        ''/\\   \\'   |(_'_)::::|\\~~~~__|)__\r\n"
			+ "     |   ''''|''o/`.-``~~~~~ ``-.     /--\\___\\    ``|`````` /____\\____/\r\n"
			+ " jrei        |  h ( `; ~~~ ~~  ~ )    |M_|#_#|      ' --   __________|~\r\n"
			+ "       --   *      '-.._~~__~..-'   --           -* -     /  ~~~~ ~~~~~~\r\n"
			+ " *   -   -      --           ----         ---         _.-'~~~~~     ~ ~~\r\n"
			+ "__--_________............-------------'''''''''''''''` ~~~~~    ~~~ ~~~~\r\n"
			+ "~~    ~~~~~~~~     ~~~~~~~   ~~~~~~~~~   ~~~~~~~~~~      ~~~~~~~     ~~~\r\n"
			+ "~~~~~~~~~  ~~~~  ~~~~~ ~~~~~~~~~ ~ ~      ~~~~~~ ~~~~~~     ~~~~    ~~~~\r\n"
			+ "~~~~~~~~     ~~~~~~~~~~~~~~~        ~~~~~~~~~~~~ ~~~~~~  ~~~ ~~~~~~  ~~~";
	UI ui;

	public String looking = "Currently you're in the City of Townsville.";
	
	private static City instance;
	
	protected City(UI ui) {
		this.ui= ui;
		//put char to say junkyard, tower, locations
		//ui.print(des);
		characters.add(new Tourguide(ui));
	}
	
	public static synchronized City getInstance(UI ui){
		
		if(instance == null){
			ui.print(des);
		instance = new City(ui);
		}
		return instance;
		}
	
	@Override
	public Location walkNorth() {
		
		return PlayGround.getInstance(ui);
	}

	@Override
	public void walkNorthDesc() {
	}

	@Override
	public Location walkSouth() {
		//tower
		return Tower.getInstance(ui);
	}

	@Override
	public void walkSouthDesc() {
	}

	@Override
	public Location walkWest() {
		return null;
	}

	@Override
	public void walkWestDesc() {
		ui.print("You find a chest full of potions");
		Potions p = new Potions (ui);
		p.randomPotionGenerator();
		items.add(p);
		
	}

	@Override
	public Location walkEast() {
		//junk yard
		return Junkyard.getInstance(ui);
	}

	@Override
	public void walkEastDesc() {

	}

	@Override
	public void lookAround() {

		ui.print(des);
		ui.print(looking);
		
	}

}
