
package com.mycompany.mavenproject1;



/**
 * Esta clase contiene los atributos y metodos get y set de la clase favoritos
 * @author Juan Ricardo Rodriguez Campos
 * @author Juan David Reyes
 * @verion 1.0.0
 * @since FavoritosNetflix 1.0.0
 */

public class Favoritos  implements Comparable<Favoritos>{
    
    
    private String titulo;
    private float rating;
    private String datos;
    private int Nac;
    private int año;

    public Favoritos(String titulo, float rating,int año) {
        this.titulo = titulo;
        this.rating = rating;
        this.año=año;
    }
    
    
    
    public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public float getRating() {
		return rating;
	}



	public void setRating(float rating) {
		this.rating = rating;
	}



	public int getAño() {
		return año;
	}



	public void setAño(int año) {
		this.año = año;
	}



	public Object[] getDetalles() {
		Object[] data = {this.titulo,this.rating,this.año};
		System.out.println(data);
		return data;
	}
	
    //String titulo, float rating,int año
	public static Favoritos build(String titulo,float rating,int año){
		return new Favoritos(titulo,rating,año);
	}



public int compareTo(Favoritos o) {
	if (rating < o.rating) {
        return -1;
    }
    if (rating > o.rating) {
        return 1;
    }
	return 0;
}
    
 
    
}
