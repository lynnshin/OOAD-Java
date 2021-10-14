package editor;

import java.awt.Button;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import panel.canvasPanel;


public class nameWindow extends JFrame implements ActionListener {

	public TextArea ObjNameField = new TextArea(null, 20, 10, TextArea.SCROLLBARS_NONE);
	
	public nameWindow(canvasPanel cP) {
		this.setTitle("Name"); 
		setLayout(null);
		setSize(200,200); 
		setLocationRelativeTo(null);		
		
		ObjNameField.setBounds(0, 0, 200, 100);//輸入的地方
		
		Button ok = new Button("OK");
		ok.setBounds(50, 100, 50, 50);
		
		Button cancel = new Button("Cancel");
		cancel.setBounds(100, 100, 50, 50);
		
		JFrame f = this;
		
		ok.addActionListener(new ActionListener() {			
			@Override
	         public void actionPerformed(ActionEvent e) { 
				for(int i = 0; i < cP.objList.size(); i++) {
					if(cP.objList.get(i).isClick) {//選到的物件如果在group裡面一起改名 (.changeName只會改點到的那個)
						cP.objList.get(i).myName = ObjNameField.getText();
						cP.objList.get(i).repaint();
					}					
				}
	            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	            f.dispose();	//關掉新視窗 	            
	         }			
			
		}); 
		
		cancel.addActionListener(new ActionListener() {
			@Override
	         public void actionPerformed(ActionEvent e) {
	            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
	            f.dispose();      
	         }
			
		}); 
		
		this.add(ObjNameField);
		this.add(ok);
		this.add(cancel);
		setVisible(true); 	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
