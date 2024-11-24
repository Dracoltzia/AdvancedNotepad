package ProcesaTextos;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;

public class laminaInterfaz extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public laminaInterfaz(String[] nombres) {
		setLayout(new BorderLayout());
		add(barra);	
		setMenu(nombres,barra);
	}
	
	public void setMenu(String[] nombres, JComponent barraMenu) {
		
		for(int i=0; i<nombres.length;i++) {
			JMenu boton=new JMenu(nombres[i]);
			barraMenu.add(boton);	
			boton.addActionListener(new ManejoBotones());
		}
	}
	
	public void setOpciones(String[] nombres, String componente, boolean accion) {
		JMenu barraMenu= new JMenu();
		for(int i=0;i<barra.getMenuCount();i++) {
			if(componente==barra.getMenu(i).getText()) {
				barraMenu= barra.getMenu(i);
			}
			
		}
		
		if(accion==false) {
		
		for(int i=0; i<nombres.length;i++) {
			JMenuItem boton=new JMenuItem(nombres[i]);
			barraMenu.add(boton);		
			}
		}
	else {
		
		for(int i=0; i<nombres.length;i++) {
			JMenuItem boton=new JMenuItem(nombres[i]);
			barraMenu.add(boton);
			boton.addActionListener(new ManejoBotones());
			}
		}
	
	}
	
	public static void setRuta(String ruta) {
		 rutaArchivo=ruta;
	}
	
	public static String getRuta() {
		return rutaArchivo;
	}
	private JMenuBar barra= new JMenuBar();
	private static String rutaArchivo="";
	
	
	
	private class ManejoBotones implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			JMenuItem boton= (JMenuItem)e.getSource();
			String nombre= boton.getText();
			String ruta=null;
			String texto=null;
			if(nombre=="Abrir...") {
				conteoAbrir=1;
				FileReader archivo;
				System.out.println("Hola");
				ruta= JOptionPane.showInputDialog("Escriba la ruta del archivo");
				laminaInterfaz.setRuta(ruta);
				try {
					archivo = new FileReader (ruta);
					int caracter=0;
					int contador=0;
					while (caracter!=-1) {
						caracter= archivo.read();
						contador++;
						}
					char[] textoChar= new char[contador];
					int indice=0;
					caracter=0;
					archivo.close();
					archivo = new FileReader (ruta);
					while (caracter!=-1) {
							caracter= archivo.read();
							if (caracter==-1){}
							else {
							char c= (char)caracter;
							textoChar[indice]=c;
							indice++;
							}
							}
					texto= new String(textoChar);
					archivo.close();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(boton, "El archivo no se encuentra o no es compatible");
					e1.printStackTrace();
				}
				
				laminaTexto.setText(texto);	
			}
			
			if(nombre=="Guardar"&& conteoAbrir==1) {
				
				try {
					FileWriter textoGuardar= new FileWriter(laminaInterfaz.getRuta());
					//for(int i =0; i< texto.length();i++) {
						textoGuardar.write(laminaTexto.getText());
					//}
						
					textoGuardar.close();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
			
			
			
			
			
			
			
			
		}
		
		private static int conteoAbrir=0;
		
	}
	
}





