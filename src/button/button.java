package button;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import panel.canvasPanel;
import selfInterface.IButton;

public class button extends JButton implements ActionListener, IButton{

	public int locX,locY;
	public Vector<button> btnList = new Vector<button>();
	canvasPanel cP;

	public button(int locX, int locY, canvasPanel cP) {
		this.locX = locX;
		this.locY = locY;
		this.cP = cP;
		this.setBackground(Color.white);
		this.setBounds(locX, locY, 70, 70);
		this.setOpaque(true);  
		this.setContentAreaFilled(true);  
		this.setFocusPainted(false);
		this.addActionListener(this);//∫ ≈•button®∆•Û
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.resetBtn();
		this.setBackground(Color.lightGray);
	}
	
	public void setIconImg(String iconPath) {
		ImageIcon icon = new ImageIcon(getClass().getResource(iconPath));		
		Image resizeImg = icon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
		icon = new ImageIcon(resizeImg);
		this.setIcon(icon);
	}
	
	public void resetBtn() {
		for(int i = 0; i < btnList.size(); i++) {
			btnList.get(i).setBackground(Color.white);
		}		
	}
}
