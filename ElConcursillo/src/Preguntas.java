import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import java.util.List;
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
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class Preguntas extends JFrame {
	private int[] premios = {0, 100, 200, 300, 500, 1000, 1500, 2500, 5000, 10000, 20000, 64000, 125000, 250000, 500000, 1000000};
	private int dineroActual = 0;
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public JButton boton0, boton1, boton2, boton3;
    public JButton coModin1, Ruleta, Llamada, Comodin_chat;
    public JButton btnSiguiente; 
    private JButton[] misBotones;
    private JLabel lblPregunta;
    private JLabel lblNombreJugador;

    private int numeroDePreguntaActual = 0;

    
    private String[] preguntas = new String[15];
    private String[][] opciones = new String[15][4];
    private int[] respuestasCorrectas = new int[15];

    public JLabel lblNewLabel_1;
    public JTextArea areaDinero;
    public JTextArea textArea;

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
        setSize(800, 600);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(30, 30, 100));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Nombre del jugador
        String nombreDisplay = (gestionInicioSesion.nombre != null) ? gestionInicioSesion.nombre : "Jugador";
        lblNombreJugador = new JLabel("Concursante: " + nombreDisplay);
        lblNombreJugador.setForeground(Color.WHITE);
        lblNombreJugador.setBounds(40, 209, 294, 25);
        contentPane.add(lblNombreJugador);

        lblPregunta = new JLabel("Pregunta actual: 1");
        lblPregunta.setForeground(Color.YELLOW);
        lblPregunta.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPregunta.setBounds(33, 64, 200, 25);
        contentPane.add(lblPregunta);

        // --- BOTONES DE RESPUESTA ---
        boton0 = new JButton("Opción A");
        boton0.setForeground(new Color(255, 255, 255));
        boton0.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
        boton0.setBackground(new Color(0, 64, 128));
        boton0.setBounds(34, 267, 232, 62);
        boton0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comprobarRespuesta(0);
            }
        });
        contentPane.add(boton0);

        boton1 = new JButton("Opción B");
        boton1.setForeground(new Color(255, 255, 255));
        boton1.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
        boton1.setBackground(new Color(21, 21, 70));
        boton1.setBounds(299, 267, 238, 62);
        boton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comprobarRespuesta(1);
            }
        });
        contentPane.add(boton1);

        boton2 = new JButton("Opción C");
        boton2.setForeground(new Color(255, 255, 255));
        boton2.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
        boton2.setBackground(new Color(21, 21, 70));
        boton2.setBounds(34, 362, 232, 62);
        boton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comprobarRespuesta(2);
            }
        });
        contentPane.add(boton2);

        boton3 = new JButton("Opción D");
        boton3.setForeground(new Color(255, 255, 255));
        boton3.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
        boton3.setBackground(new Color(21, 21, 70));
        boton3.setBounds(299, 362, 238, 62);
        boton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comprobarRespuesta(3);
            }
        });
        contentPane.add(boton3);

        misBotones = new JButton[]{boton0, boton1, boton2, boton3};

        // --- COMODÍN 50:50 ---
        coModin1 = new JButton("50:50");
        coModin1.setForeground(new Color(255, 255, 255));
        coModin1.setBackground(new Color(30, 30, 100));
        coModin1.setFont(new Font("Tahoma", Font.BOLD, 12));
        coModin1.setBounds(34, 475, 100, 40);
        coModin1.setBorder(new LineBorder(new Color(255, 215, 0), 4, true));
        coModin1.addActionListener(e -> {
            GestionComodines gc = new GestionComodines();
            int[] borrar = gc.usar50porCientoFinal(respuestasCorrectas[numeroDePreguntaActual]);
            for (int i : borrar) misBotones[i].setVisible(false);
            coModin1.setEnabled(false);
        });
        contentPane.add(coModin1);

        // --- COMODÍN RULETA ---
        Ruleta = new JButton("Ruleta");
        Ruleta.setForeground(new Color(255, 255, 255));
        Ruleta.setBackground(new Color(30, 30, 100));
        Ruleta.setFont(new Font("Tahoma", Font.BOLD, 12));
        Ruleta.setBounds(166, 475, 100, 40);
        Ruleta.setBorder(new LineBorder(new Color(255, 215, 0), 4, true));
        Ruleta.addActionListener(e -> {
            GestionComodines gc = new GestionComodines();
            int[] borrar = gc.usarRuletaAleatoria(respuestasCorrectas[numeroDePreguntaActual]);
            for (int i : borrar) misBotones[i].setVisible(false);
            JOptionPane.showMessageDialog(null, "La ruleta ha eliminado opciones.");
            Ruleta.setEnabled(false);
        });
        contentPane.add(Ruleta);

        // --- COMODÍN LLAMADA ---
        Llamada = new JButton("Llamada");
        Llamada.setForeground(new Color(255, 255, 255));
        Llamada.setBackground(new Color(30, 30, 100));
        Llamada.setFont(new Font("Tahoma", Font.BOLD, 12));
        Llamada.setBounds(299, 475, 100, 40);
        Llamada.setBorder(new LineBorder(new Color(255, 215, 0), 4, true));
        Llamada.addActionListener(e -> {
            GestionComodines gc = new GestionComodines();
            String consejo = gc.usarLlamada(respuestasCorrectas[numeroDePreguntaActual]);
            JOptionPane.showMessageDialog(null, "Amigo: " + consejo);
            Llamada.setEnabled(false);
        });
        contentPane.add(Llamada);

        // --- COMODÍN CHAT ---
        Comodin_chat = new JButton("Chat");
        Comodin_chat.setForeground(new Color(255, 255, 255));
        Comodin_chat.setBackground(new Color(30, 30, 100));
        Comodin_chat.setFont(new Font("Tahoma", Font.BOLD, 12));
        Comodin_chat.setBounds(437, 475, 100, 40);
        Comodin_chat.setBorder(new LineBorder(new Color(255, 215, 0), 5, true));
        Comodin_chat.addActionListener(e -> {
            GestionComodines gc = new GestionComodines();
            int[] v = gc.usarChat(respuestasCorrectas[numeroDePreguntaActual]);
            String msg = "A: "+v[0]+"% | B: "+v[1]+"% | C: "+v[2]+"% | D: "+v[3]+"%";
            JOptionPane.showMessageDialog(null, "Resultados de la audiencia:\n" + msg);
            Comodin_chat.setEnabled(false);
        });
        contentPane.add(Comodin_chat);

        //BOTÓN SIGUIENTE  
        btnSiguiente = new JButton("->");
        btnSiguiente.setEnabled(false); 
        btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnSiguiente.setHorizontalAlignment(SwingConstants.LEFT);
        btnSiguiente.setBackground(new Color(0, 128, 0));
        btnSiguiente.setBounds(698, 479, 66, 33);
        btnSiguiente.addActionListener(e -> {
            if (numeroDePreguntaActual < 14) {
                numeroDePreguntaActual++;
                mostrarPregunta(numeroDePreguntaActual);
                btnSiguiente.setEnabled(false); 
                for (JButton b : misBotones) {
                    b.setVisible(true);
                    b.setBackground(new Color(21, 21, 70));
                    b.setEnabled(true); 
                }
            } else {
                JOptionPane.showMessageDialog(null, "¡Has completado todas las preguntas!");
            }
        });
        contentPane.add(btnSiguiente);

        // --- BOTÓN SALIR ---
        JButton btnVolver = new JButton("SALIR");
        btnVolver.setBackground(Color.RED);
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setBounds(687, 56, 77, 33);
        btnVolver.addActionListener(e -> {
            PantallaInicioSesion inicio = new PantallaInicioSesion();
            inicio.setVisible(true);
            dispose();
        });
        contentPane.add(btnVolver);
     // --- BOTÓN RETIRARSE  ---
        JButton btnRetirarse = new JButton("RETIRARSE");
        btnRetirarse.setForeground(new Color(255, 255, 255));
        btnRetirarse.setBackground(new Color(0, 0, 255)); 
        btnRetirarse.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnRetirarse.setBounds(534, 56, 136, 33);

        btnRetirarse.addActionListener(e -> {
       
            int preguntaReal = numeroDePreguntaActual + 1;

            if (preguntaReal == 6 || preguntaReal == 11) {
                int respuesta = JOptionPane.showConfirmDialog(null, 
                    "Estás en un punto de seguro. ¿Quieres plantarte con " + dineroActual + "€?", 
                    "Retirarse", JOptionPane.YES_NO_OPTION);
                
                if (respuesta == JOptionPane.YES_OPTION) {
                    finalizarJuego(dineroActual);
                }
            } else {
                JOptionPane.showMessageDialog(null, 
                    "Solo puedes retirarte al completar la pregunta 5 o la 10.");
            }
        });
        contentPane.add(btnRetirarse);
        
        // --- LABEL PREMIOS ---
        lblNewLabel_1 = new JLabel("PREMIOS");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblNewLabel_1.setForeground(new Color(255, 255, 0));
        lblNewLabel_1.setBounds(626, 97, 87, 53);
        contentPane.add(lblNewLabel_1);

        // --- ÁREA PREMIOS ---
        areaDinero = new JTextArea();
        areaDinero.setEditable(false);
        areaDinero.setText("\n\n\n" +
            " 15   > 1.000.000€ <\n" + 
            " 14     500.000€\n" +
            " 13     250.000€\n" +
            " 12     125.000€\n" +
            " 11     64.000€\n" +
            " 10   > 20.000€ <\n" + 
            "  9    10.000€\n" +
            "  8     5.000€\n" +
            "  7     2.500€\n" +
            "  6     1.500€\n" +
            "  5   > 1.000€ <\n" +   
            "  4     500€\n" +
            "  3     300€ \n" +
            "  2     200€ \n" +
            "  1     100€ \n");
        areaDinero.setForeground(Color.WHITE);
        areaDinero.setFont(new Font("Arial Black", Font.BOLD, 13));
        areaDinero.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
        areaDinero.setBackground(new Color(21, 21, 70));
        areaDinero.setBounds(570, 99, 193, 357);
        contentPane.add(areaDinero);

        // --- ÁREA PREGUNTA ---
        textArea = new JTextArea();
        textArea.setBackground(new Color(21, 21, 70));
        textArea.setBounds(34, 99, 503, 135);
        textArea.setBorder(new LineBorder(new Color(255, 215, 0), 4, true));
        textArea.setForeground(Color.WHITE);
        textArea.setFont(new Font("Tahoma", Font.BOLD, 14));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        contentPane.add(textArea);

        cargarPreguntasDeMongoDB("Cultura General");
        mostrarPregunta(0);
    }

    // ── CARGA PREGUNTAS DESDE MONGODB
    private void cargarPreguntasDeMongoDB(String tematica) {
        try {
            MongoCollection<Document> coleccion = ConexionMongoDB.getColeccion("Preguntas");

            MongoCursor<Document> cursor = coleccion
                .find(new Document("tematica", tematica))
                .sort(new Document("nivel", 1))
                .iterator();

            int i = 0;
            while (cursor.hasNext() && i < 15) {
                Document doc = cursor.next();

                preguntas[i] = doc.getString("pregunta");

                List<String> opts = (List<String>) doc.get("opciones");
                opciones[i][0] = opts.get(0);
                opciones[i][1] = opts.get(1);
                opciones[i][2] = opts.get(2);
                opciones[i][3] = opts.get(3);

                String correcta = doc.getString("respuesta_correcta");
                for (int j = 0; j < 4; j++) {
                    if (opts.get(j).equals(correcta)) {
                        respuestasCorrectas[i] = j;
                        break;
                    }
                }
                i++;
            }
            cursor.close();
            System.out.println("Preguntas cargadas desde MongoDB: " + i);

        } catch (Exception e) {
            System.out.println("Error al conectar con MongoDB: " + e.getMessage());
        }
    }

    // ── MUESTRA LA PREGUNTA EN PANTALLA 
    private void mostrarPregunta(int indice) {
        lblPregunta.setText("Pregunta actual: " + (indice + 1));
        textArea.setText(preguntas[indice]);
        boton0.setText("A:  " + opciones[indice][0]);
        boton1.setText("B:  " + opciones[indice][1]);
        boton2.setText("C:  " + opciones[indice][2]);
        boton3.setText("D:  " + opciones[indice][3]);
    }

    // ── COMPRUEBA SI LA RESPUESTA ES CORRECTA 
    private void comprobarRespuesta(int botonPulsado) {
        if (botonPulsado == respuestasCorrectas[numeroDePreguntaActual]) {
            // --- ACIERTO ---
            misBotones[botonPulsado].setBackground(new Color(0, 150, 0));
            dineroActual = premios[numeroDePreguntaActual + 1]; 
            
           
            btnSiguiente.setEnabled(true);
            
          
            for(JButton b : misBotones) b.setEnabled(false);

            JOptionPane.showMessageDialog(null, "¡Correcto! Llevas acumulados: " + dineroActual + "€");
            
            if (numeroDePreguntaActual == 14) {
                finalizarJuego(dineroActual);
            }
        } else {
            // --- FALLO ---
            misBotones[botonPulsado].setBackground(Color.RED);
            misBotones[respuestasCorrectas[numeroDePreguntaActual]].setBackground(new Color(0, 150, 0));
            
          
            int dineroConsolacion = 0;
            if (numeroDePreguntaActual >= 10) {
                dineroConsolacion = 20000;
            } else if (numeroDePreguntaActual >= 5) {
                dineroConsolacion = 1000;
            }
            
            JOptionPane.showMessageDialog(null, "❌ Incorrecto. Te vas con el premio garantizado de: " + dineroConsolacion + "€");
            finalizarJuego(dineroConsolacion);
        }
    }
    private void finalizarJuego(int dineroFinal) {
     
        String nombre = (gestionInicioSesion.nombre != null) ? gestionInicioSesion.nombre : "Jugador Anónimo";
        guardarEnRanking(nombre, dineroFinal);
        
      
        ranking ventanaRanking = new ranking();
        ventanaRanking.setVisible(true);
        
       
        dispose();
    }
    
    private void guardarEnRanking(String nombre, int puntos) {
        try {
            MongoCollection<Document> coleccion = ConexionMongoDB.getColeccion("Ranking");
            

            Document record = new Document("nombre", nombre) 
                                    .append("puntos", puntos)
                                    .append("fecha", new java.util.Date());
            
            coleccion.insertOne(record);
            System.out.println("Ranking actualizado en MongoDB para: " + nombre);
        } catch (Exception e) {
            System.out.println("Error al guardar en ranking: " + e.getMessage());
        }
    }
    
}