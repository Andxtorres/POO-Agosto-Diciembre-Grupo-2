import javax.swing.*;

public class Main{

	public static void main(String args[]){
		Persona p= new Persona();
		JOptionPane jp= new JOptionPane();
		String nombre=jp.showInputDialog("Ingresa tu nombre:");
		p.setNombre(nombre);
		int edad=Integer.parseInt(jp.showInputDialog("Ingresa tu edad:"));
		p.setEdad(edad);
		System.out.println("El nombre de la persona es: "+p.getNombre()+
			" y su edad es: "+ p.getEdad());
		p.saludar();
		System.out.println("El nombre de la persona es: "+p.getNombre()+
			" y su edad es: "+ p.getEdad());		
	}

}