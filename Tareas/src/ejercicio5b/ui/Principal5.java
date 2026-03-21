package ejercicio5b.ui;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

import ejercicio5a.entidades.*;

public class Principal5 {
  private static final int MAX_EMPLEADOS = 20;

  public static void main(String[] args) {
    ArrayList<Empleado> empleados = new ArrayList<>();
    int indice = 0;
    boolean continuar = true;

    Scanner lector = new Scanner(System.in);

    System.out.println("Registro de Empleados");
    while (indice < MAX_EMPLEADOS && continuar) {
      System.out.println("");
      System.out.println("Empleado " + (indice + 1) + ":");

      System.out.println("Empleado es Administrativo(1) o Empleado(2)?");
      String respuesta = lector.nextLine();

      System.out.println("Ingrese el dni del empleado:");
      int dni = Integer.parseInt(lector.nextLine());

      System.out.println("Ingrese el nombre del empleado:");
      String nombre = lector.nextLine();

      System.out.println("Ingrese el apellido del empleado:");
      String apellido = lector.nextLine();

      System.out.println("Ingrese el email del empleado:");
      String email = lector.nextLine();

      System.out.println("Ingrese el sueldo base del empleado:");
      float sueldoBase = Float.parseFloat(lector.nextLine());

      if (respuesta.equals("1")) {
        System.out.println("Ingrese las horas extra del administrativo:");
        int hrExtra = Integer.parseInt(lector.nextLine());

        System.out.println("Ingrese las horas por mes del administrativo:");
        int hrMes = Integer.parseInt(lector.nextLine());

        empleados.addLast(new Administrativo(dni, nombre, apellido, email, sueldoBase, hrExtra, hrMes));
      } else if (respuesta.equals("2")) {
        System.out.println("Ingrese el porcentaje de comision del vendedor:");
        int porcenComision = Integer.parseInt(lector.nextLine());

        System.out.println("Ingrese el total de ventas del vendedor:");
        int totalVentas = Integer.parseInt(lector.nextLine());

        empleados.addLast(new Vendedor(dni, nombre, apellido, email, sueldoBase, porcenComision, totalVentas));
      }

      indice++;
      if (indice < MAX_EMPLEADOS) {
        System.out.println("");
        System.out.println("Desea ingresar otro empleado? (s/n)");
        String continuarRespuesta = lector.nextLine();
        continuar = Set.of("s", "y").contains(continuarRespuesta.toLowerCase());
      }
    }

    System.out.println("");
    for (Empleado empleado : empleados) {
      if (empleado != null) {
        System.out.println(empleado.toString());
      }
    }

    lector.close();
  }
}
