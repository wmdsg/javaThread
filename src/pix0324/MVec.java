package pix0324;

import java.lang.reflect.InvocationTargetException;

public class MVec {
	private float x;
	private float y;
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	
	public MVec(float x,float y) {
		this.x=x;
		this.y=y;
	}
	public void add(MVec mvec) {
		this.x+=mvec.x;
		this.y+=mvec.y;
	}
	
	public MVec multiply(float f) {
		return new MVec(this.x*f, this.y*f);
	}

}
