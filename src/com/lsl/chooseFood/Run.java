package com.lsl.chooseFood;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * ���ϵͳ
 * ��������
 * ������ʾ�˵����������ֵ�ˣ�����㵽���˲�ϲ���Ĳ����׳��쳣
 * @author Nerokey
 *
 */
public class Run {

	public static void main(String[] args) throws BadFoodException {		
		Scanner sc = new Scanner(System.in);
		//�û�ѡ��Ĳ�list
		ArrayList<String> list = new ArrayList<String>();

		//�����˵�����Ӳ�
		FoodMenu fm = new FoodMenu();
		fm.addFood("�������");
		fm.addFood("�Ź�������");
		fm.addFood("�б�����");
		fm.addFood("��������˿");
		fm.addFood("�峴�˻�");
		fm.addFood("�峴����");
		fm.showMenu();
		
		//����dislikeMenu
		DislikeMenu dis = new DislikeMenu();
		dis.addDislike("�б�����");
		dis.addDislike("�峴�˻�");
		
		while(true){
			try{
				System.out.print("���ˣ������ż���(0��ʾ��˽���):");
				int chiose = sc.nextInt();
				if(chiose==0){
					break;
				}
				if(dis.isExist(fm.getFoodByNo(chiose-1))){
					throw new BadFoodException("���˲�ϲ���ò�Ʒ...");
				}
				else{
					list.add(fm.getFoodByNo(chiose-1));		
				}
			} catch(BadFoodException e){
				System.out.println(e.getMessage());
			}
			finally{
				System.out.println("���ѵ��Ʒ���£�");
				for(int i=0;i<list.size();i++){
					System.out.println((i+1)+". "+list.get(i));
				}				
			}
		}
		System.out.println("��˽�������лʹ�ã�");
	}
}
