package part;
import java.util.List;
/**
 * Interface implemented by PartColorImpl
 * @author Axel, Kiran and Abdullah
 * @version 2.0
 */
public interface PartColor {
	
	boolean changeColor(Color c);
	String getActualColor();
	
	List<Color> getPossibleColors();
	void setPossibleColors(List<Color> possibleColors);
	void addColor(Color c);
	void removeColor(Color c);
}
