import javax.swing.JOptionPane;

public class Main{

	public static void main(String args[]){
		/*
			Tarea: 

			Pedir al usuario que ingrese los datos para un convertidor de
			temperatura el cual podrá:

			- Cambiar de C a K
			- Cambiar de C a F
			- Cambiar de K a F
			- Cambiar de F a K
			- Cambiar de F a C
			- Cambiar de K a C
		*/
		int respuesta=0;
		do{
		
			respuesta = Integer.parseInt(JOptionPane.showInputDialog(""+
				"Ingresa la conversión que quieres hacer \n"+
				"1.- De C a K \n"+
				"2.- De C a F \n"+
				"0.- Salir"
			));

			switch(respuesta){
				case 1:
					double aCambiar= Double.parseDouble(JOptionPane.showInputDialog("Ingresa el valor en C"));
					JOptionPane.showMessageDialog(null, "El resultado es: "+Calculadora.deCaK(aCambiar)+" K");
				break;
			}
			System.out.println("Haz realizado: "+Calculadora.numeroDeOperacionesRealizadas+" operaciones");
			Calculadora c1= new Calculadora();
			System.out.println("Haz realizado: "+c1.numeroDeOperacionesRealizadas+" operaciones desde el objeto");

		}while(respuesta!=0);

		System.exit(0);
		/*
		double numero1= Double.parseDouble(JOptionPane.showInputDialog("Ingresa el número 1"));
		double numero2= Double.parseDouble(JOptionPane.showInputDialog("Ingresa el número 2"));

		JOptionPane.showMessageDialog(null, "El resultado es: "+Calculadora.suma(numero1,numero2));
		*/
	}
}