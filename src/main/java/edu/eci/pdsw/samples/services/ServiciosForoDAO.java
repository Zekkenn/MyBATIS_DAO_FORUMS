/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services;

import edu.eci.pdsw.samples.entities.Comentario;
import edu.eci.pdsw.samples.entities.EntradaForo;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.persistence.DaoFactory;
import edu.eci.pdsw.samples.persistence.PersistenceException;
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
public class ServiciosForoDAO extends ServiciosForo{
    
    private DaoFactory daof;
    
    public ServiciosForoDAO() {
        Properties properties = null;        
        try {
            properties = new PropertiesLoader().readProperties("applicationconfig.properties");
            DaoFactory daof=DaoFactory.getInstance(properties);
        } catch (IOException ex) {
            Logger.getLogger(ServiciosForoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<EntradaForo> consultarEntradasForo() throws ExcepcionServiciosForos {
        List<EntradaForo> entradaForo = null;
        try {
            daof.beginSession();
            entradaForo = daof.getDaoEntradaForo().loadAll();
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosForoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionServiciosForos(ex.getMessage());
        }
        return entradaForo;
    }

    @Override
    public EntradaForo consultarEntradaForo(int id) throws ExcepcionServiciosForos {
        EntradaForo entradaForo = null;
        try {
            daof.beginSession();
            entradaForo = daof.getDaoEntradaForo().load(id);
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosForoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionServiciosForos(ex.getMessage());
        }
        return entradaForo;
    }

    @Override
    public void registrarNuevaEntradaForo(EntradaForo f) throws ExcepcionServiciosForos {
        try {
            daof.beginSession();
            daof.getDaoEntradaForo().save(f);
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosForoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionServiciosForos(ex.getMessage());
        }
    }

    @Override
    public void agregarRespuestaForo(int idforo, Comentario c) throws ExcepcionServiciosForos {
        try {
            daof.beginSession();
            daof.getDaoEntradaForo().addToForo(idforo, c);
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosForoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionServiciosForos(ex.getMessage());
        }
    }

    @Override
    public Usuario consultarUsuario(String email) throws ExcepcionServiciosForos {
        Usuario user = null;
        try {
            daof.beginSession();
            user = daof.getDaoUsuario().load(email);
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosForoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionServiciosForos(ex.getMessage());
        }
        return user;
    }
    
}
class PropertiesLoader {

    public Properties readProperties(String fileName) throws IOException {
        InputStream input = null;
        Properties properties = new Properties();
        input = this.getClass().getClassLoader().getResourceAsStream(fileName);
        properties.load(input);
        return properties;
    }
}