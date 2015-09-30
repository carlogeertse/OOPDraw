package Composers;

import java.awt.Point;

import mainpackage.AbstractShape;
import mainpackage.MyOval;

public class OvalComposer implements ShapeComposer{
	private MyOval oval;
	
	@Override
	public AbstractShape create(Point p) {
		MyOval s = new MyOval(); // Create the shape - Oval
		s.setStart(p);// Set the start position where mouse went down
		oval = s;
		return s;
	}

	@Override
	public AbstractShape expand(Point p) {
		MyOval s = (MyOval) oval;
		s.setEnd(p);
		oval = s;
		return s;
	}

	@Override
	public AbstractShape complete(Point p) {
		MyOval s = (MyOval) oval;
		s.setEnd(p);
		oval = s;
		return s;
	}
}
