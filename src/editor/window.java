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
		setLocationRelativeTo(null);//�����b�ù�������
		
		canvasPanel canvasPanel = new canvasPanel();
		this.add(canvasPanel);
		
		buttonPanel btnPanel = new buttonPanel(canvasPanel);
		this.add(btnPanel);
		
		menubar menubar = new menubar(canvasPanel);
		this.setJMenuBar(menubar);
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //�o�˵��������~�|�u���������|�b��x����
		setVisible(true); //��ܵe��
	}
}
