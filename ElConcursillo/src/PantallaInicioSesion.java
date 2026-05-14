import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class PantallaInicioSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel lblTitulo;
	public JLabel lblNombreTag;
	public JTextField txtNombreJugador;
	public JLabel lblTematica;
	public JCheckBox chkPredeterminado;
	public JButton btnVolver;
	public JButton btnIniciarJuego;
	public JButton btnRegistrar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaInicioSesion frame = new PantallaInicioSesion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PantallaInicioSesion() {
		setTitle("Acceso al Juego");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null); 
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 80));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// --- TÍTULO ---
		lblTitulo = new JLabel("¿Cómo te llamas, concursante?");
		lblTitulo.setBounds(161, 88, 466, 31);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.YELLOW);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 28));
		contentPane.add(lblTitulo);

		// --- ETIQUETA NOMBRE ---
		lblNombreTag = new JLabel("Nombre del jugador");
		lblNombreTag.setForeground(Color.WHITE);
		lblNombreTag.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNombreTag.setBounds(176, 147, 163, 19);
		contentPane.add(lblNombreTag);

		// --- CAMPO DE TEXTO ---
		txtNombreJugador = new JTextField();
		txtNombreJugador.setForeground(Color.WHITE);
		txtNombreJugador.setBackground(new Color(10, 10, 80));
		txtNombreJugador.setBounds(176, 167, 359, 31);
		txtNombreJugador.setColumns(10);
		txtNombreJugador.setBorder(BorderFactory.createLineBorder(new Color(255, 215, 0), 2));
		contentPane.add(txtNombreJugador);

		// --- BOTÓN REGISTRAR ---
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegistrar.setBorder(BorderFactory.createLineBorder(new Color(255, 215, 0), 2));
		btnRegistrar.setBackground(new Color(70, 130, 180));
		btnRegistrar.setBounds(545, 161, 130, 42);
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				gestionInicioSesion.nombre = txtNombreJugador.getText().trim();
				gestionInicioSesion.esPredeterminado = chkPredeterminado.isSelected();
				JOptionPane.showMessageDialog(null, "Datos de registro actualizados.");
			}
		});
		contentPane.add(btnRegistrar);

		// --- SELECCIÓN TEMÁTICA ---
		lblTematica = new JLabel("Seleccionar temática");
		lblTematica.setForeground(Color.WHITE);
		lblTematica.setFont(new Font("Arial", Font.PLAIN, 13));
		lblTematica.setBounds(176, 230, 163, 19);
		contentPane.add(lblTematica);

		chkPredeterminado = new JCheckBox("Juego Predeterminado");
		chkPredeterminado.setFont(new Font("Tahoma", Font.BOLD, 13));
		chkPredeterminado.setForeground(Color.YELLOW);
		chkPredeterminado.setBackground(new Color(10, 10, 80));
		chkPredeterminado.setBounds(176, 259, 213, 37);
		chkPredeterminado.setBorder(new LineBorder(new Color(255, 215, 0), 2, true));
		contentPane.add(chkPredeterminado);

		// --- BOTÓN VOLVER ---
		btnVolver = new JButton("VOLVER");
		btnVolver.setBackground(new Color(255, 0, 0));
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVolver.setBounds(176, 347, 163, 42);
		btnVolver.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        MenuPrincipal ventanaMenu = new MenuPrincipal();
		        ventanaMenu.setVisible(true);
		        dispose();
		    }
		});
		contentPane.add(btnVolver);

		// --- BOTÓN INICIAR JUEGO ---
		btnIniciarJuego = new JButton("INICIAR JUEGO");
		btnIniciarJuego.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnIniciarJuego.setBackground(new Color(128, 128, 255));
		btnIniciarJuego.setForeground(Color.WHITE);
		btnIniciarJuego.setBounds(449, 347, 163, 42);
		btnIniciarJuego.setBorder(BorderFactory.createLineBorder(new Color(255, 215, 0), 2));
		
		btnIniciarJuego.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		     
		        gestionInicioSesion.nombre = txtNombreJugador.getText().trim();

		        if (!chkPredeterminado.isSelected()) {
		            JOptionPane.showMessageDialog(null, "¡Atención! Marca el tipo de juego que deseas");
		        } 
		        else if (gestionInicioSesion.nombre.isEmpty()) {
		          
		            JOptionPane.showMessageDialog(null, "Por favor, introduce tu nombre para continuar.");
		        } 
		        else {
		           
		            Preguntas ventanaPreguntas = new Preguntas();
		            ventanaPreguntas.setVisible(true);
		            dispose();
		        }
		    }
		});
		contentPane.add(btnIniciarJuego);

	}
}