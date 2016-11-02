package procesador;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.CompoundBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GraphicsEnvironment;
import java.awt.Dimension;

import java.io.File;

public class MarcoFuente extends JFrame{

	public MarcoFuente(PanelTexto pt, PanelInferior pi){
		
		setLayout(new FlowLayout());
		
		gebmf= new GestionaEventosVentanasMarcoFuente(this, pt, pi);
		
		setTitle("Elejir tipo de fuente.");
		
		setSize(600, 280);
		
		setLocationRelativeTo(null);
		
		setResizable(false);
		
		try {
			
			img= ImageIO.read(new File("src/procesador/img/icono.png"));
			
			setIconImage(img);
			
		} catch (Exception e) {
			
			System.out.println("No se encontro la imagen");
		}
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		iniciarComboFuente();
		
		iniciarComboEstilo();
		
		iniciarSpinnerTamagno();
		
		iniciarPanelMuestra();
		
		iniciarPanelBotones();
		
	}
	
	private void iniciarComboFuente(){
		
		lbfuente= new JLabel("Fuentes: ");
		lbfuente.setBorder(new EmptyBorder(0, 10, 0, 0));
		
		add(lbfuente);
		
		fuente= new JComboBox();
		
		String[] tiposfuente;
		GraphicsEnvironment ge= GraphicsEnvironment.getLocalGraphicsEnvironment();
		tiposfuente= ge.getAvailableFontFamilyNames();
		
		for(String e: tiposfuente){	
			fuente.addItem(e);	
		}
		
		fuente.addActionListener(new GestionaPanelMuestra());
		
		add(fuente);
	
	}
	
	private void iniciarComboEstilo(){
		
		lbestilo= new JLabel("Estilos: ");
		lbestilo.setBorder(new EmptyBorder(0, 10, 0, 0));
		
		add(lbestilo);
		
		estilo= new JComboBox();
		estilo.addItem("Normal");
		estilo.addItem("Cursiva");
		estilo.addItem("Negrita");
		estilo.addItem("Negrita Cursiva");
		
		estilo.addActionListener(new GestionaPanelMuestra());
		
		add(estilo);
		
	}
	
	private void iniciarSpinnerTamagno(){
		
		lbtamagno= new JLabel("Tamaño: ");
		lbtamagno.setBorder(new EmptyBorder(0, 10, 0, 0));
	
		add(lbtamagno);
		
		tamagno= new JSpinner(new SpinnerNumberModel(12, 8, 30, 2));
		tamagno.setPreferredSize(new Dimension(50, 20));
		
		tamagno.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent ce) {
				
				tam= (int)tamagno.getValue();
				
				lbmuestra.setFont(new Font(tipo, estilof, tam));
				
			}
			
		});
	
		add(tamagno);
		
	}
	
	private void iniciarPanelMuestra(){
		
		muestra= new JPanel();
		muestra.setLayout(new FlowLayout());
		muestra.setBorder(new TitledBorder("Muestra"));
		
		lbmuestra= new JLabel("AaBbYyZz");
		
			tipo= (String)fuente.getSelectedItem();

			if(estilo.getSelectedItem().equals("Normal")){
				estilof= Font.PLAIN;
			}
			else if(estilo.getSelectedItem().equals("cursiva")){
				estilof= Font.ITALIC;
			}
			else if(estilo.getSelectedItem().equals("Negrita")){
				estilof= Font.BOLD;
			}
			else if(estilo.getSelectedItem().equals("Negrita Cursiva")){
				estilof= 3;
			}
			
			tam= (int)tamagno.getValue();
		
		lbmuestra.setFont(new Font(tipo, estilof, tam));
		lbmuestra.setBorder(new EmptyBorder(30, 150, 30, 150));
		
		muestra.add(lbmuestra);
		
		add(muestra);
		
	}
	
	private void iniciarPanelBotones(){
		
		botones= new JPanel();
		botones.setLayout(new FlowLayout());
		botones.setBorder(new EmptyBorder(30, 150, 30, 150));
		
		aceptar= new JButton("Aceptar");
		aceptar.addActionListener(gebmf);
		
		cancelar= new JButton("Cancelar");
		cancelar.addActionListener(gebmf);
		
		botones.add(aceptar);
		botones.add(cancelar);
		
		add(botones);
		
	}
	
	// inner class
		private class GestionaPanelMuestra implements ActionListener{

			
			public void actionPerformed(ActionEvent ae) {
				
				if(ae.getSource()==fuente){
					
					tipo= (String)fuente.getSelectedItem();
					
					lbmuestra.setFont(new Font(tipo, estilof, tam));
				}
				else if(ae.getSource()==estilo){
					
					if(estilo.getSelectedItem().equals("Normal")){
						estilof= Font.PLAIN;
					}
					else if(estilo.getSelectedItem().equals("Cursiva")){
						estilof= Font.ITALIC;
					}
					else if(estilo.getSelectedItem().equals("Negrita")){
						estilof= Font.BOLD;
					}
					else if(estilo.getSelectedItem().equals("Negrita Cursiva")){
						estilof= 3;
					}
					
					lbmuestra.setFont(new Font(tipo, estilof, tam));
					
				}
				
				
			}
			
			
		}// fin inner class
		
	
	public String getFontComboFuente(){
		
		return (String)fuente.getSelectedItem();
	}
	
	public String getStyleComboEstilo(){
		
		return (String)estilo.getSelectedItem();
		
	}
	
	public int getSizeSpinnerTamagno(){
		
		return (int)tamagno.getValue();
	}
	

	
	private GestionaEventosVentanasMarcoFuente gebmf;
	
	private JLabel lbfuente, lbestilo, lbtamagno, lbmuestra;
	
	private JComboBox fuente, estilo;
	
	private JSpinner tamagno;
	
	private JPanel muestra, botones;
	
	private JButton aceptar, cancelar;
	
	private String tipo;
	
	private int estilof=0, tam;
	
	private Image img;
	
}



