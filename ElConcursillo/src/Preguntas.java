import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Preguntas extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    
    public JButton boton0, boton1, boton2, boton3;
    public JButton coModin1, Ruleta, Llamada, Comodin_chat;
    private JButton[] misBotones;
    private JLabel lblPregunta;
    private JLabel lblNombreJugador;

    private int numeroDePreguntaActual = 0; 
    private List<Pregunta> todasLasPreguntas;
    private List<Pregunta> preguntasPartida; // Las 15 seleccionadas para jugar

    public JTextArea areaDinero;
    public JTextArea textArea;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Preguntas frame = new Preguntas();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Preguntas() {
        setTitle("El Concursillo - Panel de Juego");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); 
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(30, 30, 100)); 
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // ... (Tus JLabels de Nombre y Número de Pregunta)
        lblNombreJugador = new JLabel("Concursante: " + (gestionInicioSesion.nombre != null ? gestionInicioSesion.nombre : "Jugador"));
        lblNombreJugador.setForeground(Color.WHITE);
        lblNombreJugador.setBounds(43, 64, 301, 25);
        contentPane.add(lblNombreJugador);

        lblPregunta = new JLabel("Pregunta actual: 1");
        lblPregunta.setForeground(Color.YELLOW);
        lblPregunta.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPregunta.setBounds(33, 34, 200, 25);
        contentPane.add(lblPregunta);

        // --- BOTONES DE RESPUESTA ---
        boton0 = crearBotonRespuesta(34, 267);
        boton1 = crearBotonRespuesta(299, 267);
        boton2 = crearBotonRespuesta(34, 362);
        boton3 = crearBotonRespuesta(299, 362);
        misBotones = new JButton[]{boton0, boton1, boton2, boton3};

        // --- LÓGICA DE COMPROBACIÓN ---
        for (int i = 0; i < 4; i++) {
            final int index = i;
            misBotones[i].addActionListener(e -> comprobarRespuesta(index));
        }

        // --- ÁREA DE TEXTO PREGUNTA ---
        textArea = new JTextArea();
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setBackground(new Color(21, 21, 70));
        textArea.setForeground(Color.WHITE);
        textArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textArea.setBounds(34, 99, 503, 135);
        textArea.setBorder(new LineBorder(new Color(255, 215, 0), 4, true));
        contentPane.add(textArea);

        // ... (Tus comodines y área de dinero igual que antes)
        
        cargarYPrepararPreguntas();
    }

    private JButton crearBotonRespuesta(int x, int y) {
        JButton btn = new JButton();
        btn.setForeground(Color.WHITE);
        btn.setBackground(new Color(21, 21, 70));
        btn.setBorder(new LineBorder(Color.WHITE, 3, true));
        btn.setBounds(x, y, 232, 62);
        contentPane.add(btn);
        return btn;
    }

    private void cargarYPrepararPreguntas() {
        try {
            Gson gson = new Gson();
            InputStream is = getClass().getResourceAsStream("/resource/Preguntas.json");
            InputStreamReader reader = new InputStreamReader(is);
            todasLasPreguntas = gson.fromJson(reader, new TypeToken<List<Pregunta>>(){}.getType());

            // --- AUMENTO DE DIFICULTAD ---
           
            Collections.sort(todasLasPreguntas, Comparator.comparingInt(Pregunta::getDificultad));
            
           
            preguntasPartida = todasLasPreguntas.subList(0, Math.min(15, todasLasPreguntas.size()));

            actualizarPreguntaEnPantalla();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error cargando preguntas: " + e.getMessage());
        }
    }

    private void actualizarPreguntaEnPantalla() {
        if (numeroDePreguntaActual < preguntasPartida.size()) {
            Pregunta p = preguntasPartida.get(numeroDePreguntaActual);
            textArea.setText(p.getEnunciado());
            boton0.setText("A: " + p.getO1());
            boton1.setText("B: " + p.getO2());
            boton2.setText("C: " + p.getO3());
            boton3.setText("D: " + p.getO4());
            
            lblPregunta.setText("Pregunta actual: " + (numeroDePreguntaActual + 1));
            for(JButton b : misBotones) {
                b.setVisible(true);
                b.setBackground(new Color(21, 21, 70));
            }
        }
    }

    private void comprobarRespuesta(int indiceElegido) {
        Pregunta p = preguntasPartida.get(numeroDePreguntaActual);
        if (indiceElegido == p.getCorrecta()) {
            JOptionPane.showMessageDialog(this, "¡CORRECTO!");
            numeroDePreguntaActual++;
            if (numeroDePreguntaActual < 15) {
                actualizarPreguntaEnPantalla();
            } else {
                JOptionPane.showMessageDialog(this, "¡HAS GANADO EL MILLÓN!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Respuesta incorrecta. Fin del juego.");
            dispose();
        }
    }
}