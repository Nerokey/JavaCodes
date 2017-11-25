package com.lsl.scoreManage;

/**
 * дһ����������û������ָ��õ�������
 * ָ����    avg:��ĳ��ͬѧ���߿γ̵�ƽ���֣����������Ϊ�γ�������ѧ������
 *       get:��ȡĳ��ͬѧ��ĳ�ſγ̵ķ���    ����:get Tom Java��Ϊ��ȡTomͬѧ��Java�γ̷���
 *       max:���ĳ�ſγ̻���ĳ��ͬѧ����߷֣���������
 *       sort:��ĳ�ſγ̵ķ����������򣬲�ʹ���б����
 */
import java.text.DecimalFormat;
import java.util.Scanner;

public class Run {
	static String[] students = { "Tom", "Lucy", "Nero", "Zhang", "Jane" }; // ѧ������
	static String[] courses = { "Java", "C++", "SQL", "Html", "Math", "English" }; // �γ�����

	// ѧ���ɼ���ά����
	static int[][] grade = { { 76, 90, 66, 99, 20, 64 }, 
							 { 69, 88, 80, 91, 83, 66 }, 
							 { 8, 46, 77, 63, 57, 18 },
							 { 21, 94, 83, 52, 47, 84 }, 
							 { 37, 60, 72, 53, 88, 93 } 
						   };
	// ��ʽ��С����С�������2λ
	static DecimalFormat df = new DecimalFormat("#.00");

	// ��ӡ��ͷѧ���ɼ��ı��
	public static void printInfo() {
		for (int i = 0; i < courses.length; i++) { // ��ӡ��һ��
			System.out.print("\t" + courses[i]);
		}
		System.out.println();
		// ��ӡ���漸��
		for (int i = 0; i < grade.length; i++) {
			System.out.print(students[i] + "\t");
			for (int j = 0; j < grade[i].length; j++) {
				System.out.print(grade[i][j] + "\t");
			}
			System.out.println();
		}
	}

	// ��ȡĳ���ַ����������е�����ֵ�������ڷ���-1�������򷵻�Ԫ���±ꡣ
	public static int getIndex(String[] s, String str) {
		int index = -1;
		for (int i = 0; i < s.length; i++) {
			if (s[i].equalsIgnoreCase(str)) {
				index = i;
			}
		}
		return index;
	}

	// avg���ͳ��ƽ���ַ���
	public static boolean avg(String str) {
		// �������Ϊall�����
		if (str.equalsIgnoreCase("all")) {
			for (int i = 0; i < courses.length; i++) {
				System.out.print("\t" + courses[i]);
			}
			System.out.print("\tƽ����\n");

			// ��ӡ�������
			for (int i = 0; i < grade.length; i++) {
				System.out.print(students[i] + "\t");
				double sum = 0;
				for (int j = 0; j < grade[i].length; j++) {
					System.out.print(grade[i][j] + "\t");
					sum += grade[i][j];
				}
				// ��ʾĳ��ͬѧ��ƽ����
				System.out.println(df.format(sum / courses.length));
			}
			System.out.print("ƽ����\t");
			// ��ʾĳ�ſγ�ƽ����
			for (int i = 0; i < courses.length; i++) {
				double total = 0;
				for (int j = 0; j < students.length; j++) {
					total += grade[j][i];
				}
				System.out.print(df.format(total / students.length) + "\t");
			}
			System.out.println();
			return true;
		}
		// ���������all��
		int index1 = getIndex(courses, str);
		int index2 = getIndex(students, str);
		if (index1 == -1 && index2 == -1) {
			System.out.println("û�����ͬѧ�������ſγ̣�");
			return false;
		}
		// �Կγ�Ϊ��λ����ƽ����
		if (index1 != -1) {
			double s1 = 0;
			for (int i = 0; i < students.length; i++) {
				s1 += grade[i][index1];
			}
			System.out.println(courses[index1] + "��ƽ����Ϊ��" + df.format(s1 / students.length));
		}
		// ��ͬѧΪ��λ����ƽ����
		if (index2 != -1) {
			double s2 = 0;
			for (int i = 0; i < courses.length; i++) {
				s2 += grade[index2][i];
			}
			System.out.println(students[index2] + "ͬѧ��ƽ����Ϊ��" + df.format(s2 / courses.length));
		}
		return true;
	}

	// get�����ȡĳ���˵�ĳ�ſεĳɼ�
	public static boolean get(String name, String coursename) {
		int co_index = getIndex(courses, coursename); // �γ�������
		int na_index = getIndex(students, name); // ��������
		if (na_index == -1) {
			System.out.println("û�����ͬѧ��");
			return false;
		} else if (co_index == -1) {
			System.out.println("û�����ſγ̣�");
			return false;
		} else {
			System.out.println(students[na_index] + "ͬѧ��" + courses[co_index] + "����Ϊ��" + grade[na_index][co_index]);
		}
		return true;
	}

	// max�����ȡĳ�ſγ̻���ѧ������߷�
	public static boolean max(String str) {
		int index1 = getIndex(courses, str);
		int index2 = getIndex(students, str);
		// ����γ�����������������
		if (index1 == -1 && index2 == -1) {
			System.out.println("û�����ͬѧ�������ſγ̣�");
			return false;
		}
		int max = 0;
		int k = -1;
		// ����Ϊ�γ��������
		if (index1 != -1) {
			for (int i = 0; i < students.length; i++) {
				if (grade[i][index1] > max) {
					max = grade[i][index1];
					k = i;
				}
			}
			System.out.println(courses[index1] + "�γ̵���߷���" + students[k] + ",����Ϊ��" + grade[k][index1]);
			return true;
		}
		// ����Ϊͬѧ���ֵ����
		if (index2 != -1) {
			for (int i = 0; i < courses.length; i++) {
				if (grade[index2][i] > max) {
					max = grade[index2][i];
					k = i;
				}
			}
			System.out.println(students[index2] + "ͬѧ����߷���" + courses[k] + "������Ϊ��" + grade[index2][k]);
			return true;
		}
		return false;
	}

	// sort�����ĳ�ſγ̽��������б����
	public static boolean sort(String str) {
		// ��ȡ�γ���������
		int index = getIndex(courses, str);
		if (index == -1) {
			System.out.println("û�����ſγ̣�");
			return false;
		}
		int temp[] = new int[students.length];
		// ��ѧ����������Ҫ����ĳɼ�ȫ��������
		for (int i = 0; i < students.length; i++) {
			temp[i] = grade[i][index];
		}
		System.out.println("����\t����\t" + courses[index]); // ��ӡ��ͷ
		int k = -1;
		for (int i = 0; i < students.length; i++) {
			int max = -1;
			for (int j = 0; j < students.length; j++) {
				if (temp[j] > max) {
					k = j;
					max = temp[k];
				}
			}
			temp[k] = -1;
			System.out.println((i + 1) + "\t" + students[k] + "\t" + max);
		}
		return false;
	}

	// �������������
	public static void commandInput() {
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.print("���������");
			String command = in.next();

			if (command.equalsIgnoreCase("avg")) {
				// ͳ�� �γ�(+�γ���)��ѧ��(+ѧ������)������(+all:�����γ̺�ѧ��)��ƽ����
				String parameter = in.next();
				avg(parameter);
			}
			if (command.equalsIgnoreCase("get")) {
				// ��ȡĳ��ѧ����ĳ�ſγɼ�
				String parter1 = in.next(); // ����1:+ѧ������
				String parter2 = in.next(); // ����2:+�γ���
				get(parter1, parter2);
			}
			if (command.equalsIgnoreCase("sort")) {
				// �г�ĳ�ſγ̵�������
				String parter = in.next(); // ������+�γ���
				sort(parter);
			}
			if (command.equalsIgnoreCase("max")) {
				// ��ȡĳ�ſλ���ĳ��ѧ�������ֵ
				String parter = in.next(); // ������+ѧ���������߿γ���
				max(parter);
			}
			if (command.equalsIgnoreCase("exit")) {
				System.out.println("ϵͳ�˳�����лʹ�ã���");
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		Run.printInfo();
		commandInput();
	}
}
