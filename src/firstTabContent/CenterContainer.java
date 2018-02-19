package firstTabContent;

import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;

public class CenterContainer extends Container {
	private static final long serialVersionUID = -2029020868084009307L;
	private JButton upButton = new JButton("Up");		// Przycisk jazdy do przodu
	private JButton downButton = new JButton("Down");	// Przycisk jazdy do tylu
	private JButton leftButton = new JButton("Left");	// Przycisk skretu kol w lewo
	private JButton rightButton = new JButton("Right");	// Przycisk skretu kow w prawo
	
	private enum KEYS {UP, RIGHT, DOWN, LEFT};
	private static boolean keyState[] = new boolean[4];		// Tablica ze stanami przyciskow jazdy (Up, Right, Down, Left)
	
	private MouseListener buttonMouseListener = new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// up Button
			if(upButton.equals(e.getSource())) 
				keyState[KEYS.UP.ordinal()] = false;
			 
			
			// down Button
			if(downButton.equals(e.getSource()))
				keyState[KEYS.DOWN.ordinal()] = false;
			
			// left Button
			if(leftButton.equals(e.getSource()))
				keyState[KEYS.LEFT.ordinal()] = false;
			
			// right Button
			if(rightButton.equals(e.getSource()))
				keyState[KEYS.RIGHT.ordinal()] = false;
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// up Button
			if(upButton.equals(e.getSource())) 
				keyState[KEYS.UP.ordinal()] = true;

			// down Button
			if(downButton.equals(e.getSource()))
				keyState[KEYS.DOWN.ordinal()] = true;
			
			// left Button
			if(leftButton.equals(e.getSource()))
				keyState[KEYS.LEFT.ordinal()] = true;
			
			// right Button
			if(rightButton.equals(e.getSource()))
				keyState[KEYS.RIGHT.ordinal()] = true;
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {}
		
		@Override
		public void mouseEntered(MouseEvent e) {}
		
		@Override
		public void mouseClicked(MouseEvent e) {}
	};
	
	private KeyListener buttonKeyListener = new KeyListener() {
		
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			// up Button
			if(e.getExtendedKeyCode() == 222) 
				keyState[KEYS.UP.ordinal()] = false;
				
			
			// down Button
			if(e.getExtendedKeyCode() == 47)
				keyState[KEYS.DOWN.ordinal()] = false;
			
			// left Button
			if(e.getExtendedKeyCode() == 90)
				keyState[KEYS.LEFT.ordinal()] = false;
			
			// right Button
			if(e.getExtendedKeyCode() == 88)
				keyState[KEYS.RIGHT.ordinal()] = false;
			
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			// up Button
			if(e.getExtendedKeyCode() == 222) 
				keyState[KEYS.UP.ordinal()] = true;
				
			
			// down Button
			if(e.getExtendedKeyCode() == 47)
				keyState[KEYS.DOWN.ordinal()] = true;
			
			// left Button
			if(e.getExtendedKeyCode() == 90)
				keyState[KEYS.LEFT.ordinal()] = true;
			
			// right Button
			if(e.getExtendedKeyCode() == 88)
				keyState[KEYS.RIGHT.ordinal()] = true;
		}
	};
	
	/**********************************************************************/
	//
	// 				FUNCTION RETURN KEY STATE
	//
	// 				@ return boolean[0] - up button state
	//						 boolean[1] - right button state
	//						 boolean[2] - down button state
	//						 boolean[3] - left button state
	//
	//						 true - button pressed
	//						 false - button released
	//
	/**********************************************************************/
	
	public boolean[] getKeyState() {
		return keyState;
	}
	
	/**********************************END*********************************/
	
	public CenterContainer() {
//		setLayout(new GridLayout(3,3));
		setLayout(new MigLayout("", 			// Layout constraints
								"[70:70:70]5[70:70:70]5[70:70:70]", 	// Column constraints [column sizes min:prefered:max]...
								"[70:70:70]5[70:70:70]5[70:70:70]"));	// Row constraints	  [row sizes min:pref:max]...
		
		upButton.addMouseListener(buttonMouseListener);	
		downButton.addMouseListener(buttonMouseListener);
		leftButton.addMouseListener(buttonMouseListener);
		rightButton.addMouseListener(buttonMouseListener);
		addKeyListener(buttonKeyListener);
		upButton.addKeyListener(buttonKeyListener);
		
		
		add(new JLabel());
		add(upButton, "center align, growx, growy");	// growx <-- wypelnia przestrzen w osi x, growy <-- wypelnia przestrzen w osi y
		add(new JLabel(), "wrap") ;						// wrap <-- przejscie do nastepnego wiersza
		add(leftButton, "center align, growx, growy");
		add(new JLabel());
		add(rightButton, "center align, growx, growy, wrap");
		add(new JLabel());
		add(downButton, "center align, growx, growy");
		add(new JLabel());
	}
	
}
