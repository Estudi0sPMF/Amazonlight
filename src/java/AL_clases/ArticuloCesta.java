/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AL_clases;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class ArticuloCesta {
    
    int id_cesta;
    private int id_articulo;
    private String nombre;
    private double precio;
    private int cantidad;
    private double total_pvpart;
    ArrayList<ArticuloCesta> cesta;
    
    
public ArticuloCesta(){
    
}
    
public ArticuloCesta(int id_articulo, String nombre, double precio, int cantidad, double total_pvpart){
    
    this.id_articulo=id_articulo;
    this.nombre=nombre;
    this.precio=precio;
    this.cantidad=cantidad;
    this.total_pvpart=total_pvpart;
    
}


    public int getId_cesta() {
        return id_cesta;
    }

    public void setId_cesta(int id_cesta) {
        this.id_cesta = id_cesta;
    }

    public int getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(int id_articulo) {
        this.id_articulo = id_articulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal_pvpart() {
        return total_pvpart;
    }

    public void setTotal_pvpart(double total_pvpart) {
        this.total_pvpart = total_pvpart;
    }


            
            
            
    
}
