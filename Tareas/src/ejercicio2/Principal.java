package ejercicio2;

import java.util.Iterator;
import java.util.LinkedList;

public class Principal {

  // Leer 10 palabras y mostrarlas en orden inverso al que fueron ingresadas.

  public static void main(String[] args) {
    // Hacerlo con LinkedList

    LinkedList<String> palabras = new LinkedList<>();

    System.out.println("Ingrese 10 palabras:");
    for (int i = 0; i < 10; i++) {
      String palabra = System.console().readLine();
      palabras.add(palabra);
    }

    System.out.println("\nLas palabras en orden inverso son:");
    Iterator<String> iterador = palabras.descendingIterator();
    while (iterador.hasNext()) {
      System.out.println(iterador.next());
    }
  }
}
