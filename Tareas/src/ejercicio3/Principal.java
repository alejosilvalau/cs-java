package ejercicio3;

import java.util.Scanner;

public class Principal {

  // Leer 10 palabras, luego leer una nueva palabra e indicar si la misma ya había
  // sido ingresada en las 10 primeras.

  public static void main(String[] args) {
    String[] palabras = new String[10];

    Scanner lector = new Scanner(System.in);

    System.out.println("Ingrese 10 palabras:");
    for (int i = 0; i < 10; i++) {
      palabras[i] = lector.nextLine();
    }

    System.out.println("\nIngrese una nueva palabra:");
    String nuevaPalabra = lector.nextLine();

    boolean encontrada = false;
    for (String palabra : palabras) {
      if (palabra.equals(nuevaPalabra)) {
        encontrada = true;
        break;
      }
    }

    if (encontrada) {
      System.out.println("La palabra '" + nuevaPalabra + "' ya había sido ingresada.");
    } else {
      System.out.println("La palabra '" + nuevaPalabra + "' no había sido ingresada.");
    }

    lector.close();
  }
}
