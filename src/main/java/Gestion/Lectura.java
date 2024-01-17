/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Gestion;

import static aplicacion.Aplicacion.teclado;

/**
 *
 * @author vv
 */
public interface Lectura {
    
    
    public default String capturarCadenaCaracteres(String mensaje) {
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

    public default int capturarNumeroEntero(String mensaje) {
        while (true) {
            try {
                System.out.printf("%s: ", mensaje);
                return Integer.parseInt(teclado.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("\nMensaje: Digite un valor que corresponda a un valor entero");
            }
        }
    }

    public default Double capturarNumeroReal(String mensaje) {
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
