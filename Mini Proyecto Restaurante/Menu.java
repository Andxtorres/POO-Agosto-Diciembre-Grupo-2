import java.util.*;
import java.io.Serializable;
public class Menu implements Serializable{
	private List<Item> items;

	public Menu(){
		items= new ArrayList<Item>();
	}

	public List<Item> getItems(){
		return items;
	}
}