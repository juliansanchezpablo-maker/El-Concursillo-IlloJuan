import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Preguntas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    
 
    public JButton boton0, boton1, boton2, boton3;
    public JButton coModin1, Ruleta, Llamada, Comodin_chat;
    private JButton[] misBotones;
    private JLabel lblPregunta;


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
        setTitle("El Concursillo - Versión Final Comodines");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 450);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 240, 240));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

     
        lblPregunta = new JLabel("Pregunta actual: ");
        lblPregunta.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPregunta.setBounds(24, 10, 200, 25);
        contentPane.add(lblPregunta);

      
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

       
        coModin1 = new JButton("50:50");
        coModin1.setBackground(new Color(192, 192, 192));
        coModin1.setBounds(24, 40, 100, 40);
        contentPane.add(coModin1);
        coModin1.addActionListener(e -> {
            gestionComodines.GestionComodines gc = new gestionComodines.GestionComodines();
            int correcta = respuestasCorrectas[numeroDePreguntaActual];
            int[] aBorrar = gc.usar50porCientoFinal(correcta);
            for (int i : aBorrar) misBotones[i].setVisible(false);
            coModin1.setEnabled(false);
        });

       
        Ruleta = new JButton("Ruleta");
        Ruleta.setBackground(new Color(192, 192, 192));
        Ruleta.setBounds(134, 40, 100, 40);
        contentPane.add(Ruleta);
        Ruleta.addActionListener(e -> {
            gestionComodines.GestionComodines gc = new gestionComodines.GestionComodines();
            int correcta = respuestasCorrectas[numeroDePreguntaActual];
            int[] borrar = gc.usarRuletaAleatoria(correcta);
            for (int i : borrar) misBotones[i].setVisible(false);
            JOptionPane.showMessageDialog(null, "¡La ruleta ha eliminado " + borrar.length + " opciones!");
            Ruleta.setEnabled(false);
        });

    
        Llamada = new JButton("Llamada");
        Llamada.setBackground(new Color(192, 192, 192));
        Llamada.setBounds(244, 40, 100, 40);
        contentPane.add(Llamada);
        Llamada.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gestionComodines.GestionComodines gc = new gestionComodines.GestionComodines();
                int correcta = respuestasCorrectas[numeroDePreguntaActual];
                String consejo = gc.usarLlamada(correcta);
                JOptionPane.showMessageDialog(null, consejo, "Llamada a un amigo", JOptionPane.INFORMATION_MESSAGE);
                Llamada.setEnabled(false);
            }
        });

   
        Comodin_chat = new JButton("Chat");
        Comodin_chat.setBounds(354, 40, 100, 40); 
        Comodin_chat.setBackground(new Color(192, 192, 192));
        Comodin_chat.setForeground(new Color(0, 0, 0));
        contentPane.add(Comodin_chat);
        Comodin_chat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gestionComodines.GestionComodines gc = new gestionComodines.GestionComodines();
                int correcta = respuestasCorrectas[numeroDePreguntaActual];
                int[] votos = gc.usarChat(correcta);
                
                String msg = " Resultados del Chat:\n" +
                             "A: " + votos[0] + "%\n" +
                             "B: " + votos[1] + "%\n" +
                             "C: " + votos[2] + "%\n" +
                             "D: " + votos[3] + "%";
                
                JOptionPane.showMessageDialog(null, msg, "Comodín del Chat", JOptionPane.PLAIN_MESSAGE);
                Comodin_chat.setEnabled(false);
            }
        });

    
        JButton btnSiguiente = new JButton("Siguiente Pregunta");
        btnSiguiente.setBackground(new Color(144, 238, 144));
        btnSiguiente.setBounds(338, 370, 138, 33);
        contentPane.add(btnSiguiente);
        
        JButton btnVolverInicio = new JButton("VOLVER INICIO");
        btnVolverInicio.setBackground(new Color(255, 85, 85));
        btnVolverInicio.setBounds(10, 370, 138, 33);
        contentPane.add(btnVolverInicio);
        btnSiguiente.addActionListener(e -> {
            if (numeroDePreguntaActual < 14) {
                numeroDePreguntaActual++;
                lblPregunta.setText("Pregunta actual: " + (numeroDePreguntaActual + 1));
                for(JButton b : misBotones) b.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "¡Has llegado a la última pregunta!");
            }
        });
    }
}