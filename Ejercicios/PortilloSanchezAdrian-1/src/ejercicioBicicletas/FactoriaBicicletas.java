package ejercicioBicicletas;

public class FactoriaBicicletas {
	
	public FactoriaBicicletas () {}
	
	public Bicicleta crearBicicleta(TC tipo){
		if(tipo == TC.MONTANA)
			return new BicicletaMontaña();
		else
			return new BicicletaCarretera();
	}
	
}
