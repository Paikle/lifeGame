package Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class s1ActionListener implements ActionListener {
	DrawTest drawTest;int i;
	public s1ActionListener(DrawTest drawTest,int i) {
		// TODO �Զ����ɵĹ��캯�����
		this.drawTest = drawTest;
		this.i = i;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		drawTest.delay = i;
	}

}
