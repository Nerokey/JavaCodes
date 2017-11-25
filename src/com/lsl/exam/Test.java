package com.lsl.exam;
import java.util.Arrays;
import java.util.Scanner;

/**
 * ѡ����С����
 * ����һ������ĸ��࣬�ֱ��嵥ѡ����Ͷ�ѡ����̳��������
 * @author Nerokey
 *
 */
public class Test {

	//�жϵ�ѡ��s�Ĵ��Ƿ���ȷ
	public static boolean checkSingle(SingleChoice s, String answer){
		if(Character.toUpperCase(answer.charAt(0))==s.getAnswer()){
			System.out.println("����ˣ�");
			return true;
		}
		else{
			System.out.println("���ˣ�");
			return false;
		}
	}
	
	//�ж϶�ѡ��m�Ĵ��Ƿ���ȷ
	public static boolean checkMulti(MultiChoice m, String answer){
		
		String answ= answer.toUpperCase();
		char[] ans = answ.toCharArray();
		Arrays.sort(ans);
		Arrays.sort(m.getAnswer());
		if(Arrays.equals(ans, m.getAnswer())){
			System.out.println("��ϲ������ˣ�");
			return true;
		}
		else{
			System.out.println("�����ѽ��");
			return false;
		}
	}
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String chiose;   //�û�ѡ��Ĵ�
	
		SingleChoice s1 = new SingleChoice("�����������Ƽ����������˭��", "A.����\tB.˾���\tC.³��\tD.����", 'A');
		MultiChoice m1 = new MultiChoice("��԰��������Щ�ˣ�", "A.����\tB.�ܲ�\tC.����\tD.�ŷ�","ACD".toCharArray());
		
		System.out.println(s1.toString());   //��ӡ�����ѡ��
		System.out.print("��ѡ����Ĵ𰸣�");
		chiose= in.next();
		checkSingle(s1,chiose);
		
		System.out.println(m1.toString());   //��ӡ�����ѡ��
		System.out.print("��ѡ����Ĵ𰸣�");
		chiose= in.next();
		checkMulti(m1,chiose);
	}

}
