package Grafica;

import com.mycompany.mavenproject1.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import org.json.JSONObject;

public class Derecho extends JPanel implements ActionListener {

    public static final String AGREGAR = "AGREGAR";
    public static final String LISTAR = "LISTAR";
    public static final String RATING = "RATING";
    public static final String AÑO = "AÑO";
    
	private Izquierdo favo;
	private JButton agregar,listar,Orating,Oaño;
	private DefaultTableModel referencia_tabla_model;
	private ArrayList<Object[]> referencia_almacen;
	private String[] columnas = {" Titulo ", " Rating ", " Año "};
	private ArrayList<Favoritos2> lista2 = new ArrayList<Favoritos2>();
	private ArrayList<Favoritos> lista = new ArrayList<Favoritos>();
	
	
	
	//DefaultTableModel referencia_tabla_model, ArrayList<Object[]> referencia_almacen
	
	

	public ArrayList<Favoritos> getLista() {
		return lista;
	}

	public ArrayList<Favoritos2> getLista2() {
		return lista2;
	}

	public void setLista2(ArrayList<Favoritos2> lista2) {
		this.lista2 = lista2;
	}

	public void setLista(ArrayList<Favoritos> lista) {
		this.lista = lista;
	}

	public Derecho(DefaultTableModel referencia_tabla_model, ArrayList<Object[]> referencia_almacen) {
		super();
		this.referencia_tabla_model = referencia_tabla_model;
		this.referencia_almacen = referencia_almacen;
		
	    this.iniciar();  
	}

	public void iniciar() {

		 		
        setLayout( new GridBagLayout( ) );

        Border borde = BorderFactory.createTitledBorder( "Opciones" );
        setBorder( borde );
        
       
        GridBagConstraints constraint = new GridBagConstraints( );

        constraint.gridx = 0;
        constraint.gridy = 0;
        constraint.fill = GridBagConstraints.BOTH;

        Insets insets = new Insets( 5, 10, 5, 10 );
        constraint.insets = insets;
        
        
        agregar = new JButton( "Agregar a Favoritos" );
        agregar.addActionListener( this );
        agregar.setActionCommand( AGREGAR );	       
        constraint = new GridBagConstraints( );
        constraint.gridx = 0;
        constraint.gridy = 3;
        constraint.fill = GridBagConstraints.BOTH; 
        insets = new Insets( 5, 10, 5, 10 );
        constraint.insets = insets;	        
        add( agregar, constraint );
        
        
        listar = new JButton( "Ver favoritos" );
        listar.addActionListener( this );
        listar.setActionCommand( LISTAR );	       
        constraint = new GridBagConstraints( );
        constraint.gridx = 0;
        constraint.gridy = 6;
        constraint.fill = GridBagConstraints.BOTH; 
        insets = new Insets( 5, 10, 5, 10 );
        constraint.insets = insets;	        
        add( listar, constraint );
        
        
        Orating = new JButton( "Ordenar por puntaje" );
        Orating.addActionListener( this );
        Orating.setActionCommand( RATING );	       
        constraint = new GridBagConstraints( );
        constraint.gridx = 0;
        constraint.gridy = 9;
        constraint.fill = GridBagConstraints.BOTH; 
        insets = new Insets( 5, 10, 5, 10 );
        constraint.insets = insets;	        
        add( Orating, constraint );
        
        
        Oaño = new JButton( "Ordenar por año" );
        Oaño.addActionListener( this );
        Oaño.setActionCommand( AÑO );	       
        constraint = new GridBagConstraints( );
        constraint.gridx = 0;
        constraint.gridy = 10;
        constraint.fill = GridBagConstraints.BOTH; 
        insets = new Insets( 5, 10, 5, 10 );
        constraint.insets = insets;	        
        add( Oaño, constraint );
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String accion = e.getActionCommand( );
        if( accion.equals( AGREGAR ) ) {
        	
        	
        	try {
        		String titulo;
            	titulo = JOptionPane.showInputDialog("Digite el titulo de la pelicula");
				agregar(titulo);
				JOptionPane.showMessageDialog(null,"Pelicula Agregada");
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null,"No ingreso pelicula");
				
			}
        	
        }
        
        if( accion.equals( LISTAR ) ) {
        	
        	 Iterator<Favoritos> it = lista.iterator();
             Favoritos ob;
             while (it.hasNext()){
                 ob = it.next();
                 referencia_almacen.add(ob.getDetalles());
         		 Object[][] datos = referencia_almacen.toArray(new Object[referencia_almacen.size()][]);
         		 referencia_tabla_model.setDataVector(datos, columnas);
                  
             }
        	      		
              
        }
        
        if( accion.equals( RATING ) ) {
        	
         Collections.sort(lista);
         
       	 Iterator<Favoritos> it = lista.iterator();
         Favoritos ob;
         while (it.hasNext()){
             ob = it.next();
             referencia_almacen.add(ob.getDetalles());
     		 Object[][] datos = referencia_almacen.toArray(new Object[referencia_almacen.size()][]);
     		 referencia_tabla_model.setDataVector(datos, columnas);
              
         }
        }
        
        if( accion.equals( AÑO ) ) {
        	
        	Collections.sort(lista2);
            
          	 Iterator<Favoritos2> it = lista2.iterator();
            Favoritos2 ob;
            while (it.hasNext()){
                ob = it.next();
                referencia_almacen.add(ob.getDetalles());
        		 Object[][] datos = referencia_almacen.toArray(new Object[referencia_almacen.size()][]);
        		 referencia_tabla_model.setDataVector(datos, columnas);
                 
            }	
        	
        }
        
	}
	
	
	public void agregar(String nom)throws Exception {
		
        
        String nombre = nom.replace(" ","%20"); 
    
        
		
	    String json2 = readUrl("https://netflixroulette.net/api/api.php?title="+nom);

         JSONObject pelicula2 = new JSONObject(json2);
    
    	System.out.println("----------------------------------------------");    
        int unit = pelicula2.getInt("unit");
        String unidad = "Unit :"+Integer.toString(unit);
        int id = pelicula2.getInt("show_id");
        String ID ="ID :"+Integer.toString(id);
        String titulo = "Titulo :"+ pelicula2.getString("show_title");
        String año =pelicula2.getString("release_year");
        int a=Integer.parseInt(año);
        String rating = pelicula2.getString("rating");
        float puntaje=Float.parseFloat(rating);   
       // String datos = unidad+""+ " \n"+ID+""+ " \n"+año+""+ " \n"+categoria+""+ " \n"+director+""+ " \n"+resumen+""+ " \n"+duracion+ " \n";
       // String datosa = titulo+""+ " \n"+unidad+""+" \n"+ID+""+ " \n"+año+""+ " \n"+categoria+""+ " \n"+rating+""+" \n"+director+""+ " \n"+resumen+""+ " \n"+duracion+ " \n"+""+ " \n"+cast;
    	lista2.add(new Favoritos2(titulo,puntaje,a));
    	lista.add(new Favoritos(titulo,puntaje,a));
        this.setLista2(lista2);
        this.setLista(lista);
        
        //int cedula, String nombre, String apellido,int edad,int peso
        
		//mapa3 = new Derecho(mapa);
		
	}
	
	private static String readUrl(String urlString) throws Exception { 
        BufferedReader reader = null; 
        try { 
            URL url = new URL(urlString); 
            reader = new BufferedReader(new InputStreamReader(url.openStream())); 
            StringBuffer buffer = new StringBuffer(); 
            int read; 
            char[] chars = new char[1024]; 
            
            while ((read = reader.read(chars)) != -1) 
                   buffer.append(chars, 0, read); 
            
            return buffer.toString(); 
        } finally { 
            if (reader != null) 
                reader.close(); 
        } 
    }
	
}
