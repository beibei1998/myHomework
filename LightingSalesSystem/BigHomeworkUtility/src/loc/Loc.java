package loc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Loc {
	static int doc =0;
	static int files =0;
	 public static void main(String[] args){
		 /**
		  * �����������ļ���·���Ϳ���ͳ�ƴ�������֮���
		  * */
	        String path = "D:\\��\\��2\\����ҵgit��Ŀ\\LightingSalesSystem\\SalesSystemClient\\src";
	        //String path =  "D:\\��\\��2\\����ҵgit��Ŀ\\LightingSalesSystem\\SalesSystemServer\\src";
	        int lines = codeLines(path);
	        System.out.println("java�ļ���"+files);
	        System.out.println("����������:"+lines);
	        System.out.println("ע������:"+doc);
	        
	    }
	    
	    private static int codeLines(String rootPath){
	        int lines = 0;
	        File root = new File(rootPath);
	        File[] dirsAndFiles = root.listFiles();
	        for(File f: dirsAndFiles){
	            if(f.isDirectory()){
	                lines += codeLines(f.getAbsolutePath());
	            } else {
	                lines += codeLinesInFile(f);
	            }
	        }
	        return lines;
	    }
	    
	    private static int codeLinesInFile(File f){
	        if(!f.getName().contains("java")){return 0;}
	    	if(f.isDirectory()) return 0;
	    	files++;
	        int lines = 0;
	        try{
	            BufferedReader reader = new BufferedReader(new FileReader(f));
	            String line;
	            while((line = reader.readLine()) != null){
	                if(line.contains("{") || line.contains("}") || line.contains(";")){
	                    lines++;
	                 }
	                if(line.contains("/")||line.contains("\\")||line.contains("*")){
	                	doc++;
	                }
	            }
	            reader.close();
	            return lines;
	        }catch(Exception e){
	            e.printStackTrace();
	            return 0;
	        }
	    }
}
