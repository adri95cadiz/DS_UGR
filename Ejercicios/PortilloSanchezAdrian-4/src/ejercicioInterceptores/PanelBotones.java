package ejercicioInterceptores;

import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;


public class PanelBotones extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private	javax.swing.JButton BotonAcelerar;
	private javax.swing.JToggleButton BotonEncender;
	private JLabel EtiqMostrarEstado;
	private Boolean isAcelerando;
	private double velocidad;
	/**
	 * Create the panel.
	 */
	public PanelBotones(final Interfaz interfaz) {
		
		setLayout(null);
		isAcelerando = false;
		velocidad = 0;
		BotonEncender = new JToggleButton("Encender");
		BotonEncender.setForeground(Color.blue);
		BotonEncender.setSelected(false);
		BotonEncender.setText("Encender");
		BotonEncender.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(BotonEncender.isSelected()) {
					BotonEncender.setForeground(Color.red);
					BotonEncender.setSelected(true);
					BotonEncender.setText("Apagar");
				}
				else {
					BotonEncender.setForeground(Color.blue);
					BotonEncender.setSelected(false);
					BotonEncender.setText("Encender");
					if(isAcelerando == true){
						EtiqMostrarEstado.setText("APAGADO");
						isAcelerando = false;
						velocidad = 0;
					}
				}
			}
		});
		BotonEncender.setBounds(12, 119, 193, 46);
		add(BotonEncender);
		
		BotonAcelerar = new JButton("Acelerar");
		BotonAcelerar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(BotonEncender.isSelected()){
					EtiqMostrarEstado.setText("ACELERANDO");
					isAcelerando = true;
					interfaz.getCliente().enviarPeticion(velocidad);
				}
			}
		});
		BotonAcelerar.setBounds(234, 119, 193, 46);
		add(BotonAcelerar);
		
		EtiqMostrarEstado = new JLabel("APAGADO");
		EtiqMostrarEstado.setForeground(Color.RED);
		EtiqMostrarEstado.setFont(new Font("Dialog", Font.BOLD, 26));
		EtiqMostrarEstado.setHorizontalAlignment(SwingConstants.CENTER);
		EtiqMostrarEstado.setBounds(12, 33, 426, 46);
		add(EtiqMostrarEstado);

	}	
	
	public void setVelocidad(double velocidad){
		this.velocidad = velocidad;
	}
	
}
