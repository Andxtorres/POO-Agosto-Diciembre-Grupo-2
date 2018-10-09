public class Main{
	public static void main(String args[]){
		Contacto c1= new Contacto("Andres","5541302205");
		Direccion d= new Direccion("Privada Agustin Gutierrez ",100);
		c1.addDireccion(0,d);
		Agenda.addContacto(0,c1);
		Contacto c2= new Contacto("Miguel","55707292634");
		Direccion d2= new Direccion("Falsa direccion ",50);
		c2.addDireccion(2,d2);
		Agenda.addContacto(48,c2);
		for(int i=0; i<Agenda.contactos.length;i++){
			if(Agenda.contactos[i]!=null){
				System.out.println(i+".- "+Agenda.contactos[i].imprimeContacto());
			}else{
				System.out.println(i+".- "+"Vacio");
			}
			
		}
	}
}