public class Paciente {
    public String nombre;
    public String dni;
    public String obraSocial;

    public Paciente(String nombre, String dni, String obraSocial) {
        this.nombre = nombre;
        this.dni = dni;
        this.obraSocial = obraSocial;
    }
    public Paciente(String nombre, String dni) {
        this(nombre, dni, "No tiene obra social");
    }
@Override
public String toString() {
    return "Paciente: " + nombre + " | DNI: " + dni + " | Obra Social: " + obraSocial;
}
}