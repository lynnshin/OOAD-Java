package selfInterface;

import java.awt.Graphics;

public interface ILine {
	
	public void paint(Graphics g);
	
	public void drawArrowLine(Graphics g, int x1, int y1, int x2, int y2, int d, int h);
}
