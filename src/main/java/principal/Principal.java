package principal;

import javax.swing.JFrame;

import principal.view.PanelBankonter;
import principal.view.PanelTabla;

public class Principal extends JFrame {

	static Principal instance = null;
	public static Principal getInstance() {
		if (instance == null) {
			instance = new Principal();
		}
		return instance;
	}
	
	public Principal() {
		super("JPA");
		this.setBounds(0,0,800,600);
		PanelTabla panel = PanelTabla.getInstance();
		this.getContentPane().add(panel);
	}
	
	public static void main(String[] args) {

		Principal.getInstance().setVisible(true);

	}

}
