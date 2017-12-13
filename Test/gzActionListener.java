package Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gzActionListener implements ActionListener {
	DrawTest drawTest;
	int w;
	public gzActionListener(DrawTest drawTest,int w) {
		// TODO 自动生成的构造函数存根
		this.drawTest = drawTest; 
		this.w = w;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		drawTest.w = w;
		drawTest.setBounds(100, 100, (drawTest.px*w)+200, (drawTest.py*w)+200);
		drawTest.paintComponents(drawTest.jg);
		drawTest.update();
	}

}
