
package com.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Nombre de la clase:Conexion
 * Fecha:29/10/2017
 * Version:1.0
 * Copyright:ITCA-FEPADE
 * @author Ale Gomez
 */
public class Conexion 
{
    private Connection con;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    
    public void conectar()throws Exception
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ale?user=root&password=");
        } catch (Exception e) 
        {
            System.out.println("error en la conexion");
            e.printStackTrace();
        }
    }
    
    public void desconectar()throws Exception
    {
        try 
        {
            if (con!=null) 
            {
                if (con.isClosed()==false) 
                {
                    con.close();
                }
            }
        } catch (Exception e) 
        {
            System.out.println("error al desconectar");
            e.printStackTrace();
        }
    }
}
