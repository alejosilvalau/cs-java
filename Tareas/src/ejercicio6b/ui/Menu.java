package ejercicio6b.ui;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Set;

import ejercicio6b.entities.Product;
import ejercicio6b.logic.*;
import ejercicio6b.utils.DateUtils;

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

    newProduct.setShippingIncluded(this.confirmationStep("Is the shipping included?"));

    if (this.confirmationStep("Do you want to set a disabled on date?")) {
      newProduct.setDisabledOn(this.dateInput("Enter the product disabled on date"));
    }
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
    System.out.print("Current Product data:");
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
      productToUpdate.setShippingIncluded(
          this.confirmationStep("Is the shipping included?(" + productToUpdate.isShippingIncluded() + ")"));
    }

    if (this.wantToUpdate("disabeld on")) {
      productToUpdate
          .setDisabledOn(
              this.dateInput(
                  "Enter the new product disabled on date(" + productToUpdate.getDisabledOnFormatted() + ")"));
    }

    ctrlUpdate.update(productToUpdate);

    System.out.println("");
    System.out.println("Product updated successfully");
    return productToUpdate;
  }

  private boolean confirmationStep(String message) {
    System.out.println("");
    System.out.print(message + " (y/n): ");
    String updateResponse = s.nextLine();
    return Set.of("1", "y").contains(updateResponse.toLowerCase());
  }

  private boolean wantToUpdate(String field) {
    return confirmationStep("Do you want to update the " + field + "?");
  }

  private ZonedDateTime dateInput(String message) {
    System.out.println("");
    System.out.print(message + " (" + DateUtils.DATE_TIME_FORMAT + "): ");
    return ZonedDateTime.parse(s.nextLine(), DateUtils.DATE_TIME_FORMATTER);

  }
}
