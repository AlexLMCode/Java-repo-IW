package aplicacion;

import Gestion.*;
import modelos.Cliente;
import modelos.Factura;
import modelos.Producto;
import modelos.Proveedor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class Aplicacion {
    
    public static List<Cliente> clientes = new ArrayList<>();
    public static List<Proveedor> proveedores = new ArrayList<>();
    public static List<Producto> productos = new ArrayList<>();
    public static List<Factura> facturas = new ArrayList<>();
    
    private static final int SALIR = 0;
    private static final int GESTION_CLIENTES = 1;
    private static final int GESTION_PROVEEDORES = 2;
    private static final int GESTION_PRODUCTOS = 3;
    private static final int GESTION_FACTURACION = 4;

    private static final int CREAR = 1;
    private static final int BUSCAR = 2;
    private static final int ACTUALIZAR = 3;
    private static final int ELIMINAR = 4;

    

    public static void main(String[] args) {
        
        GestionParcial tipoGestion;
        int opcionTipoGestion;
        int opcionSubmenu;
        
        do{ 
            do{ 
                mostrarMenuPrincipal();
                opcionTipoGestion = capturarNumeroEntero("Digite la operacion a realizar");
                if (opcionTipoGestion < SALIR || opcionTipoGestion > GESTION_FACTURACION) {
                    System.out.println("MENSAJE: Debe digitar un valor entre 0 y 4");
                }
            } while (opcionTipoGestion < SALIR || opcionTipoGestion > GESTION_FACTURACION);

            if (opcionTipoGestion == SALIR) {
                break;
            }
            tipoGestion = gestionBuilder(opcionTipoGestion);
            tipoGestion.mostrarSubmenu();
            do {
                opcionSubmenu = capturarNumeroEntero("Digite la operacion a realizar");
                if (opcionSubmenu < SALIR || opcionSubmenu > ELIMINAR) {
                    System.out.println("MENSAJE: Debe digitar un valor entre 0 y 4");
                }
            } while (opcionSubmenu < SALIR || opcionSubmenu > ELIMINAR);
            switch (opcionSubmenu){
                case CREAR:
                    tipoGestion.crear();
                    break;
                case BUSCAR:
                    tipoGestion.mostrarDatos();
                    break;
                case ACTUALIZAR:
                    if(tipoGestion instanceof GestionFactura==false){
                        GestionCompleta gestionCompleta = (GestionCompleta) tipoGestion;
                        gestionCompleta.actualizarDatos();
                        gestionCompleta.mostrarDatos();
                    }
                    break;
                case ELIMINAR:
                    if(tipoGestion instanceof GestionFactura==false){
                        GestionCompleta gestionCompleta = (GestionCompleta) tipoGestion;
                        gestionCompleta.eliminar();
                    }
                    break;
            }
        } while (opcionTipoGestion != SALIR); 
    }     
            
    private static GestionParcial gestionBuilder(int opcion){
        GestionParcial tipoGestion;
        switch(opcion){
            case GESTION_CLIENTES:
                tipoGestion = new GestionCliente();
                break;
                
            case GESTION_PROVEEDORES:
                tipoGestion = new GestionProveedor();
                break;
                
            case GESTION_PRODUCTOS:
                tipoGestion = new GestionProducto();
                break;
                
            case GESTION_FACTURACION:
                tipoGestion = new GestionFactura();
                break;
                
            default:
                tipoGestion = null;
        }
        return tipoGestion;
    }
    
    public static void mostrarMenuPrincipal() {
        System.out.println("=== MENU PRINCIPAL ===");
        System.out.println("1. Gestion Clientes");
        System.out.println("2. Gestion Proveedores");
        System.out.println("3. Gestion Productos");
        System.out.println("4. Gestion Facturacion");
        System.out.println("0. Salir");
    }
    
   public static String capturarCadenaCaracteres(String mensaje) {
        String resultado = null;

        try(Scanner teclado=new Scanner(System.in)){
            while (true) {
                System.out.printf("%s: ", mensaje);
                resultado = teclado.nextLine().strip();
                if (!resultado.isEmpty()) {
                    return resultado;
                }
                System.out.println("MENSAJE: Ah escrito una cadena vacia, ingrese un valor");
            }
        }catch(Exception e){}
        return resultado;
    }

    public static Integer capturarNumeroEntero(String mensaje) {
        try(Scanner teclado=new Scanner(System.in)){
            while (true) {
                try {
                    System.out.printf("%s: ", mensaje);
                    return Integer.parseInt(teclado.nextLine());

                } catch (NumberFormatException e) {
                    System.out.println("\nMensaje: Digite un valor que corresponda a un valor entero");
                }
            }
        }catch(Exception e){}
        return null;
    }

    public static Double capturarNumeroReal(String mensaje) {
        try(Scanner teclado=new Scanner(System.in)){
            while (true) {
                try {
                    System.out.printf("%s: ", mensaje);
                    return Double.parseDouble(teclado.nextLine());

                } catch (NumberFormatException e) {

                    System.out.println("Mensaje: Digite un valor que corresponda a un numero real");
                }
            }
        }catch(Exception e){}
        return null;

    }

}
