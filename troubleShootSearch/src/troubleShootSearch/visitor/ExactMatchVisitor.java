package troubleShootSearch.visitor;

import java.util.ArrayList;

import troubleShootSearch.dSeagateProducts.dSeagateProductI;
import troubleShootSearch.util.Logger;
import troubleShootSearch.util.Results;
import troubleShootSearch.util.Logger.DebugLevel;

public class ExactMatchVisitor implements Visitor{

	Results r;
	ArrayList<String>inputList=new ArrayList<>();
	
	public ExactMatchVisitor(Results rIn,ArrayList<String> inputListIn) {
		
		r=rIn;
		inputList=inputListIn;
	}
	
	ArrayList <String> productList =new ArrayList<>();
	
	public void visit(dSeagateProductI dSeagateProductI) {
		
		Logger.writeMessage("Inside ExactMatchVisitor", DebugLevel.VISITOR);
	 		
		String name=dSeagateProductI.getClass().getSimpleName();
		
		productList=dSeagateProductI.getList();
		for(int j=0;j<inputList.size();j++) {
			for(int i=0;i<productList.size();i++) {
				
				String temp=productList.get(i);
				String tempArr[]=temp.split(" ");
				String inputTemp=inputList.get(j);
				String tempInput[]=inputTemp.split(" ");
				if(tempInput.length==1) {
					
					for(int k=0;k<tempArr.length;k++) {
						if(tempArr[k].equals(inputTemp)) {
							r.setResult(name+" Exact Match "+"for query: "+inputList.get(j)+"\n"+productList.get(i)+"\n");
							Logger.writeMessage(name+" Exact Match "+"for query: "+inputList.get(j)+"\n"+productList.get(i)+"\n", DebugLevel.RESULTS);
						}
					}
				}
				else
				{
					if(productList.get(i).contains(inputList.get(j))) {
						
						r.setResult(name+" Exact Match "+"for query: "+inputList.get(j)+"\n"+productList.get(i)+"\n");
						Logger.writeMessage(name+" Exact Match "+"for query: "+inputList.get(j)+"\n"+productList.get(i)+"\n", DebugLevel.RESULTS);
						}
				}
					
			}
		}
	}
	public String toString() {
		
		return "Exact Match class";
	}

}
