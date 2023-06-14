/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author BEASTMODE
 */
public class DeleteAccModel {
    
    String username,securityq, password;
    
    public DeleteAccModel(String username, String securityq, String password)
    {
        this.username=username;
        this.securityq=securityq;
        this.password=password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSecurityq() {
        return securityq;
    }

    public void setSecurityq(String securityq) {
        this.securityq = securityq;
    }

    public String getPass() {
        return password;
    }

    public void setPass(String password) {
        this.password = password;
    }
    
}
