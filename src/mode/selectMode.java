package mode;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.Vector;

import obj.basicObj;
import panel.canvasPanel;

public class selectMode extends mode {

	basicObj selectObj, clickObj;
	Point startP, endP;	
	
	public selectMode() {
		
	}
	
	public void mouseClicked(MouseEvent e, canvasPanel cP) {
		clickObj = null;
		boolean notInGroup = true;
		System.out.println("select");
		
		//isClick & changeName清空
		for(int i = 0; i < cP.objList.size(); i++) {			
				cP.objList.get(i).isClick = false;	
				cP.objList.get(i).changeName = false;
		}
		
		for(int i = 0; i < cP.objList.size(); i++) {
			if(cP.objList.get(i).inObj(e.getPoint())){
				clickObj = cP.objList.get(i);
				clickObj.changeName = true;
				cP.clickObj = clickObj;
			}
		}
		
		//畫點點
		if(clickObj != null) {
			if(!cP.gO.groupObjs.isEmpty()) {
				for(int i = 0; i < cP.gO.groupObjs.size(); i++) {
					if (cP.gO.groupObjs.get(i).contains(clickObj)) {
						notInGroup = false;
						for(int j = 0; j < cP.gO.groupObjs.get(i).size(); j++) {
							cP.gO.groupObjs.get(i).get(j).isClick = true;
						}						
					}	
					if (cP.gO.groupBy.contains(clickObj)) {
						for(Vector<basicObj> obj:cP.gO.groupBygroup) {
							for(basicObj b:obj) {
								b.isClick = true;
							}
							
						}
					}
				}
				if(notInGroup) {
					clickObj.isClick = true;
				}
			}
			else {
				clickObj.isClick = true;
			}
		}				

	}
	
	public void mousePressed(MouseEvent e, canvasPanel cP) {
		selectObj = null;
		startP = e.getPoint();
		
		//紀錄起始obj
		for(int i = 0; i < cP.objList.size(); i++) {
			if(cP.objList.get(i).inObj(e.getPoint())){
				selectObj = cP.objList.get(i);
			}
		}
	}
	
	public void mouseReleased(MouseEvent e, canvasPanel cP) {
		endP = e.getPoint();
		cP.groupObj.clear();
		boolean notInGroup = true;
		basicObj tmpObj;
		
		for(int i = 0; i < cP.gO.groupObjs.size(); i++) {
			for(int j = 0; j < cP.gO.groupObjs.get(i).size(); j++) {
				cP.gO.groupObjs.get(i).get(j).hasMoved = false;
			}							
		}
		
		//移動
		if (selectObj != null) {
			if(!cP.gO.groupObjs.isEmpty()) {//有group
				for(int i = 0; i < cP.gO.groupObjs.size(); i++) {
					if (cP.gO.groupObjs.get(i).contains(selectObj)) {//在group裡
						notInGroup = false;
						for(int j = 0; j < cP.gO.groupObjs.get(i).size(); j++) {
							if(!cP.gO.groupObjs.get(i).get(j).hasMoved) {
								tmpObj = cP.gO.groupObjs.get(i).get(j);
								tmpObj.setBounds(tmpObj.locX + (endP.x - startP.x), tmpObj.locY + (endP.y - startP.y), 85, 65);
								tmpObj.locX = tmpObj.locX + (endP.x - startP.x);
								tmpObj.locY = tmpObj.locY + (endP.y - startP.y);	
								tmpObj.hasMoved = true;
								tmpObj.connectPort.connectPortCandidate();
							}
						}
					}	
					if (cP.gO.groupBy.contains(selectObj)) {
						for(Vector<basicObj> obj:cP.gO.groupBygroup) {
							for(basicObj b:obj) {
								if(!b.hasMoved) {
									b.setBounds(b.locX +(endP.x - startP.x), b.locY + (endP.y - startP.y), 85, 65);
									b.locX = b.locX + (endP.x - startP.x);
									b.locY = b.locY + (endP.y - startP.y);	
									b.hasMoved = true;
									b.connectPort.connectPortCandidate();
								}
							}
							
						}
					}
				}
				if(notInGroup) {//不在group裡
					selectObj.setBounds(selectObj.locX + (endP.x - startP.x), selectObj.locY + (endP.y - startP.y), 85, 65);
					selectObj.locX = selectObj.locX + (endP.x - startP.x);
					selectObj.locY = selectObj.locY + (endP.y - startP.y);
					
					selectObj.connectPort.connectPortCandidate();
				}
			}
			else {//沒有group
				selectObj.setBounds(selectObj.locX + (endP.x - startP.x), selectObj.locY + (endP.y - startP.y), 85, 65);
				selectObj.locX = selectObj.locX + (endP.x - startP.x);
				selectObj.locY = selectObj.locY + (endP.y - startP.y);
				
				selectObj.connectPort.connectPortCandidate();
			}
			
			
		}
		
		//範圍選取
		if (selectObj == null) {
			Rectangle selectRange = new Rectangle(startP.x>endP.x ?endP.x:startP.x, startP.y>endP.y ?endP.y:startP.y, Math.abs(endP.x - startP.x), Math.abs(endP.y - startP.y));
			for(int i = 0; i < cP.objList.size(); i++) {
				cP.objList.get(i).isClick = false;		
				if(selectRange.contains(cP.objList.get(i).getBounds())) {
					cP.objList.get(i).isClick = true;
					cP.groupObj.add(cP.objList.get(i));
				}
			}
			cP.cloneGroup = new Vector<basicObj>(cP.groupObj);
		}

	}

	
}
