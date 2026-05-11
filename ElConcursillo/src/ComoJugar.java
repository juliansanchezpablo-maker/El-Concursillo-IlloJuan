import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.JScrollBar;

public class ComoJugar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel lblNewLabel;
	public JLabel lblNewLabel_2;
	public JLabel lblNewLabel_3;
	public JButton btnIniciarPartida;
	public JTextField txtIntroduceTuNombre;
	public JButton btnIniciarPartida_1;
	public JTextField textField;
	public JButton btnIniciarPartida_2;
	public JTextField txtSiFallasPierdes;
	public JButton btnIniciarPartida_3;
	public JTextField txtPuedesPlantarteEn;
	public JLabel lblTusComodines;
	public JTextField txtEliminaDosRespuestas;
	public JTextField txtLlamasAUn;
	public JTextField txtCambiaLaPregunta;
	public JTextField txtGirasLaRuleta;
	public JLabel lblTusComodines_1;
	public JLabel lblTusComodines_2;
	public JLabel lblTusComodines_3;
	public JLabel lblTusComodines_4;
	public JLabel lblPremios;
	public JButton btnIniciarPartida_4;
	public JLabel lblTusComodines_5;
	public JLabel lblNewLabel_4;
	public JLabel lblNewLabel_5;
	public JTextField txtPreguntas;
	public JLabel lblTusComodines_6;
	public JTextField txtPreguntas_1;
	public JLabel lblTusComodines_7;
	public JTextField txtPreguntas_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComoJugar frame = new ComoJugar();
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
	public ComoJugar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 80));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("¿Cómo Jugar?");
		lblNewLabel.setBounds(201, 56, 360, 50);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		contentPane.add(lblNewLabel);
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(575, 35, 0, 0);
	    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    scroll.setBorder(null);
	    getContentPane().add(scroll);
	    
	    lblNewLabel_2 = new JLabel("Cómo Jugar");
	    lblNewLabel_2.setForeground(new Color(255, 255, 255));
	    lblNewLabel_2.setBackground(new Color(255, 255, 255));
	    lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
	    lblNewLabel_2.setBounds(630, 23, 281, 37);
	    contentPane.add(lblNewLabel_2);
	    
	    lblNewLabel_3 = new JLabel("EL CONCURSILLO");
	    lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_3.setForeground(Color.YELLOW);
	    lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 25));
	    lblNewLabel_3.setBounds(-57, 14, 360, 50);
	    contentPane.add(lblNewLabel_3);
	    
	    btnIniciarPartida = new JButton("1");
	    btnIniciarPartida.setForeground(new Color(0, 64, 64));
	    btnIniciarPartida.setFont(new Font("Tahoma", Font.BOLD, 12));
	    btnIniciarPartida.setBorder(BorderFactory.createLineBorder(new Color(255, 215, 0), 2));
	    btnIniciarPartida.setBackground(new Color(240, 222, 0));
	    btnIniciarPartida.setBounds(38, 105, 28, 25);
	    contentPane.add(btnIniciarPartida);
	    
	    txtIntroduceTuNombre = new JTextField();
	    txtIntroduceTuNombre.setForeground(new Color(255, 255, 255));
	    txtIntroduceTuNombre.setBackground(new Color(128, 0, 255));
	    txtIntroduceTuNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
	    txtIntroduceTuNombre.setText("Introduce tu nombre y selecciona la tematica que desees.");
	    txtIntroduceTuNombre.setBounds(76, 105, 670, 25);
	    contentPane.add(txtIntroduceTuNombre);
	    txtIntroduceTuNombre.setColumns(10);
	    
	    btnIniciarPartida_1 = new JButton("2");
	    btnIniciarPartida_1.setForeground(new Color(0, 64, 64));
	    btnIniciarPartida_1.setFont(new Font("Tahoma", Font.BOLD, 12));
	    btnIniciarPartida_1.setBorder(BorderFactory.createLineBorder(new Color(255, 215, 0), 2));
	    btnIniciarPartida_1.setBackground(new Color(240, 222, 0));
	    btnIniciarPartida_1.setBounds(38, 138, 28, 25);
	    contentPane.add(btnIniciarPartida_1);
	    
	    textField = new JTextField();
	    textField.setText("Introduce tu nombre y selecciona la tematica que desees.");
	    textField.setForeground(Color.WHITE);
	    textField.setFont(new Font("Tahoma", Font.BOLD, 13));
	    textField.setColumns(10);
	    textField.setBackground(new Color(128, 0, 255));
	    textField.setBounds(76, 138, 670, 25);
	    contentPane.add(textField);
	    
	    btnIniciarPartida_2 = new JButton("3");
	    btnIniciarPartida_2.setForeground(new Color(0, 64, 64));
	    btnIniciarPartida_2.setFont(new Font("Tahoma", Font.BOLD, 12));
	    btnIniciarPartida_2.setBorder(BorderFactory.createLineBorder(new Color(255, 215, 0), 2));
	    btnIniciarPartida_2.setBackground(new Color(240, 222, 0));
	    btnIniciarPartida_2.setBounds(38, 173, 28, 25);
	    contentPane.add(btnIniciarPartida_2);
	    
	    txtSiFallasPierdes = new JTextField();
	    txtSiFallasPierdes.setText("Si fallas pierdes todo, salvo que hayas superado un premio garantizado (preguntas 5 y 10).");
	    txtSiFallasPierdes.setForeground(Color.WHITE);
	    txtSiFallasPierdes.setFont(new Font("Tahoma", Font.BOLD, 13));
	    txtSiFallasPierdes.setColumns(10);
	    txtSiFallasPierdes.setBackground(new Color(128, 0, 255));
	    txtSiFallasPierdes.setBounds(76, 172, 670, 25);
	    contentPane.add(txtSiFallasPierdes);
	    
	    btnIniciarPartida_3 = new JButton("4");
	    btnIniciarPartida_3.setForeground(new Color(0, 64, 64));
	    btnIniciarPartida_3.setFont(new Font("Tahoma", Font.BOLD, 12));
	    btnIniciarPartida_3.setBorder(BorderFactory.createLineBorder(new Color(255, 215, 0), 2));
	    btnIniciarPartida_3.setBackground(new Color(240, 222, 0));
	    btnIniciarPartida_3.setBounds(38, 207, 28, 25);
	    contentPane.add(btnIniciarPartida_3);
	    
	    txtPuedesPlantarteEn = new JTextField();
	    txtPuedesPlantarteEn.setText("Puedes plantarte en cualquier momento y llevarte el dinero acumulado hasta ese instante.");
	    txtPuedesPlantarteEn.setForeground(Color.WHITE);
	    txtPuedesPlantarteEn.setFont(new Font("Tahoma", Font.BOLD, 13));
	    txtPuedesPlantarteEn.setColumns(10);
	    txtPuedesPlantarteEn.setBackground(new Color(128, 0, 255));
	    txtPuedesPlantarteEn.setBounds(76, 207, 670, 25);
	    contentPane.add(txtPuedesPlantarteEn);
	    
	    lblTusComodines = new JLabel("TUS COMODINES");
	    lblTusComodines.setHorizontalAlignment(SwingConstants.CENTER);
	    lblTusComodines.setForeground(Color.YELLOW);
	    lblTusComodines.setFont(new Font("Tahoma", Font.BOLD, 14));
	    lblTusComodines.setBounds(-83, 242, 360, 50);
	    contentPane.add(lblTusComodines);
	    
	    txtEliminaDosRespuestas = new JTextField();
	    txtEliminaDosRespuestas.setForeground(new Color(255, 255, 255));
	    txtEliminaDosRespuestas.setFont(new Font("Tahoma", Font.BOLD, 10));
	    txtEliminaDosRespuestas.setText("Elimina dos respuestas incorrectas. Te quedan solo 2 opciones.");
	    txtEliminaDosRespuestas.setBackground(new Color(64, 0, 128));
	    txtEliminaDosRespuestas.setBounds(38, 304, 333, 37);
	    contentPane.add(txtEliminaDosRespuestas);
	    txtEliminaDosRespuestas.setColumns(10);
	    
	    txtLlamasAUn = new JTextField();
	    txtLlamasAUn.setForeground(new Color(255, 255, 255));
	    txtLlamasAUn.setFont(new Font("Tahoma", Font.BOLD, 10));
	    txtLlamasAUn.setText("Llamas a un amigo. Tienes 30 segundos para obtener la respuesta.");
	    txtLlamasAUn.setColumns(10);
	    txtLlamasAUn.setBackground(new Color(64, 0, 128));
	    txtLlamasAUn.setBounds(383, 304, 363, 37);
	    contentPane.add(txtLlamasAUn);
	    
	    txtCambiaLaPregunta = new JTextField();
	    txtCambiaLaPregunta.setText("Cambia la pregunta por otra igual de difícil");
	    txtCambiaLaPregunta.setForeground(Color.WHITE);
	    txtCambiaLaPregunta.setFont(new Font("Tahoma", Font.BOLD, 10));
	    txtCambiaLaPregunta.setColumns(10);
	    txtCambiaLaPregunta.setBackground(new Color(64, 0, 128));
	    txtCambiaLaPregunta.setBounds(38, 382, 333, 37);
	    contentPane.add(txtCambiaLaPregunta);
	    
	    txtGirasLaRuleta = new JTextField();
	    txtGirasLaRuleta.setText("Giras la ruleta y recuperas entre 0 y 3 comodines aleatoriamente");
	    txtGirasLaRuleta.setForeground(Color.WHITE);
	    txtGirasLaRuleta.setFont(new Font("Tahoma", Font.BOLD, 10));
	    txtGirasLaRuleta.setColumns(10);
	    txtGirasLaRuleta.setBackground(new Color(64, 0, 128));
	    txtGirasLaRuleta.setBounds(383, 382, 363, 37);
	    contentPane.add(txtGirasLaRuleta);
	    
	    lblTusComodines_1 = new JLabel("50/50");
	    lblTusComodines_1.setHorizontalAlignment(SwingConstants.CENTER);
	    lblTusComodines_1.setForeground(Color.YELLOW);
	    lblTusComodines_1.setFont(new Font("Tahoma", Font.BOLD, 11));
	    lblTusComodines_1.setBounds(-123, 268, 360, 50);
	    contentPane.add(lblTusComodines_1);
	    
	    lblTusComodines_2 = new JLabel("Llamada");
	    lblTusComodines_2.setHorizontalAlignment(SwingConstants.CENTER);
	    lblTusComodines_2.setForeground(Color.YELLOW);
	    lblTusComodines_2.setFont(new Font("Tahoma", Font.BOLD, 11));
	    lblTusComodines_2.setBounds(227, 268, 360, 50);
	    contentPane.add(lblTusComodines_2);
	    
	    lblTusComodines_3 = new JLabel("Mago");
	    lblTusComodines_3.setHorizontalAlignment(SwingConstants.CENTER);
	    lblTusComodines_3.setForeground(Color.YELLOW);
	    lblTusComodines_3.setFont(new Font("Tahoma", Font.BOLD, 11));
	    lblTusComodines_3.setBounds(-123, 347, 360, 50);
	    contentPane.add(lblTusComodines_3);
	    
	    lblTusComodines_4 = new JLabel("Ruleta");
	    lblTusComodines_4.setHorizontalAlignment(SwingConstants.CENTER);
	    lblTusComodines_4.setForeground(Color.YELLOW);
	    lblTusComodines_4.setFont(new Font("Tahoma", Font.BOLD, 11));
	    lblTusComodines_4.setBounds(218, 347, 369, 50);
	    contentPane.add(lblTusComodines_4);
	    
	    lblPremios = new JLabel("PREMIOS");
	    lblPremios.setHorizontalAlignment(SwingConstants.CENTER);
	    lblPremios.setForeground(Color.YELLOW);
	    lblPremios.setFont(new Font("Tahoma", Font.BOLD, 14));
	    lblPremios.setBounds(-108, 417, 360, 50);
	    contentPane.add(lblPremios);
	    
	    btnIniciarPartida_4 = new JButton("Volver al Menú");
	    btnIniciarPartida_4.setForeground(new Color(0, 64, 64));
	    btnIniciarPartida_4.setFont(new Font("Tahoma", Font.BOLD, 12));
	    btnIniciarPartida_4.setBorder(BorderFactory.createLineBorder(new Color(255, 215, 0), 2));
	    btnIniciarPartida_4.setBackground(new Color(255, 0, 0));
	    btnIniciarPartida_4.setBounds(630, 522, 116, 31);
	    contentPane.add(btnIniciarPartida_4);
	    
	    lblTusComodines_5 = new JLabel("1.000€");
	    lblTusComodines_5.setHorizontalAlignment(SwingConstants.CENTER);
	    lblTusComodines_5.setForeground(Color.YELLOW);
	    lblTusComodines_5.setFont(new Font("Tahoma", Font.BOLD, 13));
	    lblTusComodines_5.setBounds(-98, 458, 360, 50);
	    contentPane.add(lblTusComodines_5);
	    
	    lblNewLabel_4 = new JLabel("_______________________________________________________________________________________________________________________________________");
	    lblNewLabel_4.setForeground(Color.YELLOW);
	    lblNewLabel_4.setBounds(-205, 45, 981, 12);
	    contentPane.add(lblNewLabel_4);
	    
	    lblNewLabel_5 = new JLabel("_________________________________________________________________________________________________________________________________________");
	    lblNewLabel_5.setForeground(Color.YELLOW);
	    lblNewLabel_5.setBounds(-14, 438, 821, 29);
	    contentPane.add(lblNewLabel_5);
	    
	    txtPreguntas = new JTextField();
	    txtPreguntas.setBackground(new Color(0, 183, 0));
	    txtPreguntas.setFont(new Font("Tahoma", Font.BOLD, 11));
	    txtPreguntas.setHorizontalAlignment(SwingConstants.CENTER);
	    txtPreguntas.setText("5 Preguntas");
	    txtPreguntas.setBounds(34, 496, 96, 25);
	    contentPane.add(txtPreguntas);
	    txtPreguntas.setColumns(10);
	    
	    lblTusComodines_6 = new JLabel("20.000€");
	    lblTusComodines_6.setHorizontalAlignment(SwingConstants.CENTER);
	    lblTusComodines_6.setForeground(Color.YELLOW);
	    lblTusComodines_6.setFont(new Font("Tahoma", Font.BOLD, 13));
	    lblTusComodines_6.setBounds(50, 458, 360, 50);
	    contentPane.add(lblTusComodines_6);
	    
	    txtPreguntas_1 = new JTextField();
	    txtPreguntas_1.setText("10 Preguntas");
	    txtPreguntas_1.setHorizontalAlignment(SwingConstants.CENTER);
	    txtPreguntas_1.setFont(new Font("Tahoma", Font.BOLD, 11));
	    txtPreguntas_1.setColumns(10);
	    txtPreguntas_1.setBackground(new Color(0, 183, 0));
	    txtPreguntas_1.setBounds(181, 496, 96, 25);
	    contentPane.add(txtPreguntas_1);
	    
	    lblTusComodines_7 = new JLabel("1.000.000€");
	    lblTusComodines_7.setHorizontalAlignment(SwingConstants.CENTER);
	    lblTusComodines_7.setForeground(Color.YELLOW);
	    lblTusComodines_7.setFont(new Font("Tahoma", Font.BOLD, 13));
	    lblTusComodines_7.setBounds(181, 458, 360, 50);
	    contentPane.add(lblTusComodines_7);
	    
	    txtPreguntas_2 = new JTextField();
	    txtPreguntas_2.setText("15 Preguntas");
	    txtPreguntas_2.setHorizontalAlignment(SwingConstants.CENTER);
	    txtPreguntas_2.setFont(new Font("Tahoma", Font.BOLD, 11));
	    txtPreguntas_2.setColumns(10);
	    txtPreguntas_2.setBackground(new Color(0, 183, 0));
	    txtPreguntas_2.setBounds(314, 496, 96, 25);
	    contentPane.add(txtPreguntas_2);
	    setVisible(true);

	}
}
