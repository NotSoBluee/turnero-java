import java.awt.*;
import javax.swing.*;

public class TurneroAppGUI {

    static GestorTurnos gestor = new GestorTurnos();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Turnero Alejo – v1.0");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 1));

        // Botón 1: Agregar paciente
        JButton btnAgregarPaciente = new JButton("Agregar Paciente");
        btnAgregarPaciente.addActionListener(e -> {
            JTextField nombreField = new JTextField();
            JTextField dniField = new JTextField();
            JTextField obraSocialField = new JTextField();

            Object[] mensaje = {
                "Nombre:", nombreField,
                "DNI:", dniField,
                "Obra Social (o 'no'):", obraSocialField
            };

            int opcion = JOptionPane.showConfirmDialog(frame, mensaje, "Nuevo paciente", JOptionPane.OK_CANCEL_OPTION);
            if (opcion == JOptionPane.OK_OPTION) {
                String nombre = nombreField.getText();
                String dni = dniField.getText();
                String obraSocial = obraSocialField.getText();
                if (obraSocial.equalsIgnoreCase("no")) obraSocial = "Sin obra social";
                gestor.agregarPaciente(nombre, dni, obraSocial);
            }
        });

        // Botón 2: Agendar turno
        JButton btnAgendarTurno = new JButton("Agendar Turno");
        btnAgendarTurno.addActionListener(e -> {
            JTextField dniField = new JTextField();
            JTextField fechaField = new JTextField();
            JTextField horaField = new JTextField();

            Object[] mensaje = {
                "DNI del paciente:", dniField,
                "Fecha del turno (dd/MM/yyyy):", fechaField,
                "Hora del turno (HH:mm):", horaField
            };

            int opcion = JOptionPane.showConfirmDialog(frame, mensaje, "Nuevo turno", JOptionPane.OK_CANCEL_OPTION);
            if (opcion == JOptionPane.OK_OPTION) {
                String dni = dniField.getText();
                String fecha = fechaField.getText();
                String hora = horaField.getText();
                gestor.agendarTurno(dni, fecha, hora);
            }
        });

        // Botón 3: Listar turnos
        JButton btnListarTurnos = new JButton("Listar Turnos");
        btnListarTurnos.addActionListener(e -> {
            StringBuilder lista = new StringBuilder();
            for (Turno t : gestor.turnos) {
                lista.append("📅 ").append(t).append("\n");
            }
            if (lista.length() == 0) lista.append("❌ No hay turnos cargados.");
            JTextArea area = new JTextArea(lista.toString());
            area.setEditable(false);
            JScrollPane scroll = new JScrollPane(area);
            scroll.setPreferredSize(new Dimension(350, 200));
            JOptionPane.showMessageDialog(frame, scroll, "Turnos", JOptionPane.INFORMATION_MESSAGE);
        });

        // Botón 4: Salir
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(e -> System.exit(0));

        // Agregar botones
        frame.add(btnAgregarPaciente);
        frame.add(btnAgendarTurno);
        frame.add(btnListarTurnos);
        frame.add(btnSalir);

        frame.setVisible(true);
    }
}
