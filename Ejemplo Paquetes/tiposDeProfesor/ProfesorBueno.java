package tiposDeProfesor;

import modelos.Profesor;

public class ProfesorBueno extends Profesor{

	public ProfesorBueno(String nombre){
		super(nombre);	
	}

	public void imprimeProfesor(){
		System.out.println("El nombre del profesor bueno es: "+getNombre());
	}


	public void imprimeProfesor(String materia){
		System.out.println("El profesor bueno es: "+getNombre()+" y enseña: "+materia);
	}
	public void imprimeProfesor(String materia,String departamento){
		System.out.println("El profesor bueno es: "+getNombre()+" y enseña: "+materia+" en "+departamento );
	}	
}