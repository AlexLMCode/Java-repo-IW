/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import aplicacion.Aplicacion;
import java.util.ArrayList;
import java.util.List;
import modelos.*;

/**
 *
 * @author vv
 */
public class GestionProveedor implements GestionCompleta, Lectura {

    @Override
    public void eliminar() {
        int id;
        Proveedor proveedor;

        do {

            id = capturarNumeroEntero("Digite el numero de id del Proveedor");

            if (id <= 0) {
                System.out.println("MENSAJE: El id debe ser un numero entero positivo");
                id = 0;
            }

        } while (id <= 0);

        id = capturarNumeroEntero("Digite el id del producto");
        proveedor = buscar(id);

        if (proveedor != null) {
            List<Producto> productosProveedor = buscarProductosPorIdProveedor(Aplicacion.productos, id);

            if (productosProveedor.isEmpty()) {
                Aplicacion.proveedores.remove(proveedor);
                System.out.printf("MENSAJE: PROVEEDOR ELIMINADO ID: %s \n", proveedor.getId());
            } else {
                System.out.println("No se puede eliminar el proveedor porque tiene articulos existentes");
            }

        } else {
            System.out.println("MENSAJE: No existe un proveedor con ese id");
        }

    }

    @Override
    public void actualizarDatos() {
        int id = capturarNumeroEntero("Digite el id del producto");
        Proveedor proveedor = buscar(id);
        if(proveedor!=null){
            System.out.printf("--- 1. Actualizar Proovedor %s ---", proveedor.getNombre());
            System.out.println(" ");

            String nombre = capturarCadenaCaracteres("Digite el nuevo nombre del proovedor");
            String numeroTelefono;

            do {
                numeroTelefono = capturarCadenaCaracteres("Digite el nuevo numero del proovedor");

                if (Double.parseDouble(numeroTelefono) <= 0) {
                    System.out.println("MENSAJE: El numero de telefono debe ser un valor positivo");
                }

            } while (Double.parseDouble(numeroTelefono) <= 0);

            String direccion = capturarCadenaCaracteres("Digite la nueva direccion del proveedor");

            proveedor.setNombre(nombre);
            proveedor.setTelefono(numeroTelefono);
            proveedor.setDireccion(direccion);
        }
    }

    @Override
    public void mostrarDatos() {
        int id = capturarNumeroEntero("Digite el id del producto");
        Proveedor proveedor = buscar(id);
        if(proveedor!=null){
            System.out.printf("====== DATOS DE CLIENTE %s ======", proveedor.getNombre());
            System.out.println("Id: " + proveedor.getId());
            System.out.println("Nombre: " + proveedor.getNombre());
            System.out.println("Telefono: " + proveedor.getTelefono());
            System.out.println("Direccion: " + proveedor.getDireccion());
        }
    }

    @Override
    public Proveedor buscar(int id) {

        Proveedor ProveedorBuscado = new Proveedor(id);
        int index = Aplicacion.proveedores.indexOf(ProveedorBuscado);
        return index != -1 ? Aplicacion.proveedores.get(index) : null;
    }

    @Override
    public void crear() {
        System.out.println("--- 1. Crear Proveedor ---");

        int id;
        String numeroTelefono;
        String nombre;
        String direccion;
        Proveedor proveedor;

        do {

            id = capturarNumeroEntero("Digite el numero de id del nuevo Proveedor");

            if (id <= 0) {
                System.out.println("MENSAJE: El id debe ser un numero entero positivo");
                id = 0;
                continue;
            }
            id = capturarNumeroEntero("Digite el id del producto");
            proveedor = buscar(id);

            if (proveedor != null) {
                System.out.println("MENSAJE: Ya existe un proveedor con ese id.");
                id = 0;
            }

        } while (id <= 0);

        do {
            numeroTelefono = capturarCadenaCaracteres("Digite el numero de telefono del proveedor nuevo");

            if (Double.parseDouble(numeroTelefono) <= 0) {
                System.out.println("MENSAJE: El numero de telefono debe ser un valor positivo");
            }

        } while (Double.parseDouble(numeroTelefono) <= 0);

        nombre = capturarCadenaCaracteres("Digite el nombre del nuevo proveedor");
        direccion = capturarCadenaCaracteres("Digite la direccion");


        proveedor = new Proveedor(id, nombre, numeroTelefono, direccion);
        Aplicacion.proveedores.add(proveedor);

    }

    @Override
    public void mostrarSubmenu() {
        System.out.printf("*** Menu Gestion Cliente ***\n");
        System.out.println("1. Crear");
        System.out.println("2. Buscar");
        System.out.println("3. Actualizar");
        System.out.println("4. Eliminar");
        System.out.println("0. Salir");
    }
    
    
    private  List<Producto> buscarProductosPorIdProveedor(List<Producto> productos, int idProveedor) {
        List<Producto> productosProveedor = new ArrayList<>();

        for (Producto producto : productos) {
            if (producto.getIdProveedor() == idProveedor) {
                return productosProveedor;
            } else {
                productosProveedor.add(producto);
            }
        }

        return productosProveedor;

    }
    
}
