/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author vv
 */
public class Telefono {
    int zonaHoraria;
    String numero;

    public Telefono(String numero) {
        this.numero = numero;
        //logica de construccion de un objeto telefono
    }

    public int getZonaHoraria() {
        return zonaHoraria;
    }

    public void setZonaHoraria(int zonaHoraria) {
        this.zonaHoraria = zonaHoraria;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    
}
