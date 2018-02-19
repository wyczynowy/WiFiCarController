package firstTabContent;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import net.miginfocom.swing.*;;

public class EastContainer extends Container {

	private static final long serialVersionUID = 1980077510863712489L;
	
	public static JTextArea textArea = new JTextArea(15, 40);
	
	public EastContainer() {
		
		textArea.setMaximumSize(new Dimension(150, 150));
		
		setLayout(new MigLayout()); 
	    add(new JLabel("KONSOLA:"), "center align, wrap");
	    add(new JLabel(""), "center align, wrap");
	    add(new JScrollPane(textArea), "center align, gapleft 10, gapright 10, wrap");
	    add(new JLabel(""), "center align, wrap 10"); 
		
	}

}
