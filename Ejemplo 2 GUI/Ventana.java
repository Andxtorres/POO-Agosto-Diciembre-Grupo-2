import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Ventana extends JFrame{

	private Todo todo;
	private JPanel panelTodos,panelForma;
	private JScrollPane scollPane;
	private JTextField todoTextField;
	private JLabel todoLabel;
	private JButton saveButton;

	public Ventana(){
		todo= new Todo();
		setSize(500,500);
		setLayout(new GridLayout(2,1));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
		setVisible(true);
	}

	public void initComponents(){
		panelTodos= new JPanel();
		panelTodos.setLayout(new BoxLayout(panelTodos,BoxLayout.Y_AXIS));
		scollPane= new JScrollPane(panelTodos);
		panelForma= new JPanel();
		panelForma.setLayout(new FlowLayout());
		todoLabel= new JLabel("To do");
		todoTextField= new JTextField(40);
		panelForma.add(todoLabel);
		panelForma.add(todoTextField);
		saveButton= new JButton("Guardar");
		saveButton.addActionListener(new BotonListener());
		panelForma.add(saveButton);
		printTodos();
		add(scollPane);
		add(panelForma);
	}

	public void printTodos(){
		panelTodos.removeAll();
		for(int i=0;i<todo.getTodos().length;i++){
			if(todo.getTodos()[i]==null){
				panelTodos.add(new JLabel("Nada que hacer"));
			}else{
				panelTodos.add(new JLabel(todo.getTodos()[i]));
			}
		}
		revalidate();
		repaint();
	}

	public class BotonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			for(int i=0;i<todo.getTodos().length;i++){
				if(todo.getTodos()[i]==null){
					todo.getTodos()[i]=todoTextField.getText();
					printTodos();	
					return;
				}
			}
				
		}
	}







}