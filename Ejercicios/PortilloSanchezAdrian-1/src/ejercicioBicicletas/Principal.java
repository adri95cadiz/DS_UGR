package ejercicioBicicletas;

public class Principal {
	
	public static void main(String [] args){
		int numCorredores = 10 + (int)(Math.random() * 50); 
		CarreraMontaña carreraMontaña = new CarreraMontaña(numCorredores);		
		CarreraCarretera carreraCarretera = new CarreraCarretera(numCorredores);
		
		System.out.println("Se crearán carreras de " + numCorredores + " corredores.\n");
		
		carreraMontaña.start();
		carreraCarretera.start();
	}

}
