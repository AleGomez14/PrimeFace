
package com.dao;

import com.conexion.Conexion;
import com.modelo.*;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 * Nombre de la clase:EmpleadoDao
 * Fecha:29/10/2017
 * Version:1.0
 * Copyright:ITCA-FEPADE
 * @author Ale Gomez
 */
public class EmpleadoDao  extends Conexion
{
    private PreparedStatement pre;
    private ResultSet res;
    private String sql="";
    
    
    public List<Empleado>mostrar()
    {
        List<Empleado>le= new ArrayList<>();
        try 
        {
            this.conectar();
            sql="select * from empleado";
            pre=this.getCon().prepareStatement(sql);
            res=pre.executeQuery();
            while (res.next()) 
            {                
                Empleado em= new Empleado();
                em.setCodigo(res.getInt("codigoEmpleado"));
                em.setNombre(res.getString("nombre"));
                em.setGenero(res.getString("genero"));
                em.setEdad(res.getInt("edad"));
                em.setDireccion(res.getString("direccion"));
                em.setCargo(res.getString("cargo"));
 
                le.add(em);
            }
        } catch (Exception e) 
        {

            System.out.println("error en mostrar de dao");
            e.printStackTrace();
        }
        return le;
    }
    
    public void agregar(Empleado em)throws Exception
    {
        try 
        {
            this.conectar();
            sql="insert into empleado(codigoEmpleado,nombre,genero,edad,direccion,cargo)"
                    + "values(?,?,?,?,?,?)";
            pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, em.getCodigo());
            pre.setString(2, em.getNombre());
            pre.setString(3, em.getGenero());
            pre.setInt(4, em.getEdad());
            pre.setString(5, em.getDireccion());
            pre.setString(6, em.getCargo());
            pre.executeUpdate();
        } catch (Exception e) 
        {
            System.out.println("error al guardar en dao");
            throw e;
        }
        this.desconectar();
    }
    
    public void modificar(Empleado em)throws Exception
    {
        try 
        {
            this.conectar();
            sql="update empleado set nombre=?,genero=?,edad=?,direccion=?,cargo=?"
                    + "where codigoEmpleado=?";
            pre=this.getCon().prepareStatement(sql);
            pre.setString(1, em.getNombre());
            pre.setString(2, em.getGenero());
            pre.setInt(3, em.getEdad());
            pre.setString(4, em.getDireccion());
            pre.setString(5, em.getCargo());
            pre.setInt(6, em.getCodigo());
            pre.executeUpdate();          
        } catch (Exception e) 
        {
            System.out.println("error en modificar dao");
            throw e;
            
        }
        this.desconectar();
    }
    
    
    public void eliminar(Empleado em)throws Exception
    {
        try 
        {
            this.conectar();
            sql="delete from empleado where codigoEmpleado=?";
            pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, em.getCodigo());
            pre.executeUpdate();
        } catch (Exception e) 
        {
            System.out.println("error al eliminar en dao");
            throw e;
        }
        this.desconectar();
    }
}
