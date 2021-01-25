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
public class DetallePedido {
    private int id_detallePedido;
    private int id_pedido;
    private int id_articulo;
    private double precioArticulo;
    private int unidades;
    int altaDetPed;
    Double total_venta;
    String nombre;
    
public DetallePedido(){
    
}    
    
public DetallePedido(int id_articulo, String nombre, Double total_venta){
    this.id_articulo=id_articulo;
    this.nombre=nombre;
    this.total_venta=total_venta;
}
    
public DetallePedido(int id_pedido, int id_articulo,double precioArticulo, int unidades){
    
    
    this.id_pedido=id_pedido;
    this.id_articulo=id_articulo;
    this.precioArticulo=precioArticulo;
    this.unidades=unidades;
}
    
public void altaDetallePedido(int id_pedido, int id_articulo,double precioArticulo, int unidades){
    Connection conexion=null;
    PreparedStatement st=null;
    ConectaBD bd= new ConectaBD();
    bd.conecta();
    conexion=bd.getConexion();
    
    String sql = "INSERT INTO detalle_pedido(id_pedido,id_articulo,pvp_articulo_pedido,unidades) values(?,?,?,?)";
    
    try {
            st = conexion.prepareStatement(sql);

            st.setObject(1, id_pedido);
            st.setInt(2, id_articulo);
            st.setDouble(3, precioArticulo);
            st.setInt(4, unidades);
            
            
            altaDetPed = st.executeUpdate();

           

        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e);
        }

    }

public ArrayList listaVentaArticulos() {

        Connection conexion = null;
        Statement st = null;
        ResultSet rs = null;
        ArrayList<DetallePedido> lista_art_vendidos;
        lista_art_vendidos = new ArrayList();
        try {
            ConectaBD bd = new ConectaBD();
            bd.conecta();
            conexion=bd.getConexion();
            st = conexion.createStatement();

            String sql = "SELECT dp.ID_ARTICULO ,a.NOMBRE,sum(dp.PVP_ARTICULO_PEDIDO * dp.UNIDADES) AS total_venta \n" +
"FROM articulo a inner join detalle_pedido dp ON a.ID_ARTICULO=dp.ID_ARTICULO\n" +
"GROUP BY id_articulo";

            rs = st.executeQuery(sql);

            while (rs.next()) {

                int id_articulo = rs.getInt("id_articulo");
                String nombre=rs.getString("nombre");
                double total_venta=rs.getDouble("total_venta");
                
                
                lista_art_vendidos.add(new DetallePedido(id_articulo,nombre,total_venta));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista_art_vendidos;
    }

    public int getId_detallePedido() {
        return id_detallePedido;
    }

    public void setId_detallePedido(int id_detallePedido) {
        this.id_detallePedido = id_detallePedido;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(int id_articulo) {
        this.id_articulo = id_articulo;
    }

    public double getPrecioArticulo() {
        return precioArticulo;
    }

    public void setPrecioArticulo(double precioArticulo) {
        this.precioArticulo = precioArticulo;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public int getAltaDetPed() {
        return altaDetPed;
    }

    public void setAltaDetPed(int altaDetPed) {
        this.altaDetPed = altaDetPed;
    }

    public Double getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(Double total_venta) {
        this.total_venta = total_venta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

}
