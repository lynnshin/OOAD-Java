package button;

import java.awt.event.ActionEvent;

import mode.classMode;
import panel.canvasPanel;

public class classBtn extends button {
	
	public classBtn(int locX, int locY, canvasPanel cP) {
		super(locX, locY, cP);

		this.setIconImg("/icon/class.png");
	}
	
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		cP.m = new classMode();

	}
}
