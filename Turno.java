public class Turno {
    public String fecha;
    public Paciente paciente;

    public Turno(String fecha, Paciente paciente) {
        this.fecha = fecha;
        this.paciente = paciente;
    }
@Override
    public String toString() {
        return "Turno para " + paciente.nombre + " el día " + fecha;
    }
}
