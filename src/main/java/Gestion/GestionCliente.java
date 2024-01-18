/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import java.util.ArrayList;
import java.util.List;
import modelos.*;
import aplicacion.Aplicacion;

/**
 *
 * @author vv
 */
public class GestionCliente implements GestionCompleta, Lectura{
    
    
    @Override
    public void mostrarSubmenu() {
        System.out.printf("*** Menu Gestion Cliente ***\n");
        System.out.println("1. Crear");
        System.out.println("2. Buscar");
        System.out.println("3. Actualizar");
        System.out.println("4. Eliminar");
        System.out.println("0. Salir");
    }
    
    @Override
    public Cliente buscar(int cedulaEntrante) {
        String cedula = String.valueOf(cedulaEntrante);
        Cliente clienteBuscado = new Cliente(cedula);
        int index = Aplicacion.clientes.indexOf(clienteBuscado);
        return index != -1 ? Aplicacion.clientes.get(index) : null;
    }
    
    @Override
    public void crear() {
        System.out.println("--- 1.Crear Cliente ---");
        String nombres, apellidos;
        Telefono numeroTelefono;
        Cliente clienteCrear;
        CorreoElectronico correoElectronico;
        Direccion direccion;
        int cedula;
        cedula =capturarNumeroEntero("Ingrese de nuevo el numero de cedula a registrar: ");
        Cliente clienteBuscado = buscar(cedula);
        if (clienteBuscado==null) {
            
            nombres = capturarCadenaCaracteres("Digite los nombres del nuevo cliente: ");
            apellidos = capturarCadenaCaracteres("Digite los apellidos: ");
            String numeroTelf = capturarCadenaCaracteres("Digite el nuevo numero del cliente: ");
            String callePrincipal = capturarCadenaCaracteres("Digite la calle principal de la nueva direccion del cliente: ");
            String calleSecundaria = capturarCadenaCaracteres("Digite la calle secundaria de la nueva direccion del cliente: ");
            String correo = capturarCadenaCaracteres("Digite el correo nuevo del cliente: ");
            
            direccion = new Direccion(callePrincipal,calleSecundaria);
            numeroTelefono = new Telefono(numeroTelf);
            correoElectronico = new CorreoElectronico(correo);

            clienteCrear = new Cliente(String.valueOf(cedula), nombres, apellidos, numeroTelefono, direccion, correoElectronico);
            Aplicacion.clientes.add(clienteCrear);
        }
        else{
            System.out.printf("MENSAJE: Ya existe un cliente con la cedula %s.\n", clienteBuscado.getCedula());
        }
    }
    
    @Override
    public void mostrarDatos() {
        int cedula =capturarNumeroEntero("Ingrese de nuevo el numero de cedula a registrar: ");
        Cliente cliente = buscar(cedula);
        if(cliente!=null){
            System.out.println("========= Datos del cliente =========");
            System.out.println("Cedula: " + cliente.getCedula());
            System.out.println("Nombre: " + cliente.getNombres());
            System.out.println("Apellidos: " + cliente.getApellidos());
            System.out.println("Telefono: " + cliente.getTelefono());
            System.out.println("Direccion: " + cliente.getDireccion());
            System.out.println("Correo Electronico: " + cliente.getCorreoElectronico());
            System.out.println("====================================");
            System.out.println(" ");
        }
    }
    
    @Override
    public void actualizarDatos() {
        int cedula =capturarNumeroEntero("Ingrese de nuevo el numero de cedula a registrar: ");
        Cliente cliente = buscar(cedula);
        if(cliente!=null){
            System.out.printf("--- 1.Actualizar Cliente %s %s ---", cliente.getNombres(), cliente.getApellidos());
            String nombres = capturarCadenaCaracteres("Digite los nuevos nombres del cliente");
            String apellidos = capturarCadenaCaracteres("Digite los nuevos apellidos del cliente");
            String numeroTelf = capturarCadenaCaracteres("Digite el nuevo numero del cliente");
            String callePrincipal = capturarCadenaCaracteres("Digite la calle principal de la nueva direccion del cliente");
            String calleSecundaria = capturarCadenaCaracteres("Digite la calle secundaria de la nueva direccion del cliente");
            String correo = capturarCadenaCaracteres("Digite el correo nuevo del cliente: ");
            
            cliente.setNombres(nombres);
            cliente.setApellidos(apellidos);
            cliente.setTelefono(numeroTelf);
            cliente.setDireccion(callePrincipal,calleSecundaria);
            cliente.setCorreo(correo);
        }

    }

    @Override
    public void eliminar() {

        int cedula =capturarNumeroEntero("Ingrese de nuevo el numero de cedula a registrar: ");
        Cliente cliente = buscar(cedula);

        if (cliente != null) {
            Factura factura = buscarFacturaPorCedula(Aplicacion.facturas, Integer.parseInt(cliente.getCedula()));
            if (factura == null) {
                Aplicacion.clientes.remove(cliente);
                System.out.printf("MENSAJE: Se ah eliminado el cliente con cedula %s", cliente.getCedula());
            } else {
                System.out.println("MENSAJE: No se puede eliminar el cliente. Tiene una o mas facturas.");
            }
        } else {
            System.out.println("MENSAJE: No se encontro un cliente con ese numero de cedula.");
        }
    }
    
    private Factura buscarFacturaPorCedula(List<Factura> facturas, int numeroCedula) {

        for (Factura factura : facturas) {
            if (factura.getCedulaCliente().equals(String.valueOf(numeroCedula))) {
                return factura;
            }
        }
        return null;
    }

}


