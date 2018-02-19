package secondTabContent;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static util.TextFile.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class SecondTabCenterContainer extends Container {

	private static final long serialVersionUID = 6489750528379607693L;
	
	String fileName = "Commands.txt";
	
	public static String[] getCommand(String commandName, String file) {
		int startOfCommand = file.indexOf(commandName) + commandName.length();
		int endOfCommand = file.indexOf("\"", startOfCommand);
		return file.substring(startOfCommand, endOfCommand ).split(" ");

	}
	
	private String[] labelNames = {"Jazda do przodu", "Jazda do przodu i w prawo", "Jazda w prawo", "Jazda do tylu i w prawo", "Jazda do tylu", 
								   "Jazda do tylu i w lewo", "Jazda w lewo", "Jazda do przodu i w lewo", "Jazda do przodu w prawo na recznym", 
								   "Jazda do przodu w lewo na recznym",
								   "Swiatlo - lewy przod", "Swiatlo - prawy przod", "Swiatlo - lewy tyl", "Swiatlo - prawy tyl", "Klakson",
								   "Predkosc 10%", "Predkosc 20%", "Predkosc 30%", "Predkosc 40%", "Predkosc 50%", "Predkosc 60%",
								   "Predkosc 70%", "Predkosc 80%", "Predkosc 90%", "Predkosc 100%"};

	public static JTextField[] forwardCommandTextFields;
	public static JTextField[] forwardRightCommandTextFields = new JTextField[4];
	public static JTextField[] rightCommandTextFields = new JTextField[4];
	public static JTextField[] backwardRightCommandTextFields = new JTextField[4];
	public static JTextField[] backwardCommandTextFields = new JTextField[4];
	public static JTextField[] backwardLeftCommandTextFields = new JTextField[4];
	public static JTextField[] leftCommandTextFields = new JTextField[4];
	public static JTextField[] forwardLeftCommandTextFields = new JTextField[4];
	public static JTextField[] forwardRightOnHandbrakeCommandTextFields = new JTextField[4];
	public static JTextField[] forwardLeftOnHandbrakeCommandTextFields = new JTextField[4];
	public static JTextField[] forwardLeftLightCommandTextFields = new JTextField[4];
	public static JTextField[] forwardRightLightCommandTextFields = new JTextField[4];
	public static JTextField[] backwardLeftLightCommandTextFields = new JTextField[4];
	public static JTextField[] backwardRightLightCommandTextFields = new JTextField[4];
	public static JTextField[] hornCommandTextFields = new JTextField[4];
	public static JTextField[] speed10CommandTextFields = new JTextField[7];
	public static JTextField[] speed20CommandTextFields = new JTextField[7];
	public static JTextField[] speed30CommandTextFields = new JTextField[7];
	public static JTextField[] speed40CommandTextFields = new JTextField[7];
	public static JTextField[] speed50CommandTextFields = new JTextField[7];
	public static JTextField[] speed60CommandTextFields = new JTextField[7];
	public static JTextField[] speed70CommandTextFields = new JTextField[7];
	public static JTextField[] speed80CommandTextFields = new JTextField[7];
	public static JTextField[] speed90CommandTextFields = new JTextField[7];
	public static JTextField[] speed100CommandTextFields = new JTextField[7];
	
	private JButton saveChangesButton = new JButton("Save changes");
	
	public SecondTabCenterContainer() {
		
		setLayout(new MigLayout());		// Ustawiamy Layout dla kontenera
		
		add(new JLabel("DEFINICJA KOMEND:   (tylko wartości hexadecymalne)"), "wrap");
		add(new JLabel(" "),  "wrap");
		
		// JAZDA DO PRZODU
		add(new JLabel(labelNames[0]));																				// Dodajemy etykiete							
		forwardCommandTextFields = new JTextField[getCommand(labelNames[0] + ": \"", read(fileName)).length];		// Inicjalizacja
		for(int i = 0; i < forwardCommandTextFields.length; i++) {													// Dla kazdej referencji
			forwardCommandTextFields[i] = new JTextField(2);														// Utworz nowy obkiekt
			forwardCommandTextFields[i].setText(getCommand(labelNames[0] + ": \"", read(fileName))[i]);				// Wpisz w pole odpowiednie dane
			if (i == forwardCommandTextFields.length - 1)															// Jezeli jest to ostatnie pole
				add(forwardCommandTextFields[i], "wrap");															// To dodajemy i zawijamy wiersz
			else																									// Jezeli nie
				add(forwardCommandTextFields[i]);																	// To dodajemy w tym samym wierszu
		}

		// JAZDA DO PRZODU I W PRAWO
		add(new JLabel(labelNames[1]));
		forwardRightCommandTextFields = new JTextField[getCommand(labelNames[1] + ": \"", read(fileName)).length];		// Inicjalizacja
		for(int i = 0; i < forwardRightCommandTextFields.length; i++) {
			forwardRightCommandTextFields[i] = new JTextField(2);
			forwardRightCommandTextFields[i].setText(getCommand(labelNames[1] + ": \"", read(fileName))[i]);
			if (i == forwardRightCommandTextFields.length - 1)
				add(forwardRightCommandTextFields[i], "wrap");
			else
				add(forwardRightCommandTextFields[i]);
		}
		
		// JAZDA W PRAWO
		add(new JLabel(labelNames[2]));
		rightCommandTextFields = new JTextField[getCommand(labelNames[2] + ": \"", read(fileName)).length];		// Inicjalizacja
		for(int i = 0; i < rightCommandTextFields.length; i++) {
			rightCommandTextFields[i] = new JTextField(2);
			rightCommandTextFields[i].setText(getCommand(labelNames[2] + ": \"", read(fileName))[i]);
			if (i == rightCommandTextFields.length - 1)
				add(rightCommandTextFields[i], "wrap");
			else
				add(rightCommandTextFields[i]);
		}
		
		// JAZDA DO TYLU I W PRAWO
		add(new JLabel(labelNames[3]));
		backwardRightCommandTextFields = new JTextField[getCommand(labelNames[3] + ": \"", read(fileName)).length];		// Inicjalizacja
		for(int i = 0; i < backwardRightCommandTextFields.length; i++) {
			backwardRightCommandTextFields[i] = new JTextField(2);
			backwardRightCommandTextFields[i].setText(getCommand(labelNames[3] + ": \"", read(fileName))[i]);
			if (i == backwardRightCommandTextFields.length - 1)
				add(backwardRightCommandTextFields[i], "wrap");
			else
				add(backwardRightCommandTextFields[i]);
		}
		
		// JAZDA DO TYLU
		add(new JLabel(labelNames[4]));
		backwardCommandTextFields = new JTextField[getCommand(labelNames[4] + ": \"", read(fileName)).length];		// Inicjalizacja
		for(int i = 0; i < backwardCommandTextFields.length; i++) {
			backwardCommandTextFields[i] = new JTextField(2);
			backwardCommandTextFields[i].setText(getCommand(labelNames[4] + ": \"", read(fileName))[i]);
			if (i == backwardCommandTextFields.length - 1)
				add(backwardCommandTextFields[i], "wrap");
			else
				add(backwardCommandTextFields[i]);
		}
		
		// JAZDA DO TYLU I W LEWO
		add(new JLabel(labelNames[5]));
		backwardLeftCommandTextFields = new JTextField[getCommand(labelNames[5] + ": \"", read(fileName)).length];		// Inicjalizacja
		for(int i = 0; i < backwardLeftCommandTextFields.length; i++) {
			backwardLeftCommandTextFields[i] = new JTextField(2);
			backwardLeftCommandTextFields[i].setText(getCommand(labelNames[5] + ": \"", read(fileName))[i]);
			if (i == backwardLeftCommandTextFields.length - 1)
				add(backwardLeftCommandTextFields[i], "wrap");
			else
				add(backwardLeftCommandTextFields[i]);
		}
		
		// JAZDA W LEWO
		add(new JLabel(labelNames[6]));
		leftCommandTextFields = new JTextField[getCommand(labelNames[6] + ": \"", read(fileName)).length];		// Inicjalizacja
		for(int i = 0; i < leftCommandTextFields.length; i++) {
			leftCommandTextFields[i] = new JTextField(2);
			leftCommandTextFields[i].setText(getCommand(labelNames[6] + ": \"", read(fileName))[i]);
			if (i == leftCommandTextFields.length - 1)
				add(leftCommandTextFields[i], "wrap");
			else
				add(leftCommandTextFields[i]);
		}
		
		// JAZDA DO PRZODU I W LEWO
		add(new JLabel(labelNames[7]));
		forwardLeftCommandTextFields = new JTextField[getCommand(labelNames[7] + ": \"", read(fileName)).length];		// Inicjalizacja
		for(int i = 0; i < forwardLeftCommandTextFields.length; i++) {
			forwardLeftCommandTextFields[i] = new JTextField(2);
			forwardLeftCommandTextFields[i].setText(getCommand(labelNames[7] + ": \"", read(fileName))[i]);
			if (i == forwardLeftCommandTextFields.length - 1)
				add(forwardLeftCommandTextFields[i], "wrap");
			else
				add(forwardLeftCommandTextFields[i]);
		}
		
		// JAZDA DO PRZODU W PRAWO NA RECZNYM
		add(new JLabel(labelNames[8]));
		forwardRightOnHandbrakeCommandTextFields = new JTextField[getCommand(labelNames[8] + ": \"", read(fileName)).length];		// Inicjalizacja
		for(int i = 0; i < forwardRightOnHandbrakeCommandTextFields.length; i++) {
			forwardRightOnHandbrakeCommandTextFields[i] = new JTextField(2);
			forwardRightOnHandbrakeCommandTextFields[i].setText(getCommand(labelNames[8] + ": \"", read(fileName))[i]);
			if (i == forwardRightOnHandbrakeCommandTextFields.length - 1)
				add(forwardRightOnHandbrakeCommandTextFields[i], "wrap");
			else
				add(forwardRightOnHandbrakeCommandTextFields[i]);
		}
		
		// JAZDA DO PRZODU W LEWO NA RECZNYM
		add(new JLabel(labelNames[9]));
		forwardLeftOnHandbrakeCommandTextFields = new JTextField[getCommand(labelNames[9] + ": \"", read(fileName)).length];		// Inicjalizacja
		for(int i = 0; i < forwardLeftOnHandbrakeCommandTextFields.length; i++) {
			forwardLeftOnHandbrakeCommandTextFields[i] = new JTextField(2);
			forwardLeftOnHandbrakeCommandTextFields[i].setText(getCommand(labelNames[9] + ": \"", read(fileName))[i]);
			if (i == forwardLeftOnHandbrakeCommandTextFields.length - 1)
				add(forwardLeftOnHandbrakeCommandTextFields[i], "wrap");
			else
				add(forwardLeftOnHandbrakeCommandTextFields[i]);
		}
		
		// SWIATLO PRZOD LEWY
		add(new JLabel(labelNames[10]));
		forwardLeftLightCommandTextFields = new JTextField[getCommand(labelNames[10] + ": \"", read(fileName)).length];		// Inicjalizacja
		for(int i = 0; i < forwardLeftLightCommandTextFields.length; i++) {
			forwardLeftLightCommandTextFields[i] = new JTextField(2);
			forwardLeftLightCommandTextFields[i].setText(getCommand(labelNames[10] + ": \"", read(fileName))[i]);
			if (i == forwardLeftLightCommandTextFields.length - 1)
				add(forwardLeftLightCommandTextFields[i], "wrap");
			else
				add(forwardLeftLightCommandTextFields[i]);
		}
		
		// SWIATLO PRZOD PRAWY
		add(new JLabel(labelNames[11]));
		forwardRightLightCommandTextFields = new JTextField[getCommand(labelNames[11] + ": \"", read(fileName)).length];		// Inicjalizacja
		for(int i = 0; i < forwardRightLightCommandTextFields.length; i++) {
			forwardRightLightCommandTextFields[i] = new JTextField(2);
			forwardRightLightCommandTextFields[i].setText(getCommand(labelNames[11] + ": \"", read(fileName))[i]);
			if (i == forwardRightLightCommandTextFields.length - 1)
				add(forwardRightLightCommandTextFields[i], "wrap");
			else
				add(forwardRightLightCommandTextFields[i]);
		}
		
		// SWIATLO TYL LEWY
		add(new JLabel(labelNames[12]));
		backwardLeftLightCommandTextFields = new JTextField[getCommand(labelNames[12] + ": \"", read(fileName)).length];		// Inicjalizacja
		for(int i = 0; i < backwardLeftLightCommandTextFields.length; i++) {
			backwardLeftLightCommandTextFields[i] = new JTextField(2);
			backwardLeftLightCommandTextFields[i].setText(getCommand(labelNames[12] + ": \"", read(fileName))[i]);
			if (i == backwardLeftLightCommandTextFields.length - 1)
				add(backwardLeftLightCommandTextFields[i], "wrap");
			else
				add(backwardLeftLightCommandTextFields[i]);
		}
		
		// SWIATLO TYL PRAWY
		add(new JLabel(labelNames[13]));
		backwardRightLightCommandTextFields = new JTextField[getCommand(labelNames[13] + ": \"", read(fileName)).length];		// Inicjalizacja
		for(int i = 0; i < backwardRightLightCommandTextFields.length; i++) {
			backwardRightLightCommandTextFields[i] = new JTextField(2);
			backwardRightLightCommandTextFields[i].setText(getCommand(labelNames[13] + ": \"", read(fileName))[i]);
			if (i == backwardRightLightCommandTextFields.length - 1)
				add(backwardRightLightCommandTextFields[i], "wrap");
			else
				add(backwardRightLightCommandTextFields[i]);
		}
		
		// KLAKSON
		add(new JLabel(labelNames[14]));
		hornCommandTextFields = new JTextField[getCommand(labelNames[14] + ": \"", read(fileName)).length];		// Inicjalizacja
		for(int i = 0; i < hornCommandTextFields.length; i++) {
			hornCommandTextFields[i] = new JTextField(2);
			hornCommandTextFields[i].setText(getCommand(labelNames[14] + ": \"", read(fileName))[i]);
			if (i == hornCommandTextFields.length - 1)
				add(hornCommandTextFields[i], "wrap");
			else
				add(hornCommandTextFields[i]);
		}
		
		// PREDKOSC 10%
		add(new JLabel(labelNames[15]));
		speed10CommandTextFields = new JTextField[getCommand(labelNames[15] + ": \"", read(fileName)).length];		// Inicjalizacja
		for(int i = 0; i < speed10CommandTextFields.length; i++) {
			speed10CommandTextFields[i] = new JTextField(2);
			speed10CommandTextFields[i].setText(getCommand(labelNames[15] + ": \"", read(fileName))[i]);
			if (i == speed10CommandTextFields.length - 1)
				add(speed10CommandTextFields[i], "wrap");
			else
				add(speed10CommandTextFields[i]);
		}
		
		// PREDKOSC 20%
		add(new JLabel(labelNames[16]));
		speed20CommandTextFields = new JTextField[getCommand(labelNames[16] + ": \"", read(fileName)).length];		// Inicjalizacja
		for(int i = 0; i < speed20CommandTextFields.length; i++) {
			speed20CommandTextFields[i] = new JTextField(2);
			speed20CommandTextFields[i].setText(getCommand(labelNames[16] + ": \"", read(fileName))[i]);
			if (i == speed20CommandTextFields.length - 1)
				add(speed20CommandTextFields[i], "wrap");
			else
				add(speed20CommandTextFields[i]);
		}
		
		// PREDKOSC 30%
		add(new JLabel(labelNames[17]));
		speed30CommandTextFields = new JTextField[getCommand(labelNames[17] + ": \"", read(fileName)).length];		// Inicjalizacja
		for(int i = 0; i < speed30CommandTextFields.length; i++) {
			speed30CommandTextFields[i] = new JTextField(2);
			speed30CommandTextFields[i].setText(getCommand(labelNames[17] + ": \"", read(fileName))[i]);
			if (i == speed30CommandTextFields.length - 1)
				add(speed30CommandTextFields[i], "wrap");
			else
				add(speed30CommandTextFields[i]);
		}
		
		// PREDKOSC 40%
		add(new JLabel(labelNames[18]));
		speed40CommandTextFields = new JTextField[getCommand(labelNames[18] + ": \"", read(fileName)).length];		// Inicjalizacja
		for(int i = 0; i < speed40CommandTextFields.length; i++) {
			speed40CommandTextFields[i] = new JTextField(2);
			speed40CommandTextFields[i].setText(getCommand(labelNames[18] + ": \"", read(fileName))[i]);
			if (i == speed40CommandTextFields.length - 1)
				add(speed40CommandTextFields[i], "wrap");
			else
				add(speed40CommandTextFields[i]);
		}
		
		// PREDKOSC 50%
		add(new JLabel(labelNames[19]));
		speed50CommandTextFields = new JTextField[getCommand(labelNames[19] + ": \"", read(fileName)).length];		// Inicjalizacja
		for(int i = 0; i < speed50CommandTextFields.length; i++) {
			speed50CommandTextFields[i] = new JTextField(2);
			speed50CommandTextFields[i].setText(getCommand(labelNames[19] + ": \"", read(fileName))[i]);
			if (i == speed50CommandTextFields.length - 1)
				add(speed50CommandTextFields[i], "wrap");
			else
				add(speed50CommandTextFields[i]);
		}
		
		// PREDKOSC 60%
		add(new JLabel(labelNames[20]));
		speed60CommandTextFields = new JTextField[getCommand(labelNames[20] + ": \"", read(fileName)).length];		// Inicjalizacja
		for(int i = 0; i < speed60CommandTextFields.length; i++) {
			speed60CommandTextFields[i] = new JTextField(2);
			speed60CommandTextFields[i].setText(getCommand(labelNames[20] + ": \"", read(fileName))[i]);
			if (i == speed60CommandTextFields.length - 1)
				add(speed60CommandTextFields[i], "wrap");
			else
				add(speed60CommandTextFields[i]);
		}
		
		// PREDKOSC 70%
		add(new JLabel(labelNames[21]));
		speed70CommandTextFields = new JTextField[getCommand(labelNames[21] + ": \"", read(fileName)).length];		// Inicjalizacja
		for(int i = 0; i < speed70CommandTextFields.length; i++) {
			speed70CommandTextFields[i] = new JTextField(2);
			speed70CommandTextFields[i].setText(getCommand(labelNames[21] + ": \"", read(fileName))[i]);
			if (i == speed70CommandTextFields.length - 1)
				add(speed70CommandTextFields[i], "wrap");
			else
				add(speed70CommandTextFields[i]);
		}
		
		// PREDKOSC 80%
		add(new JLabel(labelNames[22]));
		speed80CommandTextFields = new JTextField[getCommand(labelNames[22] + ": \"", read(fileName)).length];		// Inicjalizacja
		for(int i = 0; i < speed80CommandTextFields.length; i++) {
			speed80CommandTextFields[i] = new JTextField(2);
			speed80CommandTextFields[i].setText(getCommand(labelNames[22] + ": \"", read(fileName))[i]);
			if (i == speed80CommandTextFields.length - 1)
				add(speed80CommandTextFields[i], "wrap");
			else
				add(speed80CommandTextFields[i]);
		}
		
		// PREDKOSC 90%
		add(new JLabel(labelNames[23]));
		speed90CommandTextFields = new JTextField[getCommand(labelNames[23] + ": \"", read(fileName)).length];		// Inicjalizacja
		for(int i = 0; i < speed90CommandTextFields.length; i++) {
			speed90CommandTextFields[i] = new JTextField(2);
			speed90CommandTextFields[i].setText(getCommand(labelNames[23] + ": \"", read(fileName))[i]);
			if (i == speed90CommandTextFields.length - 1)
				add(speed90CommandTextFields[i], "wrap");
			else
				add(speed90CommandTextFields[i]);
		}
		
		// PREDKOSC 100%
		add(new JLabel(labelNames[24]));
		speed100CommandTextFields = new JTextField[getCommand(labelNames[24] + ": \"", read(fileName)).length];		// Inicjalizacja
		for(int i = 0; i < speed100CommandTextFields.length; i++) {
			speed100CommandTextFields[i] = new JTextField(2);
			speed100CommandTextFields[i].setText(getCommand(labelNames[24] + ": \"", read(fileName))[i]);
			if (i == speed100CommandTextFields.length - 1)
				add(speed100CommandTextFields[i], "wrap");
			else
				add(speed100CommandTextFields[i]);
		}
		
		add(new JLabel(" "), "wrap");
		saveChangesButton.addActionListener(saveChangesButtonListener);
		add(saveChangesButton, "wrap");
	}
	
	// ZAPIS DANYCH DO PLIKU
	private ActionListener saveChangesButtonListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			StringBuffer sb = new StringBuffer();
			
			// Jazda do przodu
			sb.append(labelNames[0] + ": \"");
			for(JTextField tf : forwardCommandTextFields) {
				sb.append(tf.getText());
				sb.append(" ");
			}
			sb.delete(sb.length() - 1, sb.length());
			sb.append("\"\r\n");
			
			// Jazda do przodu i w prawo
			sb.append(labelNames[1] + ": \"");
			for(JTextField tf : forwardRightCommandTextFields) {
				sb.append(tf.getText());
				sb.append(" ");
			}
			sb.delete(sb.length() - 1, sb.length());
			sb.append("\"\r\n");
			
			// Jazda w prawo
			sb.append(labelNames[2] + ": \"");
			for(JTextField tf : rightCommandTextFields) {
				sb.append(tf.getText());
				sb.append(" ");
			}
			sb.delete(sb.length() - 1, sb.length());
			sb.append("\"\r\n");
			
			// Jazda do tylu i w prawo
			sb.append(labelNames[3] + ": \"");
			for(JTextField tf : backwardRightCommandTextFields) {
				sb.append(tf.getText());
				sb.append(" ");
			}
			sb.delete(sb.length() - 1, sb.length());
			sb.append("\"\r\n");
			
			// Jazda do tylu
			sb.append(labelNames[4] + ": \"");
			for(JTextField tf : backwardCommandTextFields) {
				sb.append(tf.getText());
				sb.append(" ");
			}
			sb.delete(sb.length() - 1, sb.length());
			sb.append("\"\r\n");
			
			// Jazda do tylu i w lewo
			sb.append(labelNames[5] + ": \"");
			for(JTextField tf : backwardLeftCommandTextFields) {
				sb.append(tf.getText());
				sb.append(" ");
			}
			sb.delete(sb.length() - 1, sb.length());
			sb.append("\"\r\n");
			
			// Jazda w lewo
			sb.append(labelNames[6] + ": \"");
			for(JTextField tf : leftCommandTextFields) {
				sb.append(tf.getText());
				sb.append(" ");
			}
			sb.delete(sb.length() - 1, sb.length());
			sb.append("\"\r\n");
			
			// Jazda do przodu i w lewo
			sb.append(labelNames[7] + ": \"");
			for(JTextField tf : forwardLeftCommandTextFields) {
				sb.append(tf.getText());
				sb.append(" ");
			}
			sb.delete(sb.length() - 1, sb.length());
			sb.append("\"\r\n");
			
			// Jazda do przodu w prawo na recznym
			sb.append(labelNames[8] + ": \"");
			for(JTextField tf : forwardRightOnHandbrakeCommandTextFields) {
				sb.append(tf.getText());
				sb.append(" ");
			}
			sb.delete(sb.length() - 1, sb.length());
			sb.append("\"\r\n");
			
			// Jazda do przodu w lewo na recznym
			sb.append(labelNames[9] + ": \"");
			for(JTextField tf : forwardLeftOnHandbrakeCommandTextFields) {
				sb.append(tf.getText());
				sb.append(" ");
			}
			sb.delete(sb.length() - 1, sb.length());
			sb.append("\"\r\n");
			
			// Swiatlo - lewy przod
			sb.append(labelNames[10] + ": \"");
			for(JTextField tf : forwardLeftLightCommandTextFields) {
				sb.append(tf.getText());
				sb.append(" ");
			}
			sb.delete(sb.length() - 1, sb.length());
			sb.append("\"\r\n");
			
			// Swiatlo - prawy przod
			sb.append(labelNames[11] + ": \"");
			for(JTextField tf : forwardRightLightCommandTextFields) {
				sb.append(tf.getText());
				sb.append(" ");
			}
			sb.delete(sb.length() - 1, sb.length());
			sb.append("\"\r\n");
			
			// Swiatlo - lewy tyl
			sb.append(labelNames[12] + ": \"");
			for(JTextField tf : backwardLeftLightCommandTextFields) {
				sb.append(tf.getText());
				sb.append(" ");
			}
			sb.delete(sb.length() - 1, sb.length());
			sb.append("\"\r\n");
			
			// Swiatlo - prawy tyl
			sb.append(labelNames[13] + ": \"");
			for(JTextField tf : backwardRightLightCommandTextFields) {
				sb.append(tf.getText());
				sb.append(" ");
			}
			sb.delete(sb.length() - 1, sb.length());
			sb.append("\"\r\n");
			
			// Klakson
			sb.append(labelNames[14] + ": \"");
			for(JTextField tf : hornCommandTextFields) {
				sb.append(tf.getText());
				sb.append(" ");
			}
			sb.delete(sb.length() - 1, sb.length());
			sb.append("\"\r\n");
			
			// Predkosc 10%
			sb.append(labelNames[15] + ": \"");
			for(JTextField tf : speed10CommandTextFields) {
				sb.append(tf.getText());
				sb.append(" ");
			}
			sb.delete(sb.length() - 1, sb.length());
			sb.append("\"\r\n");
			
			// Predkosc 20%
			sb.append(labelNames[16] + ": \"");
			for(JTextField tf : speed20CommandTextFields) {
				sb.append(tf.getText());
				sb.append(" ");
			}
			sb.delete(sb.length() - 1, sb.length());
			sb.append("\"\r\n");
			
			// Predkosc 30%
			sb.append(labelNames[17] + ": \"");
			for(JTextField tf : speed30CommandTextFields) {
				sb.append(tf.getText());
				sb.append(" ");
			}
			sb.delete(sb.length() - 1, sb.length());
			sb.append("\"\r\n");
			
			// Predkosc 40%
			sb.append(labelNames[18] + ": \"");
			for(JTextField tf : speed40CommandTextFields) {
				sb.append(tf.getText());
				sb.append(" ");
			}
			sb.delete(sb.length() - 1, sb.length());
			sb.append("\"\r\n");
			
			// Predkosc 50%
			sb.append(labelNames[19] + ": \"");
			for(JTextField tf : speed50CommandTextFields) {
				sb.append(tf.getText());
				sb.append(" ");
			}
			sb.delete(sb.length() - 1, sb.length());
			sb.append("\"\r\n");
			
			// Predkosc 60%
			sb.append(labelNames[20] + ": \"");
			for(JTextField tf : speed60CommandTextFields) {
				sb.append(tf.getText());
				sb.append(" ");
			}
			sb.delete(sb.length() - 1, sb.length());
			sb.append("\"\r\n");
			
			// Predkosc 70%
			sb.append(labelNames[21] + ": \"");
			for(JTextField tf : speed70CommandTextFields) {
				sb.append(tf.getText());
				sb.append(" ");
			}
			sb.delete(sb.length() - 1, sb.length());
			sb.append("\"\r\n");
			
			// Predkosc 80%
			sb.append(labelNames[22] + ": \"");
			for(JTextField tf : speed80CommandTextFields) {
				sb.append(tf.getText());
				sb.append(" ");
			}
			sb.delete(sb.length() - 1, sb.length());
			sb.append("\"\r\n");
			
			// Predkosc 90%
			sb.append(labelNames[23] + ": \"");
			for(JTextField tf : speed90CommandTextFields) {
				sb.append(tf.getText());
				sb.append(" ");
			}
			sb.delete(sb.length() - 1, sb.length());
			sb.append("\"\r\n");
			
			// Predkosc 100%
			sb.append(labelNames[24] + ": \"");
			for(JTextField tf : speed100CommandTextFields) {
				sb.append(tf.getText());
				sb.append(" ");
			}
			sb.delete(sb.length() - 1, sb.length());
			sb.append("\"\r\n");
			
			write(fileName, sb.toString());
			
		}
	};

}
