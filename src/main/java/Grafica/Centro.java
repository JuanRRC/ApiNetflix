package Grafica;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Centro extends JPanel {

	private Izquierdo formulario;
	private JTable tablaP;
	private String[] columnas = {" Titulo ", " Rating ", " Año "};
	private ArrayList<Object[]> personas = new ArrayList<Object[]>();
	private DefaultTableModel table_model;
	private Object[][] datos2; 
	 private Map<Integer, String> mapa3 = new TreeMap<Integer, String>();
	 
	public Centro() {
		
		datos2 = personas.toArray(new Object[personas.size()][]);
		table_model = new DefaultTableModel(datos2, columnas);
		tablaP = new JTable(table_model);
		
		
		formulario = new Izquierdo(table_model, personas);
		//mapa=new Derecho(formulario.getMapa());
		//this.add(mapa, BorderLayout.EAST);

	}
	
	
}
