/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author vv
 */
 public class Direccion {
    String callePrincipal;
    String calleSecundaria;
    String codigoPostal;

    public Direccion(String callePrincipal,String calleSecundaria) {
        this.callePrincipal= callePrincipal;
        this.calleSecundaria = calleSecundaria;
        //logica de construccion de un objeto direccion
    }

    public String getCallePrincipal() {
        return callePrincipal;
    }

    public void setDireccion(String callePrincipal,String calleSecundaria) {
        this.callePrincipal= callePrincipal;
        this.calleSecundaria = calleSecundaria;
    }

    public String getCalleSecundaria() {
        return calleSecundaria;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    
    
}
