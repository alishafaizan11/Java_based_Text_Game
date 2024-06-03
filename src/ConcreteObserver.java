import java.util.ArrayList;

public class ConcreteObserver implements Observer {
	ArrayList<ConcreteSubject> subjects;
public ConcreteObserver(ArrayList<ConcreteSubject> subject)
{
	
this.subjects = subject;
for(int i=0; i<subject.size(); i++) {
subject.get(i).registerObserver(this);
}
}
public void update(Message m) {
System.out.println("do nothing from "+this);
}
}