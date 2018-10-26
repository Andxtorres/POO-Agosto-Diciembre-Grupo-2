import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ventana extends JFrame{

	private JPanel panelForma, panelCanciones;
	private JLabel tituloL,duracionL,generoL,artistaL,nacionalidadL,posL;
	private JTextField tituloT,duracionT,generoT,artistaT,nacionalidadT,posT;
	private JButton agregarButton;
	private JScrollPane scrollPane;
	private Playlist playlist;
	private JComboBox<String> generoCombo;


	public Ventana(){
		setSize(500,500);
		setLayout(new GridLayout(1,2));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Playlists");
		initComponents();
		setVisible(true);
	}

	public void initComponents(){
		playlist= new Playlist();
		panelForma= new JPanel();
		panelCanciones= new JPanel();
		panelCanciones.setLayout(new BoxLayout(panelCanciones,BoxLayout.Y_AXIS));
		panelForma.setLayout(new GridLayout(7,2));
		tituloL= new JLabel("Título: ");
		duracionL= new JLabel("Duración: ");
		artistaL= new JLabel("Artista: ");
		nacionalidadL= new JLabel("Nacionalidad: ");
		generoL= new JLabel("Género: ");
		posL= new JLabel("Pos: ");
		tituloT= new JTextField(10);
		duracionT= new JTextField(10);
		//generoT= new JTextField(10);
		String[] generos = { "Rock", "Pop", "Jazz", "Indie", "Clasica" };

		generoCombo= new JComboBox<String>(generos);
		artistaT= new JTextField(10);
		nacionalidadT= new JTextField(10);
		posT= new JTextField(10);
		agregarButton= new JButton("Agregar");
		agregarButton.addActionListener(new AgregarListener());
		panelForma.add(tituloL);
		panelForma.add(tituloT);
		panelForma.add(duracionL);
		panelForma.add(duracionT);
		panelForma.add(generoL);
		panelForma.add(generoCombo);
		panelForma.add(artistaL);
		panelForma.add(artistaT);
		panelForma.add(nacionalidadL);
		panelForma.add(nacionalidadT);
		panelForma.add(posL);
		panelForma.add(posT);
		panelForma.add(agregarButton);
		panelForma.add(new JLabel());
		add(panelForma);
		scrollPane= new JScrollPane(panelCanciones);
		add(scrollPane);
		imprimeCanciones();
	}

	public void imprimeCanciones(){
		panelCanciones.removeAll();
		Cancion[] canciones= playlist.getCanciones();
		for(int i=0;i<canciones.length;i++){
			if(canciones[i]!=null){
				panelCanciones.add(new JLabel(i+".- "+canciones[i].getTitulo()));
			}else{
				panelCanciones.add(new JLabel(i+".- Vacío"));

			}
		}
		revalidate();
		repaint();
	}
	public class AgregarListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String titulo=tituloT.getText();
			double duracion=Double.parseDouble(duracionT.getText());
			String genero=(String)generoCombo.getSelectedItem();
			String nombreArtista=artistaT.getText();
			String nacionalidadArtista=nacionalidadT.getText();
			Cancion c= new Cancion(titulo,duracion,genero,nombreArtista,nacionalidadArtista);
			int pos= Integer.parseInt(posT.getText());
			playlist.agregarCancion(c,pos);
			imprimeCanciones();
			generoCombo.setSelectedIndex(0);
			tituloT.setText("");
			duracionT.setText("");
			artistaT.setText("");
			nacionalidadT.setText("");
			posT.setText("");
		}
	}








}