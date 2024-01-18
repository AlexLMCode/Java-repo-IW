/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Gestion;

import modelos.Proveedor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vv
 */
public class GestionProveedorTest {
    
    public GestionProveedorTest() {
    }
    
    @Test
    public void testBuscarANull() {
        System.out.println("buscar");
        GestionProveedor g = new GestionProveedor();
        Proveedor expResult = null;
        Proveedor result = g.buscar(1233);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testBuscarANotNull() {
        System.out.println("buscar");
        GestionProveedor g = new GestionProveedor();
        Proveedor expResult = new Proveedor(123);
        aplicacion.Aplicacion.proveedores.add(expResult);
        Proveedor result = g.buscar(123);
        assertEquals(expResult, result);
    }
    
}
