import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ventana extends JFrame{
	private Agenda agenda;
	private JPanel listaContactosPanel,detalleContactoPanel;
	public JPanel formularioPanel;
	private JMenuBar jMenuBar;
	private JScrollPane listaPane;
	private JMenu jMenu;
	private JMenuItem addContactItem;
	private JLabel nombreLabel,telefonoLabel,posLabel;
	private JButton agregarContactoButton;
	private JTextField nombreTextField,telefonoTextField,posTextField;


	public Ventana(){
		agenda= new Agenda();
		agenda.contactos[10]= new Contacto("Andrés","5541302205");
		agenda.contactos[11]= new Contacto("Jorge","76576125");
		setSize(500,500);
		setLayout(new GridLayout(1,2));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
		setVisible(true);
	}

	public void initComponents(){
		formularioPanel= new JPanel();
		nombreLabel = new JLabel("Nombre: ");
		telefonoLabel = new JLabel("Teléfono: ");
		agregarContactoButton= new JButton("Agregar");
		agregarContactoButton.addActionListener(new AgegarContactoListener());
		nombreTextField= new JTextField(20);
		telefonoTextField= new JTextField(20);
		posLabel= new JLabel("Pos");
		posTextField= new JTextField(20);
		formularioPanel.add(nombreLabel);
		formularioPanel.add(nombreTextField);
		formularioPanel.add(telefonoLabel);
		formularioPanel.add(telefonoTextField);
		formularioPanel.add(posLabel);
		formularioPanel.add(posTextField);
		formularioPanel.add(agregarContactoButton);

		jMenuBar= new JMenuBar();
		jMenu= new JMenu("Archivo");
		jMenuBar.add(jMenu);
		addContactItem= new JMenuItem("Agregar Contacto");
		addContactItem.addActionListener(new AddContactListener(this));
		jMenu.add(addContactItem);
		setJMenuBar(jMenuBar);
		listaContactosPanel= new JPanel();
		detalleContactoPanel= new JPanel();
		detalleContactoPanel.setLayout(new BoxLayout(detalleContactoPanel,BoxLayout.Y_AXIS));
		listaContactosPanel.setLayout(new BoxLayout(listaContactosPanel,BoxLayout.Y_AXIS));
		listaPane= new JScrollPane(listaContactosPanel);
		imprimeListaContactos();
		add(listaPane);
		detalleContactoPanel= new JPanel();
		add(detalleContactoPanel);
	}

	public void imprimeListaContactos(){
		listaContactosPanel.removeAll();
		for(int i=0; i<agenda.contactos.length;i++){
			if(agenda.contactos[i]==null){
				JLabel label= new JLabel(i+".- Vacío");
				listaContactosPanel.add(label);
			}else{
				JButton botonContacto= new JButton(i+".- "+agenda.contactos[i].nombre);
				botonContacto.addActionListener(new ContactoListener(agenda.contactos[i]));
				listaContactosPanel.add(botonContacto);
			}
			
			
		}
		revalidate();
		repaint();			
	}
	public void imprimeDetallesContacto(Contacto c){
		detalleContactoPanel.removeAll();
		detalleContactoPanel.add(new JLabel("Nombre: "+c.nombre));
		detalleContactoPanel.add(new JLabel("Teléfono: "+c.telefono));
		revalidate();
		repaint();
	}
	public class ContactoListener implements ActionListener{
		private Contacto contacto;

		public ContactoListener(Contacto contacto){
			this.contacto= contacto;
		}

		public void actionPerformed(ActionEvent e){
			System.out.println("Presionaste el botón de: "+contacto.nombre);
			imprimeDetallesContacto(contacto);
		}
	}

	public class AddContactListener implements ActionListener{
		private Ventana framePrincipal;

		public AddContactListener(Ventana framePrincipal){
			this.framePrincipal=framePrincipal;
		}
		public void actionPerformed(ActionEvent e){
			framePrincipal.remove(listaPane);
			framePrincipal.remove(detalleContactoPanel);
			framePrincipal.add(framePrincipal.formularioPanel);
			framePrincipal.revalidate();
			framePrincipal.repaint();
		}
	}

	public class AgegarContactoListener implements ActionListener{

		public void actionPerformed(ActionEvent e){
			Contacto c= new Contacto(nombreTextField.getText(),telefonoTextField.getText());
			agenda.contactos[Integer.parseInt(posTextField.getText())]=c;
			System.out.println("Agregué un contacto");
			remove(formularioPanel);
			imprimeListaContactos();
			add(listaPane);
			add(detalleContactoPanel);
			revalidate();
			repaint();
		}
	}

}
