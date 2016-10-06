package ejercicioBicicletas;

public abstract class Bicicleta {
	
	private static int id = 0;
	private int idBicicleta;
	private TC tipo;
	private Cuadro cuadro;
	private Manillar manillar;
	private Rueda rueda1, rueda2;
	FactoriaPiezas factoriaPiezas;

	public Bicicleta (TC tipo) {
		this.tipo = tipo;
		factoriaPiezas = new FactoriaPiezas();
		cuadro = factoriaPiezas.crearCuadro(tipo);
		manillar = factoriaPiezas.crearManillar(tipo);
		rueda1 = factoriaPiezas.crearRueda(tipo);
		rueda2 = factoriaPiezas.crearRueda(tipo);
		id++;
		idBicicleta = id;
	}
	
	public TC getTipo() {
		return tipo;
	}
	
	public void setTipo(TC tipo){
		this.tipo = tipo;
		cuadro.setTipo(tipo);
		manillar.setTipo(tipo);
		rueda1.setTipo(tipo);
		rueda2.setTipo(tipo);
	}
	
	public int getId() {
		return idBicicleta;
	}
	
	@Override
	public String toString() {
		return ("Bicicleta de" + tipo);
	}
	
}
