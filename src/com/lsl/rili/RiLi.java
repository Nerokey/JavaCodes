package com.lsl.rili;

/**
 * ������С����
 * ����yyyy-mm-dd�����ӡ������µ�����������������ʾ������Ǽ���
 */
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class RiLi {
	
	public static void main(String[] args) throws ParseException {
		
		System.out.println("input a date(yyyy-mm-dd):");
		Scanner scan = new Scanner(System.in);
		String dateStr = scan.nextLine();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date d = df.parse(dateStr);
		Calendar cal = new GregorianCalendar();
		cal.setTime(d);
		int t = cal.get(Calendar.DAY_OF_MONTH); // ��ȡ�������һ�����
		cal.set(Calendar.DATE, 1);
		int a = cal.get(Calendar.DAY_OF_WEEK); // ��ȡ1�������ڼ�
		int max = cal.getActualMaximum(Calendar.DATE); // ��ȡÿ������������
		// ��ӡÿ��ǰ����Ŀհ�
		System.out.println("��\tһ\t��\t��\t��\t��\t��");
		for (int i = 1; i < a; i++) {
			System.out.print(" \t");
		}

		for (int i = 1; i <= max; i++) {
			if (i == t) {
				System.out.print("*");
			}
			System.out.print(i);
			System.out.print("\t");
			if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
				System.out.println();
			cal.add(Calendar.DATE, 1);
		}
	}
}
