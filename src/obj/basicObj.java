package obj;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JComponent;

import selfInterface.IObj;

public class basicObj extends JComponent implements IObj {
	
	public int locX, locY;
	public int x, y, width, height;
	public boolean isClick = false;
	public boolean changeName = false;
	public boolean hasMoved = false;
	public String myName = "";
	public port connectPort;
	
	public basicObj(int locX, int locY) {
		this.locX = locX;
		this.locY = locY;
		this.x = 0;
		this.y = 0;
		this.width = 80;
		this.height = 60;
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2.0f));        
        
        //畫connection port的點點
        g2.setColor(Color.black);
        if (isClick == true) {
        	for (int i = 0; i < 4; i++) {
    			g2.fillOval(connectPort.portPoint[i].x-locX, connectPort.portPoint[i].y-locY, 5, 5);
    		}
        } 
        
        //寫名字
    	//讓文字置中
    	FontMetrics metrics = g2.getFontMetrics();
    	g2.drawString(myName, x + (width - metrics.stringWidth(myName)) / 2, height / 3);      
    } 
	
	public boolean inObj(Point p) {
		Rectangle bound = new Rectangle(locX, locY, width, height);
		if(bound.contains(p)) {
			return true;
		}
		else {
			return false;
		}		
	}
}
