package troubleShootSearch.visitor;

import java.util.ArrayList;

import troubleShootSearch.dSeagateProducts.dSeagateProductI;
import troubleShootSearch.util.Logger;
import troubleShootSearch.util.Results;
import troubleShootSearch.util.Logger.DebugLevel;

public class NaiveStemmingVisitor implements Visitor {

	Results r;
	ArrayList<String>inputList=new ArrayList<>();
	public NaiveStemmingVisitor(Results rIn,ArrayList<String>inputListIn) {
		
		inputList=inputListIn;
		r=rIn;
	}
	ArrayList <String> productList =new ArrayList<>();

	public void visit(dSeagateProductI dSeagateProductI) {
		
		Logger.writeMessage("Inside NaiveStemmingVisitor", DebugLevel.VISITOR);
		productList=dSeagateProductI.getList();
		String name=dSeagateProductI.getClass().getSimpleName();
		
		for(int k=0;k<inputList.size();k++) {
			
			String inputLine=inputList.get(k);
			inputLine=inputLine.toLowerCase();
			String inputWords[]=inputLine.split(" ");
			
			for(int i=0;i<productList.size();i++) {
				
				String getLine=productList.get(i);
				getLine=getLine.toLowerCase();
				String getWords []=getLine.split(" ");
				
				for(int j=0;j<getWords.length;j++) {
					if(getWords[j].contains(inputWords[0])) {
						r.setResult(name+" Naive Stemming Match "+"for query: "+inputList.get(k)+"\n"+productList.get(i)+"\n");
						Logger.writeMessage(name+" Naive Stemming Match "+"for query: "+inputList.get(k)+"\n"+productList.get(i)+"\n", DebugLevel.RESULTS);
					}
				}
			}
		}
	
	}
	public String toString() {
		
		return "Naive Stemming visitor class";
	}
}
