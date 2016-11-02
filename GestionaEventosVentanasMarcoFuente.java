package procesador;



import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionaEventosVentanasMarcoFuente implements ActionListener{

	public GestionaEventosVentanasMarcoFuente(MarcoFuente mf, PanelTexto pt, PanelInferior pi){
		
		marcofuente= mf;
		
		paneldetexto= pt;
		
		panelinferior= pi;
		
	}
	
	public void actionPerformed(ActionEvent ae){
		
		if(ae.getActionCommand().equals("Cancelar")){
			
			marcofuente.hide();
		}
		else if(ae.getActionCommand().equals("Aceptar")){
			
			int est=0;
			
			if(marcofuente.getStyleComboEstilo().equals("Normal")){
				est= Font.PLAIN;
			}
			else if(marcofuente.getStyleComboEstilo().equals("Negrita")){
				est= Font.BOLD;
			}
			else if(marcofuente.getStyleComboEstilo().equals("Cursiva")){
				est= Font.ITALIC;
			}
			else if(marcofuente.getStyleComboEstilo().equals("Negrita Cursiva")){
				est= 3;
			}
			
			
			paneldetexto.setFontAreaTexto(new Font(marcofuente.getFontComboFuente(), est,
											marcofuente.getSizeSpinnerTamagno()));
			
			panelinferior.setInfoFuente("Fuente: "+marcofuente.getFontComboFuente()+
					", Tamaño: "+marcofuente.getSizeSpinnerTamagno());
			
			marcofuente.hide();
			
		}
		
	}
	
	private MarcoFuente marcofuente;
	
	private PanelTexto paneldetexto;
	
	private PanelInferior panelinferior;
	
}
