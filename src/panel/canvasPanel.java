package panel;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JLayeredPane;

import mode.mode;
import obj.basicLine;
import obj.basicObj;
import obj.groupObj;

public class canvasPanel extends JLayeredPane implements MouseListener {

	public mode m;
	public Vector<basicObj> objList = new Vector<basicObj>();
	public Vector<basicLine> lineList = new Vector<basicLine>();
	public Vector<basicObj> groupObj = new Vector<basicObj>();
	public Vector<basicObj> cloneGroup;
	public groupObj gO = new groupObj();
	public basicObj clickObj;
	
	public canvasPanel() {
		setLayout(null);
		this.setOpaque(true);
		this.setBounds(100, 0, 680, 560);		
		this.setBackground(Color.white);
		this.setBorder(BorderFactory.createEtchedBorder());
		this.addMouseListener(this);			

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		m.mouseClicked(e, this);
		repaint();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		m.mousePressed(e, this);
		repaint();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		m.mouseReleased(e, this);
		repaint();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
