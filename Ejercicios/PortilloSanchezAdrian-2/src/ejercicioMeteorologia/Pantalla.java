package ejercicioMeteorologia;

public class Pantalla implements Observador {	
	
	private static int temperaturaObservada;
	private static Pantalla instancia;
	ObservablePantalla observablePantalla;
	
	public static Pantalla getPantalla(ObservablePantalla pantalla) {
		 
		if (instancia == null) {		 
			instancia = new Pantalla(pantalla);
		}
		
		return instancia;
	}
	
	private Pantalla(ObservablePantalla pantalla){
		this.observablePantalla = pantalla;
	}
	
	public void manejarEvento(){
		temperaturaObservada = observablePantalla.getTemperatura();
	}
	
	public int getTemperaturaObservada(){
		return temperaturaObservada;
	}
	
	public void refrescarPantalla(){
		System.out.println("La temperatura observada por la pantalla es " + temperaturaObservada);
	}

}
