package Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class initActionListener implements ActionListener {
	lifeGame lg ;
	public initActionListener(lifeGame lg) {
		// TODO 自动生成的构造函数存根
		this.lg = lg;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		lg.Initialization();
	}

}
