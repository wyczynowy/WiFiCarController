package firstTabContent;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;

import app.Engine;
import util.MyTCP;

public class FirstTab extends Container {
	private static final long serialVersionUID = 5700297223865363623L;
	
	private static MyTCP myTCP = new MyTCP();
	private Engine engine = new Engine(myTCP);								// Obiekt obslugujacy finalnie dzialania przyciskow kierowania pojazdem
	private CenterContainer centerContainer = new CenterContainer();		// Kontener srodkowy z przyciskami kierowania pojazdem
	private NorthContainer northContainer = new NorthContainer(myTCP);		// Kontener polnocny z przyciskami odpowiedzialnymi za polaczenie tcp
	private WestContainer westContainer = new WestContainer(myTCP);			// Kontener zachodni z przyciskami funkcji dodatkowych
	private EastContainer eastContainer = new EastContainer();				// Kontener wschodni z polem tekstowym wyswietlajacym informacje dla uzytkownika
	
	private int[] hornCommand = {0xAB, 0x33, 0x31, 0xAC};					// Komenda klaksonu
	
	public void drive() {
		engine.drive(centerContainer.getKeyState(), 100);					// Obsluga przyciskow kontenera srodkowego
		if(westContainer.getHornButtonState()) {							// Obsluga przycisku klaksonu
			StringBuilder string = new StringBuilder();
			string.append("Klakson --> ");
			for(int i = 0; i < hornCommand.length; i++)
			string.append(String.format("%X ", hornCommand[i]));
			string.append("\n");
			string.append( EastContainer.textArea.getText());
			EastContainer.textArea.setText(string.toString());
			if(myTCP.getConnectionToServerStatus())							// Jezeli polaczenie z serverem jest aktywne
			{
				for(int i = 0; i < hornCommand.length; i++)
					myTCP.sendToServer(hornCommand[i]);
			}
			
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
	
	public FirstTab() {
		JPanel panel = new JPanel(false);			// Tworzymy JPanel aby umiescic w nim wsszystkie elementy, ktore beda w zakladce
		panel.setLayout(new BorderLayout());
		panel.add(BorderLayout.NORTH, northContainer);
		panel.add(BorderLayout.CENTER, centerContainer);
		panel.add(BorderLayout.WEST, westContainer);
		panel.add(BorderLayout.EAST, eastContainer);
		
		setLayout(new BorderLayout());			// Ustawiamy Layout dla calego kontenera
		add(panel);								// Dodajemy panel do calego kontenera
	}

//	public static void main(String[] args) throws InterruptedException {
//		Main main = new Main();
//		main.setResizable(false);;
//		run(main, 600, 300);
//		while(true) {
//			main.drive();
//		}
//	}

}
