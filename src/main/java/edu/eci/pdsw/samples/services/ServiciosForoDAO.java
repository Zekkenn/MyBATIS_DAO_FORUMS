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
            daof=DaoFactory.getInstance(properties);
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
            daof.endSession();
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
            daof.endSession();
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosForoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionServiciosForos(ex.getMessage());
        }
        if(entradaForo == null) throw new ExcepcionServiciosForos("No se ha encontrado identificador asociado a alguna entrada de foro.");
        return entradaForo;
    }

    @Override
    public void registrarNuevaEntradaForo(EntradaForo f) throws ExcepcionServiciosForos {
        if(f.getAutor() == null) throw new ExcepcionServiciosForos("No hay usuario asociado al foro.");
        try {
            daof.beginSession();
            daof.getDaoEntradaForo().save(f);
            daof.endSession();
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosForoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionServiciosForos(ex.getMessage());
        }
    }

    @Override
    public void agregarRespuestaForo(int idforo, Comentario c) throws ExcepcionServiciosForos {
        if(c.getAutor() == null || c.getAutor().getEmail() == null) throw new ExcepcionServiciosForos("Los comentarios deben tener usuarios asociados o el usuario deben tener email.");
        try {
            daof.beginSession();
            daof.getDaoEntradaForo().addToForo(idforo, c);
            daof.endSession();
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
            daof.endSession();
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