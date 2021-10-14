package selfInterface;

import java.awt.event.MouseEvent;

import panel.canvasPanel;

public interface IMode {
	
	public void mouseClicked(MouseEvent e, canvasPanel cP);
	
	public void mousePressed(MouseEvent e, canvasPanel cP);
	
	public void mouseReleased(MouseEvent e, canvasPanel cP);
	
}
