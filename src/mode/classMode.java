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
		basicObj co = new classObj(e.getX(), e.getY());	//�b�I����mnew�@��class����
		cP.objList.add(co);//�⪫��s��obj��Vector��
		co.setBounds(e.getX(), e.getY(), 85, 65);//�b�I������m���@�ӽd��
		cP.add(co,0);//���L��ܦbcanvas�W �᭱���ѼƬO�]�w�bLayerPane���h��
	}
}
