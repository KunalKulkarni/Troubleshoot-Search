package troubleShootSearch.dSeagateProducts;


import java.util.ArrayList;


import troubleShootSearch.visitor.Visitor;
import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.Logger;
import troubleShootSearch.util.Logger.DebugLevel;
public class Product1 implements dSeagateProductI {
	
	ArrayList<String> Product1List=new ArrayList<>();
	String path;
	public Product1(String filenameIn) {
		Logger.writeMessage("Product 1 Constructor", DebugLevel.CONSTRUCTOR);
		path=filenameIn;
		FileProcessor fileProcessor=new FileProcessor(path);
		
		String Line="";
		String allLines="";
		while((Line=fileProcessor.readLine())!=null) {
			allLines+=Line;
		};
		String [] arrOfStr=new String[allLines.length()];
		arrOfStr = allLines.split("\\.");
		setList(arrOfStr);
		Logger.writeMessage("Product 1 File Processed", DebugLevel.FILE_PROCESSOR);
	}


	/**
	 * This function returns an array List. 
	 * @returns ArrayList.
	 */	
	@Override
	public ArrayList<String> getList() {
		  
		return Product1List;  
	        
	}

	/**
	 * This function accepts the Array of String and store it's value in an array List. 
	 * @param arrOfStrIN[] array of string.
	 */	
	@Override
	public void setList(String arrOfStrIn[]) {
		
		for(int i=0;i<arrOfStrIn.length;i++)
		{
			Product1List.add(arrOfStrIn[i]);
		}
	}

	/**
	 * This function accepts the Visitor. 
	 *	@param Visitor
	 */	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
		
	}
	
	public String toString() {
		
		return "Product 1 class";
	}
}
