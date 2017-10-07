package Grafica;
import com.mycompany.mavenproject1.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import com.mycompany.mavenproject1.Favoritos;

public class Inferior extends JPanel implements ActionListener {

    public static final String RATING = "RATING";
    public static final String AÑO = "AÑO";
	
	private Derecho objeto;
	private JButton Orating,Oaño;
    private DefaultTableModel referencia_tabla_model;
	private ArrayList<Object[]> referencia_almacen;
	private ArrayList<Favoritos> lista3 = new ArrayList<Favoritos>();
	private ArrayList<Favoritos2> lista4 = new ArrayList<Favoritos2>();
	private String[] columnas = {" Titulo ", " Rating ", " Año "};
	
	
	
	public Inferior(DefaultTableModel referencia_tabla_model, ArrayList<Object[]> referencia_almacen) {
		super();
		this.referencia_tabla_model = referencia_tabla_model;
		this.referencia_almacen = referencia_almacen;
		
	    this.iniciar();  
	}

	
	
	
	
	



	public void iniciar() {

		 		
        setLayout( new GridBagLayout( ) );

        Border borde = BorderFactory.createTitledBorder( "Datos" );
        setBorder( borde );
        
       
        GridBagConstraints constraint = new GridBagConstraints( );

        constraint.gridx = 0;
        constraint.gridy = 0;
        constraint.fill = GridBagConstraints.BOTH;

        Insets insets = new Insets( 5, 10, 5, 10 );
        constraint.insets = insets;
        
        
        Orating = new JButton( "Ordenar por puntaje" );
        Orating.addActionListener( this );
        Orating.setActionCommand( RATING );	       
        constraint = new GridBagConstraints( );
        constraint.gridx = 0;
        constraint.gridy = 0;
        constraint.fill = GridBagConstraints.BOTH; 
        insets = new Insets( 5, 10, 5, 10 );
        constraint.insets = insets;	        
        add( Orating, constraint );
        
        
        Oaño = new JButton( "Ordenar por año" );
        Oaño.addActionListener( this );
        Oaño.setActionCommand( AÑO );	       
        constraint = new GridBagConstraints( );
        constraint.gridx = 3;
        constraint.gridy = 0;
        constraint.fill = GridBagConstraints.BOTH; 
        insets = new Insets( 5, 10, 5, 10 );
        constraint.insets = insets;	        
        add( Oaño, constraint );
        
	}

	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String accion = e.getActionCommand( );
        if( accion.equals( RATING ) ) {
        	
        	Collections.sort(objeto.getLista());
        	
        	Iterator<Favoritos> it = objeto.getLista().iterator();
        	
            Favoritos ob;
            while (it.hasNext()){
                ob = it.next();
                referencia_almacen.add(ob.getDetalles());
        		 Object[][] datos = referencia_almacen.toArray(new Object[referencia_almacen.size()][]);
        		 referencia_tabla_model.setDataVector(datos, columnas);
                 
            }
        	
        }
	}
}
