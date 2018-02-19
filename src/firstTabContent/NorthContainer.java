package firstTabContent;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import util.MyTCP;

public class NorthContainer extends Container{
	private static final long serialVersionUID = -4191601309796984085L;

	private JTextField ipTextField = new JTextField(8);					// Pole tekstowe dla adresu ip
	private JTextField portTextField = new JTextField(3);				// Pole tekstowe dla portu
	private JToggleButton connectButton = new JToggleButton("Connect");	// Przycisk podlaczajacy do servera
	private JLabel text1Label = new JLabel("disconnected");				// Etykieta z informacjami o stanie polaczenia z serverem
	private MyTCP tcp;													// Obiekt za pomoca ktorego laczymy sie z tcp
	
	private ActionListener connectButtonListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(connectButton.isSelected()) {
				text1Label.setText("connecting");
				tcp.connectToServer(ipTextField.getText(), Integer.parseInt(portTextField.getText()));
				if(tcp.getConnectionToServerStatus()) text1Label.setText("connected");
				else {
					text1Label.setText("disconnected");
					connectButton.setSelected(false);
				}
			}
				
			if(!connectButton.isSelected()) {
				tcp.closeConnectionWithServer();
				if(!tcp.getConnectionToServerStatus())
					text1Label.setText("disconnected");
				else
					text1Label.setText("connection Error");
			}
				
			
		}
	};
	
	public NorthContainer(MyTCP myTCP) {
		tcp = myTCP;
		connectButton.addActionListener(connectButtonListener);
		ipTextField.setText("192.168.0.100");
		portTextField.setText("123");
		Box b = Box.createHorizontalBox();
		b.add(new JLabel("IP: "));
		b.add(Box.createRigidArea(new Dimension(10, 0)));
		b.add(ipTextField);
		b.add(Box.createRigidArea(new Dimension(10, 0)));
		b.add(new JLabel("port: "));
		b.add(Box.createRigidArea(new Dimension(10, 0)));
		b.add(portTextField);
		b.add(Box.createRigidArea(new Dimension(10, 0)));
		b.add(connectButton);
		b.add(Box.createRigidArea(new Dimension(10, 0)));
		b.add(text1Label);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(b);
	}
}
