import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Turno {
    public String fecha;
    public Paciente paciente;
    public String hora;

public Turno(String fecha, String hora, Paciente paciente) {
    this.fecha = fecha;
    this.hora = hora;
    this.paciente = paciente;
}
public LocalDateTime getFechaHora() {
    String fechaHoraStr = fecha + " " + hora;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    return LocalDateTime.parse(fechaHoraStr, formatter);
}

@Override
public String toString() {
    return "Turno para " + paciente.nombre + " (" + paciente.obraSocial + ")" +
           " el día " + fecha + " a las " + hora;
}
}