import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class Ventana extends JFrame{
	private JPanel panelMesas,panelFormaItem,panelMesa,panelItems,panelCompras;
	private Restaurante restaurante;
	private JTextField nombreItemT,precioItemT;
	private JLabel nombreItemL,precioItemL,tipoL;
	private JComboBox tipoCombo;
	private JButton saveItemButton;
	private JMenu menu;
	private JMenuBar menuBar;
	private JMenuItem addItemMenuItem,saveMenuMenuItem,loadMenuMenuItem;
	private int mesaActiva;
	private int itemNumber;

	public Ventana(){
		setSize(600,600);
		restaurante= new Restaurante();
		initMesas();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
		setVisible(true);
	}

	public void initComponents(){
		menuBar= new JMenuBar();
		menu= new JMenu("Archivo");
		addItemMenuItem= new JMenuItem("Nuevo Item");
		saveMenuMenuItem= new JMenuItem("Guardar Menú");
		saveMenuMenuItem.addActionListener(new SaveMenuActionListener());
		loadMenuMenuItem= new JMenuItem("Cargar Menú");
		loadMenuMenuItem.addActionListener(new LoadMenuActionListener());
		addItemMenuItem.addActionListener(new AddMenuItemListener());
		menu.add(addItemMenuItem);
		menu.add(saveMenuMenuItem);
		menu.add(loadMenuMenuItem);
		menuBar.add(menu);
		setJMenuBar(menuBar);
		panelMesas= new JPanel(new GridLayout(5,4));
		panelFormaItem= new JPanel(new GridLayout(4,2));
		nombreItemT= new JTextField(10);
		precioItemT= new JTextField(10);
		nombreItemL= new JLabel("Nombre: ");
		precioItemL= new JLabel("Precio: ");
		tipoL= new JLabel("Tipo: ");
		saveItemButton= new JButton("Guardar");
		String[] tipos = { "Bebida", "Comida"};
		tipoCombo= new JComboBox(tipos);
		panelFormaItem.add(nombreItemL);
		panelFormaItem.add(nombreItemT);
		panelFormaItem.add(precioItemL);
		panelFormaItem.add(precioItemT);
		panelFormaItem.add(tipoL);
		panelFormaItem.add(tipoCombo);
		saveItemButton.addActionListener(new SaveMenuItemListener());
		panelFormaItem.add(saveItemButton);
		panelMesa= new JPanel();
		panelMesa.setLayout(new GridLayout(2,1));
		panelItems= new JPanel(new FlowLayout());
		panelCompras= new JPanel(new FlowLayout());
		panelMesa.add(panelItems);
		panelMesa.add(panelCompras);
		add(panelMesas);
		imprimeMesas();
	}

	public void initMesas(){
		for(int i=0;i<restaurante.getMesas().length;i++){
			restaurante.getMesas()[i]= new Mesa(i);
		}
	}

	public void imprimeMesas(){
		for(int i=0;i<restaurante.getMesas().length;i++){
			JButton b= new JButton("Mesa "+i);
			b.setActionCommand(""+i);
			b.addActionListener(new MesaDetailListener());
			panelMesas.add(b);
			panelMesas.revalidate();
			panelMesas.repaint();
		}
	}

	public void imprimeMesa(Mesa mesa){

		panelCompras.removeAll();
		for(int i=0;i<mesa.getItems().size();i++){
			panelCompras.add(new JLabel(mesa.getItems().get(i).getNombre()));
		}
		revalidate();
		repaint();

	}

	public class AddMenuItemListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			remove(panelMesas);
			add(panelFormaItem);
			revalidate();
			repaint();
		}
	}

	public class SaveMenuItemListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Item item=null;
			int tipo= tipoCombo.getSelectedIndex();
			String nombre= nombreItemT.getText();
			Double precio= Double.parseDouble(precioItemT.getText());
			switch(tipo){
				case 0:
					item= new Bebida(nombre,precio);
					break;
				case 1:
					item= new Comida(nombre,precio);
					break;
			}
			restaurante.getMenu().getItems().add(item);
			remove(panelFormaItem);
			add(panelMesas);
			revalidate();
			repaint();
		}		
	}
	public class MesaDetailListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			mesaActiva=Integer.parseInt(e.getActionCommand());
			System.out.println("MesaActiva: "+mesaActiva);
			remove(panelMesas);
			add(panelMesa);
			panelItems.removeAll();
			for(int i=0;i<restaurante.getMenu().getItems().size();i++){
				JButton itemButton = new JButton(restaurante.getMenu().getItems().get(i).getNombre());
				itemButton.setActionCommand(""+i);
				itemButton.addActionListener(new AddItemToTableListener());
				panelItems.add(itemButton);
			}
			imprimeMesa(restaurante.getMesas()[mesaActiva]);
			revalidate();
			repaint();
		}
	}
	public class AddItemToTableListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			itemNumber=Integer.parseInt(e.getActionCommand());
			Item itemAAgregar= restaurante.getMenu().getItems().get(itemNumber);
			restaurante.getMesas()[mesaActiva].getItems().add(itemAAgregar);
			imprimeMesa(restaurante.getMesas()[mesaActiva]);
		}
	}

	public class SaveMenuActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			try{
				FileOutputStream fos= new FileOutputStream("menu.rest");
				ObjectOutputStream oos= new ObjectOutputStream(fos);
				oos.writeObject(restaurante);
				oos.close();
			}catch(IOException e1){
				e1.printStackTrace();
			}
		}
	}

	public class LoadMenuActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			try{
				FileInputStream fis= new FileInputStream("menu.rest");
				ObjectInputStream ois= new ObjectInputStream(fis);
				restaurante= (Restaurante)ois.readObject();
			}catch(IOException | ClassNotFoundException e1){
				e1.printStackTrace();
			}

			//repintar su mapa (Para su proyecto)
		}
	}










}