import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Ventana extends JFrame{

	private JLabel label1,label2,label3,label4,label5;
	private JPanel panel1,panel2,panel3,panel4;
	private JButton boton1;

	public Ventana(){
		super("Mi ventana");
		setLayout(new GridLayout(2,2));
		initComponents();
		
	}


	public void initComponents(){
		setSize(400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel1= new JPanel();
		TitledBorder border1 = new TitledBorder("Panel1");
		panel1.setLayout(new FlowLayout());	
		panel1.setBorder(border1);	
		add(panel1);
		panel2= new JPanel();
		TitledBorder border2 = new TitledBorder("Panel2");
		panel2.setLayout(new GridLayout(2,1));	
		panel2.setBorder(border2);	
		add(panel2);	
		panel3= new JPanel();
		TitledBorder border3 = new TitledBorder("Panel3");
		panel3.setLayout(new FlowLayout());	
		panel3.setBorder(border3);	
		add(panel3);	
		panel4= new JPanel();
		TitledBorder border4 = new TitledBorder("Panel4");
		panel4.setLayout(new FlowLayout());	
		panel4.setBorder(border4);	
		add(panel4);	

		label1= new JLabel("Label 1");
		panel2.add(label1);
		label2= new JLabel("Label 2");
		panel2.add(label2);	
		ImageIcon buttonImage= new ImageIcon("assets/asset_botton.png");
		boton1= new JButton(buttonImage);
		boton1.setBackground(null);
		boton1.setBorder(null);
		boton1.addActionListener(new BotonListener());
		panel1.add(boton1);											
		setVisible(true);

	}

	public class BotonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println("Presionaste el boton");
			label1.setText("Botón presionado");

		}
	}









}