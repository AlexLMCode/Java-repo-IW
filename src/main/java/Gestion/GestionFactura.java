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
public class GestionFactura implements GestionParcial, Lectura {
    
    @Override
    public void mostrarSubmenu(){
        System.out.println("*** Menu Gestion Facturacion***");
        System.out.println("1. Crear");
        System.out.println("2. Buscar");
        System.out.println("0. Salir");
    }
   
    @Override
    public void crear() {

        System.out.println("----- 1.- Crear Factura ------");

        double total = 0;
        int cedula;
        Cliente cliente;
        List<Integer> idsProductos = new ArrayList<>();
        int idProducto;
        Producto producto;
        int cantidad;
        int impuesto;

        do {
            System.out.println("Listado de clientes");
            for (Cliente clienteEnLista : Aplicacion.clientes) {
                System.out.printf("%s, %s %s\n.", clienteEnLista.getCedula(), clienteEnLista.getNombres(), clienteEnLista.getApellidos());
            }

            GestionCliente g = new GestionCliente();
            cedula =capturarNumeroEntero("Ingrese de nuevo el numero de cedula a registrar: ");
            cliente = (Cliente) g.buscar(cedula);

            if (cliente != null) {
                break;
            } else {
                mostrarMensaje("MENSAJE: No exisete un cliente con ese numero de cedula.");
            }
        } while (true);

        do {
            System.out.println("Listado de productos:");
            System.out.println("0. Salir");

            for (Producto productoEnLista : Aplicacion.productos) {
                System.out.printf("%d. %s - $%.2f - %d unidades\n", productoEnLista.getId(), productoEnLista.getNombre(), productoEnLista.getPrecioVenta(), productoEnLista.getCantidadMinimaStock());
            }


            idProducto = capturarNumeroEntero("Digite el id del producto");

            if (idProducto == 0 && !idsProductos.isEmpty()) {
                break;
            }

            if (idProducto <= 0) {
                mostrarMensaje("MENSAJE: El id del producto debe ser un numero positivo.");
                continue;
            }

            producto = buscarProductoPorId(Aplicacion.productos, idProducto);

            if (producto != null) {

                if (producto.getCantidadMinimaStock() > 0) {

                    do {
                        cantidad = capturarNumeroEntero("Digite la cantidad a comprar del producto seleccionado");

                        if (cantidad <= 0) {
                            System.out.println("MENSAJE: debe digitar una cantidad positiva");
                            continue;
                        }

                        if (cantidad >= producto.getCantidadMinimaStock()) {
                            System.out.println("MENSAJE: No hay cantidad suficiente de este producto, cantidad disponible: " + producto.getCantidadMinimaStock());
                            continue;
                        }

                        break;

                    } while (true);

                    producto.setCantidadMinimaStock(producto.getCantidadMinimaStock() - cantidad);

                    total += producto.getPrecioVenta() * cantidad;

                    idsProductos.add(idProducto);

                } else {
                    System.out.println("este producto no cuenta con existencias");
                }

            } else {
                System.out.println("MENSAJE: No existe un producto con el id especificado");
            }

        } while (true);

        do {
            impuesto = capturarNumeroEntero("Digite el impuesto para esta factura");

            if (impuesto <= 0) {
                System.out.println("El impuesto deve ser un numero positivo");
            }

            if (impuesto > 100) {
                System.out.println("MENSAJE: El impuesto especificado no es un valor valido, debe estar entre 1 y 100");
                continue;
            }

            break;

        } while (true);

        Factura nuevaFactura = new Factura(String.valueOf(cedula), impuesto / 100.0);

        idsProductos.forEach(idProductoLista -> nuevaFactura.agregarIdProducto(idProductoLista));
        nuevaFactura.setTotal(total);

        Aplicacion.facturas.add(nuevaFactura);

    }
    
    @Override
    public Factura buscar(int idFactura) {
        System.out.println("----- 2.- Buscar Factura ------");

        Factura factura=null;

        do {
            System.out.println("Listado de facturas");
            
            if(!Aplicacion.facturas.isEmpty()){
                for (Factura f : Aplicacion.facturas) {

                    System.out.printf("%d.", f.getId());

                }
            }

            if (idFactura <= 0) {
                mostrarMensaje("MENSAJE: El id de la factura debe ser un numero positivo");
            }
            factura = buscarFacturaPorId(Aplicacion.facturas, idFactura);

            if (factura != null) {
                break;
            } else {
                mostrarMensaje("MENSAJE: No se ah encontrado una factura con el id especificado.");
            }
        } while (true);
        return factura;

    }
    
    @Override
    public void mostrarDatos() {
        int idFactura = capturarNumeroEntero("Digite el ID de la factura");
        Factura factura = buscar(idFactura);
        if(factura!=null){
            System.out.println("----- 2.- Datos Factura ------");

            System.out.println("ID: " + factura.getId());
            System.out.println("Fecha: " + factura.getFecha());
            GestionCliente g = new GestionCliente();
            int cedula =capturarNumeroEntero("Ingrese de nuevo el numero de cedula a registrar: ");
            Cliente cliente =(Cliente) g.buscar(cedula);

            System.out.println("Total factura: $" + factura.getTotal());

            System.out.println("Datos Cliente: ");
            assert cliente != null;
            System.out.println("Cedula:" + cliente.getCedula());
            System.out.printf("Nombre completo: %s %s", cliente.getNombres(), cliente.getApellidos());

            System.out.println("");
            //System.out.println("Prouctos: " + Arrays.toString(factura.getIdsProductos()));
            System.out.println("Productos comprados:");
            Producto producto;

            for (Integer id : factura.getIdsProductos()) {
                producto = buscarProductoPorId(Aplicacion.productos, id);

                System.out.println("ID: " + id);
                assert producto != null;
                System.out.println("Nombre: " + producto.getNombre());
                System.out.println("Precio: $" + producto.getPrecioVenta());
            }
        }

    }


    private static Factura buscarFacturaPorId(List<Factura> facturas, int idFactura) {
        return facturas.stream().filter(f -> f.getId() == idFactura).findFirst().get();
    }
    
    private Producto buscarProductoPorId(List<Producto> productos, int id) {

        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }

        return null;
    }

    
    
    


}
