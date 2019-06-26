import java.util.List;
import java.util.Map;

public interface Configuration {
	Configurator getConfiguration();
	boolean isValid();
	boolean isComplete();
	
	List<PartType> getAllParts(Category c);
	void selectPart(PartType part);
	void removePart(PartType part);

	Category selectCategory(Category categ);
	Category searchCategory(String name);
	List<Category> getCategories();
	void setCategories(List<Category> categories);

	Map<Category, PartType> getActualConfig();
	void setActualConfig(Map<Category, PartType> actualConfig);
}