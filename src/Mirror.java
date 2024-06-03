
public class Mirror extends Items{
	 UI ui;

    public Mirror(UI ui,String name, String des){
        super(ui, "mirror", "Reflective object that can help in defeating Sedusa");
        this.ui = ui;
    }

    @Override
    public void use(){
        ui.print("This item can help you fight Sedusa, invoke it then!");
    }   

}


