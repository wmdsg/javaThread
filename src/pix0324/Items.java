package pix0324;
//单实例模式

import java.util.ArrayList;

public class Items {
	private ArrayList<Item> items=new ArrayList<>();
	private Items() {}//构造器私有化
	private static Items staticItems;
	public static Items getInstance() {
		if(staticItems==null) {
			staticItems=new Items();
		}
		return staticItems;
	}
	
	public void add(Item item) {
		items.add(item);
	}
	
	public void remove(Item item) {
		items.remove(item);
	}
	public void clear() {
		items.clear();
	}
	public Item get(int index) {
		return items.get(index);
	}
	
	public int size() {
		return items.size();
	}
	
}
