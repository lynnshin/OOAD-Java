package button;

import java.awt.event.ActionEvent;

import mode.selectMode;
import panel.canvasPanel;

public class selectBtn extends button{

	public selectBtn(int locX, int locY, canvasPanel cP) {
		super(locX, locY, cP);
		
		this.setIconImg("/icon/select.png");
	}
	
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		cP.m = new selectMode();

	}

}
