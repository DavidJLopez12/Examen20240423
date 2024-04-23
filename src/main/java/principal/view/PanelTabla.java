package principal.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import principal.controllers.ControladorContrato;
import principal.controllers.DatosDeTabla;
import principal.entities.Contrato;
import javax.swing.JSplitPane;


public class PanelTabla extends JPanel {

	private static final long serialVersionUID = 1L;
	public static PanelTabla instance = null;

	private DefaultTableModel dtm = null;
	private Object datosEnTabla[][] = DatosDeTabla.getDatosDeTabla();
	private String titulosEnTabla[] = DatosDeTabla.getTitulosColumnas();
	private JTable table;
	
	public PanelTabla () {
		setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(splitPane, BorderLayout.CENTER);
		
		this.dtm = getDefaultTableModelNoEditable();
		table = new JTable(dtm);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int indiceFilaSel = table.getSelectedRow();
			}
		});
		
		JScrollPane scrollpane = new JScrollPane(table);
		splitPane.setLeftComponent(scrollpane);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			int indiceFila = table.getSelectedRow();
			Object value = datosEnTabla[indiceFila][0];
			Contrato c = ControladorContrato.getInstance().obtenerContratoPorId((Integer)value);
			PanelBankonter panelbankonter = new PanelBankonter(c);
			JScrollPane scrollpane2 = new JScrollPane(panelbankonter);
			splitPane.setRightComponent(scrollpane2);
		}
		});
		
		this.setLayout(new BorderLayout());
		add(splitPane, BorderLayout.CENTER);
		
		
		
		
	}
	
	
	
	public Object[][] getDatosEnTabla() {
		return datosEnTabla;
	}



	public void setDatosEnTabla(Object[][] datosEnTabla) {
		this.datosEnTabla = datosEnTabla;
	}



	private DefaultTableModel getDefaultTableModelNoEditable () {
		DefaultTableModel dtm = new DefaultTableModel(datosEnTabla, titulosEnTabla) {
			
			/**
			 * La sobreescritura de este método nos permite controlar qué celdas queremos que sean editables
			 */
			@Override
			public boolean isCellEditable(int row, int column) {
				if (column != 1) {
					return false;
				}
				return true;
			}
		};
		return dtm;
	}
	
	public static PanelTabla getInstance() {
		if (instance == null) {
			instance = new PanelTabla();
		}
		return instance;
	}
	
	
	
	

	
}
