/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.managedbeans;

/***
importar aca las clases que necesiten
import edu.eci.pdsw.samples.aeci.;

***/
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author hcadavid
 */
@ManagedBean(name = "solicitudAfiliacion")
@SessionScoped

public class SolicitudAfiliacionBean implements Serializable{

        
    private String Nombre;
    private String Apellido;
    private int Cedula;
    private int Celular;
    private int telefonoFijo;
    private String correo;
    private int Carrera;
    private int AnoGraducacion;
    private int Periodo;
    
    /**
     *
     */
    public void enviarSolicitud(){
        System.out.println("Nombre "+Nombre);
    }
    
    /**
     * @return the Cedula
     */
    public int getCedula() {
        return Cedula;
    }

    /**
     * @param Cedula the Cedula to set
     */
    public void setCedula(int Cedula) {
        this.Cedula = Cedula;
    }

    /**
     * @return the Celular
     */
    public int getCelular() {
        return Celular;
    }

    /**
     * @param Celular the Celular to set
     */
    public void setCelular(int Celular) {
        this.Celular = Celular;
    }

    /**
     * @return the telefonoFijo
     */
    public int getTelefonoFijo() {
        return telefonoFijo;
    }

    /**
     * @param telefonoFijo the telefonoFijo to set
     */
    public void setTelefonoFijo(int telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the Carrera
     */
    public int getCarrera() {
        return Carrera;
    }

    /**
     * @param Carrera the Carrera to set
     */
    public void setCarrera(int Carrera) {
        this.Carrera = Carrera;
    }

    /**
     * @return the AnoGraducacion
     */
    public int getAnoGraducacion() {
        return AnoGraducacion;
    }

    /**
     * @param AnoGraducacion the AnoGraducacion to set
     */
    public void setAnoGraducacion(int AnoGraducacion) {
        this.AnoGraducacion = AnoGraducacion;
    }

    /**
     * @return the Periodo
     */
    public int getPeriodo() {
        return Periodo;
    }

    /**
     * @param Periodo the Periodo to set
     */
    public void setPeriodo(int Periodo) {
        this.Periodo = Periodo;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Apellido
     */
    public String getApellido() {
        return Apellido;
    }

    /**
     * @param Apellido the Apellido to set
     */
    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

}
