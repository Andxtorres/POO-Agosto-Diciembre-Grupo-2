public class Main{
	public static void main(String args[]){
		/*
		Persona p = null;
		System.out.println("Antes del print");
		try{
			System.out.println("Mi String: "+p.nombre);

		}catch(NullPointerException e){
			p= new Persona();
			System.out.println("Mi String: "+p.nombre);

		}
		System.out.println("Después del print del print");
		*/
		/*
		try{
			int resultado= 10/0;
			System.out.println("El resultado es:"+resultado);			
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Después del print del print");
		*/
		try{
			Producto p = new Producto(-100.0);
			System.out.println("El precio del producto es: $" + p.precio);

		}catch(PrecioNegativoException e){
			System.out.println("El precio no puede ser negativo");
		}
	}







}