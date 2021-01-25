/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AL_clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class Articulo {
    
    int id_articulo;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private String urlFoto;
    int altarti;
    
public Articulo(){
    
}    

public Articulo(String nombre){
    this.nombre=nombre;
}
    
public Articulo(int id_articulo,String nombre,String descripcion,double precio,int stock,String urlFoto){
    this.id_articulo=id_articulo;
    this.nombre=nombre;
    this.descripcion=descripcion;
    this.precio=precio;
    this.stock=stock;
    this.urlFoto=urlFoto;
}
      
public void altaArticulo(String nombre,String descripcion,double precio,int stock,String urlFoto){
    
    Connection conexion=null;
    PreparedStatement st=null;
    ConectaBD bd= new ConectaBD();
    bd.conecta();
    conexion=bd.getConexion();
    
    String sql = "INSERT INTO articulo(NOMBRE,DESCRIPCION,PRECIO,STOCK,URL_FOTO) values(?,?,?,?,?)";
    
    try {
            st = conexion.prepareStatement(sql);

            st.setString(1, nombre);
            st.setString(2, descripcion);
            st.setDouble(3, precio);
            st.setInt(4,stock);
            st.setString(5, urlFoto);
            
            altarti = st.executeUpdate();

           

        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e);
        }

}

public ArrayList listaArticulos(){
    
    Connection conexion = null;
    Statement st = null;
    ResultSet rs = null;
    ArrayList<Articulo> listadoarticulos;
    listadoarticulos= new ArrayList();
    
    try{
        ConectaBD bd = new ConectaBD();
        bd.conecta();
        conexion=bd.getConexion();
        st = conexion.createStatement();
        
        String sql = "Select * from articulo";
        
        rs = st.executeQuery(sql);

            while (rs.next()) {

                id_articulo = rs.getInt("id_articulo");
                nombre=rs.getString("nombre");
                descripcion =rs.getString("Descripcion");
                precio =(rs.getInt("precio") );
                stock = (rs.getInt("stock"));
                urlFoto = rs.getString("url_foto");
                                
                listadoarticulos.add(new Articulo(id_articulo,nombre,descripcion,precio,stock,urlFoto));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    
    
    return listadoarticulos;
}

public ArrayList buscaArticulos(String articulo){
    
    Connection conexion = null;
    PreparedStatement st1 = null;
    ResultSet rs = null;
    ArrayList<Articulo> seleccionarticulos;
    seleccionarticulos= new ArrayList();
    
    
    
    try{
        ConectaBD bd = new ConectaBD();
        bd.conecta();
        conexion=bd.getConexion();
       
        
        String sql = "SELECT Id_articulo,Nombre,Descripcion,Precio,Stock,URL_foto from articulo where Nombre like ?";
        
        st1 = conexion.prepareStatement(sql);

        st1.setString(1, articulo);
System.out.println(st1);
        rs = st1.executeQuery();
        

            while (rs.next()) {

                id_articulo = rs.getInt("id_articulo");
                nombre=rs.getString("nombre");
                descripcion =rs.getString("Descripcion");
                precio =(rs.getInt("precio") );
                stock = (rs.getInt("stock"));
                urlFoto = rs.getString("url_foto");
                                
                seleccionarticulos.add(new Articulo(id_articulo,nombre,descripcion,precio,stock,urlFoto));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Articulo.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    
    
    return seleccionarticulos;
}



 public void setAltarti(int altarti) {
        this.altarti = altarti;
    }

public int getAltarti(){
    
    return altarti;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }


}
