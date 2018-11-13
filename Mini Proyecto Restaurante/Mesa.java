import java.util.*;
import java.io.Serializable;
public class Mesa implements Serializable{
	private int numMesa;
	private List<Item> items;

	public Mesa(int numMesa){
		this.numMesa=numMesa;
		items = new ArrayList<Item>();
	} 

	public List<Item> getItems(){
		return items;
	}
}