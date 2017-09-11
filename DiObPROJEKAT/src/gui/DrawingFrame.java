package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ctrl.Controller;

import javax.swing.JToggleButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JToolBar;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class DrawingFrame extends JFrame {

	private JPanel contentPane;
	
	private JButton btnUndo;
	private JButton btnRedo;
	private JButton btnDelete;
	private JButton btnMode;
	private JButton btnChangeColor;
	private JButton btnSave;
	private JButton btnLoad;
	private JButton btnLineColor;
	private JButton btnFillColor;
	private JButton btnZforward;
	private JButton btnZbackward;
	
	private JToggleButton tglbtnSelection;
	private JToggleButton tglbtnPoint;
	private JToggleButton tglbtnLine;
	private JToggleButton tglbtnCircle;
	private JToggleButton tglbtnSquare;
	private JToggleButton tglbtnRectangle;
	private JToggleButton tglbtnHexagon;
	private JToggleButton tglbtnSmile;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private View pnlDrawing;
	private Controller controller;

	private Color lineColor = Color.BLACK;
	private Color fillColor = Color.WHITE;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawingFrame frame = new DrawingFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DrawingFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1033, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlToolbarTop = new JPanel();
		pnlToolbarTop.setBackground(UIManager.getColor("ToggleButton.background"));
		contentPane.add(pnlToolbarTop, BorderLayout.NORTH);
		pnlToolbarTop.setLayout(new BoxLayout(pnlToolbarTop, BoxLayout.X_AXIS));
		
		btnUndo = new JButton("Undo");
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.undo();
			}
		});
		pnlToolbarTop.add(btnUndo);
		
		btnRedo = new JButton("Redo");
		btnRedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.redo();
			}
		});
		pnlToolbarTop.add(btnRedo);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.delete();
				controller.setEndPoint(null);
				controller.setStartPoint(null);
				controller.getView().repaint();
			}
		});
		pnlToolbarTop.add(btnDelete);
		
		btnMode = new JButton("Mode");
		btnMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.moveShape();
			}
		});
		pnlToolbarTop.add(btnMode);
		
		btnChangeColor = new JButton("Change Color");
		btnChangeColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.changeShapeColor();
				controller.setEndPoint(null);
				controller.setStartPoint(null);
				controller.getView().repaint();
			}
		});
		pnlToolbarTop.add(btnChangeColor);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		pnlToolbarTop.add(btnSave);
		
		btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		pnlToolbarTop.add(btnLoad);
		
		btnLineColor = new JButton("Line Color");
		btnLineColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color current = lineColor;
				lineColor = JColorChooser.showDialog(null, "Choose line color", lineColor);
				if(lineColor == null){
					lineColor = current;
				}
				btnLineColor.setBackground(lineColor);
				btnLineColor.setOpaque(true);
			}
		});
		pnlToolbarTop.add(btnLineColor);
		
		btnFillColor = new JButton("Fill Color");
		btnFillColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color current = fillColor;
				fillColor = JColorChooser.showDialog(null, "Choose line color", fillColor);
				if(fillColor == null){
					fillColor = current;
				}
				btnFillColor.setBackground(fillColor);
				btnFillColor.setOpaque(true);
			}
		});
		pnlToolbarTop.add(btnFillColor);
		
		btnZforward = new JButton("zForward");
		btnZforward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		pnlToolbarTop.add(btnZforward);
		
		btnZbackward = new JButton("zBackward");
		btnZbackward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		pnlToolbarTop.add(btnZbackward);
		
		
		
		
		JPanel pnlToolbarLeft = new JPanel();
		pnlToolbarLeft.setBackground(UIManager.getColor("ToggleButton.background"));
		contentPane.add(pnlToolbarLeft, BorderLayout.WEST);
		
		tglbtnPoint = new JToggleButton("Point");
		tglbtnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup.add(tglbtnPoint);
		
		tglbtnLine = new JToggleButton("Line");
		tglbtnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup.add(tglbtnLine);
		pnlToolbarLeft.setLayout(new GridLayout(0, 1, 0, 0));
		
		tglbtnSelection = new JToggleButton("Selection");
		tglbtnSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//controller.enableModificationBtns();
				controller.setEndPoint(null);
				controller.setStartPoint(null);
				controller.getView().repaint();
			}
		});
		buttonGroup.add(tglbtnSelection);
		pnlToolbarLeft.add(tglbtnSelection);
		tglbtnSelection.setSelected(true);
		tglbtnSelection.setToolTipText("Shape selection");
		pnlToolbarLeft.add(tglbtnPoint);
		pnlToolbarLeft.add(tglbtnLine);
		
		
		tglbtnCircle = new JToggleButton("Circle");
		tglbtnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup.add(tglbtnCircle);
		pnlToolbarLeft.add(tglbtnCircle);
		
		tglbtnSquare = new JToggleButton("Square");
		tglbtnSquare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup.add(tglbtnSquare);
		pnlToolbarLeft.add(tglbtnSquare);
		
		tglbtnRectangle = new JToggleButton("Rectangle");
		tglbtnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup.add(tglbtnRectangle);
		pnlToolbarLeft.add(tglbtnRectangle);
		
		tglbtnHexagon = new JToggleButton("Hexagon");
		tglbtnHexagon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup.add(tglbtnHexagon);
		pnlToolbarLeft.add(tglbtnHexagon);
		
		tglbtnSmile = new JToggleButton("Smile");
		tglbtnSmile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		buttonGroup.add(tglbtnSmile);
		pnlToolbarLeft.add(tglbtnSmile);
		
		pnlDrawing = new View();
		pnlDrawing.setBackground(Color.WHITE);
		contentPane.add(pnlDrawing, BorderLayout.CENTER);
	}

	public View getPnlDrawing() {
		return pnlDrawing;
	}

	public void setPnlDrawing(View pnlDrawing) {
		this.pnlDrawing = pnlDrawing;
	}
	
	
	// START GETTERS & SETTERS
	

	public JButton getBtnUndo() {
		return btnUndo;
	}

	public void setBtnUndo(JButton btnUndo) {
		this.btnUndo = btnUndo;
	}

	public JButton getBtnRedo() {
		return btnRedo;
	}

	public void setBtnRedo(JButton btnRedo) {
		this.btnRedo = btnRedo;
	}

	public JButton getBtnDelete() {
		
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public JButton getBtnMode() {
		return btnMode;
	}

	public void setBtnMode(JButton btnMode) {
		this.btnMode = btnMode;
	}

	public JButton getBtnChangeColor() {
		return btnChangeColor;
	}

	public void setBtnChangeColor(JButton btnChangeColor) {
		this.btnChangeColor = btnChangeColor;
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(JButton btnSave) {
		this.btnSave = btnSave;
	}

	public JButton getBtnLoad() {
		return btnLoad;
	}

	public void setBtnLoad(JButton btnLoad) {
		this.btnLoad = btnLoad;
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

	public JButton getBtnZforward() {
		return btnZforward;
	}

	public void setBtnZforward(JButton btnZforward) {
		this.btnZforward = btnZforward;
	}

	public JButton getBtnZbackward() {
		return btnZbackward;
	}

	public void setBtnZbackward(JButton btnZbackward) {
		this.btnZbackward = btnZbackward;
	}

	public JToggleButton getTglbtnSelection() {
		return tglbtnSelection;
	}

	public void setTglbtnSelection(JToggleButton tglbtnSelection) {
		this.tglbtnSelection = tglbtnSelection;
	}

	public JToggleButton getTglbtnPoint() {
		return tglbtnPoint;
	}

	public void setTglbtnPoint(JToggleButton tglbtnPoint) {
		this.tglbtnPoint = tglbtnPoint;
	}

	public JToggleButton getTglbtnLine() {
		return tglbtnLine;
	}

	public void setTglbtnLine(JToggleButton tglbtnLine) {
		this.tglbtnLine = tglbtnLine;
	}

	public JToggleButton getTglbtnCircle() {
		return tglbtnCircle;
	}

	public void setTglbtnCircle(JToggleButton tglbtnCircle) {
		this.tglbtnCircle = tglbtnCircle;
	}

	public JToggleButton getTglbtnSquare() {
		return tglbtnSquare;
	}

	public void setTglbtnSquare(JToggleButton tglbtnSquare) {
		this.tglbtnSquare = tglbtnSquare;
	}

	public JToggleButton getTglbtnRectangle() {
		return tglbtnRectangle;
	}

	public void setTglbtnRectangle(JToggleButton tglbtnRectangle) {
		this.tglbtnRectangle = tglbtnRectangle;
	}

	public JToggleButton getTglbtnHexagon() {
		return tglbtnHexagon;
	}

	public void setTglbtnHexagon(JToggleButton tglbtnHexagon) {
		this.tglbtnHexagon = tglbtnHexagon;
	}

	public JToggleButton getTglbtnSmile() {
		return tglbtnSmile;
	}

	public void setTglbtnSmile(JToggleButton tglbtnSmile) {
		this.tglbtnSmile = tglbtnSmile;
	}
	
	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
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
	
	
	
	// END GETTERS & SETTERS

}
