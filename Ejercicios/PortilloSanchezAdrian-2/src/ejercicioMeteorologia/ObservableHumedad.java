package ejercicioMeteorologia;

public class ObservableHumedad extends Observable {	

	private int humedad;
	
	public ObservableHumedad(){
		super();
	}

	public int getHumedad(){
		return humedad;
	}	
	
	public void setHumedad(int humedad){
		this.humedad = humedad;
	}

}