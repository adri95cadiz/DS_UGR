package ejercicioMeteorologia;

import java.awt.*;
import javax.swing.*;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class GraficaTemperatura extends JPanel implements Observador {

	private static final long serialVersionUID = 1L;
	private int temperatura;
	private int contador; 
	private ObservablePantalla pantalla;
	private XYSeries series;
	private XYSeriesCollection dataset;
	private JFreeChart chart;
	private ChartPanel chartPanel;
	private static GraficaTemperatura instancia;
	
	public static GraficaTemperatura getGraficaTemperatura(ObservablePantalla pantalla) {
		 
		if (instancia == null) {		 
			instancia = new GraficaTemperatura(pantalla);
		}
		
		return instancia;
	}
	
	private GraficaTemperatura(ObservablePantalla pantalla) {
		this.pantalla = pantalla;
		contador = 0;
		setBorder(javax.swing.BorderFactory.createTitledBorder("Gráfica Temperatura"));
		setLayout(new BorderLayout());
		series = new XYSeries("Temperatura");
		dataset = new XYSeriesCollection(series);
		chart = ChartFactory.createXYLineChart("Gráfica Temperatura", "Medidas", "Temperatura (ºC)", dataset, PlotOrientation.VERTICAL, false, false, false);
		chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(400,200));
		add(chartPanel);
		manejarEvento();
	}
	
	public void refrescarPantalla() {
		series.add(contador, temperatura);
		contador++;
	}
	
	public void manejarEvento() {
		temperatura = pantalla.getTemperatura();
		refrescarPantalla();
	}
}
