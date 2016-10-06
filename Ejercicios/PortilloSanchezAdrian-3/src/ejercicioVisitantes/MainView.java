package ejercicioVisitantes;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class MainView extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
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
	public MainView() {
		
		setTitle("Tabla de Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);		
		
		String[] Column = new String[] {
				"TipoCliente",
				"NombreDisco",
				"PrecioDisco",
				"NombreTarjeta",
				"PrecioTarjeta",
				"NombreBus",
				"PrecioBus",
				"DescAplicado",
				"PrecioTotal" 
			};
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		for(int i = 0; i < 100; i++){
			clientes.add(new Cliente());
		}		
		
		for(int i = 0; i < 100; i++){
			clientes.get(i).run();
		}

		String[][] datoColumna = new String[100][9];
		
		for(int i = 0; i < 100; i++){
			try {
				clientes.get(i).join();
				datoColumna[i] = clientes.get(i).getFila();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		table = new JTable(datoColumna, Column);		
		scrollPane.setViewportView(table);
		
		System.out.println(Cliente.getClientes());
	}

}
