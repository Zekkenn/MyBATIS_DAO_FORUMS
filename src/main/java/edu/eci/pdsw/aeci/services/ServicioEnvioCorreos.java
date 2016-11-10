/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.services;

import edu.eci.pdsw.aeci.entities.Request;
import edu.eci.pdsw.aeci.entities.User;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 *
 * @author estudiante
 */
public class ServicioEnvioCorreos {
    
    /**
     * @return the passwordCorreoFuente
     */
    public String getPasswordCorreoFuente() {
        return passwordCorreoFuente;
    }

    /**
     * @param passwordCorreoFuente the passwordCorreoFuente to set
     */
    public void setPasswordCorreoFuente(String passwordCorreoFuente) {
        this.passwordCorreoFuente = passwordCorreoFuente;
    }

    /**
     * @return the CorreoFuente
     */
    public String getCorreoFuente() {
        return CorreoFuente;
    }

    /**
     * @param CorreoFuente the CorreoFuente to set
     */
    public void setCorreoFuente(String CorreoFuente) {
        this.CorreoFuente = CorreoFuente;
    }
    
    /*
    Correo y contrase;a actualmente de pruebas
    */
    private String CorreoFuente = "pruebapdsw@gmail.com"; 
    private String passwordCorreoFuente = "holamundo";
    
    public void aprobado(User destinatario, Request solicitud){
        
    }
    
    public void rechazado(User destinarario, Request solicitud){
        
    }
    
    
    public boolean EnviarCorreo(String nombre,String correo, String comentario){
        boolean envio = false;
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(CorreoFuente, passwordCorreoFuente);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(CorreoFuente));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(correo));
            message.setSubject(nombre);
            message.setText(comentario);
            Transport.send(message);
            envio = true;
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }return envio;
    }
}
