package Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class suspendActionListener implements ActionListener {
	DrawTest drawTest;
	public suspendActionListener(DrawTest drawTest) {
		// TODO �Զ����ɵĹ��캯�����
		this.drawTest = drawTest;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		drawTest.running = !drawTest.running;
	}

}
