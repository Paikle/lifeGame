package Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class initActionListener implements ActionListener {
	lifeGame lg ;
	public initActionListener(lifeGame lg) {
		// TODO �Զ����ɵĹ��캯�����
		this.lg = lg;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		lg.Initialization();
	}

}
