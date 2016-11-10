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
    public void addUser(User user) throws ExcepcionServiciosAeci {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addRequest(Request request) throws ExcepcionServiciosAeci {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateRequest(Request request) throws ExcepcionServiciosAeci {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Request> getActiveRequests() throws ExcepcionServiciosAeci {
        List<Request> activeRequest = null;
        try {
            daof.beginSession();
            activeRequest = daof.getDaoRequest().getActiveRequests();
            daof.endSession();
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosAeciDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionServiciosAeci(ex.getMessage());
        }
        return activeRequest;
    }

    @Override
    public void updateUser(User user) throws ExcepcionServiciosAeci {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}