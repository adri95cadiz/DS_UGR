package ejercicioMeteorologia;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Panel;

@SuppressWarnings("serial")
public class MainView extends JFrame {

	private JPanel contentPane;	
	private Simulador sim;
	private ObservablePantalla pant;
	private ObservableHumedad hum;
	private Pantalla pantalla;
	private BotonCambio botonCambio;
	private TiempoSatelital tiempoSatelital;
	private PantallaHumedad pantallaHumedad;
	private GraficaTemperatura graficaTemperatura;

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
		setTitle("Programa Meteorológico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel lblLabeltemperatura = new JLabel("LabelTemperatura");
		lblLabeltemperatura.setFont(new Font("Dialog", Font.BOLD, 32));
		lblLabeltemperatura.setBounds(12, 44, 131, 80);
		contentPane.add(lblLabeltemperatura);
		
		final JLabel lblLabelhumedad = new JLabel("LabelHumedad");
		lblLabelhumedad.setFont(new Font("Dialog", Font.BOLD, 32));
		lblLabelhumedad.setBounds(155, 34, 131, 101);
		contentPane.add(lblLabelhumedad);
		
		final JLabel lblLabeltiemposatelital = new JLabel("LabelTiempoSatelital");
		lblLabeltiemposatelital.setFont(new Font("Dialog", Font.BOLD, 32));
		lblLabeltiemposatelital.setBounds(280, 34, 131, 101);
		contentPane.add(lblLabeltiemposatelital);
		
		JLabel lblTemperatura = new JLabel("Temperatura:");
		lblTemperatura.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTemperatura.setBounds(12, 30, 131, 15);
		contentPane.add(lblTemperatura);
		
		sim = new Simulador(15,40);
		
		pant = new ObservablePantalla();
		hum = new ObservableHumedad();
		
		pantalla = Pantalla.getPantalla(pant);
		botonCambio = BotonCambio.getBotonCambio(sim, pant);
		graficaTemperatura = GraficaTemperatura.getGraficaTemperatura(pant);
		tiempoSatelital = TiempoSatelital.getTiempoSatelital(pant);
		pantallaHumedad = PantallaHumedad.getPantallaHumedad(hum);
		
		sim.start();		
		
		lblLabeltemperatura.setText(pantalla.getTemperaturaObservada()+"ºC");
		lblLabelhumedad.setText(pantallaHumedad.getHumedadObservada()+"%");		
		lblLabeltiemposatelital.setText(tiempoSatelital.getTiempoSatelitalObservado()+"ºC");
		
		JButton btnActualizarMedidas = new JButton("Actualizar Medidas");
		btnActualizarMedidas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblLabeltemperatura.setText(pantalla.getTemperaturaObservada()+"ºC");
				lblLabelhumedad.setText(pantallaHumedad.getHumedadObservada()+"%");		
				lblLabeltiemposatelital.setText(tiempoSatelital.getTiempoSatelitalObservado()+"ºC");
			}
		});
		btnActualizarMedidas.setBounds(22, 110, 169, 25);
		contentPane.add(btnActualizarMedidas);
		
		JButton btnCambiarTemperatura = new JButton("Cambiar Temperatura");
		btnCambiarTemperatura.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				botonCambio.pulsarBoton();
			}
		});
		btnCambiarTemperatura.setBounds(213, 110, 198, 25);
		contentPane.add(btnCambiarTemperatura);
		
		JLabel lblHumedad = new JLabel("Humedad:");
		lblHumedad.setFont(new Font("Dialog", Font.BOLD, 16));
		lblHumedad.setBounds(155, 31, 97, 14);
		contentPane.add(lblHumedad);
		
		JLabel lblTiempoSatelital = new JLabel("Tiempo Satelital:");
		lblTiempoSatelital.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTiempoSatelital.setBounds(284, 30, 164, 15);
		contentPane.add(lblTiempoSatelital);		
		
		Panel panel = new Panel();
		panel.setBounds(12, 141, 426, 211);
		contentPane.add(panel);
		panel.add(graficaTemperatura, BorderLayout.NORTH);
	}
}
