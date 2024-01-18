/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Gestion;


/**
 *
 * @author vv
 */
public interface GestionParcial {
    public void mostrarSubmenu();
    
    public Object buscar(int codigo);
    
    public void crear();
    
    public void mostrarDatos();
    
    default void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
    
}
