/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author BEASTMODE
 */
public class ChangeUsernameModel {
    String currentusername,securityq, newusername, password;
    
    public ChangeUsernameModel(String currentusername, String securityq, String newusername, String password)
    {
        this.currentusername=currentusername;
        this.securityq=securityq;
        this.newusername=newusername;
        this.password=password;
    }

    public String getCurrentusername() {
        return currentusername;
    }

    public void setCurrentusername(String currentusername) {
        this.currentusername = currentusername;
    }

    public String getSecurityq() {
        return securityq;
    }

    public void setSecurityq(String securityq) {
        this.securityq = securityq;
    }

    public String getNewusername() {
        return newusername;
    }

    public void setNewusername(String newusername) {
        this.newusername = newusername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
