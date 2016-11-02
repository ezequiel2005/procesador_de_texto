package procesador;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.text.StyledEditorKit;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class PanelTexto extends JPanel{

	public PanelTexto(){
		
		setLayout(new BorderLayout());
		
		// inicia y coloca el area de texto
		iniciarAreaTexto();
		
	}
	
	private void iniciarAreaTexto(){
		
		// inicia el area de texto
		areaTexto= new JTextPane();
		areaTexto.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
		
		// inicia el scroll
		miscroll= new JScrollPane(areaTexto);

		// agregamos el scroll con el area de texto al panel
		add(miscroll, BorderLayout.CENTER);
		
	}
	
	
	
	
	
	public JTextPane getAreaTexto() {
		return areaTexto;
	}

	public void setTextoAreaTexto(String texto){
		this.areaTexto.setText(texto);
	}
	
	public void setFontAreaTexto(Font fuente) {
		this.areaTexto.setFont(fuente);
	}
	
	public void setAreaTextoPopupMenu(JPopupMenu e){
		this.areaTexto.setComponentPopupMenu(e);
	}
	
	private JScrollPane miscroll;
	
	private JTextPane areaTexto;
	
	
}
