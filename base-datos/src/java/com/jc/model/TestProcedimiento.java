/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jc.model;

import java.sql.CallableStatement;
import java.sql.Connection;

/**
 *
 * @author campitos
 */
public class TestProcedimiento {
    public static void main(String args[]){
        
        try{
        Conexion c=new Conexion();
        Connection con=c.conectarse();
        
        CallableStatement callate2=con.prepareCall("{call insertar_usuario_1(?,?,?)}");
        callate2.registerOutParameter(1,java.sql.Types.INTEGER);
        callate2.setString(2,"Jose");
        callate2.setString(3,"1234");
        
        callate2.execute();
        int pk2=callate2.getInt(1);
        System.out.println("El status de insercion es: "+pk2);
        
        
        CallableStatement callate=con.prepareCall("{call autenticar_usuario_1(?,?,?)}");
        callate.registerOutParameter(1,java.sql.Types.INTEGER);
        callate.setString(2,"Jose");
        callate.setString(3,"1234");
        
        callate.execute();
        int pk=callate.getInt(1);
        System.out.println("El status de autenticacion es: "+pk);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}
