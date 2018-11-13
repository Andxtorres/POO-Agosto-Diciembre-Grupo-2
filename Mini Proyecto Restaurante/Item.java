import java.io.Serializable;
public abstract class Item implements Serializable{
	private String nombre;
	private double precio;

	public Item(String nombre, double precio){
		this.nombre= nombre;
		this.precio=precio;
	}

	public double getPrecio(){
		return precio;
	}

	public String getNombre(){
		return nombre;
	}
}