package com.lsl.chooseFood;
import java.util.ArrayList;

/**
 * ���˲�ϲ���Ĳ�
 * @author Nerokey
 *
 */
public class DislikeMenu {

	ArrayList<String> dislike = new ArrayList<String>();
	
	DislikeMenu(){
		
	}
	public void addDislike(String fname){
		dislike.add(fname);
	}
	//�жϸò����Ƿ���ڲ�ϲ���б���
	public boolean isExist(String s){
		int result = dislike.indexOf(s);
		if(result != -1){
			return true;
		}
		return false;
	}
}
