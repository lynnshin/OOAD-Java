package mode;

import java.awt.event.MouseEvent;

import obj.basicObj;
import obj.classObj;
import panel.canvasPanel;

public class classMode extends mode {

	public classMode() {

	}
	
	public void mouseClicked(MouseEvent e, canvasPanel cP) {	
		System.out.println("class");
	}
	
	public void mousePressed(MouseEvent e, canvasPanel cP) {
		basicObj co = new classObj(e.getX(), e.getY());	//在點擊位置new一個class物件
		cP.objList.add(co);//把物件存到obj的Vector裡
		co.setBounds(e.getX(), e.getY(), 85, 65);//在點擊的位置給一個範圍
		cP.add(co,0);//讓他顯示在canvas上 後面的參數是設定在LayerPane的層數
	}
}
