package button;

import java.awt.event.ActionEvent;

import mode.compositionMode;
import panel.canvasPanel;

public class compositionBtn extends button {

	public compositionBtn(int locX, int locY, canvasPanel cP) {
		super(locX, locY, cP);

		this.setIconImg("/icon/composition_line.png");
	}
	
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		cP.m = new compositionMode();

	}
}
