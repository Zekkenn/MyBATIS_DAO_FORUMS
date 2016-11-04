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
    
    public Request (int User_id, int Id,String Comentary,String State){
        user_id=User_id;
        id=Id;
        comentary=Comentary;
        state=State;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComentary() {
        return comentary;
    }

    public void setComentary(String comentary) {
        this.comentary = comentary;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
 
}
