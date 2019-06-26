package config;
import java.util.ArrayList;

import part.Category;
import part.Color;
import part.PartColorImpl;
import part.PartType;
import part.PartTypeImpl;
/**
 * Before is used to fill the database at the beginning of the execution
 * @author Axel, Kiran and Abdullah
 * @version 2.0
 */
//This class acts like a database, its not in the basic program, we did it in order to test our product with real values.
public class Before {
	public Category engineCat = new Category("Engine");
	public Category transCat = new Category("Transmission");
	public Category extCat = new Category("Exterior");
	public Category intCat = new Category("Interior");
	
	public PartTypeImpl eg100 = new PartTypeImpl("eg100", "Gasoline, 100kW", 1000, engineCat, new ArrayList<PartType>(), new ArrayList<PartType>());
	public PartTypeImpl eg133 = new PartTypeImpl("eg133", "Gasoline, 133kW", 2500,engineCat, new ArrayList<PartType>(), new ArrayList<PartType>());
	public PartTypeImpl eg210 = new PartTypeImpl("eg210", "Gasoline, 210kW", 3000,engineCat, new ArrayList<PartType>(), new ArrayList<PartType>());
	public PartTypeImpl ed110 = new PartTypeImpl("ed110", "Diesel, 110kW", 1000,engineCat, new ArrayList<PartType>(), new ArrayList<PartType>());
	public PartTypeImpl ed180 = new PartTypeImpl("ed180", "Diesel, 180kW", 1500,engineCat, new ArrayList<PartType>(), new ArrayList<PartType>());
	public PartTypeImpl eh120 = new PartTypeImpl("eh120", "Gasoline/electric, 120kW", 1200,engineCat, new ArrayList<PartType>(), new ArrayList<PartType>());
	
	public PartTypeImpl tm5 = new PartTypeImpl("tm5", "Manual, 5 gears", 100,transCat, new ArrayList<PartType>(), new ArrayList<PartType>());
	public PartTypeImpl tm6 = new PartTypeImpl("tm6", "Manual, 6 gears", 200,transCat, new ArrayList<PartType>(), new ArrayList<PartType>());
	public PartTypeImpl ta5 = new PartTypeImpl("ta5", "Automatic, 5 gears", 300,transCat, new ArrayList<PartType>(), new ArrayList<PartType>());
	public PartTypeImpl ts6 = new PartTypeImpl("ts6", "Sequential, 6 gears", 400,transCat, new ArrayList<PartType>(), new ArrayList<PartType>());
	public PartTypeImpl tsf7 = new PartTypeImpl("tsf7", "Sequential, 7 gears", 500,transCat, new ArrayList<PartType>(), new ArrayList<PartType>());
	public PartTypeImpl tc120 = new PartTypeImpl("tc120", "Converter, 120kW max", 600,transCat, new ArrayList<PartType>(), new ArrayList<PartType>());
	
	public PartColorImpl xc = new PartColorImpl("xc", "Classic paint", 650,extCat, new ArrayList<PartType>(), new ArrayList<PartType>(), new ArrayList<Color>());
	public PartColorImpl xm = new PartColorImpl("xm", "Metallic paint", 700,extCat, new ArrayList<PartType>(), new ArrayList<PartType>(), new ArrayList<Color>());
	public PartColorImpl xs = new PartColorImpl("xs", "Red and sport", 800,extCat, new ArrayList<PartType>(), new ArrayList<PartType>(), new ArrayList<Color>());
	
	public PartTypeImpl in = new PartTypeImpl("in", "Standart interior", 1000,intCat, new ArrayList<PartType>(), new ArrayList<PartType>());
	public PartTypeImpl ih = new PartTypeImpl("ih", "High-end interior", 2000,intCat, new ArrayList<PartType>(), new ArrayList<PartType>());
	public PartTypeImpl is = new PartTypeImpl("is", "Sport interior", 3000,intCat, new ArrayList<PartType>(), new ArrayList<PartType>());
	
	public Before() {
		addPart();
		addReqIncomp();
		addColor();
	}
	
	/**
	 * Add part in the categories
	 */
	public void addPart() {
		engineCat.addPart(eg100);
		engineCat.addPart(eg133);
		engineCat.addPart(eg210);
		engineCat.addPart(ed110);
		engineCat.addPart(ed180);
		engineCat.addPart(eh120);
		
		transCat.addPart(tm5);
		transCat.addPart(tm6);
		transCat.addPart(ta5);
		transCat.addPart(ts6);
		transCat.addPart(tsf7);
		transCat.addPart(tc120);
		
		extCat.addPart(xc);
		extCat.addPart(xm);
		extCat.addPart(xs);
		
		intCat.addPart(in);
		intCat.addPart(ih);
		intCat.addPart(is);
	}
	
	/**
	 * Add the Requierements and Incompatibilities
	 */
	public void addReqIncomp() {
		eh120.addRequierements(tc120);
		tc120.addRequierements(eh120);
		xs.addRequierements(is);
		is.addRequierements(xs);
		
		ta5.addIncompatibilities(eg100);
		tsf7.addIncompatibilities(eg100);
		tsf7.addIncompatibilities(eg133);
		tsf7.addIncompatibilities(ed110);
		xc.addIncompatibilities(eg210);
		xm.addIncompatibilities(eg100);
		xs.addIncompatibilities(eg100);
		is.addIncompatibilities(eg100);
		is.addIncompatibilities(tm5);
	}
	
	/**
	 * Add the colors
	 */
	public void addColor() {
		xc.addColor(new Color("Blue"));
		xc.addColor(new Color("Green"));
		xc.addColor(new Color("Yellow"));
		
		xm.addColor(new Color("Grey"));
		xm.addColor(new Color("White"));
		xm.addColor(new Color("Black"));
		
		xs.addColor(new Color("Red with white strips"));
		xs.addColor(new Color("Red with black strips"));
		xs.addColor(new Color("Red with yellow strips"));
	}

	/**
	 * Get for the category Engine
	 * @return {@link Category Category}
	 */
	public Category getEngineCat() {
		return engineCat;
	}
	/**
	 * Set for the category Engine
	 * @param engineCat Category
	 */
	public void setEngineCat(Category engineCat) {
		this.engineCat = engineCat;
	}
	/**
	 * Get for the category Transmission
	 * @return {@link Category Category}
	 */
	public Category getTransCat() {
		return transCat;
	}
	/**
	 * Set for the category Transmission
	 *  @param transCat Category
	 */
	public void setTransCat(Category transCat) {
		this.transCat = transCat;
	}
	/**
	 * Get for the category Exterior
	 * @return {@link Category Category}
	 */
	public Category getExtCat() {
		return extCat;
	}
	/**
	 * Set for the category Exterior
	 * @param extCat Category
	 */
	public void setExtCat(Category extCat) {
		this.extCat = extCat;
	}
	/**
	 * Get for the category Interior
	 * @return {@link Category Category}
	 */
	public Category getIntCat() {
		return intCat;
	}
	/**
	 * Set for the category Interior
	 * @param intCat Category
	 */
	public void setIntCat(Category intCat) {
		this.intCat = intCat;
	}
}
