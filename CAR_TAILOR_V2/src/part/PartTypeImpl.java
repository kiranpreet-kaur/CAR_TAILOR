package part;
import java.util.ArrayList;
import java.util.List;
/**
 * PartType is for all part except for Exterior
 * @author Axel, Kiran and Abdullah
 * @version 2.0
 */
public class PartTypeImpl implements PartType{
	public String part_Name;
	public String part_Desc;
	public int price;
	public Category category;
	public List<PartType> incompatibilities = new ArrayList<PartType>();
	public List<PartType> requierements = new ArrayList<PartType>();
	
	public PartTypeImpl(String name, String desc, int p,Category categ, List<PartType> incomp, List<PartType> req) {
		part_Name = name;
		part_Desc = desc;
		price = p;
		category = categ;
		incompatibilities = incomp;
		requierements = req;
	}
	
	public void addIncompatibilities(PartType p){
		incompatibilities.add(p);
	}
	
	public void removeIncompatibilities(PartType p){
		if(incompatibilities.contains(p)) {
			incompatibilities.remove(p);
		}
	}
	
	public void addRequierements(PartType p){
		requierements.add(p);
	}
	
	public void removeRequierements(PartType p){
		if(requierements.contains(p)) {
			requierements.remove(p);
		}
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPart_Name() {
		return part_Name;
	}
	public void setPart_Name(String part_Name) {
		this.part_Name = part_Name;
	}
	public String getPart_Desc() {
		return part_Desc;
	}
	public void setPart_Desc(String part_Desc) {
		this.part_Desc = part_Desc;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category categ) {
		this.category = categ;
	}
	public List<PartType> getIncompatibilities() {
		return incompatibilities;
	}
	public void setIncompatibilities(List<PartType> incompatibilities) {
		this.incompatibilities = incompatibilities;
	}
	public List<PartType> getRequierements() {
		return requierements;
	}
	public void setRequierements(List<PartType> requierements) {
		this.requierements = requierements;
	}
}
