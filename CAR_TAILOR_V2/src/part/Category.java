package part;
import java.util.ArrayList;
import java.util.List;
/**
 * Category represent the 4 type of pieces
 * @author Axel, Kiran and Abdullah
 * @version 2.0
 */
public class Category {
	public String name;
	public List<PartType> listOfPart = new ArrayList<PartType>();
	/**
	 * Constructor of the class Category
	 * @param n The name of the Category
	 */
	public Category(String n){
		name = n;
	}
	/**
	 * Search a piece by its name
	 * @param name We give the name of the piece
	 * @return {@link PartType PartType}
	 */
	public PartType getOnePart(String name) {
		for (PartType p : listOfPart) {
			if(p.getPart_Name().equals(name)) {
				return p;
			}
		}
		return null;
	}
	/**
	 * Get for the name
	 * @return String
	 */
	public String getName() {
		return name;
	}
	/**
	 * Set for the category name
	 * @param name String
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Get for the list of part
	 * @return List
	 */
	public List<PartType> getListOfPart() {
		return listOfPart;
	}
	/**
	 * Set for the category list of part
	 * @param listOfPart List
	 */
	public void setListOfPart(List<PartType> listOfPart) {
		this.listOfPart = listOfPart;
	}
	
	/**
	 * Add a part in the list of the category
	 * @param part PartTypeImpl
	 */
	public void addPart(PartTypeImpl part) {
		listOfPart.add(part);
	}
}
