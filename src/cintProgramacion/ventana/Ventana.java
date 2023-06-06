/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cintProgramacion.ventana;

/**
 *
 * 
 */

import cintProgramacion.seriesControlador.SeriesController;
import java.awt.EventQueue;
import java.awt.Image;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import cintProgramacion.modelo.Series;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textTitulo;
	private JTextField textFecha;
	private JTextField textTemporada;
	private JTextField textActores;
	private JComboBox cbxGenero;
	private JTextArea textSinopsis;
	private SeriesController seriesController;
	private Series series;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Ventana() {
		seriesController = new SeriesController();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 424, 630);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 408, 591);
		panel.setLayout(null);
		contentPane.add(panel);
		
		ImageIcon imagen = new ImageIcon("src/cintProgramacion/imagenes/youtube.jpg");
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(237, 11, 161, 113);
		lblNewLabel.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(
				lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_DEFAULT)));                                                             
		panel.add(lblNewLabel);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(10, 186, 170, 20);
		panel.add(textCodigo);
		textCodigo.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Código");
		lblCodigo.setBounds(10, 155, 94, 20);
		panel.add(lblCodigo);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textCodigo.getText().isBlank()) {
					buscarCodigo();
				}else {
					JOptionPane.showMessageDialog(null, "ingrese un codigo para buscar");
				}
			}
		});
		btnBuscar.setBounds(190, 185, 184, 23);
		panel.add(btnBuscar);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(10, 232, 62, 20);
		panel.add(lblTitulo);
		
		textTitulo = new JTextField();
		textTitulo.setText("");
		textTitulo.setBounds(10, 251, 364, 20);
		panel.add(textTitulo);
		textTitulo.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha de lanzamiento");
		lblFecha.setBounds(10, 283, 141, 28);
		panel.add(lblFecha);
		
		JLabel lblSinopsis = new JLabel("Sinopsis");
		lblSinopsis.setBounds(204, 282, 170, 29);
		panel.add(lblSinopsis);
		
		textSinopsis = new JTextArea();
		textSinopsis.setLineWrap(true);
		textSinopsis.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		textSinopsis.setBounds(194, 309, 180, 194);
		panel.add(textSinopsis);

                JScrollPane scrollPane = new JScrollPane(textSinopsis);
                scrollPane.setBounds(194, 309, 180, 194);
                panel.add(scrollPane);

		JLabel lblTemporada = new JLabel("Temporadas");
		lblTemporada.setBounds(10, 335, 120, 14);
		panel.add(lblTemporada);
		
		JLabel lblNewLabel_6 = new JLabel("Género");
		lblNewLabel_6.setBounds(10, 385, 46, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblActores = new JLabel("Actores");
		lblActores.setBounds(10, 441, 46, 14);
		panel.add(lblActores);
		
		textFecha = new JTextField();
		textFecha.setBounds(10, 311, 161, 20);
		panel.add(textFecha);
		textFecha.setColumns(10);
		
		textTemporada = new JTextField();
		textTemporada.setBounds(10, 360, 161, 20);
		panel.add(textTemporada);
		textTemporada.setColumns(10);
		
		textActores = new JTextField();
		textActores.setColumns(10);
		textActores.setBounds(10, 466, 161, 20);
		panel.add(textActores);
		
		JButton btnGuardar = new JButton("Guardar ");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnGuardar.setBounds(10, 540, 89, 23);
		panel.add(btnGuardar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificar();
			}
		});
		btnEditar.setBounds(114, 540, 89, 23);
		panel.add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                      		eliminarRegistro();
                            }
			
		});
		btnEliminar.setBounds(213, 540, 89, 23);
		panel.add(btnEliminar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarVentana();
			}
		});
		btnLimpiar.setBounds(312, 540, 89, 23);
		panel.add(btnLimpiar);
		
		cbxGenero = new JComboBox();
		cbxGenero.setModel(new DefaultComboBoxModel(new String[] {"--", "Acción", "Ciencia Ficción", "Comedia", "Drama", "Misterio", "Romántica", "Terror"}));
		cbxGenero.setBounds(10, 410, 161, 22);
		panel.add(cbxGenero);
		
		JLabel lblNewLabel_8 = new JLabel("Series TV");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Eras Medium ITC", Font.BOLD, 40));
		lblNewLabel_8.setBounds(10, 11, 223, 113);
		panel.add(lblNewLabel_8);
	}
	
	public void guardar() {
		if (textCodigo.getText().isBlank() || textTitulo.getText().isBlank() || textFecha.getText().isBlank()
				|| textTemporada.getText().isBlank() || cbxGenero.getSelectedItem().equals("--")
				|| textActores.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "EL UNICO CAMPO QUE PUEDE ESTAR VACIO ES LA SINOPSIS");
		} else {
			DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String codigo =(String) textCodigo.getText();
			String titulo = (String)textTitulo.getText();
			String temporada = (String)textTemporada.getText();
			String genero = (String) cbxGenero.getSelectedItem();
			String actores =(String) textActores.getText();
			String sinopsis = (String)textSinopsis.getText();
			Date fecha;
			
			if(sinopsis.isBlank()) {
				sinopsis = "";
			}else {
				sinopsis = textSinopsis.getText();
			}
			try {
				fecha = java.sql.Date.valueOf(LocalDate.parse(textFecha.getText(), formatoFecha));

			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "la fecha debe ser año-mes-dia");
				throw new RuntimeException(e);
			}
                        
                        series = new Series(codigo, titulo, fecha, temporada, genero, actores, sinopsis);
                        if (!this.seriesController.verificarCodigoController(codigo)) {
			    JOptionPane.showMessageDialog(null, "INGRESA OTRO CODIGO");
			return ;
                        }else{
                            this.seriesController.guardarDao(series);
                            JOptionPane.showMessageDialog(null, "REGISTRO ALMACENADO CON EXITO");
                            limpiarVentana();
                        }
		    }
		}
	
	public void limpiarVentana() {
			this.textCodigo.setText("");
			this.textTitulo.setText("");
			this.textFecha.setText("");
			this.textTemporada.setText("");
			this.cbxGenero.setSelectedIndex(0);
			this.textActores.setText("");
			this.textSinopsis.setText("");
		}

	public void modificar() {
		if (textCodigo.getText().isBlank() || textTitulo.getText().isBlank() || textFecha.getText().isBlank()
				|| textTemporada.getText().isBlank() || cbxGenero.getSelectedItem().equals("--")
				|| textActores.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "EL UNICO CAMPO QUE PUEDE ESTAR VACIO ES LA SINOPSIS");
		} else {
			DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String codigo =(String) textCodigo.getText();
			String titulo = (String)textTitulo.getText();
			String temporada = (String)textTemporada.getText();
			String genero = (String) cbxGenero.getSelectedItem();
			String actores =(String) textActores.getText();
			String sinopsis = (String)textSinopsis.getText();
			Date fecha;
			
			if(sinopsis.isBlank()) {
				sinopsis = "";
			}else {
				sinopsis = textSinopsis.getText();
			}
			try {
				fecha = java.sql.Date.valueOf(LocalDate.parse(textFecha.getText(), formatoFecha));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "la fecha debe ser año-mes-dia");
				throw new RuntimeException();
			}
			series = new Series(codigo, titulo, fecha, temporada, genero, actores, sinopsis);
			this.seriesController.editarController(codigo, titulo, fecha, temporada, genero, actores, sinopsis);
			JOptionPane.showMessageDialog(null, "REGISTRO MODIFICADO CON EXITO");
			limpiarVentana();
			}
		}

	private void buscarCodigo() {
	try {
		Series seri = seriesController.buscar(textCodigo.getText());
				textTitulo.setText(seri.getTitulo());
				textFecha.setText(seri.getFecha().toString());
				textTemporada.setText(seri.getTemporada());
				cbxGenero.setSelectedItem(seri.getGenero());
				textActores.setText(seri.getActores());
				textSinopsis.setText(seri.getSinopsis()); 
	}catch (Exception e) {
          
	}	
			}
	
	private void eliminarRegistro() {
		if(!textCodigo.getText().isBlank() || !textTitulo.getText().isBlank() || !textFecha.getText().isBlank()
				|| !textTemporada.getText().isBlank() || !cbxGenero.getSelectedItem().equals("--")
				|| !textActores.getText().isBlank()){
	
		int jop = JOptionPane.showConfirmDialog(null,"DESEA ELIMINAR EL REGISTRO");
			if(jop == JOptionPane.YES_OPTION) {
				this.seriesController.eliminarController(textCodigo.getText());
				limpiarVentana();
				JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADO CON EXITO");
				}
		}
	}
}

