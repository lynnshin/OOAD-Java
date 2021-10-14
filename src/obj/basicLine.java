package obj;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JComponent;

import selfInterface.ILine;


public class basicLine extends JComponent implements ILine {

	public Point startCP, endCP;
	public basicObj startObj, endObj;
	public port startPort, endPort;
	public int startIndex, endIndex;
	
	public basicLine(Point startP, Point endP, basicObj startObj, basicObj endObj) {
//		this.startP = startP;
//		this.endP = endP;
		this.startObj = startObj;
		this.endObj = endObj;
		this.startPort = new port(this.startObj);
		this.endPort = new port(this.endObj);
		this.startIndex = this.startPort.connectPointIndex(startP);
		this.endIndex = this.endPort.connectPointIndex(endP);		
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2.0f));
    }

	@Override
	public void drawArrowLine(Graphics g, int x1, int y1, int x2, int y2, int d, int h) {
		
	}

}
