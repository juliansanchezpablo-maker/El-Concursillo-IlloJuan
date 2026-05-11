import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import gestionComodines.GestionComodines;

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel lblNewLabel;
	public JLabel lblNewLabel_1;
	public JButton btnVerRanking;
	public JButton btnSalir;
	public JButton btnComoJugar;
	public JButton btnIniciarPartida;
	public JButton pruebaBoton;
	public JLabel lblFondo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 656, 356);
	    setSize(800, 600);
	    
	    
	    
	    contentPane = new JPanel();
	    contentPane.setLayout(null);
	    setContentPane(contentPane);
	    setVisible(true);
	
		
		lblNewLabel = new JLabel("EL CONCURSILLO");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 41));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(164, 92, 435, 54);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("¿Quién quiere ser millonario?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(256, 156, 236, 20);
		contentPane.add(lblNewLabel_1);
		
		btnVerRanking = new JButton("Ver Ranking");
		btnVerRanking.setForeground(new Color(255, 255, 255));
		btnVerRanking.setBorder(BorderFactory.createLineBorder(new Color(255, 215, 0), 2));
		btnVerRanking.setBackground(new Color(0, 0, 128));
		btnVerRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVerRanking.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnVerRanking.setBounds(256, 295, 250, 46);
		contentPane.add(btnVerRanking);
		
		btnSalir = new JButton("Salir");
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setBorder(BorderFactory.createLineBorder(new Color(255, 215, 0), 2));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalir.setBackground(new Color(255, 0, 0));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSalir.setBounds(256, 428, 250, 46);
		contentPane.add(btnSalir);
		
		btnComoJugar = new JButton("Cómo Jugar");
		btnComoJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ComoJugar ventanaComoJugar = new ComoJugar();
			ventanaComoJugar.setVisible(true);
			dispose();
			}
		});
		btnComoJugar.setForeground(Color.WHITE);
		btnComoJugar.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnComoJugar.setBorder(BorderFactory.createLineBorder(new Color(255, 215, 0), 2));
		btnComoJugar.setBackground(new Color(0, 0, 128));
		btnComoJugar.setBounds(256, 360, 250, 46);
		contentPane.add(btnComoJugar);
		
		btnIniciarPartida = new JButton("Iniciar Partida");
		btnIniciarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIniciarPartida.setForeground(new Color(255, 255, 255));
		btnIniciarPartida.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnIniciarPartida.setBorder(BorderFactory.createLineBorder(new Color(255, 215, 0), 2));
		btnIniciarPartida.setBackground(new Color(0, 0, 128));
		btnIniciarPartida.setBounds(256, 229, 250, 46);
		contentPane.add(btnIniciarPartida);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/resource/FondoQQSM2.jpg")));
		lblFondo.setBounds(0, 0, 786, 563);
		contentPane.add(lblFondo);
		
	}
}
