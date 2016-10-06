package ejercicioVisitantes;

public class VisitantePrecio extends VisitanteEquipo {
	
	private double precio;
	private static double descuentoMayorista = 15;
	private static double descuentoVIP = 10;
	private static double descuentoRegular = 0;
	
	public VisitantePrecio(TV tipo) {		
		super(tipo);
		precio = 0;	
	}
	
	public void visitarDisco(Disco d) {
		switch(this.getTipo()){
			case regular:
				precio += d.precioConDescuento(descuentoRegular);
				break;
			case VIP:
				precio += d.precioConDescuento(descuentoVIP);
				break;
			case mayorista:
				precio += d.precioConDescuento(descuentoMayorista);
				break;
		}
	}
	
	public void visitarTarjeta(Tarjeta t) {
		switch(this.getTipo()){
			case regular:
				precio += t.precioConDescuento(descuentoRegular);
				break;
			case VIP:
				precio += t.precioConDescuento(descuentoVIP);
				break;
			case mayorista:
				precio += t.precioConDescuento(descuentoMayorista);
				break;
		}
	}
	
	public void visitarBus(Bus b) {
		switch(this.getTipo()){
			case regular:
				precio += b.precioConDescuento(descuentoRegular);
				break;
			case VIP:
				precio += b.precioConDescuento(descuentoVIP);
				break;
			case mayorista:
				precio += b.precioConDescuento(descuentoMayorista);
				break;
		}
	}
	
	public double precio() {
		return precio;
	}
	
	public static void setDescuentoRegular(double descuento){
		VisitantePrecio.descuentoRegular = descuento;
	}
	
	public static void setDescuentoVIP(double descuento){
		VisitantePrecio.descuentoVIP = descuento;
	}
	
	public static void setDescuentoMayorista(double descuento){
		VisitantePrecio.descuentoMayorista = descuento;
	}
	
	public double getDescuento(){
		switch(this.getTipo()){
			case regular:
				return descuentoRegular;
			case VIP:
				return descuentoVIP;
			case mayorista:
				return descuentoMayorista;
			default:
				return 0;
		}
	}
}