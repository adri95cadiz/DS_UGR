package ejercicioInterceptores;

import java.util.ArrayList;

public class CadenaFiltros {
	
	private ArrayList<Filtro> filtros;
	
	private Interfaz objetivo;
	
	public CadenaFiltros(){
		filtros = new ArrayList<Filtro>();
	}
	
	public void addFiltro(Filtro filtro) {
		filtros.add(filtro);
	}
	
	public void ejecutar (double peticion){
		for	(Filtro	filtro:	filtros	){
			double velocidad = filtro.ejecutar(peticion);
			System.out.println("Nueva velocidad = " + velocidad + " km/h");
			objetivo.setVelocidad(velocidad);
		}
		objetivo.ejecutar(peticion);
	}
	
	public void	setObjetivo(Interfaz objetivo){
		this.objetivo = objetivo;
	}
	
}