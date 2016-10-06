package ejercicioBicicletas;

public abstract class Manillar {
	
	private TC tipo;
	
	public Manillar( TC tipo ){
		this.tipo = tipo;
	}
	
	public TC getTipo() {
		return tipo;
	}
	
	public void setTipo(TC tipo){
		this.tipo = tipo;
	}

}
