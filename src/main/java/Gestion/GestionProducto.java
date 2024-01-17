/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import aplicacion.Aplicacion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import modelos.*;

/**
 *
 * @author vv
 */
public class GestionProducto implements GestionCompleta, Lectura {

    @Override
    public void actualizarDatos() {
        Producto producto = buscar();
        if(producto!=null){
            System.out.println("--- 3. Actualizar Producto  ---");

            String nombre;
            String descripcion;
            double precio;
            double precioVenta;
            int cantidadMinimaStock;
            int idProveedor;

            nombre = capturarCadenaCaracteres("Digite el nombre para actualizar producto");
            descripcion = capturarCadenaCaracteres("Digite la nueva descripcion producto");

            // PRECIO
            do {
                precio = capturarNumeroReal("Digite el nuevo precio de compra del producto");

                if (precio <= 0) {
                    System.out.println("MENSAJE: El precio debe ser un numero entero positivo");
                    precio = 0;
                }

            } while (precio <= 0);

            // PRECIO VENTA
            do {

                precioVenta = capturarNumeroReal("Digite el nuevo precio de venta del producto");

                if (precioVenta <= 0 && precioVenta > precio) {
                    System.out.println("MENSAJE: El precio debe ser un numero entero positivo");
                    precioVenta = 0;
                }

            } while (precioVenta <= 0);

            // CANTIDAD MINIMA STOCK
            do {

                cantidadMinimaStock = capturarNumeroEntero("Digite la nueva cantidad minima de stock");

                if (cantidadMinimaStock <= 0) {
                    System.out.println("MENSAJE: El id debe ser un numero entero positivo");
                    cantidadMinimaStock = 0;
                }

            } while (cantidadMinimaStock <= 0);

            do {
                System.out.println("Listado de proveedores disponibles");

                for (Proveedor proveedor : Aplicacion.proveedores) {
                    System.out.printf("%d. %s\n", proveedor.getId(), proveedor.getNombre());
                }

                GestionProveedor g = new GestionProveedor();
                idProveedor = g.buscar().getId();
                if (g.buscar() != null) {
                    break;
                } else {
                    System.out.printf("MENSAJE: no existe un proveedor con el id %s especificado. \n", idProveedor);
                }


            } while (true);

            producto.setDescripcion(descripcion);
            producto.setNombre(nombre);
            producto.setIdProveedor(idProveedor);
            producto.setCantidadMinimaStock(cantidadMinimaStock);
            producto.setPrecioCompra(precio);
            producto.setPrecioVenta(precioVenta);
        }

    }

    @Override
    public void mostrarDatos() {
        Producto producto = buscar();
        if(producto!=null){
            System.out.println("--- 2. Datos de Producto  ---");

            System.out.println("ID: " + producto.getId());
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Descripcion: " + producto.getDescripcion());
            System.out.println("Id Proveedor: " + producto.getIdProveedor());
            System.out.println("Precio Compra: " + producto.getPrecioCompra());
            System.out.println("Precio Venta: " + producto.getPrecioVenta());
            System.out.println("Cantidad en Stock: " + producto.getCantidadMinimaStock());
        }
    }

    @Override
    public Producto buscar() {
        int id;
        
        System.out.println("--- 2. Buscar Producto  ---");
        do {
            id = capturarNumeroEntero("Digite el id del producto");
            if (id <= 0) {
                System.out.println("MENSAJE: El id debe ser un numero positivo");
                id = 0;
            }
        } while (id <= 0);
        
        Producto productoBuscado = new Producto(id);
        int index = Aplicacion.productos.indexOf(productoBuscado);
        return index != -1 ? Aplicacion.productos.get(index) : null;

    }

    @Override
    public void crear() {
        System.out.println("--- 1. Crear Producto ---");

        int id;
        String nombre;
        String descripcion;
        double precio;
        double precioVenta;
        int cantidadMinimaStock;
        int idProveedor;
        Producto producto;

        //ID
        do {

            id = capturarNumeroEntero("Digite el numero de id del nuevo Proveedor");
            if (id <= 0) {
                System.out.println("MENSAJE: El id debe ser un numero entero positivo");
                id = 0;
                continue;
            }
            producto = buscarProductoPorId(Aplicacion.productos, id);
            if (producto != null) {
                System.out.println("MENSAJE: Ya existe un producto con ese id.");
                id = 0;
            }
        } while (id <= 0);

        nombre = capturarCadenaCaracteres("Digite el nombre del nuevo producto");
        descripcion = capturarCadenaCaracteres("Digite la descripcion del nuevo producto");

        // PRECIO
        do {
            precio = capturarNumeroReal("Digite el precio de compra del producto");
            if (precio <= 0) {
                System.out.println("MENSAJE: El precio debe ser un numero entero positivo");
                precio = 0;
            }
        } while (precio <= 0);

        // PRECIO VENTA
        do {
            precioVenta = capturarNumeroReal("Digite el precio de venta del producto");
            if (precioVenta <= 0 && precioVenta > precio) {
                System.out.println("MENSAJE: El precio debe ser un numero entero positivo");
                precioVenta = 0;
            }
        } while (precioVenta <= 0);

        // CANTIDAD MINIMA STOCK
        do {
            cantidadMinimaStock = capturarNumeroEntero("Digite la cantidad minima de stock");
            if (cantidadMinimaStock <= 0) {
                System.out.println("MENSAJE: El id debe ser un numero entero positivo");
                cantidadMinimaStock = 0;
            }
        } while (cantidadMinimaStock <= 0);

        System.out.println("Listado de proveedores disponibles");

        for (Proveedor proveedor : Aplicacion.proveedores) {
            System.out.printf("%d. %s\n", proveedor.getId(), proveedor.getNombre());
        }
        GestionProveedor g = new GestionProveedor();
        Proveedor p = g.buscar();
        idProveedor = p.getId();
        producto = new Producto(id, nombre, descripcion, precio, precioVenta, cantidadMinimaStock, idProveedor);
        Aplicacion.productos.add(producto);
    }

    @Override
    public void eliminar() {
        System.out.println("--- 4. Eliminar Producto  ---");

        Producto producto;
        producto = buscar();

        if (producto != null) {

            if (!productoEnFactura(producto.getId(), Aplicacion.facturas)) {
                Aplicacion.productos.remove(producto);
                System.out.printf("Se ah eliminado el producto con el id %s", producto.getId());
            } else {
                System.out.println("MENSAJE: No se puede eliminar el producto porque esta asociado a una factura");
            }

        } else {
            System.out.println("MENSAJE: no se ah encontrado ningun producto con ese ID");
        }


    }
    
    private boolean productoEnFactura(int id,List<Factura> facturas) {
        Integer[] idsProductos;

        for (Factura factura : facturas) {
            idsProductos = factura.getIdsProductos();
            Arrays.sort(idsProductos);
            if (Arrays.binarySearch(idsProductos, id) != -1) {
                return true;
            }
        }
        return false;
    }
    
    private Producto buscarProductoPorId(List<Producto> productos, int id) {

        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }

        return null;
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
    
}
