package ejercicioBicicletas;
import java.util.ArrayList;

public class FactoriaCarreraMontaña implements Carrera{
	
	public FactoriaCarreraMontaña () {}
	
	public ArrayList<Bicicleta> crearCarrera(int n){
		FactoriaBicicletas factoriaBicicletas = new FactoriaBicicletas();
		ArrayList<Bicicleta> carrera = new ArrayList<Bicicleta>();
		for(int i = 0; i < n ; i++){
			carrera.add(factoriaBicicletas.crearBicicleta(TC.MONTANA));
		}
		return carrera;
	}
	
}
