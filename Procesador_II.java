package procesador;

import javax.swing.JFrame;
import javax.imageio.ImageIO;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.File;


public class Procesador_II {

	public static void main(String[] args){
		
		new MarcoPrincipal().setVisible(true);
		
	}
	
}

class MarcoPrincipal extends JFrame{
	
	public MarcoPrincipal(){
		
		setLayout(new BorderLayout());
		
		setTitle("Procesador de texto.");
		
		setSize(800, 500);
		
		setLocationRelativeTo(null);
		
		try {
		
			img= ImageIO.read(new File("src/procesador/img/icono.png"));
			
			setIconImage(img);
			
		}catch (Exception e) {
			
			System.out.println("No se encontro la imagen.");
		}
		
		// esto se eliminara despues
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(true);
		
		// instanciando los paneles
		
		PanelTexto pt= new PanelTexto();
		
		PanelInferior pi= new PanelInferior(pt);
		
		PanelMenu pm= new PanelMenu(pt, pi);
		
		// agregamos los paneles al marco principal
		add(pm, BorderLayout.NORTH);
		
		add(pt, BorderLayout.CENTER);
		
		add(pi, BorderLayout.SOUTH);
		
	}
	
	private Image img;
	
}
