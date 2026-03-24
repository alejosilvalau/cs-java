package ejercicio6b.entities;

import java.time.ZonedDateTime;

import ejercicio6b.utils.DateUtils;

public class Product {
  private int id;
  private String name;
  private String description;
  private double price;
  private int stock;
  private boolean shippingIncluded;
  private ZonedDateTime disabledOn;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  public boolean isShippingIncluded() {
    return shippingIncluded;
  }

  public void setShippingIncluded(boolean shippingIncluded) {
    this.shippingIncluded = shippingIncluded;
  }

  public ZonedDateTime getDisabledOn() {
    return disabledOn;
  }

  public String getDisabledOnFormatted() {
    return this.getDisabledOn() == null ? null : this.disabledOn.format(DateUtils.DATE_TIME_FORMATTER);
  }

  public void setDisabledOn(ZonedDateTime disabledOn) {
    this.disabledOn = disabledOn;
  }

  @Override
  public String toString() {
    return "\nProduct [id=" + this.getId() + ", name=" + this.getName() + ", price=" + this.getPrice()
        + ", disabledOn=" + this.getDisabledOnFormatted() + "]";
  }

  public String toStringComplete() {
    return "\nProduct [id=" + this.getId() + ", name=" + this.getName() + ", description=" + this.getDescription()
        + ", price=" + this.getPrice() + ", stock=" + this.getStock() + ", shippingIncluded="
        + this.isShippingIncluded() + ", disabledOn=" + this.getDisabledOnFormatted() + "]";
  }
}
