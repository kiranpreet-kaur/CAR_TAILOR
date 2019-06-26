package config;
import java.util.List;
import java.util.Map;

import part.Category;
import part.Color;
import part.PartType;
/**
 * Interface implemented by Configurator
 * @author Axel, Kiran and Abdullah
 * @version 2.0
 */
public interface Configuration {
	/**
	 * Get the object configurator
	 * @return {@link Configurator Configurator}
	 */
	Configurator getConfiguration();
	/**
	 * Validate the configuration or not.
	 * A configuration is valid if all requirements and incompatibilities are respected
	 * @return boolean
	 */
	boolean isValid();
	/**
	 * A configuration is complete if there are 4 pieces chose, all from different category (1 of yeach)
	 * @return boolean
	 */
	boolean isComplete();
	/**
	 * Return the actual configuration that the customer chose
	 * @return int
	 */
	int getActualPrice();
	/**
	 * Give an HTML Description of the actual configuration with the price in a file
	 */
	void htmlDescription();
	/**
	 * Add this part in the actual configuration
	 * @param part Part to add
	 */
	void selectPart(PartType part);
	/**
	 * Remove this part in the actual configuration
	 * @param part Part to remove
	 */
	void removePart(PartType part);
	/**
	 * Select a category in the configuration by giving a category in param
	 * @param categ Category to select by object
	 * @return {@link Category Category}
	 */
	Category selectCategory(Category categ);
	/**
	 * Select a category in the configuration by giving a name in param
	 * @param name Category to select by name
	 * @return {@link Category Category}
	 */
	Category searchCategory(String name);
	/**
	 * Return the list of category
	 * @return List
	 */
	List<Category> getCategories();
	/**
	 * Set the list of category
	 * @param categories List of category
	 */
	void setCategories(List<Category> categories);
	/**
	 * Give the actual configuration, in a Map with the Category as a key
	 * And the Part chosen as a value
	 * @return Map
	 */
	Map<Category, PartType> getActualConfig();
	/**
	 * Set the actualConfiguration
	 * @param actualConfig Map to set
	 */
	void setActualConfig(Map<Category, PartType> actualConfig);
	/**
	 * Change the color of the exterior here.
	 * Here we cast a PartColor because the Exterior is created as a PartColor in Before but use like a PartType after
	 * We chose the piece in the actual configuration with "categories.get(2)" because for this script 2 represent the exterior.
	 * As we cast it with PartColor we can use the "changeColor(c)".
	 * @param c Color to chose
	 */
	void changecolor(Color c);
	/**
	 * Return the name of the color chosen
	 * @return String This is the name of the color
	 */
	String whatisthecolor();

}