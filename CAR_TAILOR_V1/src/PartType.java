import java.util.List;

public interface PartType {
	String getPart_Name();
	void setPart_Name(String part_Name);
	
	String getPart_Desc();
	void setPart_Desc(String part_Desc);
	
	Category getCategory();
	void setCategory(Category categ);
	
	List<PartType> getRequierements();
	void addRequierements(PartType p);
	void removeRequierements(PartType p);
	void setRequierements(List<PartType> requierements);
	
	List<PartType> getIncompatibilities();	
	void addIncompatibilities(PartType p);
	void removeIncompatibilities(PartType p);
	void setIncompatibilities(List<PartType> incompatibilities);

}
