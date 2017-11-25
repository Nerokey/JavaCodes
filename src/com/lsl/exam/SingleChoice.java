package com.lsl.exam;

/**
 * ��ѡ����
 * �𰸴���һ���ַ�������
 * @author Nerokey
 *
 */
public class SingleChoice extends Question {

	private char rightAns;
	
	SingleChoice(String text, String option, char rightAns) {
		super(text, option);
		this.rightAns = rightAns;
	}

	public char getAnswer() {
		return rightAns;
	}

	public void setAnswer(char rightAns) {
		this.rightAns = rightAns;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(��ѡ)"+this.getText()+"\n"+this.getOption();
	}
}
