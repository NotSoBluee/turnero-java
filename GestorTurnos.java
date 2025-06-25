import java.io.*;
import java.util.ArrayList;

public class GestorTurnos {
    public ArrayList<Paciente> pacientes = new ArrayList<>();
    public ArrayList<Turno> turnos = new ArrayList<>();

    private final String ARCHIVO_PACIENTES = "pacientes.txt";
    private final String ARCHIVO_TURNOS = "turnos.txt";

    public GestorTurnos() {
        cargarPacientes();
        cargarTurnos();
    }

public void agregarPaciente(String nombre, String dni, String obraSocial) {
    for (Paciente p : pacientes) {
        if (p.dni.equals(dni)) {
            System.out.println("⚠️ Ya existe un paciente con ese DNI.");
            return;
        }
    }

    Paciente nuevo = new Paciente(nombre, dni, obraSocial);
    pacientes.add(nuevo);
    guardarPaciente(nuevo);
    System.out.println("✅ Paciente agregado.");
}


    public void mostrarPacientes() {
        for (Paciente p : pacientes) {
            System.out.println(p);
        }
    }

public void agendarTurno(String dni, String fecha, String hora) {
    for (Paciente p : pacientes) {
        if (p.dni.equals(dni)) {
            // ⚠️ Verificamos si ya tiene un turno ese día y hora
            for (Turno t : turnos) {
                if (t.paciente.dni.equals(dni) && t.fecha.equals(fecha) && t.hora.equals(hora)) {
                    System.out.println("⚠️ Ese paciente ya tiene un turno en esa fecha y hora.");
                    return;
                }
            }

            Turno nuevo = new Turno(fecha, hora, p);
            turnos.add(nuevo);
            guardarTurno(nuevo);
            System.out.println("✅ Turno agendado.");
            return;
        }
    }
    System.out.println("❌ No se encontró paciente con ese DNI.");
}


    public void mostrarTurnos() {
        for (Turno t : turnos) {
            System.out.println(t);
        }
    }

    // ------------------ ARCHIVOS ------------------

 private void cargarPacientes() {
    try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_PACIENTES))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split("\\|");
            if (partes.length >= 2) {
                String nombre = partes[0];
                String dni = partes[1];
                String obraSocial = (partes.length >= 3) ? partes[2] : "Sin obra social";
                pacientes.add(new Paciente(nombre, dni, obraSocial));
            }
        }
        System.out.println("📂 Pacientes cargados desde archivo.");
    } catch (IOException e) {
        System.out.println("📁 No se encontró archivo de pacientes. Se creará uno nuevo.");
    }
}


   private void guardarPaciente(Paciente p) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_PACIENTES, true))) {
        bw.write(p.nombre + "|" + p.dni + "|" + p.obraSocial);
        bw.newLine();
    } catch (IOException e) {
        System.out.println("❌ Error al guardar paciente.");
    }
}


private void cargarTurnos() {
    try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_TURNOS))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split("\\|");
            if (partes.length == 3) {
                String dni = partes[0];
                String fecha = partes[1];
                String hora = partes[2];
                Paciente p = buscarPacientePorDNI(dni);
                if (p != null) {
                    turnos.add(new Turno(fecha, hora, p));
                }
            }
        }
        System.out.println("📂 Turnos cargados desde archivo.");
    } catch (IOException e) {
        System.out.println("📁 No se encontró archivo de turnos. Se creará uno nuevo.");
    }
}


    private void guardarTurno(Turno t) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_TURNOS, true))) {
            bw.write(t.paciente.dni + "|" + t.fecha);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("❌ Error al guardar turno.");
        }
    }

    private Paciente buscarPacientePorDNI(String dni) {
        for (Paciente p : pacientes) {
            if (p.dni.equals(dni)) return p;
        }
        return null;
    }
}
