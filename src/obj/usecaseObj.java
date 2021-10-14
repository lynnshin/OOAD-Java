package obj;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class usecaseObj extends basicObj {

	public int locX, locY;
	public int x, y, width, height;
	
	public usecaseObj(int locX, int locY) {
		super(locX, locY);
		this.locX = locX;
		this.locY = locY;
		this.width = 80;
		this.height = 60;
		this.x = 2;
		this.y = 2;
		this.connectPort = new port(this);
	}
	
	public void paint(Graphics g) {		
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2.0f));
		g2.setColor(Color.lightGray);
        g2.fillOval(x, y, width, height);
		g2.setColor(Color.black);
        g2.drawOval(x, y, width, height);
        super.paint(g);        
    }   
}
