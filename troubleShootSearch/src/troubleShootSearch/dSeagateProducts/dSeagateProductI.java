package troubleShootSearch.dSeagateProducts;

import java.io.File;
import java.util.ArrayList;

import troubleShootSearch.visitor.Visitor;

public interface dSeagateProductI {

	public void accept(Visitor visitor);

	public ArrayList<String> getList();

	public void setList(String[] arr);
}
