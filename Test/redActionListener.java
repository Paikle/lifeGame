package Test;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class redActionListener implements ActionListener {
	DrawTest drawTest;
	
	public redActionListener(DrawTest drawTest) {
		// TODO �Զ����ɵĹ��캯�����
		this.drawTest = drawTest;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		drawTest.selectcolor = Color.RED;
	}

}
