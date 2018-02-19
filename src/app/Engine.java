package app;

import java.util.concurrent.TimeUnit;

import javax.swing.JTextField;

import firstTabContent.EastContainer;
import secondTabContent.SecondTabCenterContainer;
import util.MyTCP;

public class Engine {
	private MyTCP tcp;						// Obiekt za pomoca ktorego laczymy sie z tcp
	private enum KEYS {UP, RIGHT, DOWN, LEFT};
	
	public Engine(MyTCP myTCP) {
		tcp = myTCP;
	}
	
	public void drive(boolean[] driveState, int interval){
		// Jazda do przodu
		if ((driveState[KEYS.UP.ordinal()] == true) && (driveState[KEYS.RIGHT.ordinal()] == false)
				&& (driveState[KEYS.DOWN.ordinal()] == false) && (driveState[KEYS.LEFT.ordinal()] == false)) 
			goForward(interval);
		
		// Jazda w prawo
		else if ((driveState[KEYS.UP.ordinal()] == false) && (driveState[KEYS.RIGHT.ordinal()] == true)
				&& (driveState[KEYS.DOWN.ordinal()] == false) && (driveState[KEYS.LEFT.ordinal()] == false))
			goRight(interval);
		
		// Jazda do tylu
		else if ((driveState[KEYS.UP.ordinal()] == false) && (driveState[KEYS.RIGHT.ordinal()] == false)
				&& (driveState[KEYS.DOWN.ordinal()] == true) && (driveState[KEYS.LEFT.ordinal()] == false))
			goBackward(interval);
		
		// Jazda w lewo
		else if ((driveState[KEYS.UP.ordinal()] == false) && (driveState[KEYS.RIGHT.ordinal()] == false)
				&& (driveState[KEYS.DOWN.ordinal()] == false) && (driveState[KEYS.LEFT.ordinal()] == true))
			goLeft(interval);
		
		// Jazda do przodu i w prawo
		else if ((driveState[KEYS.UP.ordinal()] == true) && (driveState[KEYS.RIGHT.ordinal()] == true)
				&& (driveState[KEYS.DOWN.ordinal()] == false) && (driveState[KEYS.LEFT.ordinal()] == false))
			goForwardRight(interval);
		
		// Jazda do przodu i w lewo
		else if ((driveState[KEYS.UP.ordinal()] == true) && (driveState[KEYS.RIGHT.ordinal()] == false)
				&& (driveState[KEYS.DOWN.ordinal()] == false) && (driveState[KEYS.LEFT.ordinal()] == true))
			goForwardLeft(interval);
		
		// Jazda do tylu i w prawo
		else if ((driveState[KEYS.UP.ordinal()] == false) && (driveState[KEYS.RIGHT.ordinal()] == true)
				&& (driveState[KEYS.DOWN.ordinal()] == true) && (driveState[KEYS.LEFT.ordinal()] == false))
			goBackwardRight(interval);
		
		// Jazda do tylu i w lewo
		else if ((driveState[KEYS.UP.ordinal()] == false) && (driveState[KEYS.RIGHT.ordinal()] == false)
				&& (driveState[KEYS.DOWN.ordinal()] == true) && (driveState[KEYS.LEFT.ordinal()] == true))
			goBackwardLeft(interval);
		
		// Jazda do przodu w prawo na recznym
		else if ((driveState[KEYS.UP.ordinal()] == true) && (driveState[KEYS.RIGHT.ordinal()] == true)
				&& (driveState[KEYS.DOWN.ordinal()] == true) && (driveState[KEYS.LEFT.ordinal()] == false))
			goRightOnHandBrake(interval);
		
		// Jazda do przodu w lewona recznym
		else if ((driveState[KEYS.UP.ordinal()] == true) && (driveState[KEYS.RIGHT.ordinal()] == false)
				&& (driveState[KEYS.DOWN.ordinal()] == true) && (driveState[KEYS.LEFT.ordinal()] == true))
			goLeftOnHandBrake(interval);
	}

	public void goForward(int interval) {
		StringBuilder string = new StringBuilder();
		string.append("Do przodu --> ");
		for(JTextField tf : SecondTabCenterContainer.forwardCommandTextFields)
		string.append(tf.getText() + " ");
		string.append("\n");
		string.append( EastContainer.textArea.getText());
		EastContainer.textArea.setText(string.toString());
		if(tcp.getConnectionToServerStatus())	// Jezeli polaczenie z serverem jest aktywne
		{
			for(JTextField tf : SecondTabCenterContainer.forwardCommandTextFields) 
				tcp.sendToServer(Integer.parseInt(tf.getText(), 16));
		}

		try {
			TimeUnit.MILLISECONDS.sleep(interval);
		} catch (InterruptedException e) { e.printStackTrace(); }
	}

	void goForwardLeft(int interval) {
		StringBuilder string = new StringBuilder();
		string.append("Do przodu w lewo --> ");
		for(JTextField tf : SecondTabCenterContainer.forwardLeftCommandTextFields)
		string.append(tf.getText() + " ");
		string.append("\n");
		string.append( EastContainer.textArea.getText());
		EastContainer.textArea.setText(string.toString());
		if(tcp.getConnectionToServerStatus()) 	// Jezeli polaczenie z serverem jest aktywne
		{
			for(JTextField tf : SecondTabCenterContainer.forwardLeftCommandTextFields)
				tcp.sendToServer(Integer.parseInt(tf.getText(), 16));
		}
		try {
			TimeUnit.MILLISECONDS.sleep(interval);
		} catch (InterruptedException e) { e.printStackTrace(); }
	}

	void goForwardRight(int interval) {
		StringBuilder string = new StringBuilder();
		string.append("Do przodu w prawo --> ");
		for(JTextField tf : SecondTabCenterContainer.forwardRightCommandTextFields)
		string.append(tf.getText() + " ");
		string.append("\n");
		string.append( EastContainer.textArea.getText());
		EastContainer.textArea.setText(string.toString());
		if(tcp.getConnectionToServerStatus()) 	// Jezeli polaczenie z serverem jest aktywne
		{
			for(JTextField tf : SecondTabCenterContainer.forwardRightCommandTextFields	)
				tcp.sendToServer(Integer.parseInt(tf.getText(), 16));
		}
		try {
			TimeUnit.MILLISECONDS.sleep(interval);
		} catch (InterruptedException e) { e.printStackTrace(); }
	}

	void goBackward(int interval) {
		StringBuilder string = new StringBuilder();
		string.append("Do tyłu --> ");
		for(JTextField tf : SecondTabCenterContainer.backwardCommandTextFields)
		string.append(tf.getText() + " ");
		string.append("\n");
		string.append( EastContainer.textArea.getText());
		EastContainer.textArea.setText(string.toString());
		if(tcp.getConnectionToServerStatus()) 	// Jezeli polaczenie z serverem jest aktywne
		{
			for(JTextField tf : SecondTabCenterContainer.backwardCommandTextFields)
				tcp.sendToServer(Integer.parseInt(tf.getText(), 16));
		}
		try {
			TimeUnit.MILLISECONDS.sleep(interval);
		} catch (InterruptedException e) { e.printStackTrace(); }
	}

	void goBackwardLeft(int interval) {
		StringBuilder string = new StringBuilder();
		string.append("Do tyłu w lewo --> ");
		for(JTextField tf : SecondTabCenterContainer.backwardLeftCommandTextFields)
		string.append(tf.getText() + " ");
		string.append("\n");
		string.append( EastContainer.textArea.getText());
		EastContainer.textArea.setText(string.toString());
		if(tcp.getConnectionToServerStatus()) 	// Jezeli polaczenie z serverem jest aktywne
		{
			for(JTextField tf : SecondTabCenterContainer.backwardLeftCommandTextFields)
				tcp.sendToServer(Integer.parseInt(tf.getText(), 16));
		}
		try {
			TimeUnit.MILLISECONDS.sleep(interval);
		} catch (InterruptedException e) { e.printStackTrace(); }
	}

	void goBackwardRight(int interval) {
		StringBuilder string = new StringBuilder();
		string.append("Do tyłu w prawo --> ");
		for(JTextField tf : SecondTabCenterContainer.backwardRightCommandTextFields)
		string.append(tf.getText() + " ");
		string.append("\n");
		string.append( EastContainer.textArea.getText());
		EastContainer.textArea.setText(string.toString());
		if(tcp.getConnectionToServerStatus()) 	// Jezeli polaczenie z serverem jest aktywne
		{
			for(JTextField tf : SecondTabCenterContainer.backwardRightCommandTextFields)
				tcp.sendToServer(Integer.parseInt(tf.getText(), 16));
		}
		try {
			TimeUnit.MILLISECONDS.sleep(interval);
		} catch (InterruptedException e) { e.printStackTrace(); }
	}

//	void stop(int interval) {
//		System.out.println("STOP");
//		try {
//			TimeUnit.MILLISECONDS.sleep(interval);
//		} catch (InterruptedException e) { e.printStackTrace(); }
//	}

	void goLeft(int interval){
		StringBuilder string = new StringBuilder();
		string.append("W lewo --> ");
		for(JTextField tf : SecondTabCenterContainer.leftCommandTextFields)
		string.append(tf.getText() + " ");
		string.append("\n");
		string.append( EastContainer.textArea.getText());
		EastContainer.textArea.setText(string.toString());
		if(tcp.getConnectionToServerStatus()) 	// Jezeli polaczenie z serverem jest aktywne
		{
			for(JTextField tf : SecondTabCenterContainer.leftCommandTextFields)
				tcp.sendToServer(Integer.parseInt(tf.getText(), 16));
		}
		try {
			TimeUnit.MILLISECONDS.sleep(interval);
		} catch (InterruptedException e) { e.printStackTrace(); }
	}

	void goRight(int interval) {
		StringBuilder string = new StringBuilder();
		string.append("W prawo --> ");
		for(JTextField tf : SecondTabCenterContainer.rightCommandTextFields)
		string.append(tf.getText() + " ");
		string.append("\n");
		string.append( EastContainer.textArea.getText());
		EastContainer.textArea.setText(string.toString());
		if(tcp.getConnectionToServerStatus()) 	// Jezeli polaczenie z serverem jest aktywne
		{
			for(JTextField tf : SecondTabCenterContainer.rightCommandTextFields)
				tcp.sendToServer(Integer.parseInt(tf.getText(), 16));
		}
		try {
			TimeUnit.MILLISECONDS.sleep(interval);
		} catch (InterruptedException e) { e.printStackTrace(); }
	}

	void goLeftOnHandBrake(int interval) {
		StringBuilder string = new StringBuilder();
		string.append("W lewo na recznym ");
		for(JTextField tf : SecondTabCenterContainer.forwardLeftOnHandbrakeCommandTextFields)
		string.append(tf.getText() + " ");
		string.append("\n");
		string.append( EastContainer.textArea.getText());
		EastContainer.textArea.setText(string.toString());
		if(tcp.getConnectionToServerStatus()) 	// Jezeli polaczenie z serverem jest aktywne
		{
			for(JTextField tf : SecondTabCenterContainer.forwardLeftOnHandbrakeCommandTextFields)
				tcp.sendToServer(Integer.parseInt(tf.getText(), 16));
		}
		try {
			TimeUnit.MILLISECONDS.sleep(interval);
		} catch (InterruptedException e) { e.printStackTrace(); }
	}

	void goRightOnHandBrake(int interval) {
		StringBuilder string = new StringBuilder();
		string.append("W prawo na recznym ");
		for(JTextField tf : SecondTabCenterContainer.forwardRightOnHandbrakeCommandTextFields)
		string.append(tf.getText() + " ");
		string.append("\n");
		string.append( EastContainer.textArea.getText());
		EastContainer.textArea.setText(string.toString());
		if(tcp.getConnectionToServerStatus()) 	// Jezeli polaczenie z serverem jest aktywne
		{
			for(JTextField tf : SecondTabCenterContainer.forwardRightOnHandbrakeCommandTextFields)
				tcp.sendToServer(Integer.parseInt(tf.getText(), 16));
		}
		try {
			TimeUnit.MILLISECONDS.sleep(interval);
		} catch (InterruptedException e) { e.printStackTrace(); }
	}
}
