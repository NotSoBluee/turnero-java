import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorTurnos gestor = new GestorTurnos();

       while (true) {
    System.out.println("\n--- MENÚ DE TURNOS ---");
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
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("DNI: ");
            String dni = sc.nextLine();
            gestor.agregarPaciente(nombre, dni);
                }

        case 2 -> gestor.mostrarPacientes();

        case 3 -> {
            System.out.print("DNI del paciente: ");
            String dniTurno = sc.nextLine();
            System.out.print("Fecha del turno: ");
            String fecha = sc.nextLine();
            gestor.agendarTurno(dniTurno, fecha);
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

