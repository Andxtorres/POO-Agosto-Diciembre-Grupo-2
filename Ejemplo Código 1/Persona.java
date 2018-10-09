
public class Persona{

	private String nombre;
	private int edad;

	public void setNombre(String nombre){
		this.nombre= nombre;
	}

	public String getNombre(){
		return nombre;
	}

	public int getEdad(){
		return edad;
	}
	public void setEdad(int edad){
		this.edad=edad;
	}

	public void saludar(){
		nombre= nombre+ " Torres";
		System.out.println("Hola soy: "+ nombre);
	}
}