import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaInicioSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel lblNewLabel;
	public JLabel lblNewLabel_1;
	public JTextField txtEscribeTuNombre;
	public JLabel lblNewLabel_2;
	public JCheckBox OpcionJuegoPredeterminado;
	public JButton btnNewButton;
	public JButton btnIniciarJuego;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public PantallaInicioSesion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 80));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("¿Cómo te llamas, concursante?");
		lblNewLabel.setBounds(161, 88, 466, 31);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Nombre del jugador");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(176, 147, 163, 19);
		contentPane.add(lblNewLabel_1);
		
		txtEscribeTuNombre = new JTextField();
		txtEscribeTuNombre.setForeground(new Color(180, 180, 180));
		txtEscribeTuNombre.setBackground(new Color(10, 10, 80));
		txtEscribeTuNombre.setText("  Escribe tu nombre...");
		txtEscribeTuNombre.setBounds(176, 167, 436, 31);
		contentPane.add(txtEscribeTuNombre);
		txtEscribeTuNombre.setColumns(10);
		txtEscribeTuNombre.setBorder(BorderFactory.createLineBorder(new Color(255, 215, 0), 2));
		
		lblNewLabel_2 = new JLabel("Seleccionar temática");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(176, 230, 163, 19);
		contentPane.add(lblNewLabel_2);
		
		OpcionJuegoPredeterminado = new JCheckBox("Juego Predeterminado");
		OpcionJuegoPredeterminado.setFont(new Font("Tahoma", Font.BOLD, 13));
		OpcionJuegoPredeterminado.setForeground(new Color(255, 255, 0));
		OpcionJuegoPredeterminado.setBackground(new Color(10, 10, 80));
		OpcionJuegoPredeterminado.setBounds(176, 259, 213, 37);
		contentPane.add(OpcionJuegoPredeterminado);
		OpcionJuegoPredeterminado.setBorder(new LineBorder(new Color(255, 215, 0), 8, true));
		
		btnNewButton = new JButton("VOLVER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(176, 347, 163, 42);
		contentPane.add(btnNewButton);
		
		
		
		btnIniciarJuego = new JButton("INICIAR JUEGO");
		btnIniciarJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIniciarJuego.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnIniciarJuego.setBackground(new Color(128, 128, 255));
		btnIniciarJuego.setBounds(449, 347, 163, 42);
		contentPane.add(btnIniciarJuego);
		btnIniciarJuego.setBorder(BorderFactory.createLineBorder(new Color(255, 215, 0), 2));

	}
}
