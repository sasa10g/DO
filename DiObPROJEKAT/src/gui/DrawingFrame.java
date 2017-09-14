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
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

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
		setTitle("Dizajnerski obrasci IT62 (2016/17)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 946, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlToolbarTop = new JPanel();
		pnlToolbarTop.setBackground(UIManager.getColor("ToggleButton.background"));
		contentPane.add(pnlToolbarTop, BorderLayout.NORTH);
		pnlToolbarTop.setLayout(new BoxLayout(pnlToolbarTop, BoxLayout.X_AXIS));
		
		btnUndo = new JButton("Undo");
		btnUndo.setIcon(new ImageIcon("/Users/sasa10/git/DiObPROJEKAT/icon/undo.png"));
		//btnUndo.setEnabled(false);
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.undo();
			}
		});
		pnlToolbarTop.add(btnUndo);
		
		btnRedo = new JButton("Redo");
		btnRedo.setIcon(new ImageIcon("/Users/sasa10/git/DiObPROJEKAT/icon/redo.png"));
		btnRedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.redo();
			}
		});
		pnlToolbarTop.add(btnRedo);
		
		btnDelete = new JButton("Delete");
		btnDelete.setIcon(new ImageIcon("/Users/sasa10/git/DiObPROJEKAT/icon/delete.png"));
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
		btnMode.setIcon(new ImageIcon("/Users/sasa10/git/DiObPROJEKAT/icon/move.png"));
		btnMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.moveShape();
			}
		});
		pnlToolbarTop.add(btnMode);
		
		btnChangeColor = new JButton("Change Color");
		btnChangeColor.setIcon(new ImageIcon("/Users/sasa10/git/DiObPROJEKAT/icon/changeColor.png"));
		btnChangeColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.changeShapeColor();
				controller.setEndPoint(null);
				controller.setStartPoint(null);
				controller.getView().repaint();
			}
		});
		pnlToolbarTop.add(btnChangeColor);
		
		btnLineColor = new JButton("Line Color");
		btnLineColor.setIcon(new ImageIcon("/Users/sasa10/git/DiObPROJEKAT/icon/lineColor.png"));
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
		btnFillColor.setIcon(new ImageIcon("/Users/sasa10/git/DiObPROJEKAT/icon/fillColor.png"));
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
		btnZforward.setIcon(new ImageIcon("/Users/sasa10/git/DiObPROJEKAT/icon/zForward.png"));
		btnZforward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.zForward();
				controller.setEndPoint(null);
				controller.setStartPoint(null);
				controller.getView().repaint();
			}
		});
		
		btnSave = new JButton("Save");
		btnSave.setIcon(new ImageIcon("/Users/sasa10/git/DiObPROJEKAT/icon/saving.png"));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.save();
				controller.setEndPoint(null);
				controller.setStartPoint(null);
				controller.getView().repaint();
			}
		});
		
		btnLoad = new JButton("Load");
		btnLoad.setIcon(new ImageIcon("/Users/sasa10/git/DiObPROJEKAT/icon/open.png"));
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controller.load();
				controller.setEndPoint(null);
				controller.setStartPoint(null);
				controller.getView().repaint();
				
			}
		});
		pnlToolbarTop.add(btnLoad);
		pnlToolbarTop.add(btnSave);
		btnZforward.setToolTipText("Z-forward");
		pnlToolbarTop.add(btnZforward);
		
		btnZbackward = new JButton("zBackward");
		btnZbackward.setIcon(new ImageIcon("/Users/sasa10/git/DiObPROJEKAT/icon/zBackward.png"));
		btnZbackward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.zBackward();
				controller.setEndPoint(null);
				controller.setStartPoint(null);
				controller.getView().repaint();
			}
		});
		btnZbackward.setToolTipText("Z-backward");
		pnlToolbarTop.add(btnZbackward);
		
		
		
		
		JPanel pnlToolbarLeft = new JPanel();
		pnlToolbarLeft.setBackground(UIManager.getColor("Button.background"));
		contentPane.add(pnlToolbarLeft, BorderLayout.WEST);
		
		tglbtnPoint = new JToggleButton("Point");
		tglbtnPoint.setHorizontalAlignment(SwingConstants.LEFT);
		tglbtnPoint.setIcon(new ImageIcon("/Users/sasa10/git/DiObPROJEKAT/icon/shapes/point.png"));
		tglbtnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup.add(tglbtnPoint);
		
		tglbtnLine = new JToggleButton("Line");
		tglbtnLine.setHorizontalAlignment(SwingConstants.LEFT);
		tglbtnLine.setIcon(new ImageIcon("/Users/sasa10/git/DiObPROJEKAT/icon/shapes/line.png"));
		tglbtnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup.add(tglbtnLine);
		pnlToolbarLeft.setLayout(new GridLayout(0, 1, 0, 0));
		
		tglbtnSelection = new JToggleButton("Selection");
		tglbtnSelection.setHorizontalAlignment(SwingConstants.LEFT);
		tglbtnSelection.setIcon(new ImageIcon("/Users/sasa10/git/DiObPROJEKAT/icon/shapes/selection.png"));
		tglbtnSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		tglbtnCircle.setHorizontalAlignment(SwingConstants.LEFT);
		tglbtnCircle.setIcon(new ImageIcon("/Users/sasa10/git/DiObPROJEKAT/icon/shapes/circle.png"));
		tglbtnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup.add(tglbtnCircle);
		pnlToolbarLeft.add(tglbtnCircle);
		
		tglbtnSquare = new JToggleButton("Square");
		tglbtnSquare.setHorizontalAlignment(SwingConstants.LEFT);
		tglbtnSquare.setIcon(new ImageIcon("/Users/sasa10/git/DiObPROJEKAT/icon/shapes/square.png"));
		tglbtnSquare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup.add(tglbtnSquare);
		pnlToolbarLeft.add(tglbtnSquare);
		
		tglbtnRectangle = new JToggleButton("Rectangle");
		tglbtnRectangle.setHorizontalAlignment(SwingConstants.LEFT);
		tglbtnRectangle.setIcon(new ImageIcon("/Users/sasa10/git/DiObPROJEKAT/icon/shapes/rectangle.png"));
		tglbtnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup.add(tglbtnRectangle);
		pnlToolbarLeft.add(tglbtnRectangle);
		
		tglbtnHexagon = new JToggleButton("Hexagon");
		tglbtnHexagon.setHorizontalAlignment(SwingConstants.LEFT);
		tglbtnHexagon.setIcon(new ImageIcon("/Users/sasa10/git/DiObPROJEKAT/icon/shapes/hexagon.png"));
		tglbtnHexagon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup.add(tglbtnHexagon);
		pnlToolbarLeft.add(tglbtnHexagon);
		
		tglbtnSmile = new JToggleButton("Smile");
		tglbtnSmile.setHorizontalAlignment(SwingConstants.LEFT);
		tglbtnSmile.setIcon(new ImageIcon("/Users/sasa10/git/DiObPROJEKAT/icon/shapes/smiley.png"));
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
