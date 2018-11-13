import java.io.Serializable;


public class Restaurante implements Serializable{
	private Mesa[] mesas;
	private Menu menu;
	public Restaurante(){
		mesas= new Mesa[20];
		menu= new Menu();
	}

	public Mesa[] getMesas(){
		return mesas;
	}
	public Menu getMenu(){
		return menu;
	}
	public void setMenu(Menu menu){
		this.menu=menu;
	}
}