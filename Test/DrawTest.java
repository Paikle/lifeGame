package Test;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class DrawTest extends JFrame {
	
	private static int sx = 100;
	private static int sy = 100;
	protected static int w  = 20;
	private static int rw = 400;
	protected int px = 0,py = 0;
	protected Color backcolor = Color.black;
	protected Color selectcolor = Color.BLUE;
	Graphics jg;
	
	lifeGame lg = new lifeGame();
	boolean running = false; 
	//private Thread animator;
	int delay = 5;
	
	public DrawTest() {	//构造函数
		super("生命游戏");
		this.px = lg.HEIGH;
		this.py = lg.WIDTH;
		System.out.println("px:py"+px+py);
		Container p = getContentPane();
		setBounds(100, 100, (px*w)+200, (py*w)+200);//设置窗口的大小和位置,没有问题
		setVisible(true);
		p.setBackground(backcolor);
		setLayout(null);
		setResizable(false);
		p.setLocation(px, py);
		p.setSize((px*w)+100, (py*w)+100);
		
		JMenuBar Menu = new JMenuBar();
		this.setJMenuBar(Menu);
		JMenu options = new JMenu("options");
		Menu.add(options);
		JMenu color = new JMenu("colors");
		Menu.add(color);
		
		JMenu selectColor = new JMenu("selectcolor");
		color.add(selectColor);
		JMenu backColor = new JMenu("backcolor");
		color.add(backColor);
		JMenu speed = new JMenu("speed");
		Menu.add(speed);
		JMenu size = new JMenu("size");
		Menu.add(size);
		JMenu gez = new JMenu("方块大小");
		size.add(gez);
		JMenu chk = new JMenu("窗口");
		size.add(chk);
		//options子菜单
		JMenuItem init = new JMenuItem("init");
		init.addActionListener(new initActionListener(lg));
		options.add(init);
		options.addSeparator();
		JMenuItem suspend = new JMenuItem("pause");
		suspend.addActionListener(new suspendActionListener(this));
		options.add(suspend);
		JMenuItem begin = new JMenuItem("begin");
		begin.addActionListener(new suspendActionListener(this));
		options.add(begin);
		//colors子菜单
		JMenuItem red = new JMenuItem("red");
		red.addActionListener(new redActionListener(this));
		selectColor.add(red);
		JMenuItem blue = new JMenuItem("blue");
		blue.addActionListener(new blueActionListener(this));
		selectColor.add(blue);
		//speed
		JMenuItem s1 = new JMenuItem("10");
		s1.addActionListener(new s1ActionListener(this,1));
		speed.add(s1);
		JMenuItem s5 = new JMenuItem("5");
		s5.addActionListener(new s1ActionListener(this, 5));
		speed.add(s5);
		JMenuItem s10 = new JMenuItem("1");
		s10.addActionListener(new s1ActionListener(this, 10));
		speed.add(s10);
		//size.gez
		JMenuItem g20 = new JMenuItem("20");
		g20.addActionListener(new gzActionListener(this,20));
		JMenuItem g30 = new JMenuItem("30");
		g30.addActionListener(new gzActionListener(this,30));
		JMenuItem g40 = new JMenuItem("40");
		g40.addActionListener(new gzActionListener(this,40));
		gez.add(g20);gez.add(g30);gez.add(g40);
		//size.chk
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
				Thread.sleep(1000);
			}catch(Exception e) {
				e.printStackTrace();
			}
		jg = this.getGraphics();
		paintComponents(jg);
		
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				int x = e.getX();
				int y = e.getY();
				int cx = (x - sx) / w;
				int cy = (y - sy) / w;System.out.println("x:y"+x+","+y+"cx:cy"+cx+","+cy);
				if(cx<0||cy<0||cx>=lg.HEIGH||cy>=lg.WIDTH) {
					return ;
				}
				compare(cx,cy);
			}
		});	
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 32) {
					running = !running;
				}
			}
		});
		while(true) {
			if(running == true) {
				lg.getNeighbors();
				update();
				lg.nextworld();
				paintComponents(jg);
//				repaint();
				System.out.println("在循环内");
			}
			try {
				
				Thread.sleep((delay*100));
			} catch (InterruptedException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
				break;
			}
		}
	}
	/*
	public int getHeigh() {
		return lg.HEIGH+100;
	}
	public int getWidth() {
		return lg.WIDTH+100;
	}
	*/
	public void paintComponents(Graphics s) {
		try {
			//super.paintComponents(s);
			s.setColor(Color.red);
			s.drawRect(sx, sy, px*w, py*w);//sx sy 起始位置,rw rw目标大小
			System.out.println("px:py"+px+py);
			for(int i =1;i<px;i++) {
				s.drawLine(sx+(i*w), sy	, sx+(i*w), sy + (py*w));
			}
			for(int j = 1;j<py;j++) {
				s.drawLine(sx, sy+(j*w), sx+(px*w), sy+(j*w));
			}
		}catch(Exception e ) {
				e.printStackTrace();
			}
	
	}


	private void compare(int cx, int cy) {//鼠标点击的颜色
		// TODO 自动生成的方法存根
		lg.rectangle[cx][cy] = !lg.rectangle[cx][cy];
		if(lg.rectangle[cx][cy] == true)
		setGrid(cx,cy,selectcolor);
		else{
			setGrid(cx,cy,backcolor);
		}
	}
	private void setGrid(int cx, int cy, Color color) {
		// TODO 自动生成的方法存根
		jg.setColor(color);
		jg.fillRect(sx + (cx * w)+1, sy + (cy * w) + 1, w-1, w-1);
		
	}
	public void update() {
		for(int x = 0;x < lg.HEIGH;x++) {
			for(int y = 0;y < lg.WIDTH ;y++) {
				if(lg.rectangle[x][y] == true) {
					setGrid(x,y,selectcolor);
				}
				else setGrid(x,y,backcolor);
			}
		}
	}
}
