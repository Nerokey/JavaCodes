package com.lsl.chooseFood;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * �˵���
 * ʹ��ArrayList���
 * @author Nerokey
 *
 */
public class FoodMenu {

	//�˵�
	ArrayList<String> list = new ArrayList<String>();
	
	FoodMenu(){
		
	}
	public void addFood(String fname){
		list.add(fname);
	}
	public String getFoodByNo(int no){
		return list.get(no);
	}

	public void showMenu(){
		Iterator iter = list.iterator();
		int i=1;
		System.out.println("*****�˵�*****");
		while(iter.hasNext()){
			System.out.println(i+". "+iter.next());
			i++;
		}
	}
}
