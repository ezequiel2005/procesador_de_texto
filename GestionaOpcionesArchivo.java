package procesador;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class GestionaOpcionesArchivo implements ActionListener{

	public GestionaOpcionesArchivo(PanelTexto pt){
		
		paneldeltexto= pt;
		
		locacionGuardar= new JFileChooser("C:\\Users\\Ezequiel\\Desktop");
		
		abrirArchivo = new JFileChooser("C:\\Users\\Ezequiel\\Desktop");
		
	}
	
	public void actionPerformed(ActionEvent ae){
		
		if(ae.getActionCommand().equals("Nuevo")){
			
			// si no esta vacio el area de texto
			if(!paneldeltexto.getAreaTexto().getText().isEmpty()){
				
				int confirmNuevo= JOptionPane.showConfirmDialog(null, "Desea crear uno nuevo?");
				
				if(confirmNuevo==0){ 
					paneldeltexto.setTextoAreaTexto("");
					locacionArchivo= null;
					texto="";
				}
			}
			else{

				if(locacionArchivo!=null){
					
					JLabel infolocacion= new JLabel("Desea guardar los cambios realizados en "+ locacionArchivo.getPath());
					
					infolocacion.setForeground(Color.BLUE);
					infolocacion.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
					
					int confirmGuardar= JOptionPane.showConfirmDialog(null, infolocacion);
					
					if(confirmGuardar==0){
							
						// guardar
						
						try {
								
							FileWriter archivo= new FileWriter(locacionArchivo);
								
							archivo.write(paneldeltexto.getAreaTexto().getText());
							archivo.close();
								
							JOptionPane.showMessageDialog(null,
								       "El archivo se a guardado Exitosamente",
								            "Información",JOptionPane.INFORMATION_MESSAGE);
							
							locacionArchivo= null;
							texto= "";
								
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null,
								       "Su archivo no se ha guardado",
								           "Advertencia",JOptionPane.WARNING_MESSAGE);
						}
							
					}
					else if(confirmGuardar==1){
						locacionArchivo= null;
						texto= "";
					}
					
				}
				else{
					texto="";
				}

				
			}
			
		} // fin de Nuevo
		else if(ae.getActionCommand().equals("Abrir")){
			
			abrirArchivo.showOpenDialog(paneldeltexto);
			
			locacionArchivo= abrirArchivo.getSelectedFile();
			
			String aux="";
			
			try{
				
				FileReader archivo= new FileReader(locacionArchivo);
				
				BufferedReader leer= new BufferedReader(archivo);
				
				while((aux= leer.readLine())!=null){
					texto+= aux+"\n";
				}
				
				leer.close();
				
				paneldeltexto.setTextoAreaTexto(texto);
				
			}catch(Exception e){
				JOptionPane.showMessageDialog(null,"No se ha encontrado el archivo",
				                 "ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
			}
			
			
		}// fin de Abrir
		else if(ae.getActionCommand().equals("Guardar")){
			
			if(locacionArchivo!=null){
				
				try {
					
					FileWriter archivo= new FileWriter(locacionArchivo);
					
					archivo.write(paneldeltexto.getAreaTexto().getText());
					archivo.close();
					
					JOptionPane.showMessageDialog(null,
					         "El archivo se a guardado Exitosamente",
					             "Información",JOptionPane.INFORMATION_MESSAGE);
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
					        "Su archivo no se ha guardado",
					           "Advertencia",JOptionPane.WARNING_MESSAGE);
				}
				
			}
			else{
				
				locacionGuardar.showSaveDialog(paneldeltexto);
				
				locacionArchivo= locacionGuardar.getSelectedFile();
				
				try {
					
					FileWriter archivo= new FileWriter(locacionArchivo);
					
					archivo.write(paneldeltexto.getAreaTexto().getText());
					archivo.close();
					
					JOptionPane.showMessageDialog(null,
					         "El archivo se a guardado Exitosamente",
					             "Información",JOptionPane.INFORMATION_MESSAGE);
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
					        "Su archivo no se ha guardado",
					           "Advertencia",JOptionPane.WARNING_MESSAGE);
				}
				
			}
			
			
		} // fin de guardar
		else if(ae.getActionCommand().equals("Guardar Como...")){
			
			locacionGuardar.showSaveDialog(paneldeltexto);
			
			locacionArchivo= locacionGuardar.getSelectedFile();
			
			try {
				
				FileWriter archivo= new FileWriter(locacionArchivo);
				
				archivo.write(paneldeltexto.getAreaTexto().getText());
				archivo.close();
				
				JOptionPane.showMessageDialog(null,
				         "El archivo se a guardado Exitosamente",
				             "Información",JOptionPane.INFORMATION_MESSAGE);
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
				        "Su archivo no se ha guardado",
				           "Advertencia",JOptionPane.WARNING_MESSAGE);
			}
			
		} // fin de Guardar como
		else if(ae.getActionCommand().equals("Salir")){
			
			
			if(!paneldeltexto.getAreaTexto().getText().isEmpty()){
				
				if(paneldeltexto.getAreaTexto().getText().equals(texto)){
					
					System.exit(0);
				}
				else{
					
					if(locacionArchivo!=null){
					
						JLabel infolocacion= new JLabel("Desea guardar los cambios realizados en "+ locacionArchivo.getPath());
						
						infolocacion.setForeground(Color.BLUE);
						infolocacion.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
						
						int confirmGuardar= JOptionPane.showConfirmDialog(null, infolocacion);
						
						if(confirmGuardar==0){
								
							// guardar
							
							try {
									
								FileWriter archivo= new FileWriter(locacionArchivo);
									
								archivo.write(paneldeltexto.getAreaTexto().getText());
								archivo.close();
									
								JOptionPane.showMessageDialog(null,
									       "El archivo se a guardado Exitosamente",
									            "Información",JOptionPane.INFORMATION_MESSAGE);
									
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null,
									       "Su archivo no se ha guardado",
									           "Advertencia",JOptionPane.WARNING_MESSAGE);
							}
								
						}
						else if(confirmGuardar==1){
							System.exit(0);
						}
						
					}
					else{
						
						JLabel info= new JLabel("Desea guardar este archivo nuevo? ");

						info.setForeground(Color.BLUE);
						info.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
						
						int confirmGuardar= JOptionPane.showConfirmDialog(null, info);
						
						if(confirmGuardar==0){
								
							// guardar como
							locacionGuardar.showSaveDialog(paneldeltexto);
							
							locacionArchivo= locacionGuardar.getSelectedFile();
							
							try {
								
								FileWriter archivo= new FileWriter(locacionArchivo);
								
								archivo.write(paneldeltexto.getAreaTexto().getText());
								archivo.close();
								
								JOptionPane.showMessageDialog(null,
								         "El archivo se a guardado Exitosamente",
								             "Información",JOptionPane.INFORMATION_MESSAGE);
								
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null,
								        "Su archivo no se ha guardado",
								           "Advertencia",JOptionPane.WARNING_MESSAGE);
							}
								
						}
						else if(confirmGuardar==1){
							System.exit(0);
						}
						
					}
	
				}
				
			}
			else{
				
				if(locacionArchivo!=null){
					
					int confirmGuardar= JOptionPane.showConfirmDialog(null, "Desea guardar los cambios realizados en "
							+ locacionArchivo.getPath()+"?");
						
					if(confirmGuardar==0){
							
						// guardar
						
						try {
								
							FileWriter archivo= new FileWriter(locacionArchivo);
								
							archivo.write(paneldeltexto.getAreaTexto().getText());
							archivo.close();
								
							JOptionPane.showMessageDialog(null,
								       "El archivo se a guardado Exitosamente",
								            "Información",JOptionPane.INFORMATION_MESSAGE);
							
							System.exit(0);
								
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null,
								       "Su archivo no se ha guardado",
								           "Advertencia",JOptionPane.WARNING_MESSAGE);
						}
							
					}
					else if(confirmGuardar==1){
						System.exit(0);
					}	
				}
				else{
					
					System.exit(0);
				}
				
			}

		}
		
		
	}
	
	private String texto="";
	
	private JFileChooser locacionGuardar;
	
	private File locacionArchivo;
	
	private JFileChooser abrirArchivo;

	private PanelTexto paneldeltexto;
	
}
