package ejercicio5a.entidades;

public class Administrativo extends Empleado {
  private int hrExtra;
  private int hrMes;

  public Administrativo() {
    this(59498765, "Maria", "Gomez", "maria.gomez@gmail.com", 45000, 10, 160);
  }

  public Administrativo(int dni, String nombre, String apellido, String email, float sueldoBase, int hrExtra,
      int hrMes) {
    super(dni, nombre, apellido, email, sueldoBase);
    this.hrExtra = hrExtra;
    this.hrMes = hrMes;
  }

  @Override
  public String toString() {
    return super.toString() + ", sueldo: " + this.getSueldo() + "]";
  }

  private int getHrExtra() {
    return hrExtra;
  }

  private int getHrMes() {
    return hrMes;
  }

  private int getSueldo() {
    return (int) (this.getSueldoBase() * ((this.getHrExtra() * 1.5f) + this.getHrMes()) / this.getHrMes());
  }
}
