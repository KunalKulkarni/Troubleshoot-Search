package troubleShootSearch.driver;

import java.io.File;
import java.util.ArrayList;

import troubleShootSearch.dSeagateProducts.Product1;
import troubleShootSearch.dSeagateProducts.Product2;
import troubleShootSearch.dSeagateProducts.Product3;
import troubleShootSearch.dSeagateProducts.Product4;
import troubleShootSearch.dSeagateProducts.dSeagateProductI;
import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.Logger;
import troubleShootSearch.util.Logger.DebugLevel;
import troubleShootSearch.util.Results;
import troubleShootSearch.visitor.*;
/*
 * Driver class which facilitates following actions:
 * 1. Validation of Command Line Arguments
 * 2. Input file sent to each Product
 * 3. All visitors called on all 4 products
 * 4. Write the corresponding results to output.txt
 * @param args
 */
public class Driver {
	public static void main(String[] args) {

		argCheck(args);
		int level = Integer.parseInt(args[0]);

		if (level < 0 || level > 4) {

			System.err.println("Enter correct Debug Level");
			System.exit(1);
		}

		Logger.setDebugValue(level);
		Results r = new Results();
		String line;
		String fileName = "src/input.txt";
		FileProcessor fp = new FileProcessor(fileName);
		ArrayList<String> inputList = new ArrayList<>();

		while ((line = fp.readLine()) != null)
			inputList.add(line);

		dSeagateProductI Product1 = new Product1("src/One.txt");
		dSeagateProductI Product2 = new Product2("src/Two.txt");
		dSeagateProductI Product3 = new Product3("src/Three.txt");
		dSeagateProductI Product4 = new Product4("src/Four.txt");

		ExactMatchVisitor exactMatch = new ExactMatchVisitor(r, inputList);
		NaiveStemmingVisitor naiveMatch = new NaiveStemmingVisitor(r, inputList);
		SemanticMatchVisitor semanticMatch = new SemanticMatchVisitor(r, inputList);

		Product1.accept(exactMatch);
		Product2.accept(exactMatch);
		Product3.accept(exactMatch);
		Product4.accept(exactMatch);
		
		Product1.accept(naiveMatch);
		Product2.accept(naiveMatch);
		Product3.accept(naiveMatch);
		Product4.accept(naiveMatch);
		
		Product1.accept(semanticMatch);
		Product2.accept(semanticMatch);
		Product3.accept(semanticMatch);
		Product4.accept(semanticMatch);

		r.writeToFile("output.txt");
		
	}

	/**
	 * Function to check if the command line arguments are valid or not.
	 * @param arr - Array of command line arguments.
	 */
	static void argCheck(String arr[]){
		
				if(arr.length==0){
					
					Logger.writeMessage("Invalid Number of Arguments.Enter 1 Argument - DebugLevel", DebugLevel.NONE);
					System.err.println("Invalid Number of Arguments.Enter 1 Argument - DebugLevel");
					System.exit(1);
				}

	}
}
