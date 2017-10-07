package Grafica;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Superior extends JPanel{
	
	public Superior() {
		
	 setLayout( new BorderLayout( ) );
	 
     JLabel imagen = new JLabel( );
     
     ImageIcon icono = new ImageIcon( "imagen/netflix.jpg" );

     imagen.setIcon( icono );
     
     add( imagen, BorderLayout.CENTER);
     
            
     setBackground( Color.WHITE);
	}
}
