import tiposDeProfesor.ProfesorBueno;
import tiposDeProfesor.ProfesorMalo;
import modelos.Profesor;

public class Main{
	public static void main(String args[]){
		Profesor[] profesores= new Profesor[2];
		ProfesorBueno p= new ProfesorBueno("Rafael Lozano");
		ProfesorMalo pM= new ProfesorMalo("Andres Torres");
		profesores[0]=p;
		profesores[1]=pM;
		for(int i=0;i<profesores.length;i++){
			profesores[i].imprimeProfesor("Computación","DIA");
		}
	}
}