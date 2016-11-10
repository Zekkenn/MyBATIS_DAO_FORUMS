/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.entities;

import java.sql.Date;

/**
 *
 * @author 2095498
 */
public class Request {
    private int user_id; 
    private int id;
    private String comentary;
    private String state;
    private Date date;
    
    public Request (int user_id, Date date){
        this.user_id = user_id;
        this.date=date;
        this.state = "E";
    }

    /**
     * @return the user_id
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the comentary
     */
    public String getComentary() {
        return comentary;
    }

    /**
     * @param comentary the comentary to set
     */
    public void setComentary(String comentary) {
        this.comentary = comentary;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

 
}
