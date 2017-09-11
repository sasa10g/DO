package dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Shape;

import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class DlgMove extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JRadioButton rdbtnMoveOn, rdbtnMoveFor;
	private JButton okButton;
	private JButton cancelButton;
	private boolean success;
	private String xMod, yMod;
	
	
	private ArrayList<Shape> shapes;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgMove dialog = new DlgMove();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgMove() {
		setModal(true);
		setBounds(100, 100, 179, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
			rdbtnMoveFor = new JRadioButton("Move FOR");
			buttonGroup.add(rdbtnMoveFor);
			rdbtnMoveFor.setBounds(30, 30, 141, 23);
			contentPanel.add(rdbtnMoveFor);
		
		{
			rdbtnMoveOn = new JRadioButton("Move ON");
			buttonGroup.add(rdbtnMoveOn);
			rdbtnMoveOn.setBounds(30, 55, 141, 23);
			contentPanel.add(rdbtnMoveOn);
		}
		{
			JLabel lblX = new JLabel("X:");
			lblX.setBounds(41, 110, 12, 16);
			contentPanel.add(lblX);
		}
		{
			JLabel lblY = new JLabel("Y:");
			lblY.setBounds(40, 133, 12, 16);
			contentPanel.add(lblY);
		}
		{
			txtX = new JTextField();
			txtX.setBounds(60, 98, 67, 26);
			contentPanel.add(txtX);
			txtX.setColumns(10);
		}
		{
			txtY = new JTextField();
			txtY.setBounds(60, 128, 67, 26);
			contentPanel.add(txtY);
			txtY.setColumns(10);
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
							if(rdbtnMoveFor.isSelected()){
								if(txtX.getText().isEmpty()){
									txtX.setText("0");
								}
								if(txtY.getText().isEmpty()){
									txtY.setText("0");
								}
							}
								
							
							
							else if(rdbtnMoveOn.isSelected()){
								if ( Integer.parseInt(txtX.getText()) < 0 
										|| Integer.parseInt(txtY.getText())< 0) {
								    throw new NumberFormatException();
								}
							}
							
							Integer.parseInt(txtX.getText());
							Integer.parseInt(txtY.getText());
							
							
							xMod = txtX.getText();
							yMod = txtY.getText();
							
							success = true;
							dispose();
						}
						catch(NumberFormatException e1){
							JOptionPane.showMessageDialog(null, "Invalid input", "Error",
									JOptionPane.ERROR_MESSAGE);
							txtX.requestFocus();
							txtY.requestFocus();
							txtX.setText("");
							txtY.setText("");
							
							setVisible(true);
							success = false;
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

	public JTextField getTxtX() {
		return txtX;
	}

	public void setTxtX(JTextField txtX) {
		this.txtX = txtX;
	}

	public JTextField getTxtY() {
		return txtY;
	}

	public void setTxtY(JTextField txtY) {
		this.txtY = txtY;
	}

	public JRadioButton getRdbtnMoveOn() {
		return rdbtnMoveOn;
	}

	public void setRdbtnMoveOn(JRadioButton rdbtnMoveOn) {
		this.rdbtnMoveOn = rdbtnMoveOn;
	}

	public JRadioButton getRdbtnMoveFor() {
		return rdbtnMoveFor;
	}

	public void setRdbtnMoveFor(JRadioButton rdbtnMoveFor) {
		this.rdbtnMoveFor = rdbtnMoveFor;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public void setOkButton(JButton okButton) {
		this.okButton = okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getxMod() {
		return xMod;
	}

	public void setxMod(String xMod) {
		this.xMod = xMod;
	}

	public String getyMod() {
		return yMod;
	}

	public void setyMod(String yMod) {
		this.yMod = yMod;
	}

	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}

}
