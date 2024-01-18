/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package modelos;

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
public class CorreoElectronicoTest {
    
    @Test
    public void testSetCorreoEc() {
        System.out.println("setCorreo");
        String correoExp = "alvascon@espol.ec";
        CorreoElectronico correo = new CorreoElectronico(correoExp);
        String correoP = correo.getCorreo();
        assertEquals(correoExp,correoP);
    }
    
    @Test
    public void testSetCorreoCom() {
        System.out.println("setCorreo");
        String correoExp = "alvascon@dominio.com";
        CorreoElectronico correo = new CorreoElectronico(correoExp);
        String correoP = correo.getCorreo();
        assertEquals(correoExp,correoP);
    }
    
    @Test
    public void testSetCorreoGob() {
        System.out.println("setCorreo");
        String correoExp = "12espol@gobierno.gob";
        CorreoElectronico correo = new CorreoElectronico(correoExp);
        String correoP = correo.getCorreo();
        assertEquals(correoExp,correoP);
    }

    
}
