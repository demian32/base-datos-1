/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jc.model;

/**
 *
 * @author campitos
 */
import java.sql.*;
import java.util.ArrayList;
public class DAOUsuario {
    static Conexion con;
    
    public DAOUsuario(){
        con=new Conexion();
    }
    
    public void insertar(Usuario u)throws Exception{
     Connection cone=   con.conectarse();
   CallableStatement callate=  cone.prepareCall("{call insertar_usuario_1(?,?,?)}");
   callate.setInt(1,u.getId());
   callate.setString(2,u.getNombre());
   callate.setString(3, u.getPass());
   callate.executeUpdate();
   callate.close();
   cone.close();
   System.out.println("Se inserto el registro con exito");
    
 }
    
    public static ArrayList<Usuario> buscarTodos()throws Exception {
        
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        
        //Primero nos conectamos
        Connection conexion = con.conectarse();
        
        //Crear un statement de SQL
        Statement st = conexion.createStatement();
        
        //Crear un ResultSet (Columnas y Filas)
        ResultSet res = st.executeQuery("SELECT * FROM USUARIO_1");
        
        //Llenar el ArrayList
        while (res.next()){
            
            int id = res.getInt(1);
            String nombre = res.getString(2);
            String pass = res.getString(3);
            
            Usuario u = new Usuario (id,nombre,pass);
            
            usuarios.add(u);
            
        }
        
        return usuarios;
    }
}
