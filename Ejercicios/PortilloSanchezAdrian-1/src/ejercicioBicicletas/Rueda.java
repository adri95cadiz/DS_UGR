package ejercicioBicicletas;

public abstract class Rueda {
	
	private TC tipo;
	
	public Rueda( TC tipo ){
		this.tipo = tipo;
	}
	
	public TC getTipo() {
		return tipo;
	}
	
	public void setTipo(TC tipo){
		this.tipo = tipo;
	}

}
