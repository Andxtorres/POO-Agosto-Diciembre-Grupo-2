public class Bebida extends Item{

	public Bebida(String nombre,double precio){
		super(nombre,precio);
	}

	public double getPrecio(){
		return getPrecio()*1.10;
	}
}