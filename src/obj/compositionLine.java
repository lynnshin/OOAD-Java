package obj;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class compositionLine extends basicLine {

	public Point startCP, endCP;
	public basicObj startObj, endObj;
	public int startIndex, endIndex;

	public compositionLine(Point startP, Point endP, basicObj startObj, basicObj endObj) {
		super(startP, endP, startObj, endObj);
//		this.startP = startP;
//		this.endP = endP;	
		this.startObj = startObj;
		this.endObj = endObj;
		this.startPort = new port(this.startObj);
		this.endPort = new port(this.endObj);
		this.startIndex = this.startPort.connectPointIndex(startP);
		this.endIndex = this.endPort.connectPointIndex(endP);		
	}
	
	public void paint(Graphics g) {
		this.startPort = new port(this.startObj);
		this.endPort = new port(this.endObj);		
		this.startCP = this.startPort.connectPoint(this.startIndex);
		this.endCP = this.endPort.connectPoint(this.endIndex);
		
		super.paint(g);
		drawArrowLine(g, startCP.x, startCP.y, endCP.x, endCP.y, 10, 8);
    }
	
	public void drawArrowLine(Graphics g, int x1, int y1, int x2, int y2, int d, int h){

		int dx = x2 - x1, dy = y2 - y1;
		double D = Math.sqrt(dx*dx + dy*dy);
		double xm = D - d, xn = xm, ym = h, yn = -h, x, xp, yp;
		double sin = dy/D, cos = dx/D;
		
		//右邊的點		
		x = xm*cos - ym*sin + x1;
		ym = xm*sin + ym*cos + y1;
		xm = x;
		
		//左邊的點	
		x = xn*cos - yn*sin + x1;
		yn = xn*sin + yn*cos + y1;
		xn = x;
		
		//下面的點
		xp = x2-cos*20;
		yp = y2-sin*20;
		
		int[] xpoints = {x2, (int) xm, (int) xp, (int) xn};
		int[] ypoints = {y2, (int) ym, (int) yp, (int) yn};
				
		g.drawLine(x1, y1, x2, y2);
		g.setColor(Color.white);
		g.fillPolygon(xpoints, ypoints, 4);
		g.setColor(Color.black);
		g.drawPolygon(xpoints, ypoints, 4);
	}
}
