package troubleShootSearch.visitor;
import java.util.ArrayList;
import java.util.HashMap;

import troubleShootSearch.dSeagateProducts.dSeagateProductI;
import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.Logger;
import troubleShootSearch.util.Results;
import troubleShootSearch.util.Logger.DebugLevel;

public class SemanticMatchVisitor implements Visitor {
	ArrayList <String> productList =new ArrayList<>();
	ArrayList <String> inputList =new ArrayList<>();
	HashMap<String,String> wordMap=new HashMap<>();
	Results r;
	public SemanticMatchVisitor(Results RIn,ArrayList <String> inputListIn) {
		
		inputList=inputListIn;
		FileProcessor fileProcessor=new FileProcessor("src/synonyms.txt");
		r=RIn;
		ArrayList<String> Synonyms=new ArrayList<>();
		String Line="";
		String arrSplit[]=new String[2];
		while((Line=fileProcessor.readLine())!=null) {
			
			arrSplit=Line.split(":");
			wordMap.put(arrSplit[0], arrSplit[1]);
		};
	}
	public void visit(dSeagateProductI dSeagateProductI) {
		
		Logger.writeMessage("Inside SemanticMatchVisitor", DebugLevel.VISITOR);
		productList=dSeagateProductI.getList();
		
		for(int k=0;k<inputList.size();k++) {

			String inputLine=inputList.get(k);
			String inputWords[]=inputLine.split(" ");
			String lastWord=inputWords[inputWords.length-1];
			
			for(int i=0;i<productList.size();i++) {
				
				String name=dSeagateProductI.getClass().getSimpleName();
				String getLine=productList.get(i);
				getLine=getLine.toLowerCase();
				String getWords []=getLine.split(" ");
				
					for(int j=0;j<getWords.length;j++) {
				
					if(lastWord.equals(wordMap.get(getWords[j]))){
						
						r.setResult(name+" Semantic Match "+"for query: "+inputList.get(k)+"\n"+productList.get(i)+"\n");
						Logger.writeMessage(name+" Semantic Match "+"for query: "+inputList.get(k)+"\n"+productList.get(i)+"\n", DebugLevel.RESULTS);
						
					}
				}
			}
		}
	}
	
	public String toString() {
		
		return "Semantic Match Visitor class";
	}
	
}
