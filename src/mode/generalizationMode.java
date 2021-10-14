package mode;

import java.awt.Point;
import java.awt.event.MouseEvent;

import obj.basicObj;
import obj.generalizationLine;
import panel.canvasPanel;

public class generalizationMode extends mode {
	
	basicObj startObj, endObj;
	Point startCP, endCP;
	
	public generalizationMode() {
		
	}
	
	public void mouseClicked(MouseEvent e, canvasPanel cP) {	
		System.out.println("generalization");
	}
	
	public void mousePressed(MouseEvent e, canvasPanel cP) {
		startObj = null;
		for(int i = 0; i < cP.objList.size(); i++) {
			if(cP.objList.get(i).inObj(e.getPoint())){
				startObj = cP.objList.get(i);
				startCP = e.getPoint();
			}
		}
	}

	public void mouseReleased(MouseEvent e, canvasPanel cP) {
		endObj = null;
		for(int i = 0; i < cP.objList.size(); i++) {
			if(cP.objList.get(i).inObj(e.getPoint())){
				endObj = cP.objList.get(i);
				endCP = e.getPoint();
			}
		}
		
		if((startObj != null) && (endObj != null) && (startObj != endObj)) {
			generalizationLine al = new generalizationLine(startCP, endCP, startObj, endObj);
			cP.lineList.add(al);	
			al.setBounds(0, 0, 680, 560);
			cP.add(al,0);	
		}
	}
}
