package ejercicioMeteorologia;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Simulador extends Thread {
	
	private int t1, t2;		
	private Random r = new Random(t2);
	ObservablePantalla observablePantalla;
	ObservableHumedad observableHumedad;
	Observador pantalla, botonCambio, graficaTemperatura, tiempoSatelital, pantallaHumedad;
	
	public Simulador(int min, int max){
		
		this.t1 = min;
		this.t2 = max;
		
		this.observablePantalla = new ObservablePantalla();
		this.observableHumedad = new ObservableHumedad();
		
		pantalla = Pantalla.getPantalla(observablePantalla);
		observablePantalla.incluirObservador(pantalla);
		botonCambio = BotonCambio.getBotonCambio(this, observablePantalla);
		observablePantalla.incluirObservador(botonCambio);
		graficaTemperatura = GraficaTemperatura.getGraficaTemperatura(observablePantalla);
		observablePantalla.incluirObservador(graficaTemperatura);
		tiempoSatelital = TiempoSatelital.getTiempoSatelital(observablePantalla);
		observablePantalla.incluirObservador(tiempoSatelital);	
		
		pantallaHumedad = PantallaHumedad.getPantallaHumedad(observableHumedad);
		observableHumedad.incluirObservador(pantallaHumedad);
	}	
	
	public void setTemperatura(){
		observablePantalla.setTemperatura(r.nextInt((t2 - t1) + 1) + t1);
		observablePantalla.notificarObservadores();
	}
	
	public void setHumedad(){
		observableHumedad.setHumedad(r.nextInt(100) + 1);
		observableHumedad.notificarObservadores();
	}
	
	
	public void run() {

		while (true){

			observablePantalla.setTemperatura(r.nextInt((t2 - t1) + 1) + t1);
			observablePantalla.notificarObservadores();
			observableHumedad.setHumedad(r.nextInt(100) + 1);
			observableHumedad.notificarObservadores();
	
			try {
				TimeUnit.SECONDS.sleep(60);
			}	
			catch(java.lang.InterruptedException e){	
				e.printStackTrace();	
			}			
			
		}
	}

}
