package ejercicio6a.ui;

import java.util.Scanner;
import java.util.Set;

import ejercicio6a.entities.*;
import ejercicio6a.logic.*;

public class Menu {
  Scanner s = null;

  List ctrlList = new List();
  Search ctrlSearch = new Search();
  Add ctrlAdd = new Add();
  Delete ctrlDelete = new Delete();
  Update ctrlUpdate = new Update();

  public void start() {
    s = new Scanner(System.in);
    System.out.println("Welcome to the Java Market App");
    System.out.println();

    String command;
    do {
      command = getCommand();
      executeCommand(command);
      System.out.println();

    } while (!Set.of("exit", "e").contains(command.toLowerCase()));

    s.close();
  }

  private void executeCommand(String command) {
    switch (command) {
      case "list":
      case "l":
        System.out.println(ctrlList.getAll());
        break;
      case "search":
      case "s":
        System.out.println(this.search().toStringComplete());
        break;
      case "new":
      case "n":
        System.out.println(this.add().toStringComplete());
        break;
      case "delete":
      case "d":
        System.out.println(this.delete().toStringComplete());
        break;
      case "update":
      case "u":
        System.out.println(this.update().toStringComplete());
        break;
      default:
        break;
    }
  }

  private String getCommand() {
    System.out.println("Enter the command according to the option you want to perform");
    System.out.println("list\t(l)\t\tlist all products");
    System.out.println("search\t(s)\t\tsearch a product");
    System.out.println("new\t(n)\t\tcreate a new product");
    System.out.println("delete\t(d)\t\tdelete a product");
    System.out.println("update\t(u)\t\tupdate a product");
    System.out.println("exit\t(e)\t\texit the application");
    System.out.println();
    System.out.print("command: ");
    return s.nextLine();
  }

  private Product search() {
    System.out.println("");
    System.out.print("Enter the product id: ");
    int id = Integer.parseInt(s.nextLine());

    Product p = new Product();
    p.setId(id);
    ctrlSearch.getById(p);
    return p;
  }

  private Product add() {
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
    System.out.print("Is the shipping included? (y/n): ");
    String continueResponse = s.nextLine();
    newProduct.setShippingIncluded(Set.of("1", "y").contains(continueResponse.toLowerCase()));

    ctrlAdd.add(newProduct);
    return newProduct;
  }

  private Product delete() {
    System.out.println("");
    System.out.print("Enter the product id: ");
    int id = Integer.parseInt(s.nextLine());

    Product p = new Product();
    p.setId(id);
    ctrlDelete.delete(p);

    System.out.println("");
    System.out.println("Product deleted successfully");
    return p;
  }

  private Product update() {
    Product productToUpdate = this.search();

    if (productToUpdate == null) {
      System.out.println("");
      System.out.println("Product not found");
      return null;
    }

    System.out.println("");
    System.out.println("Current Product data:");
    System.out.println(productToUpdate.toStringComplete());

    if (this.wantToUpdate("name")) {
      System.out.println("");
      System.out.print("Enter the new product name(" + productToUpdate.getName() + "): ");
      productToUpdate.setName(s.nextLine());
    }

    if (this.wantToUpdate("description")) {
      System.out.println("");
      System.out.print("Enter the new product description(" + productToUpdate.getDescription() + "): ");
      productToUpdate.setDescription(s.nextLine());
    }

    if (this.wantToUpdate("price")) {
      System.out.println("");
      System.out.print("Enter the new product price(" + productToUpdate.getPrice() + "): ");
      productToUpdate.setPrice(Double.parseDouble(s.nextLine()));
    }

    if (this.wantToUpdate("stock")) {
      System.out.println("");
      System.out.print("Enter the new product stock(" + productToUpdate.getStock() + "): ");
      productToUpdate.setStock(Integer.parseInt(s.nextLine()));
    }

    if (this.wantToUpdate("shipping included")) {
      System.out.println("");
      System.out.print("Is the shipping included(" + (productToUpdate.isShippingIncluded() ? "y" : "n") + ")? (y/n): ");
      String continueResponse = s.nextLine();
      productToUpdate.setShippingIncluded(Set.of("1", "y").contains(continueResponse.toLowerCase()));
    }

    ctrlUpdate.update(productToUpdate);

    System.out.println("");
    System.out.println("Product updated successfully");
    return productToUpdate;
  }

  private boolean wantToUpdate(String field) {
    System.out.println("");
    System.out.print("Do you want to update the " + field + "? (y/n): ");
    String updateResponse = s.nextLine();
    return Set.of("1", "y").contains(updateResponse.toLowerCase());
  }
}
