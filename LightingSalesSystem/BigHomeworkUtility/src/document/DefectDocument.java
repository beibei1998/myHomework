package document;

import assistant.ReadWriteTxt;

/**
 * ��input�ļ���д������
 * �˴�split�õ�Tab����Ϊ�ҵ�excel�ָ���ΪTab ����32�У����ǿ����Լ��ټ�һЩ����
 * */

public class DefectDocument {
	
	
	public static void main(String [] args){
		write();
	}
	
	public static String read(){
		String path = "defectInput.txt";
		String input = ReadWriteTxt.readTxt(path);
		return input;
	}
	
	public static void write(){
		String path  = "defect.txt";
		String content = "|ȱ��ID|��������|��������ID|�������|ʵ�ʽ��|���ȼ�|��ע|   ";
		content += System.lineSeparator()+"| :--- | :--- | :--- | :--- | :--- | :--- |  ";
		content += System.lineSeparator();
		
		String input = read();
		String[] lines=input.split(System.lineSeparator());
		for(String line:lines){
			String[] words = line.split("	");//�����õ�Tab
			for(int i=0;i<words.length;i++){
				if(i!=words.length-1){
					content +=" | "+ words[i];
				}
				else{
					content += " | "+ words[i]+" |    "+System.lineSeparator();
				}
			}
		}
		ReadWriteTxt.writeTxtAppend(path, content);
	}
}
