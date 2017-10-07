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
import java.util.Map;
import java.util.TreeMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONObject;



public class Izquierdo extends JPanel implements ActionListener {

    public static final String BUSCAR1 = "BUSCAR1";
    public static final String BUSCAR2 = "BUSCAR2";
    public static final String CLEAR = "CLEAR";
   
	
	private JTextField actorb,titulob;
	private JButton buscar1,buscar2,limpiar;
    private String[] columnas = {" Titulo ", " Rating ", " Año "};
    private JTextField nombre,apellido,cedula,edad,peso;
    private ArrayList<Favoritos> lista2 = new ArrayList<Favoritos>();
    private Map<Integer, String> mapa = new TreeMap<Integer, String>();
    private ArrayList<Favoritos2> lista1 = new ArrayList<Favoritos2>();
    private DefaultTableModel referencia_tabla_model;
	private ArrayList<Object[]> referencia_almacen;
	
	
	public Izquierdo(DefaultTableModel referencia_tabla_model, ArrayList<Object[]> referencia_almacen) {
		super();
		this.referencia_tabla_model = referencia_tabla_model;
		this.referencia_almacen = referencia_almacen;
		
	    this.iniciar();  
	}

	public void iniciar() {

		 		
        setLayout( new GridBagLayout( ) );

        Border borde = BorderFactory.createTitledBorder( "Busqueda" );
        setBorder( borde );
        
       
        GridBagConstraints constraint = new GridBagConstraints( );

        constraint.gridx = 0;
        constraint.gridy = 0;
        constraint.fill = GridBagConstraints.BOTH;

        Insets insets = new Insets( 5, 10, 5, 10 );
        constraint.insets = insets;
        
        
        buscar1 = new JButton( "Buscar" );
        buscar1.addActionListener( this );
        buscar1.setActionCommand( BUSCAR1 );	       
        constraint = new GridBagConstraints( );
        constraint.gridx = 0;
        constraint.gridy = 3;
        constraint.fill = GridBagConstraints.BOTH; 
        insets = new Insets( 5, 10, 5, 10 );
        constraint.insets = insets;	        
        add( buscar1, constraint );
        
        
        buscar2 = new JButton( "Buscar" );
        buscar2.addActionListener( this );
        buscar2.setActionCommand( BUSCAR2 );	       
        constraint = new GridBagConstraints( );
        constraint.gridx = 0;
        constraint.gridy = 6;
        constraint.fill = GridBagConstraints.BOTH; 
        insets = new Insets( 5, 10, 5, 10 );
        constraint.insets = insets;	        
        add( buscar2, constraint );
        
        limpiar = new JButton( "Limpiar Pantalla" );
        limpiar.addActionListener( this );
        limpiar.setActionCommand( CLEAR );	       
        constraint = new GridBagConstraints( );
        constraint.gridx = 0;
        constraint.gridy = 15;
        constraint.fill = GridBagConstraints.BOTH; 
        insets = new Insets( 5, 10, 5, 10 );
        constraint.insets = insets;	        
        add( limpiar, constraint );
        
        JLabel bus1 = new JLabel("Buscar por Actor :");
        constraint = new GridBagConstraints( );
        constraint.gridx = 0;
        constraint.gridy = 1;
        constraint.fill = GridBagConstraints.BOTH; 
        insets = new Insets( 5, 10, 5, 10 );
        constraint.insets = insets;
        add(bus1,constraint);
        
        actorb = new JTextField(5);
        actorb.addActionListener(this);
        constraint = new GridBagConstraints( );
        constraint.gridx = 0;
        constraint.gridy = 2;
        constraint.fill = GridBagConstraints.BOTH; 
        insets = new Insets( 5, 10, 5, 10 );
        constraint.insets = insets;
        add(actorb,constraint);
       
        
        JLabel ape = new JLabel("Buscar por titulo :");
        constraint = new GridBagConstraints( );
        constraint.gridx = 0;
        constraint.gridy = 4;
        constraint.fill = GridBagConstraints.BOTH; 
        insets = new Insets( 5, 10, 5, 10 );
        constraint.insets = insets;
        add(ape,constraint);
        
        titulob = new JTextField(5);
        titulob.addActionListener(this);
        constraint = new GridBagConstraints( );
        constraint.gridx = 0;
        constraint.gridy = 5;
        constraint.fill = GridBagConstraints.BOTH; 
        insets = new Insets( 5, 10, 5, 10 );
        constraint.insets = insets;
        add(titulob,constraint);
     
	}
	
	
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String accion = e.getActionCommand( );
        if( accion.equals( BUSCAR2 ) ) {
        	      	
			try {
				String n = titulob.getText();
				referencia_almacen.clear();
				buscar(n);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "Campo de busqueda vacio", "Error!", JOptionPane.ERROR_MESSAGE);
			}
			
        	
            this.actorb.setText("");
            this.titulob.setText("");
            
            
        }
        
        if( accion.equals( BUSCAR1)) {
        	   	
        	try {
        		String nom = actorb.getText();
				buscar2(nom);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "Campo de busqueda vacio", "Error!", JOptionPane.ERROR_MESSAGE);
				
			}
        	this.actorb.setText("");
            this.titulob.setText("");
        }
        
        if( accion.equals(CLEAR)) {
        	
        	referencia_tabla_model.setRowCount(0);
        	referencia_almacen.clear();
        	
        }
		
	}
	
	public void buscar(String nom)throws Exception {
		
		           
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
    	
    	
       
        //int cedula, String nombre, String apellido,int edad,int peso
        referencia_almacen.add(Favoritos.build(titulo,puntaje,a).getDetalles());
		Object[][] datos = referencia_almacen.toArray(new Object[referencia_almacen.size()][]);
		referencia_tabla_model.setDataVector(datos, columnas);
		//mapa3 = new Derecho(mapa);
	}

	
	public void buscar2(String nom)throws Exception {
		
		
		
        String nombre = nom.replace(" ","%20"); 
    
        
        String json = readUrl("https://netflixroulette.net/api/api.php?actor="+nombre); //API de netflix
        JSONArray pelicula = new JSONArray(json);  	 
       // String datos = unidad+""+ " \n"+ID+""+ " \n"+año+""+ " \n"+categoria+""+ " \n"+director+""+ " \n"+resumen+""+ " \n"+duracion+ " \n";
       // String datosa = titulo+""+ " \n"+unidad+""+" \n"+ID+""+ " \n"+año+""+ " \n"+categoria+""+ " \n"+rating+""+" \n"+director+""+ " \n"+resumen+""+ " \n"+duracion+ " \n"+""+ " \n"+cast;
        eliminar();
        for(int i=0; i<pelicula.length(); i++){
        
              System.out.println("----------------------------------------------");
              JSONObject pelicula3 = (JSONObject)pelicula.get(i);
            
        	  int unit = pelicula3.getInt("unit");
              String unidad = "Unit :"+Integer.toString(unit);
              int id = pelicula3.getInt("show_id");
              String ID ="ID :"+Integer.toString(id);
              String titulo = "Titulo :"+ pelicula3.getString("show_title");
              String año =pelicula3.getString("release_year");
              int a=Integer.parseInt(año);
              String rating = pelicula3.getString("rating");
              float puntaje=Float.parseFloat(rating);  
              
            referencia_almacen.add(Favoritos.build(titulo,puntaje,a).getDetalles());
      		Object[][] datos = referencia_almacen.toArray(new Object[referencia_almacen.size()][]);
      		referencia_tabla_model.setDataVector(datos, columnas);
              
        } 
        
        this.titulob.setText("");
        this.actorb.setText("");       
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
    
    public void eliminar(){
        
    	this.referencia_tabla_model.setRowCount(0);
        } 
        //cargaTicket();
    

    
    
    
}
