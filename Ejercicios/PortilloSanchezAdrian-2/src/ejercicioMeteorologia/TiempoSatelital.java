package ejercicioMeteorologia;

public class TiempoSatelital implements Observador {
	
	private ObservablePantalla pantalla;
	private int tiempoSatelital;
	private static TiempoSatelital instancia;
	
	public static TiempoSatelital getTiempoSatelital(ObservablePantalla pantalla) {
		 
		if (instancia == null) {		 
			instancia = new TiempoSatelital(pantalla);
		}
		
		return instancia;
	}
	
	private TiempoSatelital(ObservablePantalla pantalla){
		this.pantalla = pantalla;
	}
	
	public int getTiempoSatelitalObservado(){
		return tiempoSatelital;
	}

	public void manejarEvento() {
		tiempoSatelital = pantalla.getTiempoSatelital();
	}
	
	public void refrescarPantalla(){
		System.out.println("El tiempo satelital es " + this.getTiempoSatelitalObservado() );
	}

}
