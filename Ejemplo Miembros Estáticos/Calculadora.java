public class Calculadora{
	public static int numeroDeOperacionesRealizadas;

	public static double suma(double x, double y){
		numeroDeOperacionesRealizadas++;
		return x+y;
	}

	public static double deCaK(double x){
		numeroDeOperacionesRealizadas++;
		return x+273;
	}
}