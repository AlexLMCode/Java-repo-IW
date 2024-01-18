/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Gestion;

import java.util.Scanner;

/**
 *
 * @author vv
 */
public interface Lectura {
    
    
    
    public default String capturarCadenaCaracteres(String mensaje) {
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

    public default Integer capturarNumeroEntero(String mensaje) {
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

    public default Double capturarNumeroReal(String mensaje) {
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
