package procesador;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.StyledEditorKit;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class PanelMenu extends JPanel{

	public PanelMenu(PanelTexto paneldetexto, PanelInferior pi){
		
		setLayout(new BorderLayout());
		
		pt= paneldetexto;

		gf= new GestionaMarcoFuente(pt, pi);
		
		goa= new GestionaOpcionesArchivo(pt);
		
		// inicia y coloca la barra de menu en el panel
		iniciarBarraMenu();
		
		iniciarMenuEmergente();
		
		notaProgramador= "Esta es la version 2.0";
			
	}
	
	private void iniciarBarraMenu(){
		
		// inicia la barra de menu
		barraMenu= new JMenuBar();
		
		// inicia las opciones para la barra de menu
		archivo= new JMenu("Archivo");
		edicion= new JMenu("Edicion");
		formato= new JMenu("Formato");
		ayuda= new JMenu("Ayuda");
		
		// iniciar las opciones de ARCHIVO
		iniciarOpcionesArchivo();
		
		// iniciar las opciones de FORMATO
		iniciarOpcionesFormato("Fuente");
		
		// iniciar las opcines de AYUDA
		iniciarOpcionesAyuda("Acerca de");
		
		// iniciar la opciones de EDICION
		iniciarOpcionesEdicion();
		
		// agregamos las opciones a la barra de menu
		barraMenu.add(archivo);
		barraMenu.add(edicion);
		barraMenu.add(formato);
		barraMenu.add(ayuda);
		
		// agregamos la barra de menu al panel
		add(barraMenu, BorderLayout.CENTER);
		
	}
	
	private void iniciarOpcionesFormato(String rotulo){
		
		JMenuItem opcionesFuente= new JMenuItem(rotulo);
		opcionesFuente.setBorder(new EmptyBorder(3, 6, 3, 6));
		opcionesFuente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.ALT_DOWN_MASK));
		opcionesFuente.addActionListener(gf);
	
		formato.add(opcionesFuente);
		
	}
	
	private void iniciarOpcionesArchivo(){
		
		JMenuItem opcionesNuevo= new JMenuItem("Nuevo");
		opcionesNuevo.setBorder(new EmptyBorder(3, 6, 3, 6));
		opcionesNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.ALT_DOWN_MASK));
		opcionesNuevo.addActionListener(goa);
		archivo.add(opcionesNuevo);
		
		JMenuItem opcionesAbrir = new JMenuItem("Abrir");
		opcionesAbrir.setBorder(new EmptyBorder(3, 6, 3, 6));
		opcionesAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_DOWN_MASK));
		opcionesAbrir.addActionListener(goa);
		archivo.add(opcionesAbrir);
		
		JMenuItem opcionesGuardar= new JMenuItem("Guardar");
		opcionesGuardar.setBorder(new EmptyBorder(3, 6, 3, 6));
		opcionesGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_DOWN_MASK));
		opcionesGuardar.addActionListener(goa);
		archivo.add(opcionesGuardar);
		
		
		JMenuItem opcionesGuardarComo= new JMenuItem("Guardar Como...");
		opcionesGuardarComo.setBorder(new EmptyBorder(3, 6, 3, 6));
		opcionesGuardarComo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.ALT_DOWN_MASK));
		opcionesGuardarComo.addActionListener(goa);
		archivo.add(opcionesGuardarComo);
		
		archivo.addSeparator();
		
		JMenuItem opcionesSalir= new JMenuItem("Salir");
		opcionesSalir.setBorder(new EmptyBorder(3, 6, 3, 6));
		opcionesSalir.addActionListener(goa);
		archivo.add(opcionesSalir);
		
	}
	
	private void iniciarOpcionesAyuda(String rotulo){
		
		JMenuItem opcionesAcerca= new JMenuItem(rotulo);
		opcionesAcerca.setBorder(new EmptyBorder(3, 6, 3, 6));
		opcionesAcerca.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.ALT_DOWN_MASK));
		opcionesAcerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				JOptionPane.showMessageDialog(null, notaProgramador, "Acerca De", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		ayuda.add(opcionesAcerca);
	}
	
	private void iniciarOpcionesEdicion(){
		
		JMenuItem izquierda= new JMenuItem("Izquierda", new ImageIcon("src/procesador/img/izquierda.gif"));
		izquierda.setBorder(new EmptyBorder(3, 6, 3, 6));
		izquierda.addActionListener(new StyledEditorKit.AlignmentAction("izquierda", 0));
		izquierda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK));
		
		JMenuItem centrado= new JMenuItem("Centrado", new ImageIcon("src/procesador/img/centrado.gif"));
		centrado.setBorder(new EmptyBorder(3, 6, 3, 6));
		centrado.addActionListener(new StyledEditorKit.AlignmentAction("centrado", 1));
		centrado.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK));
		
		JMenuItem derecha= new JMenuItem("Derecha", new ImageIcon("src/procesador/img/derecha.gif"));
		derecha.setBorder(new EmptyBorder(3, 6, 3, 6));
		derecha.addActionListener(new StyledEditorKit.AlignmentAction("derecha", 2));
		derecha.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
		
		JMenuItem justificado= new JMenuItem("Justificado", new ImageIcon("src/procesador/img/justificado.gif"));
		justificado.setBorder(new EmptyBorder(3, 6, 3, 6));
		justificado.addActionListener(new StyledEditorKit.AlignmentAction("justificado", 3));
		justificado.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, InputEvent.CTRL_DOWN_MASK));
		
		edicion.add(izquierda);
		edicion.add(centrado);
		edicion.add(derecha);
		edicion.add(justificado);
		
	}
	
	private void iniciarMenuEmergente(){
		
		menuEmergente= new JPopupMenu();
		
		JMenuItem copiar= new JMenuItem("Copiar", new ImageIcon("src/procesador/img/copiar.gif"));
		JMenuItem cortar= new JMenuItem("Cortar", new ImageIcon("src/procesador/img/cortar.gif"));
		JMenuItem pegar= new JMenuItem("Pegar", new ImageIcon("src/procesador/img/pegar.gif"));

		copiar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
		copiar.addActionListener(new DefaultEditorKit.CopyAction());
		
		cortar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
		cortar.addActionListener(new DefaultEditorKit.CutAction());	
		
		pegar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));
		pegar.addActionListener(new DefaultEditorKit.PasteAction());

		
		menuEmergente.add(copiar);
		menuEmergente.add(cortar);
		menuEmergente.add(pegar);
		
		pt.setAreaTextoPopupMenu(menuEmergente);
		
	}
	
	
	
	private JMenuBar barraMenu;
	
	private JMenu archivo, edicion, formato, ayuda;
	
	private GestionaMarcoFuente gf;
	
	private GestionaOpcionesArchivo goa;
	
	private PanelTexto pt;
	
	private String notaProgramador;
	
	private JPopupMenu menuEmergente;
}



