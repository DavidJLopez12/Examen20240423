package principal.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import principal.controllers.ControladorUsuario;
import principal.entities.Usuario;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelUsuarios extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField jtfId;
	private JTextField jtfUsuario;
	private JTextField jtfEmail;
	private JPasswordField jpPassword;
	private JComboBox jcbColor;
	JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
//			PanelUsuarios dialog = new PanelUsuarios();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PanelUsuarios(Usuario p) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				JLabel lblGestionDeUsuarios = new JLabel("Gestion de usuarios:");
				GridBagConstraints gbc_lblGestionDeUsuarios = new GridBagConstraints();
				gbc_lblGestionDeUsuarios.gridwidth = 2;
				gbc_lblGestionDeUsuarios.insets = new Insets(0, 0, 5, 0);
				gbc_lblGestionDeUsuarios.gridx = 0;
				gbc_lblGestionDeUsuarios.gridy = 0;
				panel.add(lblGestionDeUsuarios, gbc_lblGestionDeUsuarios);
			}
			{
				JLabel lblId = new JLabel("Id:");
				GridBagConstraints gbc_lblId = new GridBagConstraints();
				gbc_lblId.anchor = GridBagConstraints.EAST;
				gbc_lblId.insets = new Insets(0, 0, 5, 5);
				gbc_lblId.gridx = 0;
				gbc_lblId.gridy = 1;
				panel.add(lblId, gbc_lblId);
			}
			{
				jtfId = new JTextField();
				GridBagConstraints gbc_jtfId = new GridBagConstraints();
				gbc_jtfId.insets = new Insets(0, 0, 5, 0);
				gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
				gbc_jtfId.gridx = 1;
				gbc_jtfId.gridy = 1;
				panel.add(jtfId, gbc_jtfId);
				jtfId.setColumns(10);
			}
			{
				JLabel lblUsuario = new JLabel("Usuario:");
				GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
				gbc_lblUsuario.anchor = GridBagConstraints.EAST;
				gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
				gbc_lblUsuario.gridx = 0;
				gbc_lblUsuario.gridy = 2;
				panel.add(lblUsuario, gbc_lblUsuario);
			}
			{
				jtfUsuario = new JTextField();
				GridBagConstraints gbc_jtfUsuario = new GridBagConstraints();
				gbc_jtfUsuario.insets = new Insets(0, 0, 5, 0);
				gbc_jtfUsuario.fill = GridBagConstraints.HORIZONTAL;
				gbc_jtfUsuario.gridx = 1;
				gbc_jtfUsuario.gridy = 2;
				panel.add(jtfUsuario, gbc_jtfUsuario);
				jtfUsuario.setColumns(10);
			}
			{
				JLabel lblContrasea = new JLabel("Contraseña:");
				GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
				gbc_lblContrasea.anchor = GridBagConstraints.EAST;
				gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
				gbc_lblContrasea.gridx = 0;
				gbc_lblContrasea.gridy = 3;
				panel.add(lblContrasea, gbc_lblContrasea);
			}
			{
				jpPassword = new JPasswordField();
				GridBagConstraints gbc_jpPassword = new GridBagConstraints();
				gbc_jpPassword.insets = new Insets(0, 0, 5, 0);
				gbc_jpPassword.fill = GridBagConstraints.HORIZONTAL;
				gbc_jpPassword.gridx = 1;
				gbc_jpPassword.gridy = 3;
				panel.add(jpPassword, gbc_jpPassword);
			}
			{
				JLabel lblEmail = new JLabel("Email:");
				GridBagConstraints gbc_lblEmail = new GridBagConstraints();
				gbc_lblEmail.anchor = GridBagConstraints.EAST;
				gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
				gbc_lblEmail.gridx = 0;
				gbc_lblEmail.gridy = 4;
				panel.add(lblEmail, gbc_lblEmail);
			}
			{
				jtfEmail = new JTextField();
				GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
				gbc_jtfEmail.insets = new Insets(0, 0, 5, 0);
				gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
				gbc_jtfEmail.gridx = 1;
				gbc_jtfEmail.gridy = 4;
				panel.add(jtfEmail, gbc_jtfEmail);
				jtfEmail.setColumns(10);
			}
			{
				JLabel lblColorPreferido = new JLabel("Color preferido:");
				GridBagConstraints gbc_lblColorPreferido = new GridBagConstraints();
				gbc_lblColorPreferido.anchor = GridBagConstraints.EAST;
				gbc_lblColorPreferido.insets = new Insets(0, 0, 5, 5);
				gbc_lblColorPreferido.gridx = 0;
				gbc_lblColorPreferido.gridy = 5;
				panel.add(lblColorPreferido, gbc_lblColorPreferido);
			}
			{
				jcbColor = new JComboBox();
				GridBagConstraints gbc_jcbColor = new GridBagConstraints();
				gbc_jcbColor.insets = new Insets(0, 0, 5, 0);
				gbc_jcbColor.fill = GridBagConstraints.HORIZONTAL;
				gbc_jcbColor.gridx = 1;
				gbc_jcbColor.gridy = 5;
				panel.add(jcbColor, gbc_jcbColor);
			}
			{
				JButton btnGuardar = new JButton("Guardar");
				btnGuardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						guardar();
					}
				});
				GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
				gbc_btnGuardar.gridwidth = 2;
				gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
				gbc_btnGuardar.gridx = 0;
				gbc_btnGuardar.gridy = 7;
				panel.add(btnGuardar, gbc_btnGuardar);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		cargarColores();
		cargarUsuario(p);
		cargarFondo();
	}
	
	private void cargarFondo() {
		Usuario p = ControladorUsuario.findArtById(Integer.parseInt(this.jtfId.getText()));
		if (((String) this.jcbColor.getSelectedItem()).length() > 0) {
			this.panel.setBackground(Color.decode(p.getColorPreferido()));
		}
		else {
			this.panel.setBackground(Color.WHITE);
		}
	}
	private void cargarColores() {

		this.jcbColor.addItem("#FF00FF");
		this.jcbColor.addItem("#9890A5");
		this.jcbColor.addItem("#765456");
		this.jcbColor.addItem("#879876");
	}
	private void cargarUsuario(Usuario p) {
		this.jtfId.setText(String.valueOf(p.getId()));
		this.jtfUsuario.setText(p.getNombreUsuario());
		this.jpPassword.setText(p.getPassword());
		this.jtfEmail.setText(p.getEmail());

		for (int i = 0; i < this.jcbColor.getItemCount(); i++) {
			if (p.getColorPreferido() == String.valueOf(this.jcbColor.getItemAt(i))) {
				this.jcbColor.setSelectedIndex(i);

			}
		}

	}
	private void guardar() {
		Usuario p = ControladorUsuario.findArtById(Integer.parseInt(this.jtfId.getText()));
		
		p.setNombreUsuario(this.jtfUsuario.getText());
		p.setPassword(this.jpPassword.getText());
		p.setEmail(this.jtfEmail.getText());
		p.setNombreUsuario(this.jtfUsuario.getText());
		p.setColorPreferido((String) this.jcbColor.getSelectedItem());
		
		ControladorUsuario.update(p);
		JOptionPane.showMessageDialog(null, "Registro modificado con éxito");
		
		}
	private boolean isEmailValido () {		
		return this.jtfEmail.getText().matches("[@]{1,}.*");
	}
	

	}
