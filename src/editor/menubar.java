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
	    		//group�_�Ӫ�����[��groupObj��
	    		cP.gO.addchild(cP.cloneGroup);
	    		cP.gO.groupbygroup();
	    		System.out.println(cP.gO.groupObjs);
	    	}
	    });
	    
	    unGroup.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		//�q�̫�group�_�Ӫ��}�l�� �R���̦��ŦX
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
	    			//�}�s����
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

	
