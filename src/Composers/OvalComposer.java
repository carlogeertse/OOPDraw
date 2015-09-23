package Composers;

import java.awt.Point;

import mainpackage.AbstractShape;
import mainpackage.MyOval;

public class OvalComposer implements ShapeComposer{
	private AbstractShape shape;
	
	@Override
	public AbstractShape create(Point p) {
		MyOval s = new MyOval(); // Create the shape - Oval
		s.setStart(p);// Set the start position where mouse went down
		shape = s;
		return s;
	}

	@Override
	public AbstractShape expand(Point p) {
		MyOval s = (MyOval) shape;
		s.setEnd(p);
		shape = s;
		return s;
	}

	@Override
	public AbstractShape complete(Point p) {
		MyOval s = (MyOval) shape;
		s.setEnd(p);
		shape = s;
		return s;
	}
}
