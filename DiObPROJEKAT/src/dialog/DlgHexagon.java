package dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgHexagon extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtRadius;
	private String radius;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgHexagon dialog = new DlgHexagon();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgHexagon() {
		setModal(true);
		setBounds(100, 100, 198, 170);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblRadius = new JLabel("Radius:");
			lblRadius.setBounds(30, 30, 53, 16);
			contentPanel.add(lblRadius);
		}
		{
			txtRadius = new JTextField();
			txtRadius.setBounds(89, 25, 68, 26);
			contentPanel.add(txtRadius);
			txtRadius.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						try{
							Integer.parseInt(txtRadius.getText());
							if ( Integer.parseInt(txtRadius.getText()) <= 0) {
							    throw new NumberFormatException();
							}
							radius = txtRadius.getText();
							dispose();
						}
						catch(NumberFormatException e2){
							JOptionPane.showMessageDialog(null, "Invalid function", "Error",
							JOptionPane.ERROR_MESSAGE);
							txtRadius.requestFocus();
							txtRadius.setText("");
							DlgHexagon dlgHexagon = new DlgHexagon();
							dlgHexagon.setVisible(false);
						}
						
						
						
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JTextField getTxtRadius() {
		return txtRadius;
	}

	public void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
	}

	public String getRadius() {
		return radius;
	}

	public void setRadius(String radius) {
		this.radius = radius;
	}

}
