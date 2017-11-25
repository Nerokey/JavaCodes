package com.lsl.exam;

/**
 * ��ѡ����
 * �����ַ�������
 * @author Nerokey
 *
 */
public class MultiChoice extends Question {

	private char[] answer;
	
	MultiChoice(String text, String option, char[] answer){
		super(text, option);
		this.answer = answer;
	}

	public char[] getAnswer() {
		return answer;
	}

	public void setAnswer(char[] answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(��ѡ)"+this.getText()+"\n"+this.getOption();
	}
	
	
	
}
