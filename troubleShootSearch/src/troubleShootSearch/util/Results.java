package troubleShootSearch.util;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Results implements FileDisplayInterface{

	FileWriter fw;
	PrintWriter pw;
	String resultString;
	public Results(){
		
		resultString="";
	}
	
	public void setResult(String data){
		
		resultString=resultString+data+"\n";
	}
	

	@Override
	public void writeToFile(String filename) {
		// TODO Auto-generated method stub
		try {
			
			fw=new FileWriter(filename,true);
			pw=new PrintWriter(fw,true);
			pw.println(resultString);
		} catch (IOException e) {

			System.out.println("Error in Filename");
			System.exit(1);
			e.printStackTrace();
		}
		
		try {
			
			pw.flush();
			fw.close();
			pw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String toString(){
	String s="Class used to write the Search results onto the File and StdOut"+resultString;
	return s;
}
	
}