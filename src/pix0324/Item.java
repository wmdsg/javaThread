package pix0324;
//

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Item {
	public MVec location;
	public MVec veloc;
	public MVec acce;
	public int color;
	
	int len=4;
	public Item(MVec location,MVec veloc,MVec acce,int color) {
		this.location=location;
		this.veloc=veloc;
		this.acce=acce;
		this.color=color;
		len=4;
	}
	public void drawSelf(Graphics graphics) {
		graphics.setColor(new Color(color));
		graphics.fillRect((int)location.getX(), (int)location.getY(), len, len);
	}
	
	public void move() {
		this.veloc.add(acce);
		this.location.add(veloc);
	}
	
	public void setAcce(MVec acce) {
		this.acce=acce;
	}
}
