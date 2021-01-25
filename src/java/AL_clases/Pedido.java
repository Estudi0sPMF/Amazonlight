/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AL_clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

/**
 *
 * @author HP
 */
public class Pedido {
    
    int id_pedido;
    private LocalDate fecha_pedido=LocalDate.now();
    private int id_cliente;
    private double importe_pedido;
    int altaPedido;
    
 
    
public Pedido( int id_pedido,LocalDate fecha_pedido, int id_cliente, double importe_pedido){

this.id_pedido=id_pedido;
this.fecha_pedido=fecha_pedido;
this.id_cliente=id_cliente;
this.importe_pedido=importe_pedido;
} 

public void altaPedido(LocalDate fecha_pedido, int id_cliente, double importe_pedido){
  
    Connection conexion=null;
    PreparedStatement st=null;
    ConectaBD bd= new ConectaBD();
    bd.conecta();
    conexion=bd.getConexion();
    
    String sql = "INSERT INTO pedido(id_cliente,fecha_pedido,importe_pedido) values(?,?,?)";
    
    try {
            st = conexion.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            st.setInt(1, id_cliente);
            st.setObject(2, fecha_pedido);
            st.setDouble(3, importe_pedido);
            
            System.out.println(st.toString());
            altaPedido = st.executeUpdate();
               int ultimoId = 0;
            ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    ultimoId = rs.getInt(1);
                   
                }
           id_pedido = ultimoId;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e);
        }

}

    public int getId_pedido() {
        // Select id_pedido FROM pedidos order by id_pedido DESC LIMIT 1
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public LocalDate getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(LocalDate fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public double getImporte_pedido() {
        return importe_pedido;
    }

    public void setImporte_pedido(double importe_pedido) {
        this.importe_pedido = importe_pedido;
    }

    public int getAltaPedido() {
        return altaPedido;
    }

    public void setAltaPedido(int altaPedido) {
        this.altaPedido = altaPedido;
    }


    
}
