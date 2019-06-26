import java.util.ArrayList;
import java.util.List;

public class Category {
	public String name;
	public List<PartType> listOfPart = new ArrayList<PartType>();
	
	public Category(String n){
		name = n;
	}
	
	public PartType getOnePart(String name) {
		for (PartType p : listOfPart) {
			if(p.getPart_Name().equals(name)) {
				
				return p;
			}
		}
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PartType> getListOfPart() {
		return listOfPart;
	}

	public void setListOfPart(List<PartType> listOfPart) {
		this.listOfPart = listOfPart;
	}
	
	public void addPart(PartTypeImpl part) {
		listOfPart.add(part);
	}
}
