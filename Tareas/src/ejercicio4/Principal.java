package ejercicio4;

import java.util.Scanner;

public class Principal {

  // Leer un entero y luego una lista de 20 enteros. Guardar los mayores al número
  // inicial y mostrarlos al final. Usar arrays, no otras colecciones.

  private static final int CANTIDAD = 20;

  public static void main(String[] args) {
    int[] numeros = new int[CANTIDAD];

    Scanner lector = new Scanner(System.in);

    System.out.println("Ingrese un número entero:");
    String cadena = lector.nextLine();
    int numeroInicial = Integer.parseInt(cadena);

    System.out.println("Ingrese " + CANTIDAD + " números:");
    for (int i = 0; i < CANTIDAD; i++) {
      String palabra = lector.nextLine();
      int numeroResultante = Integer.parseInt(palabra);

      if (numeroResultante > numeroInicial) {
        numeros[i] = numeroResultante;
      } else {
        numeros[i] = Integer.MIN_VALUE;
      }
    }

    System.out.println("\nNúmeros mayores a " + numeroInicial + ":");
    for (int numero : numeros) {
      if (numero != Integer.MIN_VALUE) {
        System.out.println(numero);
      }
    }

    lector.close();
  }
}
