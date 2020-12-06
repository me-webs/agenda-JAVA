package grafica.ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private Fondo contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnEdicion = new JMenu("Tablas");
		menuBar.add(mnEdicion);
		
		JMenuItem mntmAgendaPersonal = new JMenuItem("Agenda Personal");
		mntmAgendaPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VentanaAgenda ventana = new VentanaAgenda();
				ventana.setVisible(true);
				
			}
		});
		mnEdicion.add(mntmAgendaPersonal);
		
		JMenuItem mntmCargosEmpresa = new JMenuItem("Cargos Empresa");
		mntmCargosEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VentanaDesignacionCargo ventana = new VentanaDesignacionCargo();
				ventana.setVisible(true);
				
				
			}
		});
		mnEdicion.add(mntmCargosEmpresa);
		
		JMenu mnArchivos = new JMenu("Archivos");
		menuBar.add(mnArchivos);
		
		JMenuItem mntmCerrar = new JMenuItem("Cerrar");
		mntmCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		mnArchivos.add(mntmCerrar);
		contentPane = new Fondo("primerFondo.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
