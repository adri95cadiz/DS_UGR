package ejercicioInterceptores;

public class Calcular implements Filtro {

	public double ejecutar(Object o) {
		double velocidad = (double) o;
		return velocidad + 10;
	}
}

