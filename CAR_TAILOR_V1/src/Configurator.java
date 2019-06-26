import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
	
	public List<PartType> getAllParts(Category c){
		List<PartType> res = new ArrayList<>();;
		for(PartType partType : actualConfig.values()) {
			if(partType.getCategory().equals(c)) {
				res.add(partType);
			}
		}
		return res;
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
