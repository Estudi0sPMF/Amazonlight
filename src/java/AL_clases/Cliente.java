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
public class Cliente {

    int id_cliente;
    private String nombre;
    private String apellido;
    private String dni;
    private String direccion;
    private String telefono;
    private String email;
    private String tipo_usuario;
    private String pwd;

    public Cliente() {
    }

    public Cliente(int id_cliente, String nombre, String apellido, String dni, String direccion, String telefono, String email, String tipo_usuario, String pwd) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.tipo_usuario = tipo_usuario;
        this.pwd = pwd;

    }

    public void altaCliente(String nombre, String apellido, String dni, String direccion, String telefono, String email, String tipo_usuario, String pwd) {

        Connection conexion = null;
        PreparedStatement st = null;
        ConectaBD bd = new ConectaBD();
        bd.conecta();
        bd.getConexion();
        conexion = bd.getConexion();

        String sql = "INSERT INTO cliente(nombre,apellido,dni,direccion,telefono,email,tipo_usuario,pwd) values(?,?,?,?,?,?,'U',?)";

        try {
            st = conexion.prepareStatement(sql);

            st.setString(1, nombre);
            st.setString(2, apellido);
            st.setString(3, dni);
            st.setString(4, direccion);
            st.setString(5, telefono);
            st.setString(6, email);
            st.setString(7, pwd);

            int altacli = st.executeUpdate();

            if (altacli > 0) {
                System.out.println("Alta Cliente realizada correctamente");

            }
            if (altacli <= 0) {
                System.out.println("Error en Alta de Cliente");

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e);
        }

    }

    public ArrayList listaClientes() {

        Connection conexion = null;
        Statement st = null;
        ResultSet rs = null;
        ArrayList<Cliente> listadoclientes;
        listadoclientes = new ArrayList();
        try {
            ConectaBD bd = new ConectaBD();
            bd.conecta();
            conexion=bd.getConexion();
            st = conexion.createStatement();

            String sql = "SELECT * from cliente";

            rs = st.executeQuery(sql);

            while (rs.next()) {

                int id_cliente = rs.getInt("id_cliente");
                String nombre=rs.getString("nombre");
                String apellido=rs.getString("apellido");
                String dni = rs.getString("dni");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                String tipo_usuario  = rs.getString("tipo_usuario");
                String pwd = rs.getString("pwd");
                
                listadoclientes.add(new Cliente(id_cliente,nombre,apellido,dni,direccion,telefono,email,tipo_usuario,pwd));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listadoclientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return nombre;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
}
