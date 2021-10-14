package button;

import java.awt.event.ActionEvent;

import mode.generalizationMode;
import panel.canvasPanel;

public class generalizationBtn extends button {

	public generalizationBtn(int locX, int locY, canvasPanel cP) {
		super(locX, locY, cP);

		this.setIconImg("/icon/generalization_line.png");
	}
	
	public void actionPerformed(ActionEvent e) {	
		super.actionPerformed(e);
		cP.m = new generalizationMode();

	}
}
