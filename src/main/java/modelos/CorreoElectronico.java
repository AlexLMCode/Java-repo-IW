/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;


/**
 *
 * @author vv
 */
public class CorreoElectronico {
    String correo;
    TipoCuenta tipoCuenta;
    
    public CorreoElectronico(String correo){
        
        setCorreo(correo);
        
        
    }
    
    public final void setCorreo(String correo){
       
       if(validCorreo(correo)){
            this.correo=correo;
            setTipoCuenta(correo);
        }
        
    }
    
    private void setTipoCuenta(String correo){
        //Logica para determinar tipo de cuenta
    }
    
    private boolean validCorreo(String correo) {
        String regex = "[a-zA-Z0-9._%+-]@[a-zA-Z0-9._%+-].[a-zA-Z0-9._%+-]$";
        
        return !correo.matches(regex);
    }

    public String getCorreo() {
        return correo;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }
    

}
