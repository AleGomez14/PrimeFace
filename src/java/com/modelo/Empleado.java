
package com.modelo;

/**
 * Nombre de la clase:Empleado
 * Fecha: 26/10/2017
 * Version:1.0
 * Copyright:ITCA-FEPADE
 * @author Ale Gomez
 */
public class Empleado 
{
    private int codigo;
    private String nombre;
    private String genero;
    private int edad;
    private String direccion;
    private String cargo;
    

    public Empleado() {
    }

    public Empleado(int codigo, String nombre, String genero, int edad, String direccion, String cargo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.direccion = direccion;
        this.cargo = cargo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    
    
    public String convertirIntereses (String[] intereses)
    {
        String interesesC=null;
        for (int i = 0; i <intereses.length; i++) {
            if(interesesC !=null)
            interesesC = interesesC + intereses[i];
            else
                interesesC = intereses[i];   
        }
        return interesesC;
    }
    
    public String[] obtenerIntereses(String intereses)
    {
        String[] interesesBase=null;
        
        if(intereses.equals("Leer")){
            interesesBase[1] = "Leer";
        } 
        if(intereses.equals("Leer,Dormir"))
        {
            interesesBase[2] = "Dormir";
        }
            
        if(intereses.equals("Leer,Dormir,Cantar"))
        {
            interesesBase[3] = "Cantar";
        }
            
        if(intereses.equals("Leer,Dormir,Cantar,Jugar"))        
        {
            interesesBase[4] = "Jugar";
        }
            
        
        return interesesBase;
    }
    
}
