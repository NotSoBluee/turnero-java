public class Turno {
    public String fecha;
    public Paciente paciente;
    public String hora;

public Turno(String fecha, String hora, Paciente paciente) {
    this.fecha = fecha;
    this.hora = hora;
    this.paciente = paciente;
}

@Override
public String toString() {
    return "Turno para " + paciente.nombre + " el día " + fecha + " a las " + hora;
    }
}