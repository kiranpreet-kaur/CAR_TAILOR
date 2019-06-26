package config;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import part.Category;
import part.Color;
import part.PartColor;
import part.PartType;

/**
 * Configurator is the class where you can find all methods used to configure the car
 * @author Axel, Kiran and Abdullah
 * @version 2.0
 */
public class Configurator implements Configuration {

	public List<Category> categories = new ArrayList<Category>();
	public Map<Category, PartType> actualConfig = new HashMap<>();
	
	private Before bef = new Before(); 
	
	public Configurator() {
		addCateg();
	}
	
	public void addCateg() {
		categories.add(bef.getEngineCat());
		categories.add(bef.getTransCat());
		categories.add(bef.getExtCat());
		categories.add(bef.getIntCat());
	}

	@Override
	public Configurator getConfiguration() {
		return this;
	}
	/**
	 * Change the color of the exterior here.
	 * Here we cast a PartColor because the Exterior is created as a PartColor in Before but use like a PartType after
	 * We chose the piece in the actual configuration with "categories.get(2)" because for this script 2 represent the exterior.
	 * As we cast it with PartColor we can use the "changeColor(c)".
	 * @param c Color to chose
	 */
	public void changecolor(Color c) {
		((PartColor) actualConfig.get(categories.get(2))).changeColor(c);
	}
	
	public String whatisthecolor() {
		return ((PartColor) actualConfig.get(categories.get(2))).getActualColor();
	}
	
	public void htmlDescription() {
		if(isValid() && isComplete()) {
			File f = new File("description.html");
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(f));
				bw.write("<h1>This is your configuration</h1>");
				for(PartType partType : actualConfig.values()) {
					bw.write("<p>"+partType.getCategory().getName()+" : <b>"+partType.getPart_Name()+"</b></p>");
				}
				bw.write("<p>The price is : <b>"+getActualPrice()+"</b></p>");
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("In order to get the html description you mast have a valid and complete configuration");
		}
	}
	
	public int getActualPrice() {
		if(isValid()) {
			int total = 0;
			for(PartType partType : actualConfig.values()) {
				total += partType.getPrice();
			}
			return total;
		} else {
			System.out.println("In order to get the price you must have a valid configuration");
			return -1;
		}
	}
	
	public void selectPart(PartType part){
		Category tmpcat = part.getCategory();
		actualConfig.put(tmpcat, part);
		
	}
	
	public Category selectCategory(Category categ) {
		return categories.stream().filter(c->c.equals(categ)).findFirst().get();
	}

	public Category searchCategory(String name){
		for (Category categ : categories) {
			if(categ.getName().equals(name)) {
				return categ;
			}
		}
		return null;
	}
	
	public boolean isValid() {
		for(PartType partType : actualConfig.values()) {
			List<PartType> tmpIncomp = partType.getIncompatibilities();
			if(actualConfig.values().stream().anyMatch(p->tmpIncomp.contains(p))){
				return false;
			}
			List<PartType> tmpReq = partType.getRequierements();
			if(!tmpReq.isEmpty()) {
				for(PartType partReq : tmpReq) {
					if(!actualConfig.containsValue(partReq)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public boolean isComplete() {
		boolean res = true;
		if(actualConfig.size() != 4) return false;
		for (Category categ : categories) {
			if(actualConfig.get(categ) == null) {
				res =  false;
			}
		}
		return res;
	}

	public void removePart(PartType part) {
		Objects.requireNonNull(part, "Part is null");
		if (part.getCategory() != null) {
			if(part != null && actualConfig.get(part.getCategory()) != null) {
				actualConfig.remove(part.getCategory(), part);
			}else {
				throw new NullPointerException("PartType is null or Category is empty");
			}
		} else {
			throw new NullPointerException("part.getCategory() is null");
		}
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Map<Category, PartType> getActualConfig() {
		return actualConfig;
	}

	public void setActualConfig(Map<Category, PartType> actualConfig) {
		this.actualConfig = actualConfig;
	}
}
