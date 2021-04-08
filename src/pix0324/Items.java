package pix0324;
//��ʵ��ģʽ

import java.util.ArrayList;

public class Items {
	private ArrayList<Item> items=new ArrayList<>();
	private Items() {}//������˽�л�
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
