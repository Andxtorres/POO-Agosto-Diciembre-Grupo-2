public class Artista{
	private String nombre;
	private String nacionalidad;

	public Artista(String nombre,String nacionalidad){
		this.nombre=nombre;
		this.nacionalidad=nacionalidad;
	}

	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	public String getNombre(){
		return nombre;
	}
	public void setNacionalidad(String nacionalidad){
		this.nacionalidad=nacionalidad;
	}

	public String getNacionalidad(){
		return nacionalidad;
	}
}