package ejercicioVisitantes;

public class Bus extends Equipo {
	
	private double potencia;
	private double precio;
	
	Bus(String nombre, double precio, double potencia) {
		super(nombre);
		this.precio = precio;
		this.potencia = potencia;
	}
	
	public double potencia() {
		return potencia;
	}
	
	public double precioNeto() {
		return precio;
	}
	
	public double precioConDescuento(double descuento) {
		return precio - ((descuento/100) * precio);
	}
	
	public void aceptar(VisitanteEquipo ve) {
		ve.visitarBus(this);
	}
}