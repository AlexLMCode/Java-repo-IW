package aplicacion;

import modelos.Cliente;
import modelos.Factura;
import modelos.Proveedor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplicacion {
    private static final int SALIR = 0;
    private static final int GESTION_CLIENTES = 1;
    private static final int GESTION_PROVEEDORES = 2;
    private static final int GESTION_PRODUCTOS = 3;
    private static final int GESTION_FACTURACION = 4;

    private static final int CREAR = 1;
    private static final int BUSCAR = 2;
    private static final int ACTUALIZAR = 3;
    private static final int ELIMINAR = 4;

    public static Scanner teclado;

    public static void main(String[] args) {
        teclado = new Scanner(System.in);

        List<Cliente> clientes = new ArrayList<>();
        List<Proveedor> proveedores = new ArrayList<>();
        List<Proveedor> productos = new ArrayList<>();
        List<Factura> facturas = new ArrayList<>();

        int opcion;
        int opcionSubmenu;
        Cliente cliente;

        do { // Iniciar apliacion

            do { //Mostrar el menu principal mientras que no se eliga la opcion salir o la opcion de facturacion
                mostrarMenuPrincipal();
                opcion = capturarNumeroEntero("Digite la operacion a realizar");

                if (opcion < SALIR || opcion > GESTION_FACTURACION) {
                    System.out.println("MENSAJE: Debe digitar un valor entre 0 y 4");

                }

            } while (opcion < SALIR || opcion > GESTION_FACTURACION);

            switch (opcion) {
                // CRUD CLIENTES
                case GESTION_CLIENTES:

                    do {
                        mostrarSubmenu("Clientes");
                        opcionSubmenu = capturarNumeroEntero("Digite la operacion a realizar");

                        if (opcionSubmenu < SALIR || opcionSubmenu > ELIMINAR) {
                            System.out.println("MENSAJE: Debe digitar un valor entre 0 y 4");
                        }

                    } while (opcionSubmenu < SALIR || opcionSubmenu > ELIMINAR);

                    switch (opcionSubmenu) {

                        case CREAR:
                            cliente = crearCliente(clientes);
                            clientes.add(cliente);
                            break;

                        case BUSCAR:
                            cliente = buscarCliente(clientes);
                            if (cliente != null) {
                                mostrarDatosCliente(cliente);
                            } else {
                                System.out.println("No se encontro un cliente");
                            }
                            break;

                        case ACTUALIZAR:
                            cliente = buscarCliente(clientes);
                            if (cliente != null) {
                                actualizarDatosCliente(cliente);
                                mostrarDatosCliente(cliente);
                            } else {
                                System.out.println("No se encontro un cliente");
                            }

                            break;

                        case ELIMINAR:
                            eliminarCliente(clientes, facturas);
                            break;
                    }
                    break;

                // CRUD PRODUCTOS
                case GESTION_PRODUCTOS:
                    break;
                case GESTION_PROVEEDORES:
                    break;
                case GESTION_FACTURACION:
                    break;
            }

        } while (opcion != SALIR);

    }

    private static void eliminarCliente(List<Cliente> clientes, List<Factura> facturas) {
        int numeroCedula;

        do {
            numeroCedula = capturarNumeroEntero("Digite la cedula de un cliente");

            if (numeroCedula <= 0) {
                System.out.println("MENSAJE: La cedula debe ser un numero entero positivo");
                numeroCedula = 0;
                continue;
            }

        } while (numeroCedula <= 0);

        Cliente cliente = buscarClientePorCedula(clientes, String.valueOf(numeroCedula));

        if (cliente != null) {
            Factura factura = buscarFacturaPorCedula(facturas, numeroCedula);
            if (factura == null) {
                clientes.remove(cliente);
                System.out.printf("MENSAJE: Se ah eliminado el cliente con cedula %s", cliente.getCedula());
            } else {
                System.out.println("MENSAJE: No se puede eliminar el cliente. Tiene una o mas facturas.");
            }
        } else {
            System.out.println("MENSAJE: No se encontro un cliente con ese numero de cedula.");
        }


    }

    private static Factura buscarFacturaPorCedula(List<Factura> facturas, int numeroCedula) {

        for (Factura factura : facturas) {
            if (factura.getCedulaCliente().equals(String.valueOf(numeroCedula))) {
                return factura;
            }
        }
        return null;
    }

    private static void actualizarDatosCliente(Cliente cliente) {
        System.out.printf("--- 1.Actualizar Cliente %s %s ---", cliente.getNombres(), cliente.getApellidos());
        String nombres = capturarCadenaCaracteres("Digite los nuevos nombres del cliente");
        String apellidos = capturarCadenaCaracteres("Digite los nuevos apellidos del cliente");

        String numeroTelefono;

        do {
            numeroTelefono = capturarCadenaCaracteres("Digite el nuevo numero del cliente");

            if (Double.parseDouble(numeroTelefono) <= 0) {
                System.out.println("MENSAJE: El numero de telefono debe ser un valor positivo");
            }

        } while (Double.parseDouble(numeroTelefono) <= 0);

        String direccion = capturarCadenaCaracteres("Digite la nueva direccion del cliente");
        String email;

        while (true) {
            email = capturarCadenaCaracteres("Digite el nuevo correo electronico del cliente");

            if (validEmail(email)) {
                System.out.println("MENSAJE: Correo invalido");
                continue;
            }
            break;
        }

        cliente.setNombres(nombres);
        cliente.setApellidos(apellidos);
        cliente.setDireccion(direccion);
        cliente.setTelefono(numeroTelefono);
        cliente.setCorreoElectronico(email);

    }

    private static void mostrarDatosCliente(Cliente cliente) {
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

    private static Cliente buscarCliente(List<Cliente> clientes) {
        int numeroCedula;

        do {
            numeroCedula = capturarNumeroEntero("Digite la cedula de un cliente");

            if (numeroCedula <= 0) {
                System.out.println("MENSAJE: La cedula debe ser un numero entero positivo");
                numeroCedula = 0;
                continue;
            }

        } while (numeroCedula <= 0);

        return buscarClientePorCedula(clientes, String.valueOf(numeroCedula));

    }

    private static Cliente crearCliente(List<Cliente> clientes) {
        System.out.println("--- 1.Crear Cliente ---");
        int numeroCedula;
        String numeroTelefono;
        Cliente cliente;

        do {
            numeroCedula = capturarNumeroEntero("Digite la cedula de un cliente nuevo");

            if (numeroCedula <= 0) {
                System.out.println("MENSAJE: La cedula debe ser un numero entero positivo");
                numeroCedula = 0;
                continue;
            }

            cliente = buscarClientePorCedula(clientes, String.valueOf(numeroCedula));

            if (cliente != null) {
                // Si no es null significa que ya existe
                System.out.printf("MENSAJE: Ya existe un cliente con la cedula %s.\n", numeroCedula);
                numeroCedula = 0;
            }

        } while (numeroCedula <= 0);

        String nombres = capturarCadenaCaracteres("Digite los nombres del nuevo cliente");
        String apellidos = capturarCadenaCaracteres("Digite los apellidos");

        do {
            numeroTelefono = capturarCadenaCaracteres("Digite el numero de telefono del cliente nuevo");

            if (Double.parseDouble(numeroTelefono) <= 0) {
                System.out.println("MENSAJE: El numero de telefono debe ser un valor positivo");
            }

        } while (Double.parseDouble(numeroTelefono) <= 0);

        String direccion = capturarCadenaCaracteres("Digite la direccion del cliente nuevo");
        String email;

        while (true) {
            email = capturarCadenaCaracteres("Digite el correo electronico del nuevo cliente");

            if (validEmail(email)) {
                System.out.println("MENSAJE: Correo invalido");
                continue;
            }
            break;
        }

        cliente = new Cliente(String.valueOf(numeroCedula), nombres, apellidos, numeroTelefono, direccion, email);
        return cliente;
    }

    static boolean validEmail(String email) {
        String regex = "^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$";
        return !email.matches(regex);
    }

    private static Cliente buscarClientePorCedula(List<Cliente> clientes, String cedula) {
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                return cliente;
            }
        }
        return null;
    }

    public static void mostrarMenuPrincipal() {
        System.out.println("=== MENU PRINCIPAL ===");
        System.out.println("1. Gestion Clientes");
        System.out.println("2. Gestion Proveedores");
        System.out.println("3. Gestion Productos");
        System.out.println("4. Gestion Facturacion");
        System.out.println("0. Salir");
    }

    public static void mostrarSubmenuFacturacion() {
        System.out.println("*** Menu Gestion Facturacion***");
        System.out.println("1. Crear");
        System.out.println("2. Buscar");
        System.out.println("0. Salir");
    }

    public static void mostrarSubmenu(String tipoMenu) {
        System.out.printf("*** Menu Gestion %s ***\n", tipoMenu);
        System.out.println("1. Crear");
        System.out.println("2. Buscar");
        System.out.println("3. Actualizar");
        System.out.println("4. Eliminar");
        System.out.println("0. Salir");
    }

    public static String capturarCadenaCaracteres(String mensaje) {
        String resultado;

        while (true) {
            System.out.printf("%s: ", mensaje);
            resultado = teclado.nextLine().strip();

            if (!resultado.isEmpty()) {
                return resultado;
            }

            System.out.println("MENSAJE: Ah escrito una cadena vacia, ingrese un valor");

        }
    }

    public static int capturarNumeroEntero(String mensaje) {

        while (true) {

            try {
                System.out.printf("%s: ", mensaje);
                return Integer.parseInt(teclado.nextLine());

            } catch (NumberFormatException e) {

                System.out.println("Mensaje: Digite un valor que corresponda a un valor entero");

            }

        }

    }

    public static Double capturarNumeroReal(String mensaje) {

        while (true) {

            try {
                System.out.printf("%s: ", mensaje);
                return Double.parseDouble(teclado.nextLine());

            } catch (NumberFormatException e) {

                System.out.println("Mensaje: Digite un valor que corresponda a un numero real");

            }

        }

    }

}
