import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;


public class JUnitTest_V1 {

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
	public void partNeedReq() {
		Configurator editor = new Configurator();
		Configuration config = editor.getConfiguration();
		Category engineCat = config.searchCategory("Engine");
		
		PartType eh120 = engineCat.getOnePart("eh120");
		config.selectPart(eh120);
		assertFalse("Configuration with EH120 without TC120 must be unvalid", config.isValid());
		assertFalse("Configuration with only 2 part cannot be complete", config.isComplete());
	}
	
	@Test
	public void select2IncompPart() {
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
		config.removePart(eg100);
		assertTrue("Empty configuration must be valid", config.isValid());
		assertTrue("Engine category is empty", config.getActualConfig().get(engineCat) == null);
	}

}
