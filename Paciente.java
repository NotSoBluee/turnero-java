public class Paciente {
    public String nombre;
    public String dni;

    public Paciente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }
@Override
    public String toString() {
        return nombre + " (DNI: " + dni + ")";
    }
}
