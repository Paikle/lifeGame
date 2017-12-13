package Test;

public class lifeGame {
	protected int HEIGH = 20;
	protected int WIDTH = 20;
	
	boolean [][] rectangle = new boolean[HEIGH][WIDTH];
	int [][] neighbors = new int[HEIGH][WIDTH];
	
	
	public lifeGame() {
		Initialization();
		
	}
	public void Initialization() {//��ʼ��//��rectangle�е�ֵ��ʼ��Ϊfalse
		for(int x = 0;x<HEIGH;x++) {
			for(int y = 0;y<WIDTH;y++) {
				rectangle[x][y] = false;
				neighbors[x][y] = 0;
			}
		}
	}
	public int Torf(int x,int y) {//�������ֵ�ǲ���Ϊǽ�ڻ����ǿ�,�Ƚ��Ƿ�ΪNo
		boolean Next = (x<0||y<0||x>=HEIGH||y>=WIDTH||rectangle[x][y]== false);
		return Next?0:1;
	}
	public void getNeighbors() {//�����������Χ�Ļ�������
		int x,y;
		for(x= 0;x < HEIGH;x++)
			for(y = 0;y < WIDTH;y++) {
				neighbors[x][y] = 0;
				neighbors[x][y] += Torf(x-1,y-1);
				neighbors[x][y] += Torf(x-1, y);
				neighbors[x][y] += Torf(x-1, y+1);
				neighbors[x][y] += Torf(x, y-1);
				neighbors[x][y] += Torf(x, y+1);
				neighbors[x][y] += Torf(x+1, y-1);
				neighbors[x][y] += Torf(x+1, y);
				neighbors[x][y] += Torf(x+1, y+1);
			}
	}
	public void nextworld() {
		int x=0,y=0;
			for(x = 0;x<HEIGH;x++)
				for(y = 0;y<WIDTH;y++) {					
					if(neighbors[x][y] == 3) {
						rectangle[x][y] = true;
					}
					else if(neighbors[x][y]<2||neighbors[x][y]>3) {
						rectangle[x][y] = false;
					}
//					neighbors[x][y]=0;
				}
	}
	
}
