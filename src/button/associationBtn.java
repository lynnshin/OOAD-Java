package button;

import java.awt.event.ActionEvent;

import mode.associationMode;
import panel.canvasPanel;

public class associationBtn extends button {
	
	public associationBtn(int locX, int locY, canvasPanel cP) {
		super(locX, locY, cP);

		this.setIconImg("/icon/association_line.png");	
	}
	
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		cP.m = new associationMode();
		
	}
}
