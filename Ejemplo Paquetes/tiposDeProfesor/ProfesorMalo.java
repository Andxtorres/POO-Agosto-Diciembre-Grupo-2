package tiposDeProfesor;

import modelos.Profesor;

public class ProfesorMalo extends Profesor{

	public ProfesorMalo(String nombre){
		super(nombre);	
	}

	public void imprimeProfesor(){
		System.out.println("El nombre del profesor malo es: "+getNombre());
	}
	public void imprimeProfesor(String materia,String departamento){
		System.out.println("El profesor malo es: "+getNombre()+" y enseña: "+materia+" en "+departamento );
	}	

}