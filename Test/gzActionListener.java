package Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gzActionListener implements ActionListener {
	DrawTest drawTest;
	int w;
	public gzActionListener(DrawTest drawTest,int w) {
		// TODO �Զ����ɵĹ��캯�����
		this.drawTest = drawTest; 
		this.w = w;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		drawTest.w = w;
		drawTest.setBounds(100, 100, (drawTest.px*w)+200, (drawTest.py*w)+200);
		drawTest.paintComponents(drawTest.jg);
		drawTest.update();
	}

}
