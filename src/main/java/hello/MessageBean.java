package hello;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author viter
 */
public class MessageBean implements Serializable {
     
    private String msg;
        
    public MessageBean() {
    }
    
    public String getMsg() {
        return msg;
    }
    
    public void setMsg(String lang) {
        switch(lang){
            case "pt":
                msg = "Olá! Boas vindas";
                break;
            case "en":
                msg = "Hello! Welcome";
                break;
            case "fr":
                msg = "Bonjour! Bienvenue";
                break;
            case "de":
                msg = "Hallo! Herzlich willkommen";
                break;
            default:
                msg = "Olá! Boas vindas";
                break;
        }
    }
}
