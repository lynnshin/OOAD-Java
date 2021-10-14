package editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import obj.groupObj;
import panel.canvasPanel;


public class menubar extends JMenuBar implements ActionListener {

	public menubar(canvasPanel cP) {
		JMenu fileMenu = new JMenu("File");
	    JMenu editMenu = new JMenu("Edit"); 
	    
	    JMenuItem group = new JMenuItem("Group");
	    JMenuItem unGroup = new JMenuItem("UnGroup");
	    JMenuItem changeName = new JMenuItem("Change Object Name");
	    
	    group.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		//group起來的物件加到groupObj中
	    		cP.gO.addchild(cP.cloneGroup);
	    		cP.gO.groupbygroup();
	    		System.out.println(cP.gO.groupObjs);
	    	}
	    });
	    
	    unGroup.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		//從最後group起來的開始找 刪掉最早符合
	    		for (int i = cP.gO.groupObjs.size()-1; i >= 0; i--) {
	    			if(cP.gO.groupObjs.get(i).contains(cP.clickObj)) {
	    				cP.gO.removechild(cP.gO.groupObjs.get(i));
	    				cP.gO.groupbygroup();
	    				break;
	    			}
	    		}
	    	}
	    });
	    
	    changeName.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    			//開新視窗
		    		nameWindow openChangeName = new nameWindow(cP);	    		
	    	}
	    });
	    
	    editMenu.add(group);
	    editMenu.add(unGroup);
	    editMenu.add(changeName);
	    
	    this.add(fileMenu);
	    this.add(editMenu);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}

	
