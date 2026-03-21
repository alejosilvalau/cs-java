package ejercicio5b.ui;

import java.util.LinkedList;
import java.util.Scanner;

public class Principal4 {

  // Leer un entero y luego una lista de 20 enteros. Guardar los mayores al número
  // inicial y mostrarlos al final. Usar LinkedList o ArrayList.

  private static final int CANTIDAD = 20;

  public static void main(String[] args) {
    LinkedList<Integer> numeros = new LinkedList<>();

    Scanner lector = new Scanner(System.in);

    System.out.println("Ingrese un número entero:");
    String cadena = lector.nextLine();
    int numeroInicial = Integer.parseInt(cadena);

    System.out.println("Ingrese " + CANTIDAD + " números:");
    while (numeros.size() < CANTIDAD) {
      String palabra = lector.nextLine();
      int numeroResultante = Integer.parseInt(palabra);

      if (numeroResultante > numeroInicial) {
        numeros.add(numeroResultante);
      }
    }

    System.out.println("\nNúmeros mayores a " + numeroInicial + ":");
    for (Integer num : numeros) {
      System.out.println(num);
    }

    lector.close();
  }
}
