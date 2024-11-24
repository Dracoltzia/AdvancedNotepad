package ProcesaTextos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class laminaTexto extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public laminaTexto (){
		setLayout(new BorderLayout());
		areaTexto=new JTextPane();
		add(areaTexto,BorderLayout.CENTER);
	}
	
	private static JTextPane areaTexto;
	
	private class ManejaTexto implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			
		}
		
		
		
	}

	public static void setText(String texto) {
		areaTexto.setText(texto);
		}
	
	public static String getText() {
		String text=areaTexto.getText();
		return text;
		}
	}


