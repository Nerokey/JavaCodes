package com.lsl.exam;

/**
 * ѡ����Ļ���
 * ���������ֶκ�ѡ���ֶ�
 * @author Nerokey
 *
 */
public class Question {

	private String text;   //����
	private String option;  //ѡ��
	
	Question(String text,String option){
		this.text = text;
		this.option = option;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	
}
