public class Playlist{

	private Cancion[] canciones;

	public Playlist(){
		canciones= new Cancion[50];
	}

	public void agregarCancion(Cancion cancion,int index){
		canciones[index]=cancion;
	}

	public Cancion[] getCanciones(){
		return canciones;
	}

	public void imprimePlaylist(){
		for(int i=0;i<canciones.length;i++){
			if(canciones[i]!=null){
				System.out.println(i+".- "+canciones[i].getTitulo());

			}else{
				System.out.println(i+".- Vacío");

			}
		}
	}
}