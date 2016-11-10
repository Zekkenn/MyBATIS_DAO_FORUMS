/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.services;



import edu.eci.pdsw.aeci.entities.Program;
import edu.eci.pdsw.aeci.entities.Request;
import edu.eci.pdsw.aeci.entities.User;
import edu.eci.pdsw.aeci.persistence.DaoFactory;
import edu.eci.pdsw.aeci.persistence.PersistenceException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author suntse
 */
public class ServiciosAeciDAO extends ServiciosAeci{
    
    private DaoFactory daof;
    
    public ServiciosAeciDAO() {

    }
    
    @Override
    public void registrarNuevoUsuario(User usario){
    
    }
    
    @Override
    public void registrarNuevaSolicitud(Request solicitud){
    
    }
    
    @Override
    public List<Request> consultarEnviosSolicitud(){
        return null;
    }
    
    @Override
    public Program consultarPrograma(int id){
        return null;
    }

}