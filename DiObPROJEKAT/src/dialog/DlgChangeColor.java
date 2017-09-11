package dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.GridLayout;

public class DlgChangeColor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnLineColor, btnFillColor;
	private Color lineColor;
	private Color fillColor;
	private boolean sucssess;
	JButton okButton;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgChangeColor dialog = new DlgChangeColor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgChangeColor() {
		setModal(true);
		setBounds(100, 100, 300, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setEnabled(false);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						sucssess = true;
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
		
		btnLineColor = new JButton("Line Color");
		btnLineColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Color current = lineColor;
				lineColor = JColorChooser.showDialog(null, "Choose line color", lineColor);
				
				if(lineColor != null){
					okButton.setEnabled(true);
				}else{
					lineColor = current;
				}
				
				btnLineColor.setBackground(lineColor);
				btnLineColor.setOpaque(true);
				
			}
		});
		contentPanel.add(btnLineColor);
		
		
		btnFillColor = new JButton("Fill Color");
		btnFillColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Color current = fillColor;
				fillColor = JColorChooser.showDialog(null, "Choose line color", fillColor);
				
				if(fillColor != null){
					okButton.setEnabled(true);
				}
				else{
					fillColor = current;
				}
				btnFillColor.setBackground(fillColor);
				btnFillColor.setOpaque(true);
				
			}
		});
		contentPanel.add(btnFillColor);
	}

	public JButton getBtnLineColor() {
		return btnLineColor;
	}

	public void setBtnLineColor(JButton btnLineColor) {
		this.btnLineColor = btnLineColor;
	}

	public JButton getBtnFillColor() {
		return btnFillColor;
	}

	public void setBtnFillColor(JButton btnFillColor) {
		this.btnFillColor = btnFillColor;
	}

	public Color getLineColor() {
		return lineColor;
	}

	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	public boolean isSucssess() {
		return sucssess;
	}

	public void setSucssess(boolean sucssess) {
		this.sucssess = sucssess;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public void setOkButton(JButton okButton) {
		this.okButton = okButton;
	}
}
