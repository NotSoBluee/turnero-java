import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorTurnos gestor = new GestorTurnos();

       while (true) {
    System.out.println("\n--- MENÚ DE TURNOS --- PARA VOLVER ATRAS ESCRIBE CANCELAR ---");
    System.out.println("1. Agregar paciente");
    System.out.println("2. Ver pacientes");
    System.out.println("3. Agendar turno");
    System.out.println("4. Ver turnos");
    System.out.println("0. Salir");
    System.out.print("Opción: ");

    int op = sc.nextInt();
    sc.nextLine(); // Limpiar buffer

    switch (op) {
        case 1 -> {
                System.out.print("Nombre (o 'cancelar'): ");
                String nombre = sc.nextLine();
                if (nombre.equalsIgnoreCase("cancelar")) continue;

                System.out.print("DNI (o 'cancelar'): ");
                String dni = sc.nextLine();
                if (dni.equalsIgnoreCase("cancelar")) continue;

                System.out.print("¿Tiene obra social? (nombre o 'no'): ");
                String obraSocial = sc.nextLine();
                if (obraSocial.equalsIgnoreCase("cancelar")) continue;
                if (obraSocial.equalsIgnoreCase("no")) obraSocial = "Sin obra social";

                gestor.agregarPaciente(nombre, dni, obraSocial);

                }

        case 2 -> gestor.mostrarPacientes();

        case 3 -> {
            System.out.print("DNI del paciente (o 'cancelar'): ");
            String dniTurno = sc.nextLine();
            if (dniTurno.equalsIgnoreCase("cancelar")) continue;

            
            System.out.print("Fecha del turno (formato: dd/MM/yyyy, ej: 25/06/2025): ");
            String fecha = sc.nextLine();
            if (fecha.equalsIgnoreCase("cancelar")) continue;

            System.out.print("Hora del turno (formato: HH:mm, ej: 14:30): ");
            String hora = sc.nextLine();
            if (hora.equalsIgnoreCase("cancelar")) continue;

            gestor.agendarTurno(dniTurno, fecha, hora);
        }

        case 4 -> gestor.mostrarTurnos();

        case 0 -> {
            System.out.println("👋 Fin del programa.");
            sc.close(); // Cerramos el Scanner correctamente
            return; // Salimos del main
                }
        default -> System.out.println("❌ Opción inválida.");
   

            }
        }
    }
}  

