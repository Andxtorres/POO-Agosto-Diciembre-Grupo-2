public class Cancion{

	private String titulo;
	private Artista artista;
	private double duracion;
	private String genero;

	public Cancion(String titulo, double duracion, String genero, String nombreArtista,String nacionalidadArtista){
		this.titulo=titulo;
		this.duracion=duracion;
		this.genero=genero;
		artista= new Artista(nombreArtista,nacionalidadArtista);
	}


	public void setTitulo(String titulo){
		this.titulo=titulo;
	}

	public String getTitulo(){
		return titulo;
	}
	public void setTitulo(Artista artista){
		this.artista=artista;
	}

	public Artista getArtista(){
		return artista;
	}
	public void setDuracion(double duracion){
		this.duracion=duracion;
	}

	public double getDuracion(){
		return duracion;
	}
	public void setGenero(String genero){
		this.genero=genero;
	}

	public String getGenero(){
		return genero;
	}

}