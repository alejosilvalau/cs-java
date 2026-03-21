package ejercicio6a.ui;

import java.util.Scanner;

import ejercicio6a.entities.*;

public class Menu {
  Scanner s = null;

  public void start() {
    s = new Scanner(System.in);
    System.out.println("Welcome to the Java Market App");
    System.out.println();

    String command;
    do {
      command = getCommand();
      executeCommand(command);
      System.out.println();

    } while (!command.equalsIgnoreCase("exit"));

    s.close();
  }

  private void executeCommand(String command) {
    switch (command) {
      case "list":
        System.out.println();
        break;
      case "seach":

        break;
      case "new":

        break;
      case "delete":

        break;
      case "update":

        break;
      default:
        break;
    }
  }

  private String getCommand() {
    System.out.println("Enter the command according to the option you want to perform");
    System.out.println("list\t\tlist all products");
    System.out.println("search\t\tsearch a product");
    System.out.println("new\t\tcreate a new product");
    System.out.println("delete\t\tdelete a product");
    System.out.println("update\t\tupdate a product");
    System.out.println();
    System.out.print("command: ");
    return s.nextLine();
  }
}
