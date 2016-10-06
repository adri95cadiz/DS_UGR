package ejercicioInterceptores;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Interfaz extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CadenaFiltros cadenaFiltros;
	private Cliente cliente;
	private PanelBotones panel;

	/**
	 * Launch the application.
	*/ 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public Interfaz() {		
		
		cadenaFiltros = new CadenaFiltros();
		cadenaFiltros.setObjetivo(this);
		cadenaFiltros.addFiltro(new Calcular());
		cliente = new Cliente();
		cliente.setCadenaFiltros(cadenaFiltros);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		panel = new PanelBotones(this);
		setTitle("Sistema de Control Autómatico de Vehículo");
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setPreferredSize(new Dimension(438, 201));
		
		this.addWindowListener(new WindowAdapter(){
			public void	windowClosing(WindowEvent e){
				System.exit(0);
			}
		});		
		
	}
	
	public Cliente getCliente(){
		return cliente;
	}
	
	public void	ejecutar(double	peticion){
		this.pack();
		this.setVisible(true);
		System.out.println("A partir de una velocidad de = " + peticion + "km/h");
	}
	
	public void setVelocidad(double velocidad){
		panel.setVelocidad(velocidad);
	}
	
}
