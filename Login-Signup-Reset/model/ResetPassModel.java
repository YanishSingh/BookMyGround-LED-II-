/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author BEASTMODE
 */
public class ResetPassModel {
    String username,securityq, newPass, confirmNewPass;
    
    public ResetPassModel(String username, String securityq, String newPass, String confirmNewPass)
    {
        this.username=username;
        this.securityq=securityq;
        this.newPass=newPass;
        this.confirmNewPass=confirmNewPass;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }

    public String getConfirmNewPass() {
        return confirmNewPass;
    }

    public void setConfirmNewPass(String confirmNewPass) {
        this.confirmNewPass = confirmNewPass;
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
}

