package ejercicioMeteorologia;

public class ObservablePantalla extends Observable {	

	private int temperatura, tiempoSatelital;
	
	public ObservablePantalla(){
		super();
	}

	public int getTemperatura(){
		return temperatura;
	}	
	
	public int getTiempoSatelital(){
		return tiempoSatelital;
	}	
	
	public void setTemperatura(int temperatura){
		this.temperatura = temperatura;
		this.tiempoSatelital = temperatura + 1;
	}

}
