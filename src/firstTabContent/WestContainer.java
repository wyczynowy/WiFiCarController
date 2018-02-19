package firstTabContent;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;
import util.MyTCP;

public class WestContainer extends Container{
	
	private static final long serialVersionUID = 4404857593314943988L;
	
	private JCheckBox lightFrontLeft = new JCheckBox("Przód lewy");
	private JCheckBox lightFrontRight = new JCheckBox("Przód prawy");
	private JCheckBox lightRearLeft = new JCheckBox("Tył lewy");
	private JCheckBox lightRearRight = new JCheckBox("Tył prawy");
	private JButton hornButton = new JButton("Klakson");
	private JComboBox<String> comboBoxSpeedList = new JComboBox<String>();
	private String[] speedValues = {"10% Speed", "20% Speed", "30% Speed", "40% Speed", "50% Speed", 
								    "60% Speed", "70% Speed", "80% Speed", "90% Speed", "100% Speed", };
	private int[] speedCommand = {0xAB, 0x35, 0x30, 0x00, 0xAC};
	private MyTCP tcp;
	
	private static boolean hornButtonState = false;
	
	public boolean getHornButtonState() {
		return hornButtonState;
	}
	
	private ActionListener comboBoxSpeedListListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			StringBuilder string = new StringBuilder();
			string.append("Prędkość ");
			string.append(speedValues[comboBoxSpeedList.getSelectedIndex()].substring(0, 3));
			if(comboBoxSpeedList.getSelectedIndex() == 9)
				string.append("%");
			string.append(" --> ");
			for(int i = 0; i < speedCommand.length; i++) {
				if(i == 3) {
					if(comboBoxSpeedList.getSelectedIndex() < 9) {
						string.append("0");
						string.append(String.format("%X ", 0x00));                  
					}
						
					string.append(String.format("%X ", Integer.parseInt(speedValues[comboBoxSpeedList.getSelectedIndex()].substring(0, 1)) + 0X30));
					string.append(String.format("%X ", Integer.parseInt(speedValues[comboBoxSpeedList.getSelectedIndex()].substring(1, 2)) + 0X30));
					if(comboBoxSpeedList.getSelectedIndex() >= 9)
						string.append(String.format("%X ", Integer.parseInt(speedValues[comboBoxSpeedList.getSelectedIndex()].substring(2, 3)) + 0X30));

				}
				else
					string.append(String.format("%X ", speedCommand[i]));
			}	
			string.append("\n");
			string.append( EastContainer.textArea.getText());
			EastContainer.textArea.setText(string.toString());
			
			if(tcp.getConnectionToServerStatus())							// Jezeli polaczenie z serverem jest aktywne
			{
				for(int i = 0; i < speedCommand.length; i++) {
					if(i == 3) {
						if((comboBoxSpeedList.getSelectedIndex() + 1) * 25 < 100)
							tcp.sendToServer("0");
						tcp.sendToServer(String.valueOf((comboBoxSpeedList.getSelectedIndex() + 1) * 25));
					}
					else
						tcp.sendToServer(speedCommand[i]);
				}
					
			}
			
		}
	};
	
	private MouseListener hornButtonListener = new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {
			hornButtonState = !hornButtonState;
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			hornButtonState = !hornButtonState;
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}
		
	};
	
	private ActionListener lightButtonsListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(lightFrontLeft.equals(e.getSource())) {
				System.out.println("Przednie lewe światło");
				if(tcp.getConnectionToServerStatus()) {	// Jezeli polaczenie z serverem jest aktywne
					tcp.sendToServer(171);
					tcp.sendToServer("Przednie lewe światło");
					tcp.sendToServer(172);
					tcp.sendToServer('\n');
				}
			}
			
			if(lightFrontRight.equals(e.getSource())) {
				System.out.println("Przednie prawe światło");
				if(tcp.getConnectionToServerStatus()) {	// Jezeli polaczenie z serverem jest aktywne
					tcp.sendToServer(171);
					tcp.sendToServer("Przednie prawe światło");
					tcp.sendToServer(172);
					tcp.sendToServer('\n');
				}
			}
			
			if(lightRearLeft.equals(e.getSource())) {
				System.out.println("Tylne lewe światło");
				if(tcp.getConnectionToServerStatus()) {	// Jezeli polaczenie z serverem jest aktywne
					tcp.sendToServer(171);
					tcp.sendToServer("Tylne lewe światło");
					tcp.sendToServer(172);
					tcp.sendToServer('\n');
				}
			}
			
			if(lightRearRight.equals(e.getSource())) {
				System.out.println("Tylne prawe światło");
				if(tcp.getConnectionToServerStatus()) {	// Jezeli polaczenie z serverem jest aktywne
					tcp.sendToServer(171);
					tcp.sendToServer("Tylne prawe światło");
					tcp.sendToServer(172);
					tcp.sendToServer('\n');
				}
			}
				
		}
		
	};
	public WestContainer(MyTCP myTCP) {
		tcp = myTCP;
		
		lightFrontLeft.addActionListener(lightButtonsListener);
		lightFrontRight.addActionListener(lightButtonsListener);
		lightRearLeft.addActionListener(lightButtonsListener);
		lightRearRight.addActionListener(lightButtonsListener);
		hornButton.addMouseListener(hornButtonListener);
		
		for(String val : speedValues)
		comboBoxSpeedList.addItem(val);
		
		comboBoxSpeedList.addActionListener(comboBoxSpeedListListener);
		
		setLayout(new MigLayout("", "[]", "[]10[][][][]15[]10[]10[]"));
		
		add(new JLabel("OŚWIETLENIE:"), "wrap, center align");
		add(lightFrontLeft, "wrap");
		add(lightFrontRight, "wrap");
		add(lightRearLeft, "wrap");
		add(lightRearRight, "wrap");
		add(new JLabel("OPCJE DODATKOWE:"), "wrap, center align");
		add(comboBoxSpeedList, "wrap");
		add(hornButton, "wrap");
		
	}
}
