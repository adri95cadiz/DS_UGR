package ejercicioMeteorologia;

public class BotonCambio implements Observador {
	
	private Simulador simulador;
	private ObservablePantalla pantalla;
	private int temperatura;
	private static BotonCambio instancia;
	
	public static BotonCambio getBotonCambio(Simulador sim, ObservablePantalla pantalla) {
		 
		if (instancia == null) {		 
			instancia = new BotonCambio(sim, pantalla);
		}
		
		return instancia;
	}
	
	private BotonCambio(Simulador sim, ObservablePantalla pantalla){
		this.pantalla = pantalla;
		this.simulador = sim;	
	}
	
	public void pulsarBoton() {
		simulador.setTemperatura();
		simulador.setHumedad();
	}
	
	public int getTemperaturaObservada(){
		return temperatura;
	}

	public void manejarEvento() {
		temperatura = pantalla.getTemperatura();
	}
	
	public void refrescarPantalla(){
		System.out.println("La temperatura observada por el botonCambio " + temperatura);
	}

}
