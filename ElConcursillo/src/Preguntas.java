import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Preguntas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    
    public JButton boton0, boton1, boton2, boton3;
    public JButton coModin1, Ruleta, Llamada, Comodin_chat;
    private JButton[] misBotones;
    private JLabel lblPregunta;
    private JLabel lblNombreJugador;

    private int numeroDePreguntaActual = 0; 
    private int[] respuestasCorrectas = {1, 0, 3, 2, 1, 0, 0, 1, 2, 3, 1, 2, 0, 3, 1};

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Preguntas frame = new Preguntas();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Preguntas() {
        setTitle("El Concursillo - Panel de Juego");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 450);
        setLocationRelativeTo(null); 
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(30, 30, 100)); 
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Nombre del Jugador
        String nombreDisplay = (gestionInicioSesion.nombre != null) ? gestionInicioSesion.nombre : "Jugador";
        lblNombreJugador = new JLabel("Concursante: " + nombreDisplay);
        lblNombreJugador.setForeground(Color.WHITE);
        lblNombreJugador.setBounds(24, 10, 300, 25);
        contentPane.add(lblNombreJugador);

        lblPregunta = new JLabel("Pregunta actual: " + (numeroDePreguntaActual + 1));
        lblPregunta.setForeground(Color.YELLOW);
        lblPregunta.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPregunta.setBounds(24, 100, 200, 25);
        contentPane.add(lblPregunta);

        // --- BOTONES DE RESPUESTA ---
        boton0 = new JButton("Opción A");
        boton0.setBounds(24, 223, 200, 40);
        contentPane.add(boton0);

        boton1 = new JButton("Opción B");
        boton1.setBounds(244, 223, 206, 40);
        contentPane.add(boton1);

        boton2 = new JButton("Opción C");
        boton2.setBounds(24, 273, 200, 40);
        contentPane.add(boton2);

        boton3 = new JButton("Opción D");
        boton3.setBounds(244, 273, 206, 40);
        contentPane.add(boton3);

        misBotones = new JButton[]{boton0, boton1, boton2, boton3};

        // --- LOS 4 COMODINES ---

        // 1. COMODÍN 50:50
        coModin1 = new JButton("50:50");
        coModin1.setBounds(24, 40, 100, 40);
        coModin1.addActionListener(e -> {
            GestionComodines gc = new GestionComodines();
            int[] borrar = gc.usar50porCientoFinal(respuestasCorrectas[numeroDePreguntaActual]);
            for (int i : borrar) misBotones[i].setVisible(false);
            coModin1.setEnabled(false);
        });
        contentPane.add(coModin1);

        // 2. COMODÍN RULETA
        Ruleta = new JButton("Ruleta");
        Ruleta.setBounds(134, 40, 100, 40);
        Ruleta.addActionListener(e -> {
            GestionComodines gc = new GestionComodines();
            int[] borrar = gc.usarRuletaAleatoria(respuestasCorrectas[numeroDePreguntaActual]);
            for (int i : borrar) misBotones[i].setVisible(false);
            JOptionPane.showMessageDialog(null, "La ruleta ha eliminado opciones.");
            Ruleta.setEnabled(false);
        });
        contentPane.add(Ruleta);

        // 3. COMODÍN LLAMADA
        Llamada = new JButton("Llamada");
        Llamada.setBounds(244, 40, 100, 40);
        Llamada.addActionListener(e -> {
            GestionComodines gc = new GestionComodines();
            String consejo = gc.usarLlamada(respuestasCorrectas[numeroDePreguntaActual]);
            JOptionPane.showMessageDialog(null, "Amigo: " + consejo);
            Llamada.setEnabled(false);
        });
        contentPane.add(Llamada);

        // 4. COMODÍN CHAT
        Comodin_chat = new JButton("Chat");
        Comodin_chat.setBounds(354, 40, 100, 40);
        Comodin_chat.addActionListener(e -> {
            GestionComodines gc = new GestionComodines();
            int[] v = gc.usarChat(respuestasCorrectas[numeroDePreguntaActual]);
            String msg = "A: "+v[0]+"% | B: "+v[1]+"% | C: "+v[2]+"% | D: "+v[3]+"%";
            JOptionPane.showMessageDialog(null, "Resultados de la audiencia:\n" + msg);
            Comodin_chat.setEnabled(false);
        });
        contentPane.add(Comodin_chat);

        // --- NAVEGACIÓN ---
        JButton btnSiguiente = new JButton("SIGUIENTE");
        btnSiguiente.setBackground(Color.GREEN);
        btnSiguiente.setBounds(338, 370, 138, 33);
        btnSiguiente.addActionListener(e -> {
            if (numeroDePreguntaActual < 14) {
                numeroDePreguntaActual++;
                lblPregunta.setText("Pregunta actual: " + (numeroDePreguntaActual + 1));
                for(JButton b : misBotones) b.setVisible(true);
            }
        });
        contentPane.add(btnSiguiente);

        JButton btnVolver = new JButton("VOLVER");
        btnVolver.setBackground(Color.RED);
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setBounds(10, 370, 138, 33);
        btnVolver.addActionListener(e -> {
            PantallaInicioSesion inicio = new PantallaInicioSesion();
            inicio.setVisible(true);
            dispose();
        });
        contentPane.add(btnVolver);
    }
}