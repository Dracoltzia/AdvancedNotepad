package ProcesaTextos;
import java.awt.*;

import javax.swing.*;

public class graficosVentana extends JFrame{

	private static final long serialVersionUID = 1L;

	public graficosVentana(){
		setBounds(400,200,600,400);
		setLayout(new BorderLayout());
		
		laminaInterfaz lam1= new laminaInterfaz(menuBarra);
		lam1.setOpciones(Archivo, "Archivo", true);
		lam1.setOpciones(Fuente, "Fuente", true);
		lam1.setOpciones(Estilo, "Estilo", true);
		lam1.setOpciones(Herramientas, "Herramientas", true);
		add(lam1,BorderLayout.NORTH);
		
		
		laminaTexto lamTex1= new laminaTexto();
		add(lamTex1,BorderLayout.CENTER);
		setVisible(true);
	}
	
	String[] menuBarra= {"Archivo","Fuente","Estilo","Herramientas"};
	String[] Archivo= {"Abrir...","Guardar","Guardar como...","Exportar"};
	String[] Fuente= {"Arial","Times New Roman","Courier","Otros..."};
	String[] Estilo= {"Negrita","Cursiva","Subrrayado"};
	String[] Herramientas= {"Copiar","Cortar","Pegar"};
	
}
