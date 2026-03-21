package ejercicio5a.entidades;

public abstract class Empleado {
  private int dni;
  private String nombre;
  private String apellido;
  private String email;
  private float sueldoBase;

  public Empleado() {
    this(43321456, "Juan", "Perez", "juan.perez@gmail.com", 50000);
  }

  public Empleado(int dni, String nombre, String apellido, String email, float sueldoBase) {
    this.dni = dni;
    this.nombre = nombre;
    this.apellido = apellido;
    this.email = email;
    this.sueldoBase = sueldoBase;
  }

  @Override
  public String toString() {
    return "Empleado [dni=" + this.getDni() + ", nombre=" + this.getNombre() + ", apellido=" + this.getApellido();
  }

  public int getDni() {
    return dni;
  }

  public String getNombre() {
    return nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public float getSueldoBase() {
    return sueldoBase;
  }

}
