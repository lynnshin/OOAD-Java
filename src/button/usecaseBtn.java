package button;

import java.awt.event.ActionEvent;

import mode.usecaseMode;
import panel.canvasPanel;

public class usecaseBtn extends button {
	
	public usecaseBtn(int locX, int locY, canvasPanel cP) {
		super(locX, locY, cP);

		this.setIconImg("/icon/use_case.png");
	}
	
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		cP.m = new usecaseMode();
	}
}
