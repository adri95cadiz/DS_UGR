package ejercicioMeteorologia;

public class PantallaHumedad implements Observador{	
	
	private static int humedadObservada;
	private static PantallaHumedad instancia;	
	ObservableHumedad observableHumedad;
	
	public static PantallaHumedad getPantallaHumedad(ObservableHumedad pantalla) {
		 
		if (instancia == null) {		 
			instancia = new PantallaHumedad(pantalla);
		}
		
		return instancia;
	}
	
	private PantallaHumedad(ObservableHumedad humedad){
		this.observableHumedad = humedad;
	}
	
	public void manejarEvento(){
		humedadObservada = observableHumedad.getHumedad();
	}
	
	public int getHumedadObservada(){
		return humedadObservada;
	}
	
	public void refrescarPantalla(){
		System.out.println("La humedad observada por la pantalla es " + humedadObservada);
	}

}
