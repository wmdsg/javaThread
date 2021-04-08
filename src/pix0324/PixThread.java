package pix0324;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class PixThread extends Thread{
	private MainWindow mainWindow;
	private Graphics g;
	private int[][] img;
	
	boolean isStart=false;
	boolean goback=false;
	int backcount=0;
	int count=0;
	private Items items=Items.getInstance();
	
	public PixThread(MainWindow mainWindow,int[][] img) {
		this.mainWindow=mainWindow;
		g=mainWindow.getGraphics();
		this.img=img;
	}
	//»­Á£×Ó
	public void run() {
		while(true) {
			BufferedImage bufferedImage=new BufferedImage(1900, 1000, BufferedImage.TYPE_INT_RGB);
			Graphics graphics=bufferedImage.getGraphics();
			if(isStart) {
				for(int i=0;i<items.size();i++) {
					Item item=items.get(i);
					item.drawSelf(graphics);
					item.move();
				}
				mainWindow.setImage(bufferedImage);
				if(!goback) {
					count++;
				}else {
					count--;
				if(count==0) {
					for(int i=0;i<items.size();i++) {
						Item item=items.get(i);
						item.acce=new MVec(-item.acce.getX(), -item.acce.getY());
					}
				}
				if(count<0) {
					backcount--;
				}
				if(backcount==0) {
					isStart=false;
					goback=false;
					count=0;
					items.clear();
					for(int i=0;i<img.length;i+=4) {
						for(int j=0;j<img[0].length;j+=4) {
							int v=img[i][j];
							MVec location=new MVec(500+i, 35+j);
							MVec veloc=new MVec(0, 0);
							Random random=new Random();
							float ax=random.nextFloat()*2-1;
							float ay=random.nextFloat()*2-1;
							MVec acce=new MVec(ax, ay);
							Item item=new Item(location, veloc, acce, v);
							items.add(item);
						}
					}
					mainWindow.loadImg();
				}
				}
			}
				mainWindow.repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	
	public void Init() {
		System.out.println(img.length);
		System.out.println(img[0].length);
		int zeroX=500;int zeroY=35;
		Random random=new Random();
		for(int i=0;i<img.length;i+=4) {
			for(int j=0;j<img[0].length;j+=4) {
				int v=img[i][j];
				MVec location=new MVec(zeroX+i, zeroY+j);
				MVec veloc=new MVec(0, 0);
				
				float ax=random.nextFloat()*2-1;
				float ay=random.nextFloat()*2-1;
				MVec acce=new MVec(ax, ay);
				
				Item item=new Item(location, veloc, acce, v);
				items.add(item);
			}
		}
	}
}
