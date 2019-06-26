package part;
import java.util.List;
/**
 * PartColorImpl is a specific PartType (can choose a color) for the moment it's only for exterior
 * @author Axel, Kiran and Abdullah
 * @version 2.0
 */
public class PartColorImpl extends PartTypeImpl implements PartColor{
	public List<Color> possibleColors;
	public Color actualColor = new Color("Default");

	public PartColorImpl(String name, String desc, int p,Category categ, List<PartType> incomp, List<PartType> req, List<Color> possibleColors) {
		super(name, desc, p, categ, incomp, req);
		this.possibleColors = possibleColors;
	}
	
	public boolean changeColor(Color c) {
		if(possibleColors.contains(c)) {
			actualColor = c;
			return true;
		}
		return false;
	}
	
	public String getActualColor() {
		return actualColor.getName();
	}

	public List<Color> getPossibleColors() {
		return possibleColors;
	}

	public void setPossibleColors(List<Color> possibleColors) {
		this.possibleColors = possibleColors;
	}
	
	public void addColor(Color c){
		possibleColors.add(c);
	}
	
	public void removeColor(Color c){
		if(possibleColors.contains(c)) {
			possibleColors.remove(c);
		}
	}
	
}
