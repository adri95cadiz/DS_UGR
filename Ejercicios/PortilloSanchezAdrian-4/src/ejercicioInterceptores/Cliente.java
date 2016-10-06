package ejercicioInterceptores;

public class Cliente {
	
	CadenaFiltros cadenaFiltros;
	
	public Cliente(){		
	}
	
	public void setCadenaFiltros(CadenaFiltros cad){
		this.cadenaFiltros = cad;
	}
	
	public void enviarPeticion(double peticion){
		cadenaFiltros.ejecutar(peticion);
	}

}
