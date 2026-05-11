import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PruebaBotones extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    
    // Botones de respuesta
    public JButton boton0, boton1, boton2, boton3;
    // Botones de comodines
    public JButton coModin1, Ruleta;
    
    // Array para agrupar los botones y facilitar el acceso por índice
    private JButton[] misBotones;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PruebaBotones frame = new PruebaBotones();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public PruebaBotones() {
        setTitle("Juego de Preguntas - Comodines");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // --- Inicialización de botones de respuesta ---
        boton0 = new JButton("Opción A");
        boton0.setBounds(70, 30, 120, 40);
        contentPane.add(boton0);

        boton1 = new JButton("Opción B");
        boton1.setBounds(240, 30, 120, 40);
        contentPane.add(boton1);

        boton2 = new JButton("Opción C");
        boton2.setBounds(70, 90, 120, 40);
        contentPane.add(boton2);

        boton3 = new JButton("Opción D");
        boton3.setBounds(240, 90, 120, 40);
        contentPane.add(boton3);

        // Guardamos los botones en el array (el orden es vital)
        misBotones = new JButton[]{boton0, boton1, boton2, boton3};

        // --- Botón Comodín 50:50 ---
        coModin1 = new JButton("50:50");
        coModin1.setBounds(240, 180, 100, 30);
        contentPane.add(coModin1);
        
        coModin1.addActionListener(e -> {
            gestionComodines.GestionComodines gc = new gestionComodines.GestionComodines();
            
            // Supongamos que la correcta es la 1 (Boton1)
            int correcta = 1; 
            int[] aBorrar = gc.usar50porCientoFinal(correcta);
            
            // Ocultamos los botones usando un bucle limpio
            for (int i = 0; i < aBorrar.length; i++) {
                int indice = aBorrar[i];
                misBotones[indice].setVisible(false);
            }
            coModin1.setEnabled(false);
        });

        // --- Botón Ruleta ---
        Ruleta = new JButton("Ruleta");
        Ruleta.setBounds(70, 180, 100, 30);
        contentPane.add(Ruleta);
        
        Ruleta.addActionListener(e -> {
            gestionComodines.GestionComodines gc = new gestionComodines.GestionComodines();
            
            int correcta = 0; 
            int[] borrar = gc.usarRuletaAleatoria(correcta);
            
            for (int i = 0; i < borrar.length; i++) {
                misBotones[borrar[i]].setVisible(false);
            }
            
            JOptionPane.showMessageDialog(null, "¡La ruleta ha eliminado " + borrar.length + " opciones!");
            Ruleta.setEnabled(false);
        });
    }
}