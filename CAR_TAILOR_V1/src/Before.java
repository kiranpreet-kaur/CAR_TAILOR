import java.util.ArrayList;

public class Before {
	public Category engineCat = new Category("Engine");
	public Category transCat = new Category("Transmission");
	public Category extCat = new Category("Exterior");
	public Category intCat = new Category("Interior");
	
	public PartTypeImpl eg100 = new PartTypeImpl("eg100", "Gasoline, 100kW", engineCat, new ArrayList<PartType>(), new ArrayList<PartType>());
	public PartTypeImpl eg133 = new PartTypeImpl("eg133", "Gasoline, 133kW", engineCat, new ArrayList<PartType>(), new ArrayList<PartType>());
	public PartTypeImpl eg210 = new PartTypeImpl("eg210", "Gasoline, 210kW", engineCat, new ArrayList<PartType>(), new ArrayList<PartType>());
	public PartTypeImpl ed110 = new PartTypeImpl("ed110", "Diesel, 110kW", engineCat, new ArrayList<PartType>(), new ArrayList<PartType>());
	public PartTypeImpl ed180 = new PartTypeImpl("ed180", "Diesel, 180kW", engineCat, new ArrayList<PartType>(), new ArrayList<PartType>());
	public PartTypeImpl eh120 = new PartTypeImpl("eh120", "Gasoline/electric, 120kW", engineCat, new ArrayList<PartType>(), new ArrayList<PartType>());
	
	public PartTypeImpl tm5 = new PartTypeImpl("tm5", "Manual, 5 gears", transCat, new ArrayList<PartType>(), new ArrayList<PartType>());
	public PartTypeImpl tm6 = new PartTypeImpl("tm6", "Manual, 6 gears", transCat, new ArrayList<PartType>(), new ArrayList<PartType>());
	public PartTypeImpl ta5 = new PartTypeImpl("ta5", "Automatic, 5 gears", transCat, new ArrayList<PartType>(), new ArrayList<PartType>());
	public PartTypeImpl ts6 = new PartTypeImpl("ts6", "Sequential, 6 gears", transCat, new ArrayList<PartType>(), new ArrayList<PartType>());
	public PartTypeImpl tsf7 = new PartTypeImpl("tsf7", "Sequential, 7 gears", transCat, new ArrayList<PartType>(), new ArrayList<PartType>());
	public PartTypeImpl tc120 = new PartTypeImpl("tc120", "Converter, 120kW max", transCat, new ArrayList<PartType>(), new ArrayList<PartType>());
	
	public PartTypeImpl xc = new PartTypeImpl("xc", "Classic paint", extCat, new ArrayList<PartType>(), new ArrayList<PartType>());
	public PartTypeImpl xm = new PartTypeImpl("xm", "Metallic paint", extCat, new ArrayList<PartType>(), new ArrayList<PartType>());
	public PartTypeImpl xs = new PartTypeImpl("xs", "Red and sport", extCat, new ArrayList<PartType>(), new ArrayList<PartType>());
	
	public PartTypeImpl in = new PartTypeImpl("in", "Standart interior", intCat, new ArrayList<PartType>(), new ArrayList<PartType>());
	public PartTypeImpl ih = new PartTypeImpl("ih", "High-end interior", intCat, new ArrayList<PartType>(), new ArrayList<PartType>());
	public PartTypeImpl is = new PartTypeImpl("is", "Sport interior", intCat, new ArrayList<PartType>(), new ArrayList<PartType>());
	
	public Before() {
		addPart();
		addReqIncomp();
	}
	
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

	public Category getEngineCat() {
		return engineCat;
	}

	public void setEngineCat(Category engineCat) {
		this.engineCat = engineCat;
	}

	public Category getTransCat() {
		return transCat;
	}

	public void setTransCat(Category transCat) {
		this.transCat = transCat;
	}

	public Category getExtCat() {
		return extCat;
	}

	public void setExtCat(Category extCat) {
		this.extCat = extCat;
	}

	public Category getIntCat() {
		return intCat;
	}

	public void setIntCat(Category intCat) {
		this.intCat = intCat;
	}
}
