package procesador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionaMarcoFuente implements ActionListener{

	public GestionaMarcoFuente(PanelTexto pt, PanelInferior pi){
		
		marcodelafuente= new MarcoFuente(pt, pi);
		
	}
	
	
	public void actionPerformed(ActionEvent ae){
		
		marcodelafuente.setVisible(true);
		
	}
	
	private MarcoFuente marcodelafuente;
	
	
}
