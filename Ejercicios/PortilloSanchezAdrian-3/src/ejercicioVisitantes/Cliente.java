package ejercicioVisitantes;

import java.util.Random;

public class Cliente extends Thread {
	
	private VisitantePrecio vp;
	private VisitanteNombre vn;
	private static Random r = new Random(0);
	private static int nClients = 0;
	private static int nRegulares = 0;
	private static int nVIPs = 0;
	private static int nMayoristas = 0;
	private int numClient;
	private String[] fila;
		
	public Cliente(){
		TV tipo;
		int nTipo = r.nextInt((2) + 1);
		switch(nTipo) {
			case 0:
				tipo = TV.regular;
				nRegulares++;
				if(nRegulares == 25)
					VisitantePrecio.setDescuentoRegular(5);
				break;
			case 1:
				tipo = TV.VIP;
				nVIPs++;
				if(nVIPs == 25)
					VisitantePrecio.setDescuentoVIP(15);
				break;
			case 2: 
				tipo = TV.mayorista;
				nMayoristas++;
				if(nMayoristas == 25)
					VisitantePrecio.setDescuentoMayorista(20);
				break;
			default:
				tipo = null;
		}
		vp = new VisitantePrecio(tipo);
		vn = new VisitanteNombre(tipo);		
		numClient = nClients;
		nClients++;		
	}	
	
	public void run() {
		
		Equipo d = new Disco("Disco "+numClient, r.nextInt((150 - 50) + 1) + 50, r.nextInt((400 - 200) + 1) + 200); 
		Equipo t = new Tarjeta("Tarjeta "+numClient, r.nextInt((500 - 200) + 1) + 200, r.nextInt((600 - 200) + 1) + 200);
		Equipo b = new Bus("Bus "+numClient, r.nextInt((20 - 5) + 1) + 5, 50);		
		
		d.aceptar(vp);
		t.aceptar(vp);
		b.aceptar(vp);
		
		d.aceptar(vn);
		t.aceptar(vn);
		b.aceptar(vn);
		
		fila = new String[]{
			vp.getTipo().toString(),
			vn.nombreDisco(),
			Double.toString(d.precioNeto()),
			vn.nombreTarjeta(),
			Double.toString(t.precioNeto()),
			vn.nombreBus(),
			Double.toString(b.precioNeto()),
			Double.toString(vp.getDescuento()),
			Double.toString(((VisitantePrecio)vp).precio())    	
		};
		
	}
	
	public String[] getFila(){
		return fila;
	}
	
	public static String getClientes() {
		return ("Hay " + nClients + " clientes, de los cuales: " + nRegulares + " son regulares, " + nVIPs + " son VIPs, y " + nMayoristas + " son mayoristas.");
	}
	
}