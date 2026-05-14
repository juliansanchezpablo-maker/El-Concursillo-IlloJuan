import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Sorts;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class ranking extends JFrame {

    private JPanel contentPane;
    private JTextArea txtRanking;

    public ranking() {
        // Configuración básica de la ventana
        setTitle("Ranking de Jugadores");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(450, 500); 
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(30, 30, 100)); // Fondo azul oscuro
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // --- TÍTULO ---
        JLabel lblTitulo = new JLabel("TOP 10 JUGADORES");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setForeground(new Color(255, 215, 0)); // Dorado
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblTitulo.setBounds(50, 25, 330, 40);
        contentPane.add(lblTitulo);

        // --- ÁREA DE TEXTO (RANKING) ---
        txtRanking = new JTextArea();
        txtRanking.setEditable(false);
        txtRanking.setForeground(Color.WHITE);
        txtRanking.setBackground(new Color(21, 21, 70)); // Azul noche
        txtRanking.setFont(new Font("Monospaced", Font.BOLD, 14));
        txtRanking.setBorder(new LineBorder(new Color(255, 215, 0), 2));
        
        // Cargamos los datos reales al abrir la ventana
        cargarDatosEnTabla();

        JScrollPane scrollPane = new JScrollPane(txtRanking);
        scrollPane.setBounds(40, 80, 350, 300);
        scrollPane.setBorder(null);
        contentPane.add(scrollPane);

        // --- BOTÓN VOLVER ---
        JButton btnVolver = new JButton("VOLVER");
        btnVolver.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setBackground(new Color(255, 128, 128)); 
        btnVolver.setBounds(160, 400, 110, 40);

        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                MenuPrincipal menu = new MenuPrincipal();
                
               
                menu.setVisible(true);
                
             
                dispose();
            }
        });
        contentPane.add(btnVolver);
    }

    
    public void cargarDatosEnTabla() {
        List<Document> lista = obtenerTopRanking();
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        
        int puesto = 1;
        for (Document doc : lista) {
           
            String nombre = doc.getString("nombre");
            Object puntos = doc.get("puntos");
            
         
            if (nombre == null || nombre.trim().isEmpty()) {
                nombre = "Jugador";
            }
            
         
            if (puntos == null) {
                puntos = 0;
            }
            
          
            sb.append(String.format("  %2d. %-15s ...... %s€\n", puesto, nombre, puntos));
            puesto++;
        }
        
        if (lista.isEmpty()) {
            sb.append("   No hay puntuaciones registradas.");
        }
        
        txtRanking.setText(sb.toString());
    }

    /**
     * Guarda una nueva partida en la colección "Ranking"
     */
    public void guardarPuntuacion(String nombre, int puntos) {
        try {
            MongoCollection<Document> coleccion = ConexionMongoDB.getColeccion("Ranking");
            Document partida = new Document("nombre", nombre)
                                    .append("puntos", puntos)
                                    .append("fecha", new Date());
            coleccion.insertOne(partida);
            System.out.println("✅ Puntuación guardada correctamente.");
        } catch (Exception e) {
            System.err.println("❌ Error al guardar: " + e.getMessage());
        }
    }

    /**
     * Consulta el Top 10 
     */
    public List<Document> obtenerTopRanking() {
        List<Document> lista = new ArrayList<>();
        try {
            MongoCollection<Document> coleccion = ConexionMongoDB.getColeccion("Ranking");
            coleccion.find()
                     .sort(Sorts.descending("puntos"))
                     .limit(10) 
                     .into(lista);
        } catch (Exception e) {
            System.err.println("❌ Error al obtener el ranking: " + e.getMessage());
        }
        return lista;
    }


    public static void main(String[] args) {
        ranking frame = new ranking();
        frame.setVisible(true);
    }
}

