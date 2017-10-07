/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author Clint
 */
public class Favoritos2 implements Comparable<Favoritos2>{
    
  	    private String titulo;
	    private float rating;
	    private int año;
	    
	    public Favoritos2(String titulo,float rating,int año) {
	    	this.titulo=titulo;
	    	this.rating=rating;
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
		public static Favoritos2 build(String titulo,float rating,int año){
			return new Favoritos2(titulo,rating,año);
		}
		
		
		public int compareTo(Favoritos2 o) {
			if (año < o.año) {
		        return -1;
		    }
		    if (año > o.año) {
		        return 1;
		    }
		    return 0;
	
		
    
		}
}
