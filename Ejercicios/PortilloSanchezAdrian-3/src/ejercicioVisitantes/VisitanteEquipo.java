package ejercicioVisitantes;

public abstract class VisitanteEquipo {
	
	private TV tipoVisitante;
	
	public VisitanteEquipo(TV tipo){
		this.tipoVisitante = tipo;
	}
	
	public abstract void visitarDisco(Disco d);
	
	public abstract void visitarTarjeta(Tarjeta t);
	
	public abstract void visitarBus(Bus b);
	
	public TV getTipo(){
		return tipoVisitante;
	}
	
	public String toString(){
		return ("cliente de tipo " + tipoVisitante);
	}
	
}