package Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class s1ActionListener implements ActionListener {
	DrawTest drawTest;int i;
	public s1ActionListener(DrawTest drawTest,int i) {
		// TODO 自动生成的构造函数存根
		this.drawTest = drawTest;
		this.i = i;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		drawTest.delay = i;
	}

}
