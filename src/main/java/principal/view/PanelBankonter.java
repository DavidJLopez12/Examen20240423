package principal.view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JTextField;

import principal.controllers.ControladorContrato;
import principal.controllers.ControladorUsuario;
import principal.controllers.DatosDeTabla;
import principal.entities.Contrato;
import principal.entities.Usuario;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelBankonter extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfId;
	private JTextField jtfDescripcion;
	private JTextField jtfSaldo;
	private JTextField jtfLimite;
	private JTextField jtfFirma;
	JRadioButton rdBancaria;
	JRadioButton rdCredito;
	JRadioButton rdDebito;
	JRadioButton rdPrestamo;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox <Usuario> jcbUsuario;

	/**
	 * Create the panel.
	 */
	public PanelBankonter(Contrato c) {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 65, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblGestionDeContratos = new JLabel("Gestion de contratos");
		GridBagConstraints gbc_lblGestionDeContratos = new GridBagConstraints();
		gbc_lblGestionDeContratos.insets = new Insets(0, 0, 5, 0);
		gbc_lblGestionDeContratos.gridwidth = 15;
		gbc_lblGestionDeContratos.gridx = 0;
		gbc_lblGestionDeContratos.gridy = 0;
		panel.add(lblGestionDeContratos, gbc_lblGestionDeContratos);
		
		JLabel lblId = new JLabel("Id:");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 1;
		panel.add(lblId, gbc_lblId);
		
		jtfId = new JTextField(c.getId());
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 5);
		gbc_jtfId.gridwidth = 13;
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		panel.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		rdBancaria = new JRadioButton("Cuenta Bancaria");
		buttonGroup.add(rdBancaria);
		rdBancaria.setSelected(true);
		GridBagConstraints gbc_rdBancaria = new GridBagConstraints();
		gbc_rdBancaria.insets = new Insets(0, 0, 5, 5);
		gbc_rdBancaria.gridx = 1;
		gbc_rdBancaria.gridy = 2;
		panel.add(rdBancaria, gbc_rdBancaria);
		
		rdCredito = new JRadioButton("Tarjeta Credito");
		buttonGroup.add(rdCredito);
		GridBagConstraints gbc_rdCredito = new GridBagConstraints();
		gbc_rdCredito.insets = new Insets(0, 0, 5, 5);
		gbc_rdCredito.gridx = 2;
		gbc_rdCredito.gridy = 2;
		panel.add(rdCredito, gbc_rdCredito);
		
		JLabel lblTipoDeContrato = new JLabel("Tipo de contrato:");
		GridBagConstraints gbc_lblTipoDeContrato = new GridBagConstraints();
		gbc_lblTipoDeContrato.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoDeContrato.gridx = 0;
		gbc_lblTipoDeContrato.gridy = 3;
		panel.add(lblTipoDeContrato, gbc_lblTipoDeContrato);
		
		rdDebito = new JRadioButton("Tarjeta Debito");
		buttonGroup.add(rdDebito);
		GridBagConstraints gbc_rdDebito = new GridBagConstraints();
		gbc_rdDebito.insets = new Insets(0, 0, 5, 5);
		gbc_rdDebito.gridx = 1;
		gbc_rdDebito.gridy = 3;
		panel.add(rdDebito, gbc_rdDebito);
		
		rdPrestamo = new JRadioButton("Prestamo");
		buttonGroup.add(rdPrestamo);
		GridBagConstraints gbc_rdPrestamo = new GridBagConstraints();
		gbc_rdPrestamo.insets = new Insets(0, 0, 5, 5);
		gbc_rdPrestamo.gridx = 2;
		gbc_rdPrestamo.gridy = 3;
		panel.add(rdPrestamo, gbc_rdPrestamo);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 0;
		gbc_lblDescripcion.gridy = 6;
		panel.add(lblDescripcion, gbc_lblDescripcion);
		
		jtfDescripcion = new JTextField(c.getDescripcion());
		GridBagConstraints gbc_jtfDescripcion = new GridBagConstraints();
		gbc_jtfDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDescripcion.gridwidth = 13;
		gbc_jtfDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDescripcion.gridx = 1;
		gbc_jtfDescripcion.gridy = 6;
		panel.add(jtfDescripcion, gbc_jtfDescripcion);
		jtfDescripcion.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 7;
		panel.add(lblUsuario, gbc_lblUsuario);
		
		jcbUsuario = new JComboBox();
		GridBagConstraints gbc_jcbUsuario = new GridBagConstraints();
		gbc_jcbUsuario.gridwidth = 6;
		gbc_jcbUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_jcbUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbUsuario.gridx = 1;
		gbc_jcbUsuario.gridy = 7;
		panel.add(jcbUsuario, gbc_jcbUsuario);
		
		JButton btnGestiona = new JButton("Gestionar Usuario");
		btnGestiona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestionUsuario();
			}
		});
		GridBagConstraints gbc_btnGestiona = new GridBagConstraints();
		gbc_btnGestiona.gridwidth = 8;
		gbc_btnGestiona.insets = new Insets(0, 0, 5, 0);
		gbc_btnGestiona.gridx = 7;
		gbc_btnGestiona.gridy = 7;
		panel.add(btnGestiona, gbc_btnGestiona);
		
		JLabel lblSaldo = new JLabel("Saldo:");
		GridBagConstraints gbc_lblSaldo = new GridBagConstraints();
		gbc_lblSaldo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSaldo.gridx = 0;
		gbc_lblSaldo.gridy = 8;
		panel.add(lblSaldo, gbc_lblSaldo);
		
		jtfSaldo = new JTextField(String.valueOf(c.getSaldo()));
		GridBagConstraints gbc_jtfSaldo = new GridBagConstraints();
		gbc_jtfSaldo.gridwidth = 13;
		gbc_jtfSaldo.insets = new Insets(0, 0, 5, 5);
		gbc_jtfSaldo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfSaldo.gridx = 1;
		gbc_jtfSaldo.gridy = 8;
		panel.add(jtfSaldo, gbc_jtfSaldo);
		jtfSaldo.setColumns(10);
		
		JLabel lblLimite = new JLabel("Limite:");
		GridBagConstraints gbc_lblLimite = new GridBagConstraints();
		gbc_lblLimite.insets = new Insets(0, 0, 5, 5);
		gbc_lblLimite.gridx = 0;
		gbc_lblLimite.gridy = 9;
		panel.add(lblLimite, gbc_lblLimite);
		
		jtfLimite = new JTextField(String.valueOf(c.getLimite()));
		GridBagConstraints gbc_jtfLimite = new GridBagConstraints();
		gbc_jtfLimite.gridwidth = 13;
		gbc_jtfLimite.insets = new Insets(0, 0, 5, 5);
		gbc_jtfLimite.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfLimite.gridx = 1;
		gbc_jtfLimite.gridy = 9;
		panel.add(jtfLimite, gbc_jtfLimite);
		jtfLimite.setColumns(10);
		
		JLabel lblFechafirma = new JLabel("FechaFirma:");
		GridBagConstraints gbc_lblFechafirma = new GridBagConstraints();
		gbc_lblFechafirma.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechafirma.gridx = 0;
		gbc_lblFechafirma.gridy = 10;
		panel.add(lblFechafirma, gbc_lblFechafirma);
		
		jtfFirma = new JTextField(dateToString(c.getFechaFirma()));
		GridBagConstraints gbc_jtfFirma = new GridBagConstraints();
		gbc_jtfFirma.insets = new Insets(0, 0, 5, 5);
		gbc_jtfFirma.gridwidth = 13;
		gbc_jtfFirma.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFirma.gridx = 1;
		gbc_jtfFirma.gridy = 10;
		panel.add(jtfFirma, gbc_jtfFirma);
		jtfFirma.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar(c);
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridwidth = 17;
		gbc_btnGuardar.gridx = 0;
		gbc_btnGuardar.gridy = 12;
		panel.add(btnGuardar, gbc_btnGuardar);
		cargarTodosUsuarios();
		
	}
	
	
	
	
	
	

	
	private void cargarTodosUsuarios() {
		List<Usuario> l = (List<Usuario>) new ControladorUsuario().getInstance().findAll();
        for (Usuario o : l) {
            this.jcbUsuario.addItem(o);
            
        }
	}
	
	public static String dateToString(Date fecha) {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    return sdf.format(fecha);
	}
	private void guardar(Contrato o) {
		if (isDescValida()) {
			if (esLimiteFloat()) {
				if (esSaldoFloat()) {
					o.setIdUsuario((int) this.jcbUsuario.getSelectedItem());
					o.setDescripcion(this.jtfDescripcion.getText());
					o.setSaldo(Float.valueOf(this.jtfSaldo.getText()));
					o.setLimite(Float.valueOf(this.jtfLimite.getText()));
					o.setFechaFirma(deStringADate(this.jtfFirma.getText()));
				}
				else {
					JOptionPane.showMessageDialog(null, "Error al guardar, la descripcion no es valida");
				}
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Error al guardar, el limite no es valido");
			}
		}
		else {
		}	
		
		if (rdBancaria.isSelected()) {
			o.setIdTipoContrato(1);
		}
		if (rdDebito.isSelected()) {
			o.setIdTipoContrato(2);
		}
		if (rdCredito.isSelected()) {
			o.setIdTipoContrato(3);
		}
		if (rdPrestamo.isSelected()) {
			o.setIdTipoContrato(4);
		}
		PanelTabla.getInstance().setDatosEnTabla(DatosDeTabla.getDatosDeTabla());	
		ControladorContrato.getInstance().update(o);
		JOptionPane.showMessageDialog(null, "Contrato guardado con exito");
	}	
	
	public static Date deStringADate(String texto) {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	 
	    try {
	        Date fecha = sdf.parse(texto);
	        return fecha; // Si la cadena se puede parsear como fecha, entonces tiene el formato correcto
	    } catch (ParseException e) {
	    	JOptionPane.showMessageDialog(null, "Error, la fecha no tiene un formato valido");
	        return null; // Si hay una excepción al parsear, significa que no tiene el formato correcto
	    }
	}
	
	
	public boolean esSaldoFloat() {
		try {
			Float.parseFloat(this.jtfSaldo.getText());
			return true;
	}
		catch (Exception ex) {
			return false;
		}
	}
	
	private void selUsuario (Usuario o) {
		for (int i = 0; i < this.jcbUsuario.getItemCount(); i++) {
            if (this.jcbUsuario.getItemAt(i).getId() == o.getId()) {
                this.jcbUsuario.setSelectedIndex(i);
            }
        }
	}
	
	private void gestionUsuario() {
		Usuario p = (Usuario) this.jcbUsuario.getSelectedItem();
		PanelUsuarios gp = new PanelUsuarios(p);
		gp.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		gp.setVisible(true);
	}
	public boolean esLimiteFloat() {
		try {
			Float.parseFloat(this.jtfLimite.getText());
			return true;
	}
		catch (Exception ex) {
			return false;
		}
	}
	
	 private boolean isDescValida () {
	        String codigo = this.jtfDescripcion.getText();
	        int contLetras = 0;
	        
	        for (int i = 0; i < codigo.length(); i++) {
	            if (Character.isLetter(codigo.charAt(i))) {
	                contLetras++;
	            }
	        }
	        
	        if (contLetras > 4) {
	            return true;
	        }
	        return false;
	    }
	}
