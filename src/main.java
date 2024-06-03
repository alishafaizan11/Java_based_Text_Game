import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		UI ui = new UI();
		ArrayList<ConcreteSubject> a = new ArrayList<ConcreteSubject>();
		a.add(ui);
		
		Player player = Player.getInstance(a,ui);
		TCPClient sensors = new TCPClient("10.25.150.35", 64565);
	}
}

																	