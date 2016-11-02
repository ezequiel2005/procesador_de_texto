package procesador;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.BorderLayout;

import java.awt.Font;

public class PanelInferior extends JPanel{

	public PanelInferior(PanelTexto pt){
		
		setLayout(new BorderLayout());
		
		mifuente= pt.getAreaTexto().getFont();
		
		// inicia y coloca el info en el panel
		iniciarInfoFuente();
		
	}
	
	private void iniciarInfoFuente(){
		
		// inicia el info de la fuente
		infoFuente= new JLabel("Fuente: "+mifuente.getFontName()+
				", Tamaño: "+mifuente.getSize(), JLabel.CENTER);
		
		infoFuente.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		// agrega el info al panel
		add(infoFuente, BorderLayout.CENTER);
	}
	
	
	
	public void setInfoFuente(String rotulo) {
		this.infoFuente.setText(rotulo);
	}



	private JLabel infoFuente;
	
	private Font mifuente;
	
}
