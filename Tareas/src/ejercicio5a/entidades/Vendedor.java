package ejercicio5a.entidades;

public class Vendedor extends Empleado {
  private int porcenComision;
  private int totalVentas;

  public Vendedor() {
    this(59498765, "Maria", "Gomez", "maria.gomez@gmail.com", 45000, 10, 160);
  }

  public Vendedor(int dni, String nombre, String apellido, String email, float sueldoBase, int porcenComision,
      int totalVentas) {
    super(dni, nombre, apellido, email, sueldoBase);
    this.porcenComision = porcenComision;
    this.totalVentas = totalVentas;
  }

  @Override
  public String toString() {
    return super.toString() + ", sueldo: " + this.getSueldo() + "]";
  }

  private int getPorcenComision() {
    return porcenComision;
  }

  private int getTotalVentas() {
    return totalVentas;
  }

  private int getSueldo() {
    return (int) (this.getSueldoBase() + (this.getPorcenComision() * this.getTotalVentas() / 100f));
  }
}
