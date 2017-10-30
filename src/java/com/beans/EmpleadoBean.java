
package com.beans;

import com.dao.EmpleadoDao;
import com.modelo.Empleado;
import java.io.Serializable;
import java.util.*;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 * Nombre de la clase:EmpleadoBeans
 * Fecha:29/10/2017
 * Version:1.0
 * Copyright:ITCA-FEPADE
 * @author Ale Gomez
 */
@Named(value = "empleadoBean")
@ViewScoped
public class EmpleadoBean implements  Serializable{

    private Empleado scli= new Empleado();
    private Empleado cli= new  Empleado();
    private List<Empleado>lista= new ArrayList<>();
    private EmpleadoDao dao = new EmpleadoDao();
    //no G&S
    public EmpleadoBean() 
    {
        lista=dao.mostrar();
    }

    public Empleado getScli() {
        return scli;
    }

    public void setScli(Empleado scli) {
        this.scli = scli;
    }

    public Empleado getCli() {
        return cli;
    }

    public void setCli(Empleado cli) {
        this.cli = cli;
    }

    public List<Empleado> getLista() {
        return lista;
    }

    public void setLista(List<Empleado> lista) {
        this.lista = lista;
    }
    
    public void insertar()
    {
        try {
            dao.agregar(cli);
            FacesContext context=FacesContext.getCurrentInstance();
            context.addMessage
        (null, new FacesMessage(FacesMessage.SEVERITY_INFO,
        "Gestion Emplead","Datos Insertados Correctamente"));
            lista=dao.mostrar();
            this.limpiar();
        } catch (Exception e) 
        {
            System.out.println("erroe en ingrear en el beans");
            e.printStackTrace();
        }
    }
    
    public void modificar()
    {
        try 
        {
            dao.modificar(scli);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null,new FacesMessage
            (FacesMessage.SEVERITY_INFO,
            "Gestion de Empleado","Dato Modificado"));
            lista=dao.mostrar();
            this.limpiar();
        } catch (Exception e) 
        {
            System.out.println("error en modificar de beans");
        }
    }
    
    public void eliminar()
    {
        try 
        {
            dao.eliminar(scli);
            FacesContext context= FacesContext.getCurrentInstance();
            context.addMessage(null,new FacesMessage
        (FacesMessage.SEVERITY_INFO,
        "Gestion de Empleado","Datos Eliminado"));
            lista= dao.mostrar();
            this.limpiar();
        } catch (Exception e) 
        {
            System.out.println("error en elimnar de beans");
        }
    }
    
    public void limpiar()
    {
        scli= new Empleado();
        cli= new Empleado();
    }
    public void select()
    {
        cli=scli;
        System.out.println("error en el select del beans");
    }
    
}
