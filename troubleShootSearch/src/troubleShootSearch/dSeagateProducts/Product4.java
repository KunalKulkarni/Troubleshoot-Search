package troubleShootSearch.dSeagateProducts;

import java.util.ArrayList;

import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.Logger;
import troubleShootSearch.util.Logger.DebugLevel;
import troubleShootSearch.visitor.Visitor;

public class Product4 implements dSeagateProductI {
	ArrayList<String> Product4List = new ArrayList<>();

	String path;

	public Product4(String FilenameIn) {
		Logger.writeMessage("Product 4 Constructor", DebugLevel.CONSTRUCTOR);
		path = FilenameIn;
		FileProcessor fileProcessor = new FileProcessor(path);
		String Line = "";
		String allLines = "";
		while ((Line = fileProcessor.readLine()) != null) {
			allLines += Line;
		}
		;
		String[] arrOfStr = new String[allLines.length()];
		arrOfStr = allLines.split("\\.");
		setList(arrOfStr);
		Logger.writeMessage("Product 4 File Processed", DebugLevel.FILE_PROCESSOR);
	}
	

	/**
	 * This function returns an array List. 
	 * @returns ArrayList.
	 */	
	@Override
	public ArrayList<String> getList() {
		return Product4List;
		// TODO Auto-generated method stub

	}

	/**
	 * This function accepts the Array of String and store it's value in an array List. 
	 * @param aarOfStrIN[] array of string.
	 */	
	@Override
	public void setList(String[] arrOfStrIn) {
		for (int i = 0; i < arrOfStrIn.length; i++) {
			Product4List.add(arrOfStrIn[i]);
		}
	}

	/**
	 * This function accepts the Visitor. 
	 *	@param Visitor
	 */	
	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}

	public String toString() {

		return "Product 4 class";
	}

}
