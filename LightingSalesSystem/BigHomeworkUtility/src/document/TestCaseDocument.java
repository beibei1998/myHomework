package document;

import assistant.ReadWriteTxt;

/**
 * @see DefectDocument��
 * */

public class TestCaseDocument {

	public static void main(String [] args){
		write();
	}
	
	public static String read(){
		String path = "TestCaseInput.txt";
		String input = ReadWriteTxt.readTxt(path);
		return input;
	}
	
	public static void write(){
		String path  = "testCase.txt";
		String content = "|��������ID|����|�������|���Խ��|���Զ���ID|   ";
		content += System.lineSeparator()+"| :--- | :--- | :--- | :--- | :--- |   ";
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
