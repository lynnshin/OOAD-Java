package mode;

import java.awt.event.MouseEvent;

import obj.basicObj;
import obj.usecaseObj;
import panel.canvasPanel;

public class usecaseMode extends mode {

	public usecaseMode() {

	}
	
	public void mouseClicked(MouseEvent e, canvasPanel cP) {	
		System.out.println("usecase");
	}
	
	public void mousePressed(MouseEvent e, canvasPanel cP) {
		basicObj co = new usecaseObj(e.getX(), e.getY());	//�b�I����mnew�@��class����
		cP.objList.add(co);//�⪫��s�bobj��arraylist��
		co.setBounds(e.getX(), e.getY(), 85, 65);//�b�I������m���@�ӽd��
		cP.add(co,0);//���L��ܦbcanvas�W �᭱���ѼƬO�]�w�bLayerPane���h��
	}
}
