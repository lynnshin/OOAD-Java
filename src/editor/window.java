package editor;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import panel.buttonPanel;
import panel.canvasPanel;

public class window extends JFrame{

	public window(){
		this.setTitle("UML Editor"); 
		setLayout(null);
		setSize(800,620); 
		setLocationRelativeTo(null);//視窗在螢幕正中間
		
		canvasPanel canvasPanel = new canvasPanel();
		this.add(canvasPanel);
		
		buttonPanel btnPanel = new buttonPanel(canvasPanel);
		this.add(btnPanel);
		
		menubar menubar = new menubar(canvasPanel);
		this.setJMenuBar(menubar);
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //這樣視窗關掉才會真的關掉不會在後台執行
		setVisible(true); //顯示畫面
	}
}
