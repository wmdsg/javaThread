package pix0324;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listener implements KeyListener{
	PixThread pixThread;
	public Listener(PixThread pixThread) {
		this.pixThread=pixThread;
	}
	
	public void keyTyped(KeyEvent e){
		
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_1) {
			pixThread.isStart=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_2) {
			pixThread.goback=true;
			pixThread.backcount=pixThread.count;
			pixThread.count=2*pixThread.count;
			Items items=Items.getInstance();
			for(int i=0;i<items.size();i++) {
				Item item=items.get(i);
				item.acce=new MVec(-item.acce.getX(), -item.acce.getY());
			}
			
		}
	}
	
	public void keyReleased(KeyEvent e) {
		
	}
}
