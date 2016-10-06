package ejercicioMeteorologia;
import java.util.ArrayList;

public abstract class Observable {
	
	ArrayList<Observador> observadores;
	
	public Observable(){
		observadores = new ArrayList<Observador>();
	}

	public void incluirObservador(Observador observador) {
		observadores.add(observador);				
	}

	public void notificarObservadores(){
		for(int i = 0; i < observadores.size(); i++){
			observadores.get(i).manejarEvento();
		}
	}

}
