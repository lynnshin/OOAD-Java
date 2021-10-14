package obj;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class classObj extends basicObj {

	public int locX, locY;
	public int x, y, width, height;
	
	public classObj(int locX, int locY) {
		super(locX,locY);
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
        g2.fillRect(x, y, width, height/3);
        g2.fillRect(x, y + 20, width, height/3);
        g2.fillRect(x, y + 40, width, height/3);
		g2.setColor(Color.black);
        g2.drawRect(x, y, width, height/3);
        g2.drawRect(x, y + 20, width, height/3);
        g2.drawRect(x, y + 40, width, height/3);
        super.paint(g);        
    }   
}
