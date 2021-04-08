package pix0324;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

//共享队列练习

//整理关于图片获取，图像处理，线程，队列共享的几个关键点，整理出常用写法，常用模板。
public class MainWindow extends JFrame {
	public int[][] imgArray;
	private Image image;
	public MainWindow(){
		this.setTitle("粒子往复");
		this.setSize(1900, 1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loadImg();
		this.setVisible(true);
	}
	//画图片
	public void loadImg() {
		imgArray=getImagePixel("wife6.jfif");
		int zeroX=500;int zeroY=35;
		BufferedImage bufferedImage=new BufferedImage(1900, 1000, BufferedImage.TYPE_INT_RGB);
		Graphics graphics=bufferedImage.getGraphics();
		for(int i=0;i<imgArray.length;i++) {
			for(int j=0;j<imgArray[0].length;j++) {
				graphics.setColor(new Color(imgArray[i][j]));
				graphics.drawRect(zeroX+i, zeroY+j, 1, 1);
			}
		}
		this.image=bufferedImage;
	}
	public void setImage(Image image) {
		this.image=image;
	}
	
	
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, null);
	}
	
	public static void main(String[] args) {
		MainWindow mainWindow=new MainWindow();
		PixThread pixThread=new PixThread(mainWindow, mainWindow.imgArray);
		pixThread.Init();
		Listener listener=new Listener(pixThread);
		mainWindow.addKeyListener(listener);
		pixThread.start();
		
	}
	
	public int[][] getImagePixel(String path){
		File file=new File(path);
		BufferedImage bImage=null;
		try {
			bImage=ImageIO.read(file);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//得到宽高
		int w=bImage.getWidth();
		int h=bImage.getHeight();
		int[][] imageArray=new int[w][h];
		for(int i=0;i<w;i++) {
			for(int j=0;j<h;j++) {
				int pixel=bImage.getRGB(i, j);
				imageArray[i][j]=pixel;
			}
		}
		return imageArray;
	}
}
