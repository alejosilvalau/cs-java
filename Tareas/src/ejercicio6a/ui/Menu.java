package ejercicio6a.ui;

import java.util.Scanner;

import ejercicio6a.entities.*;
import ejercicio6a.logic.*;

public class Menu {
  Scanner s = null;

  List ctrlList = new List();
  Search ctrlSearch = new Search();
  Add ctrlAdd = new Add();
  Delete ctrlDelete = new Delete();

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
        System.out.println(ctrlList.getAll());
        break;
      case "search":
        System.out.println(search());
        break;
      case "new":
        System.out.println(add());
        break;
      case "delete":
        System.out.println(delete());
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

  private String search() {
    System.out.println("");
    System.out.print("Enter the product id: ");
    int id = Integer.parseInt(s.nextLine());

    Product p = new Product();
    p.setId(id);
    ctrlSearch.getById(p);
    return p.toStringComplete();
  }

  private String add() {
    Product newProduct = new Product();

    System.out.println("");
    System.out.print("Enter the product name: ");
    newProduct.setName(s.nextLine());

    System.out.println("");
    System.out.print("Enter the product description: ");
    newProduct.setDescription(s.nextLine());

    System.out.println("");
    System.out.print("Enter the product price: ");
    newProduct.setPrice(Double.parseDouble(s.nextLine()));

    System.out.println("");
    System.out.print("Enter the product stock: ");
    newProduct.setStock(Integer.parseInt(s.nextLine()));

    System.out.println("");
    System.out.print("Is the shipping included? (true/false): ");
    newProduct.setShippingIncluded(Boolean.parseBoolean(s.nextLine()));

    ctrlAdd.add(newProduct);
    return newProduct.toStringComplete();
  }

  private String delete() {
    System.out.println("");
    System.out.print("Enter the product id: ");
    int id = Integer.parseInt(s.nextLine());

    Product p = new Product();
    p.setId(id);
    ctrlDelete.delete(p);

    System.out.println("");
    System.out.println("Product deleted successfully");
    return p.toStringComplete();
  }
}
