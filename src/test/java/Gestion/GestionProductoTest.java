/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Gestion;

import modelos.Producto;
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
public class GestionProductoTest {
    
    public GestionProductoTest() {
    }
    
    @Test
    public void testBuscarANull() {
        System.out.println("buscar");
        GestionProducto g = new GestionProducto();
        Producto expResult = null;
        Producto result = g.buscar(1233);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testBuscarANotNull() {
        System.out.println("buscar");
        GestionProducto g = new GestionProducto();
        Producto expResult = new Producto(123);
        aplicacion.Aplicacion.productos.add(expResult);
        Producto result = g.buscar(123);
        assertEquals(expResult, result);
    }
}
