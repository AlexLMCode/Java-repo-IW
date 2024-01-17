/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import static aplicacion.Aplicacion.capturarCadenaCaracteres;

/**
 *
 * @author vv
 */
public class CorreoElectronico {
    String correo;
    TipoCuenta tipoCuenta;
    
    public CorreoElectronico(){
        this.setCorreo();
    }
    
    public final void setCorreo(){
        String correoPrueba;
        do {
            correoPrueba = capturarCadenaCaracteres("Digite el correo electronico del nuevo cliente");
            if (!validCorreo(correoPrueba)) {
                System.out.println("MENSAJE: Correo invalido");
            }
        } while(!validCorreo(correoPrueba));
        
        this.correo=correoPrueba;
        setTipoCuenta(correoPrueba);
        
    }
    
    private void setTipoCuenta(String correoNuevo){
        //Logica para determinar tipo de cuenta
    }
    
    private boolean validCorreo(String correo) {
        String regex = "^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$";
        return !correo.matches(regex);
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }
    

}
