package ejercicioBicicletas;
import java.util.*;

public class CarreraCarretera extends Thread{
	
	private int numCorredores;
	private ArrayList<Bicicleta> corredores;
	Carrera factoriaCarreraCarretera;
	
	public CarreraCarretera (int n){
		this.numCorredores = n;
		factoriaCarreraCarretera = new FactoriaCarreraCarretera();
		corredores = factoriaCarreraCarretera.crearCarrera(n);		
	}	

	public ArrayList<Bicicleta> getCorredores() {
		return corredores;
	}

	public int getNumCorredores() {
		return numCorredores;
	}
	
	
	public void run () {
		System.out.println("Se ha iniciado la carrera de Carretera");
		int retirar = (int) Math.round(numCorredores*0.1);
		
		try {
		    Thread.sleep(60000);                
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		
		Collections.shuffle(corredores);		
		for(int i = 1; i <= retirar; i++){
			System.out.println("Se retira el corredor " + corredores.get(numCorredores-i).getId() + " de la carrera de carretera."); 
			corredores.set(numCorredores-i, null);
		}
		System.out.println("Se han retirado " + retirar + " corredores de la carrera de carretera.");
		System.out.println("\nEl ganador de la carrera de carretera es el corredor con la bicicleta número " + corredores.get(0).getId() + ".\n");		
	}
}
