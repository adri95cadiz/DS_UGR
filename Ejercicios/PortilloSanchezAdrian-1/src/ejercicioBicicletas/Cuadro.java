package ejercicioBicicletas;

public abstract class Cuadro {
	
	private TC tipo;
	
	public Cuadro( TC tipo ){
		this.tipo = tipo;
	}
	
	public TC getTipo() {
		return tipo;
	}
	
	public void setTipo(TC tipo){
		this.tipo = tipo;
	}

}
