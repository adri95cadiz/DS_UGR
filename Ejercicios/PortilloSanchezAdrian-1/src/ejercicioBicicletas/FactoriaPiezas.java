package ejercicioBicicletas;

public class FactoriaPiezas {
	
	public FactoriaPiezas() {}
	
	public Cuadro crearCuadro(TC tipo){
		if(tipo == TC.MONTANA)
			return new CuadroMontaña();
		else
			return new CuadroCarretera();
	}
	public Manillar crearManillar(TC tipo){
		if(tipo == TC.MONTANA)
			return new ManillarMontaña();
		else
			return new ManillarCarretera();		
	}
	public Rueda crearRueda(TC tipo){
		if(tipo == TC.MONTANA)
			return new RuedaMontaña();
		else
			return new RuedaCarretera();		
	}

}
