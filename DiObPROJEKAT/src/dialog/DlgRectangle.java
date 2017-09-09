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

public class DlgRectangle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtSide;
	private JTextField txtHeight;
	private String side, heightr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRectangle dialog = new DlgRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRectangle() {
		setModal(true);
		setBounds(100, 100, 182, 191);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblX = new JLabel("X:");
			lblX.setBounds(30, 30, 23, 16);
			contentPanel.add(lblX);
		}
		{
			JLabel lblY = new JLabel("Y:");
			lblY.setBounds(29, 56, 24, 16);
			contentPanel.add(lblY);
		}
		{
			txtSide = new JTextField();
			txtSide.setBounds(50, 23, 54, 26);
			contentPanel.add(txtSide);
			txtSide.setColumns(10);
		}
		{
			txtHeight = new JTextField();
			txtHeight.setBounds(50, 51, 54, 26);
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
							Integer.parseInt(txtSide.getText());
							
							if ( Integer.parseInt(txtSide.getText()) <= 0 
									|| Integer.parseInt(txtHeight.getText())<= 0) {
							    throw new NumberFormatException();
							}
							side = txtSide.getText();						
							heightr = txtHeight.getText();
							dispose();
						}
						catch(NumberFormatException e1){
							JOptionPane.showMessageDialog(null, "Invalid funtion", "Error",
							JOptionPane.ERROR_MESSAGE);
							txtSide.requestFocus();
							txtSide.setText("");
							txtHeight.requestFocus();
							txtHeight.setText("");
							DlgRectangle dlgRectangle = new DlgRectangle();
							dlgRectangle.setVisible(false);
							
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

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getHeightr() {
		return heightr;
	}

	public void setHeightr(String heightr) {
		this.heightr = heightr;
	}

}
