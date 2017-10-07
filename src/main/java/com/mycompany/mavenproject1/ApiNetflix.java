
package com.mycompany.mavenproject1;

/**
 * Esta clase contiene los metodos de busqueda y ordenamiento para un proyecto que utliliza la api de netflix
 * @author Juan Ricardo Rodriguez Campos
 * @author Juan David Reyes
 * @verion 1.0.0
 * @since FavoritosNetflix 1.0.0
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Scanner;

public class ApiNetflix {
    
    //atributos de la clase ApiNetflix (arrays y contador)
    
    
    Favoritos lista[]=new Favoritos[3];
    String listaA[]=new String[3];
    Favoritos aux[]=new Favoritos[1];
    
    //metodos get y set de la clase

    /**
     * 
     * @return 
     */
    public Favoritos[] getLista() {
        return lista;
    }

    /**
     * 
     * @param lista 
     */
    public void setLista(Favoritos[] lista) {
        this.lista = lista;
    }

    public String[] getListaA() {
        return listaA;
    }

    public void setListaA(String[] listaA) {
        this.listaA = listaA;
    }

   
 
    
    
    /**
     * metodo Actor que contiene las tres formas de busqueda que contiene el programa
     * @param op
     * @throws Exception 
     */
    public void Actor(int op) throws Exception{
        //ller datos por consola
        Scanner t = new Scanner(System.in);
        
       
                
    }
    
    /**
     * metodo agregar que recibe el nombre de la pelicula como parametro, lo busca y los envia a la clase Favoritos para la creacion de objetos
     * @param nombre
     * @throws Exception 
     */
    /*
    public void Agregar() throws Exception{
            Scanner t = new Scanner(System.in);
            int n=0;
            int contador=0;
            int des=0;
            int tamaño=15;
            if(contador<15){
            do{
                System.out.println("Ingrese el nombre de la pelicula :");
                String nombre= t.nextLine();
            //aqui se reemplaza los espacios por "%20" para evitar algun tipo de error
            String nombre1 = nombre.replace(" ","%20"); 
            
            String json2 = ApiNetflix.readUrl("https://netflixroulette.net/api/api.php?title="+nombre1);
            JSONObject pelicula2 = new JSONObject(json2);
            
            System.out.println("----------------------------------------------");    
                int unit = pelicula2.getInt("unit");
                String unidad = "Unit :"+Integer.toString(unit);
                int id = pelicula2.getInt("show_id");
                String ID ="ID :"+Integer.toString(id);
                String titulo = "Titulo :"+ pelicula2.getString("show_title");
                String año = "Año :"+pelicula2.getString("release_year");
                String rating = pelicula2.getString("rating");
                float puntaje=Float.parseFloat(rating);
                String categoria =" Categoria :"+ pelicula2.getString("category");
                String cast= "Cast :"+pelicula2.getString("show_cast");
                String director = "Director :"+ pelicula2.getString("director");
                String resumen= "Resumen :"+pelicula2.getString("summary");
                String duracion ="Duracion :"+ pelicula2.getString("runtime");
                String datos = unidad+""+ " \n"+ID+""+ " \n"+año+""+ " \n"+categoria+""+ " \n"+director+""+ " \n"+resumen+""+ " \n"+duracion+ " \n";
                String datosa = titulo+""+ " \n"+unidad+""+" \n"+ID+""+ " \n"+año+""+ " \n"+categoria+""+ " \n"+rating+""+" \n"+director+""+ " \n"+resumen+""+ " \n"+duracion+ " \n"+""+ " \n"+cast;
               
                
               

    }
    
    
    //Metodo de ordenamiento del array de objetos
    
      
public void ascendete() {
        
    Favoritos a[]=this.lista;           
    Favoritos aux[]=new Favoritos[1];
    int tamaño=a.length;
     
    for(int i=1;i<tamaño;i++){
        for(int j=0;j<tamaño-1;j++){
            if(a[j].getRating() > a[j+1].getRating()){
                    aux[0]=a[j];
                    a[j]=a[j+1];
                    a[j+1]=aux[0];
            }
        }
    }
        this.setLista(a);
        
    }

public void Alfa(){
    Arrays.sort(this.listaA);
    
    for(int i=0;i<this.listaA.length;i++){           
            System.out.println("----------Pelicula "+(i+1)+"-----------");

            System.out.println(this.listaA[i]);
                   
            System.out.println("---------------------------------------");
            
            
            System.out.println("--------------------------------");
            
        }      

}
  
public void nactores(){
    
    Favoritos a[]=this.lista;           
    Favoritos aux[]=new Favoritos[1];
    int tamaño=a.length;
     
    for(int i=1;i<tamaño;i++){
        for(int j=0;j<tamaño-1;j++){
            if(a[j].getNac() > a[j+1].getNac()){
                    aux[0]=a[j];
                    a[j]=a[j+1];
                    a[j+1]=aux[0];
            }
        }
    }
        this.setLista(a);
}
    //-------------------------------------------------------------------------------------
    /**
     * Metodo mostrar que lista las peliculas agregadas al array de objetos favoritos
     
    public void mostrar(){
        for(int i=0;i<this.lista.length;i++){           
            System.out.println("----------Pelicula "+(i+1)+"-----------");

            System.out.println(this.lista[i].getTitulo());

            System.out.println("Rating :"+this.lista[i].getRating());

            System.out.println(this.lista[i].getCast());

            System.out.println(this.lista[i].getDatos());
            
            System.out.println("Numero de actores"+this.lista[i].getNac());
                    
            System.out.println("---------------------------------------");
            
            
            System.out.println("--------------------------------");
            
        }      
    }
    
    
    
    
        public void mostrarA(){
        for(int i=0;i<this.listaA.length;i++){           
            System.out.println("----------Pelicula "+(i+1)+"-----------");
            System.out.println("Unidad : :"+this.listaA[i].getUnit());
            System.out.println("Id :"+this.listaA[i].getId());
            System.out.println("Titulo :"+this.listaA[i].getTitulo());
            System.out.println("Año de estreno :"+this.listaA[i].getAño());
            System.out.println("Rating :"+this.listaA[i].getRating());
            System.out.println("Categoria :"+this.listaA[i].getCategoria());
            System.out.println("Cast :"+this.listaA[i].getCast());
            System.out.println("Director :"+this.listaA[i].getDirector());
            System.out.println("Resumen :"+this.listaA[i].getResumen());
            System.out.println("Duracion :"+this.listaA[i].getDuracion());
            System.out.println("---------------------------------------");
            
            
            System.out.println("--------------------------------");
            
        }      
    }
    */
    
    /**
     * metodo que recibe como parametro la direccion de la url y permite que se trabaje con los datos obtenidos de ella.
     * @param urlString
     * @return
     * @throws Exception 
     */


    // Fin de la clase ApiNetflix
}

    
    

