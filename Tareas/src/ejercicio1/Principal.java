package ejercicio1;

public class Principal {

  // Mostrar por consola los 10 primeros números enteros y los 10 primeros números
  // impares

  public static void main(String[] args) {
    System.out.println("Los 10 primeros números enteros son:");
    for (int i = 0; i < 10; i++) {
      System.out.println(i);
    }

    System.out.println("\nLos 10 primeros números impares son:");
    for (int i = 1; i < 20; i += 2) {
      System.out.println(i);
    }
  }
}
