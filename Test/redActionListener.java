package Test;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class redActionListener implements ActionListener {
	DrawTest drawTest;
	
	public redActionListener(DrawTest drawTest) {
		// TODO 自动生成的构造函数存根
		this.drawTest = drawTest;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		drawTest.selectcolor = Color.RED;
	}

}
