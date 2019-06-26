package test;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import config.Configuration;
import config.Configurator;
import part.Category;
import part.PartColor;
import part.PartType;
/**
 * JUnit-Test
 * @author Axel, Kiran and Abdullah
 * @version 2.0
 */
public class JUnitTest_Config {
	@Test
	public void userStartsConfigurator() {
		Configurator editor = new Configurator();
		Configuration config = editor.getConfiguration();
		assertTrue("Empty configuration must be valid", config.isValid());
		assertFalse("Empty configuration cannot be complete", config.isComplete());
	}
	
	@Test
	public void creationOfCategory() {
		Configurator editor = new Configurator();
		Configuration config = editor.getConfiguration();
		List<Category> catList = config.getCategories();
		assertTrue("Size of the list of categories is 4", catList.size() == 4);
		Category engineCat = config.searchCategory("Engine");
		assertTrue("Category engineCat is well recuperate", engineCat.getName().equals("Engine"));
	}
	
	@Test
	public void selectAPart() {
		Configurator editor = new Configurator();
		Configuration config = editor.getConfiguration();
		Category engineCat = config.searchCategory("Engine");
		
		PartType eg100 = engineCat.getOnePart("eg100");
		config.selectPart(eg100);
		assertTrue("Name of the engine = eg100",config.getActualConfig().get(engineCat).getPart_Name().equals("eg100"));
		assertTrue("Configuration with EG100 but no transmission must be valid", config.isValid());
		assertFalse("Configuration with only 1 part cannot be complete", config.isComplete());	
	}
	
	@Test
	public void configIsCompleteAndValid() {
		Configurator editor = new Configurator();
		Configuration config = editor.getConfiguration();
		Category engineCat = config.searchCategory("Engine");
		Category transCat = config.searchCategory("Transmission");
		Category intCat = config.searchCategory("Interior");
		Category extCat = config.searchCategory("Exterior");
		
		PartType eg100 = engineCat.getOnePart("eg100");
		PartType tm5 = transCat.getOnePart("tm5");
		PartType in = intCat.getOnePart("in");
		PartType xc = extCat.getOnePart("xc");
		
		config.selectPart(eg100);
		config.selectPart(tm5);
		config.selectPart(in);
		config.selectPart(xc);
		assertTrue("Empty configuration must be valid", config.isValid());
		assertTrue("Configuration should be complete", config.isComplete());
	}
	
	@Test
	public void partNeedRequirement() {
		Configurator editor = new Configurator();
		Configuration config = editor.getConfiguration();
		Category engineCat = config.searchCategory("Engine");
		
		PartType eh120 = engineCat.getOnePart("eh120");
		config.selectPart(eh120);
		assertFalse("Configuration with EH120 without TC120 must be unvalid", config.isValid());
		assertFalse("Configuration with only 2 part cannot be complete", config.isComplete());
		
		Category transCat = config.searchCategory("Transmission");
		PartType tc120 = transCat.getOnePart("tc120");
		config.selectPart(tc120);
		assertTrue("Empty configuration must be valid", config.isValid());
		assertFalse("Configuration shouldn't be complete", config.isComplete());
	}
	
	@Test
	public void select2IncompatiblePart() {
		Configurator editor = new Configurator();
		Configuration config = editor.getConfiguration();
		Category engineCat = config.searchCategory("Engine");
		Category transCat = config.searchCategory("Transmission");
		
		PartType eg100 = engineCat.getOnePart("eg100");
		config.selectPart(eg100);
		PartType ta5 = transCat.getOnePart("ta5");
		config.selectPart(ta5);
		assertFalse("Configuration with EH120 without TA5 must be unvalid", config.isValid());
		assertFalse("Configuration with only 2 part cannot be complete", config.isComplete());
		
	}
	
	@Test
	public void removeAPart() {
		Configurator editor = new Configurator();
		Configuration config = editor.getConfiguration();
		Category engineCat = config.searchCategory("Engine");
		
		PartType eg100 = engineCat.getOnePart("eg100");
		config.selectPart(eg100);
		System.out.println("--------------------------------------");
		System.out.println("Select a part for the configuration");
		System.out.println("Part : "+config.getActualConfig().get(engineCat).getPart_Name());
		config.removePart(eg100);
		System.out.println("Delete a part for the configuration");
		System.out.println("Part = ? -> " + config.getActualConfig().get(engineCat));
		assertTrue("Empty configuration must be valid", config.isValid());
		assertTrue("Engine category is empty", config.getActualConfig().get(engineCat) == null);
	}
	
	
	@Test
	public void priceOfValidConfig() {
		Configurator editor = new Configurator();
		Configuration config = editor.getConfiguration();
		Category engineCat = config.searchCategory("Engine");
		Category transCat = config.searchCategory("Transmission");
		Category intCat = config.searchCategory("Interior");
		Category extCat = config.searchCategory("Exterior");
		
		PartType eg100 = engineCat.getOnePart("eg100");
		PartType tm5 = transCat.getOnePart("tm5");
		PartType in = intCat.getOnePart("in");
		PartType xc = extCat.getOnePart("xc");
		
		config.selectPart(eg100);
		config.selectPart(tm5);
		config.selectPart(in);
		config.selectPart( xc);
		assertTrue("Empty configuration must be valid", config.isValid());
		assertTrue("Configuration should be complete", config.isComplete());
		assertTrue("Price = 2750", config.getActualPrice()==2750);
		
		System.out.println("--------------------------------------");
		System.out.println("Display the price of the configuration");
		System.out.println("Price : "+config.getActualPrice());
	}
	
	@Test
	public void changeColor() {
		Configurator editor = new Configurator();
		Configuration config = editor.getConfiguration();
		Category engineCat = config.searchCategory("Engine");
		Category transCat = config.searchCategory("Transmission");
		Category intCat = config.searchCategory("Interior");
		Category extCat = config.searchCategory("Exterior");
		
		PartType eg100 = engineCat.getOnePart("eg100");
		PartType tm5 = transCat.getOnePart("tm5");
		PartType in = intCat.getOnePart("in");
		PartColor xc = (PartColor) extCat.getOnePart("xc");
		
		config.selectPart(eg100);
		config.selectPart(tm5);
		config.selectPart(in);
		config.selectPart((PartType) xc);
		assertTrue("Empty configuration must be valid", config.isValid());
		assertTrue("Configuration should be complete", config.isComplete());
		
		System.out.println("---------------------------");
		System.out.println("Select a color for Exterior");
		int tmp = (int) (Math.random() * (xc.getPossibleColors().size()-1));
		config.changecolor(xc.getPossibleColors().get(tmp));
		System.out.println("Color : "+config.whatisthecolor());
		System.out.println("Change the color for Exterior");
		if(tmp==xc.getPossibleColors().size()-1)tmp--;
		else if(tmp>=0)tmp++;
		config.changecolor(xc.getPossibleColors().get(tmp));
		System.out.println("Color : "+config.whatisthecolor());
		assertTrue("The color should be yellow", config.whatisthecolor().equals(xc.getPossibleColors().get(tmp).name));
	}
	
	@Test
	public void creationHTML() {
		Configurator editor = new Configurator();
		Configuration config = editor.getConfiguration();
		Category engineCat = config.searchCategory("Engine");
		Category transCat = config.searchCategory("Transmission");
		Category intCat = config.searchCategory("Interior");
		Category extCat = config.searchCategory("Exterior");
		PartType eg100 = engineCat.getOnePart("eg100");
		PartType tm5 = transCat.getOnePart("tm5");
		PartType in = intCat.getOnePart("in");
		PartType xc = extCat.getOnePart("xc");
		config.selectPart(eg100);
		config.selectPart(tm5);
		config.selectPart(in);
		config.selectPart(xc);
		//Creation of the HTML Description in the folder
		config.htmlDescription();
	}
	
	@Test
	public void changeRequirements() {
		Configurator editor = new Configurator();
		Configuration config = editor.getConfiguration();
		Category engineCat = config.searchCategory("Engine");
		Category transCat = config.searchCategory("Transmission");
		
		PartType eh120 = engineCat.getOnePart("eh120");
		System.out.println("------------------");
		System.out.println("Basic requirements");
		for(PartType part : eh120.getRequierements()) {
			System.out.println(part.getPart_Name());
		}
		
		PartType tm5 = transCat.getOnePart("tm5");
		eh120.addRequierements(tm5);
		System.out.println("Basic requirements + tm5");
		for(PartType part : eh120.getRequierements()) {
			System.out.println(part.getPart_Name());
		}
		assertTrue("EH120 should contains TM5 in requirement list", eh120.getRequierements().contains(tm5));
		
		eh120.removeRequierements(tm5);
		System.out.println("Basic requirements (TM5 is removed)");
		for(PartType part : eh120.getRequierements()) {
			System.out.println(part.getPart_Name());
		}
		assertFalse("EH120 shouldn't contains TM5 in requirement list", eh120.getRequierements().contains(tm5));
	}
	
	@Test
	public void changeIncompatitibilites() {
		Configurator editor = new Configurator();
		Configuration config = editor.getConfiguration();
		Category engineCat = config.searchCategory("Engine");
		Category transCat = config.searchCategory("Transmission");
		
		PartType eh120 = engineCat.getOnePart("eh120");
		System.out.println("------------------");
		System.out.println("Basic incompatibilities");
		for(PartType part : eh120.getIncompatibilities()) {
			System.out.println(part.getPart_Name());
		}
		
		PartType tm5 = transCat.getOnePart("tm5");
		eh120.addIncompatibilities(tm5);
		System.out.println("Basic incompatibilities + tm5");
		for(PartType part : eh120.getIncompatibilities()) {
			System.out.println(part.getPart_Name());
		}
		assertTrue("EH120 should contains TM5 in incompatibilities list", eh120.getIncompatibilities().contains(tm5));
		
		eh120.removeIncompatibilities(tm5);
		System.out.println("Basic incompatibilities (TM5 is removed)");
		for(PartType part : eh120.getIncompatibilities()) {
			System.out.println(part.getPart_Name());
		}
		assertFalse("EH120 shouldn't contains TM5 in incompatibilities list", eh120.getIncompatibilities().contains(tm5));
	}
}
