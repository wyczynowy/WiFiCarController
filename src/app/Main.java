package app;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import firstTabContent.FirstTab;
import secondTabContent.SecondTab;

import static util.SwingConsole.run;

public class Main extends JFrame {

	private static final long serialVersionUID = 8540441083051003178L;
	private String[] tabsNames = { "Jazda", "Ustawienia", "Inne"};
	private JTabbedPane tabs = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
	
	FirstTab ft = new FirstTab();
	
	public void drive() {
		ft.drive();
	}
	
	public Main() {
		tabs.addTab(tabsNames[0], new FirstTab());
		tabs.addTab(tabsNames[1], new SecondTab());
		tabs.addTab(tabsNames[2], new JLabel("Empty"));
		add(tabs);
	}

	public static void main(String[] args) throws InterruptedException {
	try {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	} catch (Exception e) {
		throw new RuntimeException();
	}
//    UIManager.put("swing.boldMetal", Boolean.FALSE);	//Turn off metal's use of bold fonts  
	Main main = new Main();
	main.setResizable(false);
	
	run(main, 600, 350);
	while(true) {
		main.drive();
	}
}

}
