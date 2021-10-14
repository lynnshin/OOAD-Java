package panel;

import java.awt.Color;
import java.util.Vector;

import javax.swing.JPanel;

import button.associationBtn;
import button.button;
import button.classBtn;
import button.compositionBtn;
import button.generalizationBtn;
import button.selectBtn;
import button.usecaseBtn;

public class buttonPanel extends JPanel{
	
	public Vector<button> buttonList = new Vector<button>();
	
	public buttonPanel(canvasPanel cP) {
		setLayout(null);
		this.setBounds(0,0,100,600);
		this.setBackground(Color.white);
		
		button selectBtn = new selectBtn(15,20, cP);
		button associationBtn = new associationBtn(15,110, cP);
		button generalizationBtn = new generalizationBtn(15,200, cP);
		button compositionBtn = new compositionBtn(15,290, cP);
		button classBtn = new classBtn(15,380, cP);
		button usecaseBtn = new usecaseBtn(15,470, cP);
		
		buttonList.add(selectBtn);
		buttonList.add(associationBtn);
		buttonList.add(generalizationBtn);
		buttonList.add(compositionBtn);
		buttonList.add(classBtn);
		buttonList.add(usecaseBtn);
		
		//放到panel上
		for (int i = 0; i < buttonList.size();i++) {
			this.add(buttonList.get(i));
		}
		
		//把buttonList存到每個button物件的btnList裡
		for (int i = 0; i < buttonList.size();i++) {
			buttonList.get(i).btnList.addAll(buttonList);
		}
	}
}
