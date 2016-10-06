package ejercicioVisitantes;

public class VisitanteNombre extends VisitanteEquipo {
	
	private String nombreDisco;
	private String nombreTarjeta;
	private String nombreBus;
	
	public VisitanteNombre(TV tipo){
		super(tipo);
	}
	
	public void visitarDisco(Disco d) {
		nombreDisco = d.nombre();
	}
	
	public void visitarTarjeta(Tarjeta t) {
		nombreTarjeta = t.nombre();
	}
	
	public void visitarBus(Bus b) {
		nombreBus = b.nombre();
	}

	public String nombreDisco() {
		return nombreDisco;
	}

	public String nombreTarjeta() {
		return nombreTarjeta;
	}

	public String nombreBus() {
		return nombreBus;
	}
	
}