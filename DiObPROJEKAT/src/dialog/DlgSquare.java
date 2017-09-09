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

public class DlgSquare extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtHeight;
	private String side = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgSquare dialog = new DlgSquare();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgSquare() {
		setModal(true);
		setBounds(100, 100, 221, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblHeight = new JLabel("Height:");
			lblHeight.setBounds(30, 30, 46, 16);
			contentPanel.add(lblHeight);
		}
		{
			txtHeight = new JTextField();
			txtHeight.setBounds(88, 25, 100, 26);
			contentPanel.add(txtHeight);
			txtHeight.setColumns(10);
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
							Integer.parseInt(txtHeight.getText());
							if ( Integer.parseInt(txtHeight.getText()) <= 0) {
							    throw new NumberFormatException();
							}
							side = txtHeight.getText();
							dispose();
							
						}
						catch(NumberFormatException e1){
							JOptionPane.showMessageDialog(null, "Invalid function", "Error",
							JOptionPane.ERROR_MESSAGE);
							txtHeight.requestFocus();
							txtHeight.setText("");
							DlgSquare dlgSquare = new DlgSquare();
							dlgSquare.setVisible(false);
						}
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

	public JTextField getTxtHeight() {
		return txtHeight;
	}

	public void setTxtHeight(JTextField txtHeight) {
		this.txtHeight = txtHeight;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

}
