package ejercicioBicicletas;
import java.util.*;

public class CarreraMontaña extends Thread{
	
	private int numCorredores;
	private ArrayList<Bicicleta> corredores;
	Carrera factoriaCarreraMontaña;
	
	public CarreraMontaña (int n){
		this.numCorredores = n;
		factoriaCarreraMontaña = new FactoriaCarreraMontaña();
		corredores = factoriaCarreraMontaña.crearCarrera(n);		
	}	

	public ArrayList<Bicicleta> getCorredores() {
		return corredores;
	}

	public int getNumCorredores() {
		return numCorredores;
	}
	
	
	public void run () {
		System.out.println("Se ha iniciado la carrera de Montaña");
		int retirar = (int) Math.round(numCorredores*0.2);
		
		try {
		    Thread.sleep(60000);                
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		
		Collections.shuffle(corredores);		
		for(int i = 1; i <= retirar; i++){
			System.out.println("Se retira el corredor " + corredores.get(numCorredores-i).getId() + " de la carrera de montaña."); 
			corredores.set(numCorredores-i, null);
		}
		System.out.println("Se han retirado " + retirar + " corredores de la carrera de montaña.");
		System.out.println("\nEl ganador de la carrera de montaña es el corredor con la bicicleta número " + corredores.get(0).getId() + ".\n");		
	}
}
